package badminton_association.com.example.honza.badmintonassociation.Models;

import java.io.Serializable;

/**
 * Created by Honza on 16/12/2017.
 */

public class Model implements Serializable {
    private int id;

    public Model(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
