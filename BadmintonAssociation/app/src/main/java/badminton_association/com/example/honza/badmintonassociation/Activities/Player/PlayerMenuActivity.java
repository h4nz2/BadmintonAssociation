package badminton_association.com.example.honza.badmintonassociation.Activities.Player;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import badminton_association.com.example.honza.badmintonassociation.Activities.MainActivity;
import badminton_association.com.example.honza.badmintonassociation.HTTPInterface;
import badminton_association.com.example.honza.badmintonassociation.Models.Player;
import badminton_association.com.example.honza.badmintonassociation.R;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PlayerMenuActivity extends AppCompatActivity {
    public static String PLAYER_ID = "player_id";
    public static String PLAYER = "player";

    private Button tournaments;
    private Button myAccount;
    private Button matches;
    private Button availableTournaments;

    private Player mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_menu);

        tournaments = (Button) findViewById(R.id.myTournamentsButton);
        myAccount = (Button) findViewById(R.id.myAccountButton);
        availableTournaments = (Button) findViewById(R.id.availableTournamentsButton);
        matches = (Button) findViewById(R.id.matchesButton);

        RestAdapter radapter=new RestAdapter.Builder().setEndpoint(MainActivity.URL).build();

        HTTPInterface restInt = radapter.create(HTTPInterface.class);

        restInt.getPlayer(new Callback<Player>() {
            @Override
            public void success(Player player, Response response) {
                mPlayer = player;
                setListeners();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("getScores", error.getMessage());
            }
        });

    }

    private void setListeners(){
        myAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayerMenuActivity.this, PlayerMyAccountActivity.class);
                intent.putExtra(PLAYER, mPlayer);
                startActivity(intent);
            }
        });

        tournaments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayerMenuActivity.this, PlayerTournamentsActivity.class);
                intent.putExtra(PLAYER_ID, mPlayer.getId());
                startActivity(intent);
            }
        });

        availableTournaments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayerMenuActivity.this, PlayerAvailableTournamentsActivity.class);
                intent.putExtra(PLAYER_ID, mPlayer.getId());
                startActivity(intent);
            }
        });
    }
}
