/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonAssociation.REST;

import com.janhric.badmintonAssociation.Gateways.ParticipateGateway;
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
    @POST
    @Path("/post")
    @Produces(MediaType.APPLICATION_JSON)
    public Response newRecord(ParticipatePK participate) {
        try{
            ParticipateGateway gateway = new ParticipateGateway();
            gateway.createRecord(participate);
            gateway.closeConnection();
            return Response.status(201).build();
        } catch (Exception e){
            return Response.status(500).entity(e.getMessage()).build();
        }
    }
}
