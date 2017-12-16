package badminton_association.com.example.honza.badmintonassociation.Models;

import java.io.Serializable;

/**
 * Created by Honza on 16/12/2017.
 */

public class User extends Model implements Serializable{
    private String name;
    private String address;
    private String phone;

    public User(){
        super();
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

    public User(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public User(int id, String name, String address, String phone) {
        setId(id);
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

}
