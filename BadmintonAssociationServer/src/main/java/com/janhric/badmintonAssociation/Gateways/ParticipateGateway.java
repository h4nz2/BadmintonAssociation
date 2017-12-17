/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonAssociation.Gateways;

import com.janhric.badmintonAssociation.entities.ParticipatePK;
import java.sql.*;

/**
 *
 * @author Honza
 */
public class ParticipateGateway extends Gateway{
    public ParticipateGateway() throws SQLException{
        super();
    }
    
    public void createRecord(ParticipatePK participate) throws SQLException {
            String query = "insert into participate(playerID, tournamentID) values(?, ?)";
            PreparedStatement preparedStmt = getPreparedStatement(query);
            preparedStmt.setInt (1, participate.getPlayerID());
            preparedStmt.setInt(2, participate.getTournamentID());
            preparedStmt.execute();
    }
}
