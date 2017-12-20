/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonassociationconsole.controllers;

import com.janhric.badmintonassociationconsole.Gateways.ParticipateGateway;
import com.janhric.badmintonassociationconsole.entities.ParticipatePK;
import com.janhric.badmintonassociationconsole.entities.Player;
import com.janhric.badmintonassociationconsole.entities.Tournament;
import java.sql.SQLException;

/**
 *
 * @author Honza
 */
public class ParticipateController {
    public void newRecord(Player player, Tournament tournament){
        ParticipateGateway gw = new ParticipateGateway();
        try{
            gw.createRecord(new ParticipatePK(player.getId(), tournament.getId()));
            gw.closeConnection();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
