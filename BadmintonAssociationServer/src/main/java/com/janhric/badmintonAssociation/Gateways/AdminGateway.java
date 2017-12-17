/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonAssociation.Gateways;

import com.janhric.badmintonAssociation.entities.Admin;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Honza
 */
public class AdminGateway extends Gateway {
    
    public List<Admin> getAllAdmins() throws SQLException {
        return listFromResultSet(getStatement().executeQuery("select * from admin"));
    }
    
    public Admin getAdmin(int adminID) throws SQLException {
        String query = "select * from admin where id = ?";
        PreparedStatement preparedStmt = getPreparedStatement(query);
        preparedStmt.setInt(1, adminID);
        return listFromResultSet(preparedStmt.executeQuery()).get(0);
    }
    
    public void postAdmin(Admin admin) throws SQLException {
        //update
        if(admin.getId() > 0){
            String query = "update admin set name=?, phone=?, address=? where id=?";
            PreparedStatement preparedStmt = getPreparedStatement(query);
            preparedStmt.setString (1, admin.getName());
            preparedStmt.setString(2, admin.getPhone());
            preparedStmt.setString(3, admin.getAddress());
            preparedStmt.setInt(4, admin.getId());
            preparedStmt.execute();
        } //create
        else{
            String query = "insert into admin(name, phone, address) values(?, ?, ?)";
            PreparedStatement preparedStmt = getPreparedStatement(query);
            preparedStmt.setString (1, admin.getName());
            preparedStmt.setString(2, admin.getPhone());
            preparedStmt.setString(3, admin.getAddress());            
            preparedStmt.execute();
        }
            
    }
    
    private List<Admin> listFromResultSet(ResultSet resultSet) throws SQLException{
        List<Admin> admins = new ArrayList<Admin>();
        while(resultSet.next()){
            Admin admin = new Admin();
            admin.setId(resultSet.getInt("id"));
            admin.setName(resultSet.getString("name"));
            admin.setPhone(resultSet.getString("phone"));
            admin.setAddress(resultSet.getString("address"));
            admins.add(admin);
        }
        return admins;
    }
}
