/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonassociationconsole.Gateways;

import com.janhric.badmintonAssociation.entities.Tournament;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Honza
 */
public class TournamentGateway extends Gateway{
    private VenueGateway mVenueGateway;
    
    public TournamentGateway() throws SQLException {
        super();
        mVenueGateway = new VenueGateway();
    }
   
    public List<Tournament> getAllTournaments() throws SQLException{
        return listFromResultSet(getStatement().executeQuery("select * from tournament"));
    }
    
    public List<Tournament> getPlayerTournaments(int playerID) throws SQLException{
        String query = "select * from tournament where id in ("
                    + "select tournamentID from participate where playerID=?"
                    + ")";
        PreparedStatement preparedStmt = getPreparedStatement(query);
        preparedStmt.setInt(1, playerID);
        return listFromResultSet(preparedStmt.executeQuery());        
    }
    
    public List<Tournament> getAvailableTournaments(int playerID) throws SQLException{
        String query = "select * from tournament where id not in ("
                    + "select tournamentID from participate where playerID=?"
                    + ")";
        PreparedStatement preparedStmt = getPreparedStatement(query);
        preparedStmt.setInt(1, playerID);
        return listFromResultSet(preparedStmt.executeQuery());        
    }
    
    public void postTournament(Tournament tournament) throws SQLException {
        //update
        if(tournament.getId() > 0){
            String query = "update tournament set name=?, startDate=?, endDate=?, venueID=? where id=?";
            PreparedStatement preparedStmt = getPreparedStatement(query);
            preparedStmt.setString (1, tournament.getName());
            preparedStmt.setString(2, tournament.getStartDate());
            preparedStmt.setString(3, tournament.getEndDate());
            preparedStmt.setInt(4, tournament.getVenue().getId());
            preparedStmt.setInt(5, tournament.getId());
            preparedStmt.execute();
        } //create
        else{
            String query = "insert into tournament(name, startDate, endDate, venueID) values(?, ?, ?, ?)";
            PreparedStatement preparedStmt = getPreparedStatement(query);
            preparedStmt.setString (1, tournament.getName());
            preparedStmt.setString(2, tournament.getStartDate());
            preparedStmt.setString(3, tournament.getEndDate());
            preparedStmt.setInt(4, tournament.getVenue().getId());
            preparedStmt.execute();
        }
    }
    
    private List<Tournament> listFromResultSet(ResultSet resultSet) throws SQLException{
        List<Tournament> tournaments = new ArrayList<Tournament>();
        while(resultSet.next()){
            Tournament tournament = new Tournament();
            tournament.setId(resultSet.getInt("id"));
            tournament.setName(resultSet.getString("name"));
            tournament.setVenue(mVenueGateway.getVenue(resultSet.getInt("venueid")));
            mVenueGateway.closeConnection();
            tournament.setStartDate(resultSet.getString("startdate"));
            tournament.setEndDate(resultSet.getString("enddate"));
            tournaments.add(tournament);
        }
        return tournaments;
    }
    
}
