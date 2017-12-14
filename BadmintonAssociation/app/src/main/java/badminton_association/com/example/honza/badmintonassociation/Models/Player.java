package badminton_association.com.example.honza.badmintonassociation.Models;

import java.io.Serializable;

/**
 * Created by Honza on 13/12/2017.
 */

public class Player implements Serializable {
    private int id;
    private String name;
    private String phone;
    private String address;
    private Enum.Gender gender;

    public Player(){};

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
    }

    public Player(String name, String phone, String address, Enum.Gender gender){
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
    }

    public void save(){
        //TODO REST communication
    }
}
