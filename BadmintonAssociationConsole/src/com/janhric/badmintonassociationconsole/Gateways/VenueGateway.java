/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonassociationconsole.Gateways;

import com.janhric.badmintonassociationconsole.entities.Venue;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Honza
 */
public class VenueGateway extends Gateway {    
    public VenueGateway() {
        super();
    }
    
    public Venue getVenue(int id) throws SQLException{
        String query = "select * from venue where id = ?";
        PreparedStatement preparedStmt = getPreparedStatement(query);
        preparedStmt.setInt(1, id);
        return listFromResultSet(preparedStmt.executeQuery()).get(0);
    }
    
    public List<Venue> getAllVenues() throws SQLException{
        return listFromResultSet(getStatement().executeQuery("select * from venue"));
    }
    
    private List<Venue> listFromResultSet(ResultSet resultSet) throws SQLException{
        List<Venue> venues = new ArrayList<Venue>();

        while(resultSet.next()){
            Venue venue = new Venue();
            venue.setId(resultSet.getInt("id"));
            venue.setName(resultSet.getString("name"));
            venue.setAddress(resultSet.getString("address"));
            venues.add(venue);
        }
        return venues;
    }
}
