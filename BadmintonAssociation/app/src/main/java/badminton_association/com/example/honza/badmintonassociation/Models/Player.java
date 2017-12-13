package badminton_association.com.example.honza.badmintonassociation.Models;

/**
 * Created by Honza on 13/12/2017.
 */

public class Player {
    private int id;
    private String name;
    private int phone;
    private String address;
    private Enum.Gender gender;

    public Player(){};

    public Player(int id, String name, int phone, String address, Enum.Gender gender){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
    }
}
