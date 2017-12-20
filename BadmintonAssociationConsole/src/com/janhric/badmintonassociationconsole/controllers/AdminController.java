/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonassociationconsole.controllers;

import static badmintonassociationconsole.BadmintonAssociationConsole.URL;
import com.janhric.badmintonassociationconsole.Gateways.AdminGateway;
import com.janhric.badmintonassociationconsole.Gateways.PlayerGateway;
import com.janhric.badmintonassociationconsole.Gateways.VenueGateway;
import com.janhric.badmintonassociationconsole.Gateways.VenueGatewayCSV;
import com.janhric.badmintonassociationconsole.entities.Admin;
import com.janhric.badmintonassociationconsole.entities.Player;
import com.janhric.badmintonassociationconsole.entities.Venue;
import com.janhric.badmintonassociationconsole.views.AdminView;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Honza
 */
public class AdminController {
    private AdminView adminView;
    private AdminGateway gateway;
    private Admin admin;
    
    public AdminController(){
        adminView = new AdminView(this);
        gateway = new AdminGateway();
    }
    
    public Admin editAdmin(Admin admin){
        try{
            gateway.postAdmin(admin);
        } catch (SQLException e){
            e.printStackTrace();
        }        
        return admin;
    }

    public void start() {
        adminView.showMenu();
    }

    public Admin getAdmin() {
        try{
            Admin admin = gateway.getAdmin(1);
            gateway.closeConnection();
            return admin;            
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }   
        
    }
    
    public void createVenue(Venue venue){
        /*VenueGateway gw = new VenueGateway();
        try{
            gw.createVenue(venue);
            gw.closeConnection();
        } catch (SQLException e){
            e.printStackTrace();
        }*/
        
        VenueGatewayCSV gateway = new VenueGatewayCSV();
        gateway.createVenue(venue);
    }

    public List<Venue> getAllVenuesCsv() {
        /*
        VenueGateway gw = new VenueGateway();
        List<Venue> venues = new ArrayList<Venue>();
        try{
            venues = gw.getAllVenues();
            gw.closeConnection();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return venues;
        */
        
        VenueGatewayCSV gw = new VenueGatewayCSV();
        return gw.readAllVenues();
        
    }
}
