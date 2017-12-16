package badminton_association.com.example.honza.badmintonassociation.Models;

import java.util.Date;

/**
 * Created by Honza on 16/12/2017.
 */

public class Tournament extends Model{

    private String startDate;
    private String endDate;
    private String name;
    private Integer venueID;

    public Tournament() {
    }

    public Tournament(Integer id, String startDate, String endDate, String name, Integer venueID) {
        super.setId(id);
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
        this.venueID = venueID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVenueID() {
        return venueID;
    }

    public void setVenueID(Integer venueID) {
        this.venueID = venueID;
    }

}
