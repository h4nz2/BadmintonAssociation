package badminton_association.com.example.honza.badmintonassociation.Activities.Admin;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

import badminton_association.com.example.honza.badmintonassociation.Activities.MainActivity;
import badminton_association.com.example.honza.badmintonassociation.HTTPInterface;
import badminton_association.com.example.honza.badmintonassociation.ListAdapters.AdminTournamentsAdapter;
import badminton_association.com.example.honza.badmintonassociation.Models.Tournament;
import badminton_association.com.example.honza.badmintonassociation.R;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class AdminTournamentsActivity extends AppCompatActivity {
    public static final String TOURNAMENT = "tournament";

    private RecyclerView tournamentsView;
    private List<Tournament> mTournaments;
    private AdminTournamentsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_tournaments);

        tournamentsView = (RecyclerView) findViewById(R.id.tournamentsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        tournamentsView.setLayoutManager(mLayoutManager);
        tournamentsView.setHasFixedSize(true);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminTournamentsActivity.this, AdminNewTournament.class);
                startActivity(intent);
            }
        });
    }

    public void updateUI(){
        if(adapter == null){
            adapter = new AdminTournamentsAdapter(mTournaments, this);
            tournamentsView.setAdapter(adapter);
        }
        else
            adapter.notifyDataSetChanged();
    }

    public void getTournaments(){
        RestAdapter radapter=new RestAdapter.Builder().setEndpoint(MainActivity.URL).build();

        HTTPInterface restInt = radapter.create(HTTPInterface.class);

        restInt.getAllTournaments(new Callback<List<Tournament>>() {
            @Override
            public void success(List<Tournament> tournaments, Response response) {
                if(mTournaments == null)
                    mTournaments = tournaments;
                else {
                    mTournaments.clear();
                    mTournaments.addAll(tournaments);
                }
                updateUI();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("getScores", error.getMessage());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getTournaments();
    }
}
