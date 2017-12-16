/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonAssociation.REST;

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
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Honza
 */
@Path("/tournament")
public class TournamentRest {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";
    private static final String DB_NAME = "badminton";
    public static final String DATE_FORMAT = "yyyy-mm-dd";
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tournament> getTournaments() {
        ArrayList<Tournament> tournaments = new ArrayList<Tournament>();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:6000/" + DB_NAME, USERNAME, PASSWORD);            
            Statement statement = connection.createStatement();            
            ResultSet resultSet = statement.executeQuery("select * from tournament"); 
            while(resultSet.next()){
                Tournament tournament = new Tournament();
                tournament.setId(resultSet.getInt("id"));
                tournament.setName(resultSet.getString("name"));
                tournament.setVenueID(resultSet.getInt("venueid"));
                tournament.setStartDate(resultSet.getString("startdate"));
                tournament.setEndDate(resultSet.getString("enddate"));
                tournaments.add(tournament);
            }      
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tournaments;
    }
    
    @GET
    @Path("/player")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tournament> getTournamentsByPlayer(@QueryParam("player") int player) {
        ArrayList<Tournament> tournaments = new ArrayList<Tournament>();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:6000/" + DB_NAME, USERNAME, PASSWORD);            
            Statement statement = connection.createStatement();          
            String query = "select * from tournament where id in ("
                    + "select tournamentID from participate where playerID=?"
                    + ")";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, player);
            ResultSet resultSet = preparedStmt.executeQuery();
            
            while(resultSet.next()){
                Tournament tournament = new Tournament();
                tournament.setId(resultSet.getInt("id"));
                tournament.setName(resultSet.getString("name"));
                tournament.setVenueID(resultSet.getInt("venueid"));
                tournament.setStartDate(resultSet.getString("startdate"));
                tournament.setEndDate(resultSet.getString("enddate"));
                tournaments.add(tournament);
            }      
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tournaments;
    }
    
    @GET
    @Path("/available")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tournament> getAvailableTournamentsByPlayer(@QueryParam("player") int player) {
        ArrayList<Tournament> tournaments = new ArrayList<Tournament>();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:6000/" + DB_NAME, USERNAME, PASSWORD);            
            Statement statement = connection.createStatement();          
            String query = "select * from tournament where id not in ("
                    + "select tournamentID from participate where playerID=?"
                    + ")";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, player);
            ResultSet resultSet = preparedStmt.executeQuery();
            
            while(resultSet.next()){
                Tournament tournament = new Tournament();
                tournament.setId(resultSet.getInt("id"));
                tournament.setName(resultSet.getString("name"));
                tournament.setVenueID(resultSet.getInt("venueid"));
                tournament.setStartDate(resultSet.getString("startdate"));
                tournament.setEndDate(resultSet.getString("enddate"));
                tournaments.add(tournament);
            }      
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tournaments;
    }
    
}
