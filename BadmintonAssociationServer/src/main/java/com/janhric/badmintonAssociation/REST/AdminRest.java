/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonAssociation.REST;

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
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";
    private static final String DB_NAME = "badminton";
    
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Admin getAdmin(@QueryParam("id") int id) {
        Admin admin = new Admin();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:6000/" + DB_NAME, USERNAME, PASSWORD);            
            String query = "select * from admin where id=?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, id);
            ResultSet resultSet = preparedStmt.executeQuery();
            if(resultSet.first()){
                admin.setId(resultSet.getInt("id"));
                admin.setName(resultSet.getString("name"));
                admin.setPhone(resultSet.getString("phone"));
                admin.setAddress(resultSet.getString("address"));
            }      
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
    }    
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Admin> getAdmins() {
        ArrayList<Admin> admins = new ArrayList<Admin>();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:6000/" + DB_NAME, USERNAME, PASSWORD);            
            Statement statement = connection.createStatement();            
            ResultSet resultSet = statement.executeQuery("select * from admin"); 
            while(resultSet.next()){
                Admin admin = new Admin();
                admin.setId(resultSet.getInt("id"));
                admin.setName(resultSet.getString("name"));
                admin.setPhone(resultSet.getString("phone"));
                admin.setAddress(resultSet.getString("address"));
                admins.add(admin);
            }      
            connection.close();
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
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:6000/" + DB_NAME, USERNAME, PASSWORD); 
            String query = "insert into admin(name, phone, address) values(?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, admin.getName());
            preparedStmt.setString(2, admin.getPhone());
            preparedStmt.setString(3, admin.getAddress());            
            preparedStmt.execute();
            
            return Response.status(201).entity(admin).build();
        } catch (Exception e){
            return Response.status(500).build();
        }
    } 
}
