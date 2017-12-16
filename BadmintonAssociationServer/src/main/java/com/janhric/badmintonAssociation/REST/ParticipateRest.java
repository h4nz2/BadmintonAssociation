/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonAssociation.REST;

import com.janhric.badmintonAssociation.entities.ParticipatePK;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Honza
 */
@Path("/participate")
public class ParticipateRest {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";
    private static final String DB_NAME = "badminton";
    
    @POST
    @Path("/post")
    @Produces(MediaType.APPLICATION_JSON)
    public Response newRecord(ParticipatePK participate) {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:6000/" + DB_NAME, USERNAME, PASSWORD); 
            String query = "insert into participate(playerID, tournamentID) values(?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt (1, participate.getPlayerID());
            preparedStmt.setInt(2, participate.getTournamentID());
            preparedStmt.execute();
            
            return Response.status(201).build();
        } catch (Exception e){
            return Response.status(500).entity(e.getMessage()).build();
        }
    }
}
