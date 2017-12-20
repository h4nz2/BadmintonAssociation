/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonassociationconsole.controllers;

import com.janhric.badmintonassociationconsole.Gateways.VenueGateway;
import com.janhric.badmintonassociationconsole.entities.Venue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Honza
 */
public class VenueController {
    public List<Venue> getallVenues(){
        VenueGateway gw = new VenueGateway();
        List<Venue> venues = new ArrayList<Venue>();
        try{
            venues = gw.getAllVenues();
            gw.closeConnection();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return venues;
    }
}
