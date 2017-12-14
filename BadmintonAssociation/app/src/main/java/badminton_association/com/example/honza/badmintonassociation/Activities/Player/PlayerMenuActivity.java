package badminton_association.com.example.honza.badmintonassociation.Activities.Player;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import badminton_association.com.example.honza.badmintonassociation.Models.Player;
import badminton_association.com.example.honza.badmintonassociation.R;

public class PlayerMenuActivity extends AppCompatActivity {

    private Button tournaments;
    private Button myAccount;
    private Button matches;
    private Button venues;

    private Player mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_menu);

        tournaments = (Button) findViewById(R.id.tournamentsButton);
        myAccount = (Button) findViewById(R.id.myAccountButton);
        venues = (Button) findViewById(R.id.venuesButton);
        matches = (Button) findViewById(R.id.matchesButton);

        PlayerGateway playerGateway = new PlayerGateway();
        mPlayer = playerGateway.getPlayer(1);

        myAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayerMenuActivity.this, PlayerMyAccountActivity.class);
                intent.putExtra("player", mPlayer);
                startActivity(intent);
            }
        });

        tournaments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayerMenuActivity.this, PlayerTournamentsActivity.class);
                startActivity(intent);
            }
        });
    }
}
