package badminton_association.com.example.honza.badmintonassociation;

/**
 * Created by Honza on 16/12/2017.
 */

import java.util.List;

import badminton_association.com.example.honza.badmintonassociation.Models.Admin;
import badminton_association.com.example.honza.badmintonassociation.Models.Participate;
import badminton_association.com.example.honza.badmintonassociation.Models.Player;
import badminton_association.com.example.honza.badmintonassociation.Models.Tournament;
import badminton_association.com.example.honza.badmintonassociation.Models.Venue;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;


public interface HTTPInterface {
    @GET("/player/get?id=1")
    void getPlayer(Callback<Player> cb);

    @GET("/admin/get?id=1")
    void getAdmin(Callback<Admin> cb);

    @POST("/player/post")
    void postPlayer(@Body Player player, Callback<Object> cb);

    @GET("/tournament/player")
    void getPlayerTournaments(@Query("player") int id, Callback<List<Tournament>> cb);

    @GET("/tournament/available")
    void getAvailableTournaments(@Query("player") int id, Callback<List<Tournament>> cb);

    @POST("/participate/post")
    void joinPlayerTournament(@Body Participate participate, Callback<Object> cb);

    @GET("/tournament/all")
    void getAllTournaments(Callback<List<Tournament>> cb);

    @GET("/venue/all")
    void getAllVenues(Callback<List<Venue>> cb);

    @POST(("/tournament/post"))
    void postTournament(@Body Tournament tournament, Callback<Object> cb);

}
