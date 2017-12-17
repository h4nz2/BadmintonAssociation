/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonAssociation.Gateways;

import com.janhric.badmintonAssociation.entities.Venue;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Honza
 */
public class VenueGateway extends Gateway {
    
    public VenueGateway() throws SQLException{
        super();
    }
    
    public List<Venue> getAllVenues() throws SQLException{
        List<Venue> venues = new ArrayList<Venue>();
        Statement statement = getStatement();
        ResultSet resultSet = statement.executeQuery("select * from venue"); 
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
