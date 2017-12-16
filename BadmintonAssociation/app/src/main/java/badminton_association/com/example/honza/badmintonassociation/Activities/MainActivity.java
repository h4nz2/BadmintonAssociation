package badminton_association.com.example.honza.badmintonassociation.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import badminton_association.com.example.honza.badmintonassociation.Activities.Admin.AdminMenuActivity;
import badminton_association.com.example.honza.badmintonassociation.Activities.Player.PlayerMenuActivity;
import badminton_association.com.example.honza.badmintonassociation.R;

public class MainActivity extends AppCompatActivity {
    public static final String URL = "http://192.168.0.102:28429/BadmintonAssociationServer";

    private Button adminButton;
    private Button playerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adminButton = (Button) findViewById(R.id.adminButton);
        playerButton = (Button) findViewById(R.id.playerButton);

        adminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdminMenuActivity.class);
                startActivity(intent);
            }
        });

        playerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlayerMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
