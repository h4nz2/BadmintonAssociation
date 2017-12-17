/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonAssociation.REST;

import com.janhric.badmintonAssociation.Gateways.AdminGateway;
import com.janhric.badmintonAssociation.entities.Admin;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.QueryParam;

@Path("/admin")
public class AdminRest {
    
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Admin getAdmin(@QueryParam("id") int id) {
        Admin admin = new Admin();
        try {
            AdminGateway gateway = new AdminGateway();
            admin = gateway.getAdmin(id);
            gateway.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
    }    
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Admin> getAdmins() {
        List<Admin> admins = new ArrayList<Admin>();

        try {
            AdminGateway gateway = new AdminGateway();
            admins = gateway.getAllAdmins();
            gateway.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admins;
    }    
    
    @POST
    @Path("/edit")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postAdmin(Admin admin) {
        try{
            AdminGateway gateway = new AdminGateway();
            gateway.postAdmin(admin);   
            gateway.closeConnection();
            return Response.status(201).entity(admin).build();
        } catch (Exception e){
            return Response.status(500).build();
        }
    } 
}
