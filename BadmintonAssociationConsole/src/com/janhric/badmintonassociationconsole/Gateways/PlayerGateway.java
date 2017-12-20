/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonassociationconsole.Gateways;

import com.janhric.badmintonassociationconsole.entities.Player;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Honza
 */
public class PlayerGateway extends Gateway{
    public PlayerGateway() {
        super();
    }
    
    public List<Player> getAllPlayers() throws SQLException{
        return listFromResultSet(getStatement().executeQuery("select * from player"));
    }
    
    public Player getPlayer(int playerID) throws SQLException{
        String query = "select * from player where id = ?";
        PreparedStatement preparedStmt = getPreparedStatement(query);
        preparedStmt.setInt(1, playerID);
        return listFromResultSet(preparedStmt.executeQuery()).get(0);
    }
    
    public void postPlayer(Player player) throws SQLException {
        //update
        if(player.getId() > 0){
            String query = "update player set name=?, phone=?, address=?, gender=? where id=?";
            PreparedStatement preparedStmt = getPreparedStatement(query);
            preparedStmt.setString (1, player.getName());
            preparedStmt.setString(2, player.getPhone());
            preparedStmt.setString(3, player.getAddress());      
            preparedStmt.setShort(4, (short)player.getGender().ordinal());
            preparedStmt.setInt(5, player.getId());
            preparedStmt.execute();
        } //create 
        else {
            String query = "insert into player(name, phone, address, gender) values(?, ?, ?, ?)";
            PreparedStatement preparedStmt = getPreparedStatement(query);
            preparedStmt.setString (1, player.getName());
            preparedStmt.setString(2, player.getPhone());
            preparedStmt.setString(3, player.getAddress());      
            preparedStmt.setShort(4, (short)player.getGender().ordinal());
            preparedStmt.execute();
        }
    }
    
    public void deletePlayer(Player player) throws SQLException {
        String query = "delete from player where id=?";
        PreparedStatement preparedStmt = getPreparedStatement(query);
        preparedStmt.setInt(1, player.getId());
        preparedStmt.execute();
    }
    
    private List<Player> listFromResultSet(ResultSet resultSet) throws SQLException{
        List<Player> players = new ArrayList<Player>();
        
        while(resultSet.next()){
            Player player = new Player();
            player.setId(resultSet.getInt("id"));
            player.setName(resultSet.getString("name"));
            player.setPhone(resultSet.getString("phone"));
            player.setAddress(resultSet.getString("address"));
            player.setGender(resultSet.getShort("gender"));
            players.add(player);
        }    
        
        return players;
    }
    
}
