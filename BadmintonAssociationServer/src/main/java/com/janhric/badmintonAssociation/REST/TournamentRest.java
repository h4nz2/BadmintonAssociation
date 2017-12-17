/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonAssociation.REST;

import com.janhric.badmintonAssociation.Gateways.TournamentGateway;
import com.janhric.badmintonAssociation.entities.Tournament;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Honza
 */
@Path("/tournament")
public class TournamentRest {
   @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tournament> getTournaments() {
        List<Tournament> tournaments = new ArrayList<Tournament>();

        try {
            TournamentGateway gateway = new TournamentGateway();
            tournaments = gateway.getAllTournaments();
            gateway.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tournaments;
    }
    
    @GET
    @Path("/player")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tournament> getTournamentsByPlayer(@QueryParam("player") int player) {
        List<Tournament> tournaments = new ArrayList<Tournament>();

        try {
            TournamentGateway gateway = new TournamentGateway();
            tournaments = gateway.getPlayerTournaments(player);
            gateway.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tournaments;
    }
    
    @GET
    @Path("/available")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tournament> getAvailableTournamentsByPlayer(@QueryParam("player") int player) {
        List<Tournament> tournaments = new ArrayList<Tournament>();

        try {
            TournamentGateway gateway = new TournamentGateway();
            tournaments = gateway.getAvailableTournaments(player);
            gateway.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tournaments;
    }
    
    @POST
    @Path("/post")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postTournament(Tournament tournament) {
        try{
            TournamentGateway gateway = new TournamentGateway();
            gateway.postTournament(tournament);
            gateway.closeConnection();
            return Response.status(201).entity(tournament).build();
        } catch (Exception e){
            e.printStackTrace();
            return Response.status(500).entity(e.getMessage()).build();
        }
    }
    
}
