/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonassociationconsole.controllers;

import com.janhric.badmintonassociationconsole.Gateways.TournamentGateway;
import com.janhric.badmintonassociationconsole.entities.Tournament;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Honza
 */
public class TournamentController {

    public void createTournament(Tournament tournament) {
        TournamentGateway gw = new TournamentGateway();
        try{
            gw.postTournament(tournament);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public List<Tournament> getAllTournaments(){
        TournamentGateway gw = new TournamentGateway();
        List<Tournament> tournaments = new ArrayList<Tournament>();
        try{
            tournaments = gw.getAllTournaments();
            gw.closeConnection();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return tournaments;
    }
    
}
