package badminton_association.com.example.honza.badmintonassociation.Activities.Player;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import badminton_association.com.example.honza.badmintonassociation.Activities.MainActivity;
import badminton_association.com.example.honza.badmintonassociation.HTTPInterface;
import badminton_association.com.example.honza.badmintonassociation.ListAdapters.PlayerTournamentsListAdapter;
import badminton_association.com.example.honza.badmintonassociation.Models.Tournament;
import badminton_association.com.example.honza.badmintonassociation.R;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static badminton_association.com.example.honza.badmintonassociation.Activities.Player.PlayerMenuActivity.PLAYER_ID;

public class PlayerAvailableTournamentsActivity extends AppCompatActivity {
    private RecyclerView tournamentsList;
    private List<Tournament> mTournaments;
    private PlayerTournamentsListAdapter adapter;
    private int playerID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_available_tournaments);

        tournamentsList = (RecyclerView) findViewById(R.id.tournamentsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        tournamentsList.setLayoutManager(mLayoutManager);
        tournamentsList.setHasFixedSize(true);

        playerID = getIntent().getIntExtra(PLAYER_ID, 0);

        RestAdapter radapter=new RestAdapter.Builder().setEndpoint(MainActivity.URL).build();

        HTTPInterface restInt = radapter.create(HTTPInterface.class);

        restInt.getAvailableTournaments(playerID, new Callback<List<Tournament>>() {
            @Override
            public void success(List<Tournament> tournaments, Response response) {
                mTournaments = tournaments;
                updateUI();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("getScores", error.getMessage());
            }
        });
    }

    public void updateUI(){
        if(adapter == null){
            adapter = new PlayerTournamentsListAdapter(mTournaments, true, this, playerID);
            tournamentsList.setAdapter(adapter);
        }
        else
            adapter.notifyDataSetChanged();
    }
}
