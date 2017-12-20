package badminton_association.com.example.honza.badmintonassociation.Activities.Admin;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import badminton_association.com.example.honza.badmintonassociation.Activities.MainActivity;
import badminton_association.com.example.honza.badmintonassociation.HTTPInterface;
import badminton_association.com.example.honza.badmintonassociation.Models.Tournament;
import badminton_association.com.example.honza.badmintonassociation.Models.Venue;
import badminton_association.com.example.honza.badmintonassociation.R;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class AdminNewTournament extends AppCompatActivity {
    private Tournament mTournament;
    private List<Venue> mVenues;

    private EditText nameEdit;
    private EditText startDateEdit;
    private EditText endDateEdit;
    private Spinner venuesSpinner;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_new_tournament);

        nameEdit = (EditText) findViewById(R.id.nameEdit);
        startDateEdit = (EditText) findViewById(R.id.startDateEdit);
        endDateEdit = (EditText) findViewById(R.id.endDateEdit);
        venuesSpinner = (Spinner) findViewById(R.id.venueSpinner);
        submitButton = (Button) findViewById(R.id.submitButton);

        mTournament = (Tournament) getIntent().getSerializableExtra(AdminTournamentsActivity.TOURNAMENT);
        if (mTournament == null)
            mTournament = new Tournament();

        nameEdit.setText(mTournament.getName());
        startDateEdit.setText(mTournament.getStartDate());
        endDateEdit.setText(mTournament.getEndDate());

        final Context self = this;
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTournament.setName(nameEdit.getText().toString());
                mTournament.setStartDate(startDateEdit.getText().toString());
                mTournament.setEndDate(endDateEdit.getText().toString());
                mTournament.setVenue(mVenues.get(venuesSpinner.getSelectedItemPosition()));

                RestAdapter radapter=new RestAdapter.Builder().setEndpoint(MainActivity.URL).build();

                HTTPInterface restInt = radapter.create(HTTPInterface.class);

                restInt.postTournament(mTournament, new Callback<Object>() {
                    @Override
                    public void success(Object o, Response response) {
                        finish();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(self);
                        alertDialogBuilder.setTitle("Unable to save.");
                        alertDialogBuilder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        alertDialogBuilder.show();
                        error.printStackTrace();
                    }
                });
            }
        });

        RestAdapter radapter=new RestAdapter.Builder().setEndpoint(MainActivity.URL).build();

        HTTPInterface restInt = radapter.create(HTTPInterface.class);

        restInt.getAllVenues(new Callback<List<Venue>>() {
            @Override
            public void success(List<Venue> venues, Response response) {
                mVenues = venues;
                populateSpinner();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("getScores", error.getMessage());
            }
        });
    }

    private void populateSpinner(){
        List<String> venueNames = new ArrayList<String>();
        for (Venue venue:mVenues) {
            venueNames.add(venue.getName());
        }
        venuesSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, venueNames));
        if(mTournament.getVenue() != null)
            venuesSpinner.setSelection(venueNames.indexOf(mTournament.getVenue().getName()));
    }
}
