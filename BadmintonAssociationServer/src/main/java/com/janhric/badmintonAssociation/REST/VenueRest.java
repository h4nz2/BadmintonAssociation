/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonAssociation.REST;

import com.janhric.badmintonAssociation.Gateways.VenueGateway;
import com.janhric.badmintonAssociation.entities.Tournament;
import com.janhric.badmintonAssociation.entities.Venue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Honza
 */
@Path("/venue")
public class VenueRest {
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Venue> getAllVenues() {
        List<Venue> venues = new ArrayList<Venue>();

        try {
            VenueGateway gateway = new VenueGateway();
            venues = gateway.getAllVenues();
            gateway.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return venues;
    }
}
