package badminton_association.com.example.honza.badmintonassociation.Activities.Player;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import badminton_association.com.example.honza.badmintonassociation.Models.Enum;
import badminton_association.com.example.honza.badmintonassociation.Models.Player;
import badminton_association.com.example.honza.badmintonassociation.R;

import static badminton_association.com.example.honza.badmintonassociation.Activities.Player.PlayerMenuActivity.PLAYER;

public class PlayerMyAccountActivity extends AppCompatActivity {

    private EditText nameEdit;
    private EditText phoneEdit;
    private EditText addressEdit;
    private RadioGroup genderRadioGroup;
    private Button updateButton;

    private Player mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_my_account);

        nameEdit = (EditText) findViewById(R.id.nameEdit);
        phoneEdit = (EditText) findViewById(R.id.phoneEdit);
        addressEdit = (EditText) findViewById(R.id.addressEdit);
        genderRadioGroup = (RadioGroup) findViewById(R.id.genderRadioGroup);
        updateButton = (Button) findViewById(R.id.updateButton);

        mPlayer = (Player) getIntent().getSerializableExtra(PLAYER);

        nameEdit.setText(mPlayer.getName());
        phoneEdit.setText(mPlayer.getPhone());
        addressEdit.setText(mPlayer.getAddress());
        genderRadioGroup.check(mPlayer.getGenderAsInt());

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.setName(nameEdit.getText().toString());
                mPlayer.setPhone(phoneEdit.getText().toString());
                mPlayer.setAddress(addressEdit.getText().toString());
                mPlayer.setGender(Enum.Gender.fromInteger(genderRadioGroup.getCheckedRadioButtonId()));
                mPlayer.save();
                finish();
            }
        });

    }
}
