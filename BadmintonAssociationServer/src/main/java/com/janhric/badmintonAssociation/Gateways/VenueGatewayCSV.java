/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonAssociation.Gateways;

import com.janhric.badmintonAssociation.entities.Venue;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Honza
 */
public class VenueGatewayCSV {
    private static String FILENAME = "/tables/venuesTable.csv";
    private static String DELIMITER = ";";
    
    public void createVenue(Venue venue){
        FileWriter fileWriter = null; 
        try {
            fileWriter = new FileWriter(FILENAME);            
            fileWriter.append(venueToCsvLine(venue));            
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {     
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }
    
    
    private String venueToCsvLine(Venue venue){
        String line = "";
        line += Integer.toString(venue.getId()) + DELIMITER;
        line += venue.getName() + DELIMITER;
        line += venue.getAddress() + DELIMITER;
        line += "\n";        
        return line;
    }
}
