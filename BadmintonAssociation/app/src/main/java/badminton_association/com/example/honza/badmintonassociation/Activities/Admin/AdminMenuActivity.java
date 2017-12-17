package badminton_association.com.example.honza.badmintonassociation.Activities.Admin;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import badminton_association.com.example.honza.badmintonassociation.Activities.MainActivity;
import badminton_association.com.example.honza.badmintonassociation.HTTPInterface;
import badminton_association.com.example.honza.badmintonassociation.Models.Admin;
import badminton_association.com.example.honza.badmintonassociation.R;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class AdminMenuActivity extends AppCompatActivity {
    public static final String ADMIN = "admin";

    private Admin mAdmin;

    private Button venues;
    private Button tournaments;
    private Button admins;
    private Button players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);

        admins = (Button) findViewById(R.id.adminsButton);
        players = (Button) findViewById(R.id.playersButton);
        venues = (Button) findViewById(R.id.venuesButton);
        tournaments = (Button) findViewById(R.id.tournamentsButton);

        RestAdapter radapter=new RestAdapter.Builder().setEndpoint(MainActivity.URL).build();

        HTTPInterface restInt = radapter.create(HTTPInterface.class);

        restInt.getAdmin(new Callback<Admin>() {
            @Override
            public void success(Admin admin, Response response) {
                mAdmin = admin;
                setListeners();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("getScores", error.getMessage());
            }
        });
    }

    private void setListeners() {
        players.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        tournaments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminMenuActivity.this, AdminTournamentsActivity.class);
                intent.putExtra(ADMIN, mAdmin);
                startActivity(intent);
            }
        });

    }
}
