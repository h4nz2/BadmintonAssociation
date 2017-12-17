/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonAssociation.Gateways;

import java.sql.*;

/**
 *
 * @author Honza
 */
public class Gateway {
    protected static final String USERNAME = "root";
    protected static final String PASSWORD = "1234";
    protected static final String DB_NAME = "badminton";
    
    protected Connection mConnection; 
        
    public Statement getStatement() throws SQLException{
        if(mConnection == null || mConnection.isClosed())
            connect();
        return mConnection.createStatement();
    }
    
    public PreparedStatement getPreparedStatement(String query) throws SQLException{
        if(mConnection == null || mConnection.isClosed())
            connect();
        return mConnection.prepareStatement(query);
    }
    
    private void connect() throws SQLException {
        mConnection = DriverManager.getConnection("jdbc:mysql://localhost:6000/" + DB_NAME, USERNAME, PASSWORD);
    }
    
    public void closeConnection() throws SQLException {
        if(!mConnection.isClosed())
            mConnection.close();
    }
}
