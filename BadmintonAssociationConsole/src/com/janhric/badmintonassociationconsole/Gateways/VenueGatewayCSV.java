/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonassociationconsole.Gateways;

import com.janhric.badmintonassociationconsole.entities.Venue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Honza
 */
public class VenueGatewayCSV {
    private static String FILENAME = "venuesTable.csv";
    private static String DELIMITER = ";";
    
    public void createVenue(Venue venue){
        List<Venue> venues = readAllVenues();
        venues.add(venue);
        saveVenues(venues);
    }
    
    public List<Venue> readAllVenues(){
        List<Venue> venues = new ArrayList<Venue>();
        BufferedReader fileReader = null;
     
        try {        	
            String line = "";
            fileReader = new BufferedReader(new FileReader(FILENAME));
            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(DELIMITER);
                if (tokens.length >= 2) {
                    Venue venue = new Venue();
                    venue.setName(tokens[0]);
                    venue.setAddress(tokens[1]);
                    venues.add(venue);
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return venues;
    }
    
    private void saveVenues(List<Venue> venues){
        BufferedWriter fileWriter = null;
        
        try {
            fileWriter = new BufferedWriter(new FileWriter(FILENAME));
            for(Venue venue : venues){
                fileWriter.write(venueToCsvLine(venue));
                fileWriter.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {     
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    private String venueToCsvLine(Venue venue){
        String line = "";
        line += venue.getName() + DELIMITER;
        line += venue.getAddress();
        line += "\n";        
        return line;
    }
}
