/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonAssociation.REST;

import com.janhric.badmintonAssociation.Enum.Gender;
import com.janhric.badmintonAssociation.entities.Admin;
import com.janhric.badmintonAssociation.entities.Player;
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

@Path("/player")
public class PlayerRest {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";
    private static final String DB_NAME = "badminton";
    
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Player getPlayer(@QueryParam("id") int id) {
        Player player = new Player();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:6000/" + DB_NAME, USERNAME, PASSWORD);            
            
            String query = "select * from player where id=?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, id);
            ResultSet resultSet = preparedStmt.executeQuery();
            
            if(resultSet.first()){
                player.setId(resultSet.getInt("id"));
                player.setName(resultSet.getString("name"));
                player.setPhone(resultSet.getString("phone"));
                player.setAddress(resultSet.getString("address"));
                player.setGender(resultSet.getShort("gender"));
            }      
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return player;
    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Player> getPlayers() {
        ArrayList<Player> admins = new ArrayList<Player>();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:6000/" + DB_NAME, USERNAME, PASSWORD);            
            Statement statement = connection.createStatement();            
            ResultSet resultSet = statement.executeQuery("select * from player"); 
            while(resultSet.next()){
                Player player = new Player();
                player.setId(resultSet.getInt("id"));
                player.setName(resultSet.getString("name"));
                player.setPhone(resultSet.getString("phone"));
                player.setAddress(resultSet.getString("address"));
                player.setGender(resultSet.getShort("gender"));
                admins.add(player);
            }      
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admins;
    }
    
    @POST
    @Path("/post")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postPlayer(Player player) {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:6000/" + DB_NAME, USERNAME, PASSWORD); 
            if(player.getId() > 0){
                String query = "update player set name=?, phone=?, address=?, gender=? where id=?";
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString (1, player.getName());
                preparedStmt.setString(2, player.getPhone());
                preparedStmt.setString(3, player.getAddress());      
                preparedStmt.setShort(4, (short)player.getGender().ordinal());
                preparedStmt.setInt(5, player.getId());
                preparedStmt.execute();
            } else {
                String query = "insert into player(name, phone, address, gender) values(?, ?, ?, ?)";
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString (1, player.getName());
                preparedStmt.setString(2, player.getPhone());
                preparedStmt.setString(3, player.getAddress());      
                preparedStmt.setShort(4, (short)player.getGender().ordinal());
                preparedStmt.execute();
            }
            return Response.status(201).entity(player).build();
        } catch (Exception e){
            return Response.status(500).entity(e.getMessage()).build();
        }
    } 
}
