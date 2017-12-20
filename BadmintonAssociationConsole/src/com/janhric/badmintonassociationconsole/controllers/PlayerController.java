/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonassociationconsole.controllers;

import com.janhric.badmintonassociationconsole.Gateways.PlayerGateway;
import com.janhric.badmintonassociationconsole.entities.Player;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Honza
 */
public class PlayerController {
    public List<Player> getAllPlayers() {
        PlayerGateway playerGateway = new PlayerGateway();
        List<Player> players = new ArrayList<>();
        try{
            players = playerGateway.getAllPlayers();
            playerGateway.closeConnection();
            return players;
        } catch (Exception e) {
            e.printStackTrace();
            return players;
        }            
    }
    
    public boolean deletePlayer(Player player){
        PlayerGateway playerGateway = new PlayerGateway();
        try{
            playerGateway.deletePlayer(player);
            return true;
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
