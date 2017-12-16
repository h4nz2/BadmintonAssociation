package badminton_association.com.example.honza.badmintonassociation.Models;

import android.util.Log;

import java.io.Serializable;

import badminton_association.com.example.honza.badmintonassociation.Activities.MainActivity;
import badminton_association.com.example.honza.badmintonassociation.HTTPInterface;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Honza on 13/12/2017.
 */

public class Player extends User implements Serializable {
   private Enum.Gender gender;

    public Player(){};

    public Enum.Gender getGender() {
        return gender;
    }

    public void setGender(Enum.Gender gender) {
        this.gender = gender;
    }

    public int getGenderAsInt(){
        return gender.ordinal();
    }

    public Player(int id, String name, String phone, String address, Enum.Gender gender){
        setId(id);
        setName(name);
        setPhone(phone);
        setAddress(address);
        this.gender = gender;
    }

    public Player(String name, String phone, String address, Enum.Gender gender){
        setName(name);
        setPhone(phone);
        setAddress(address);
        this.gender = gender;
    }

    public Player(int id, String name, String phone, String address, int gender){
        super.setId(id);
        setName(name);
        setPhone(phone);
        setAddress(address);
        this.gender = Enum.Gender.fromInteger(gender);
    }

    public Player(String name, String phone, String address, int gender){
        setName(name);
        setPhone(phone);
        setAddress(address);
        this.gender = Enum.Gender.fromInteger(gender);
    }

    public void save(){
        RestAdapter radapter=new RestAdapter.Builder().setEndpoint(MainActivity.URL).build();

        HTTPInterface restInt = radapter.create(HTTPInterface.class);

        restInt.postPlayer(this, new Callback<Object>() {
            @Override
            public void success(Object o, Response response) {
                Log.d("postScore", "Submission successful.");
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("postScore", "Submission failed." + error.getMessage());
            }
        });
    }
}
