package badminton_association.com.example.honza.badmintonassociation.Models;

/**
 * Created by Honza on 16/12/2017.
 */

public class Participate {
    private int playerID;
    private int tournamentID;



    public int getPlayerID() {
        return playerID;
    }

    public Participate(){

    }

    public Participate(int playerID, int tournamentID) {
        this.playerID = playerID;
        this.tournamentID = tournamentID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public int getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(int tournamentID) {
        this.tournamentID = tournamentID;
    }
}
