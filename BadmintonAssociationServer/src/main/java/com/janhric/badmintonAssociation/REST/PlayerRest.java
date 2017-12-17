/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonAssociation.REST;

import com.janhric.badmintonAssociation.Enum.Gender;
import com.janhric.badmintonAssociation.Gateways.PlayerGateway;
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
   @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Player getPlayer(@QueryParam("id") int id) {
        Player player = new Player();
        try {
            PlayerGateway gateway = new PlayerGateway();
            player = gateway.getPlayer(id);
            gateway.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return player;
    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<Player>();

        try {
            PlayerGateway gateway = new PlayerGateway();
            players = gateway.getAllPlayers();
            gateway.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return players;
    }
    
    @POST
    @Path("/post")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postPlayer(Player player) {
        try{
            PlayerGateway gateway = new PlayerGateway();
            gateway.postPlayer(player);
            gateway.closeConnection();
            return Response.status(201).entity(player).build();
        } catch (Exception e){
            return Response.status(500).entity(e.getMessage()).build();
        }
    } 
}
