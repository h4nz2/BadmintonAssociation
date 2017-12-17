package badminton_association.com.example.honza.badmintonassociation.Models;

import java.io.Serializable;

/**
 * Created by Honza on 16/12/2017.
 */

public class Tournament extends Model implements Serializable{

    private String startDate;
    private String endDate;
    private String name;
    private Venue venue;

    public Tournament() {
    }

    public Tournament(Integer id, String startDate, String endDate, String name, Venue venue) {
        super.setId(id);
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
        this.venue = venue;
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

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

}
