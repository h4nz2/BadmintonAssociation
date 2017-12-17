package badminton_association.com.example.honza.badmintonassociation.Models;

/**
 * Created by Honza on 16/12/2017.
 */

public class Venue extends Model {
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
