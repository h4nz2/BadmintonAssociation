/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonassociationconsole.entities;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Honza
 */

public class Game implements Serializable {

    private static final long serialVersionUID = 1L;
   
    private Integer id;
  
    private Date matchDate;
   
    private Integer homeScore;
    private Integer guestscore;
    private Integer homePlayerId;
    private Integer guestPlayerId;
    private Integer tournamentId;

    public Game() {
    }

    public Game(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public Integer getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Integer homeScore) {
        this.homeScore = homeScore;
    }

    public Integer getGuestscore() {
        return guestscore;
    }

    public void setGuestscore(Integer guestscore) {
        this.guestscore = guestscore;
    }

    public Integer getHomePlayerId() {
        return homePlayerId;
    }

    public void setHomePlayerId(Integer homePlayerId) {
        this.homePlayerId = homePlayerId;
    }

    public Integer getGuestPlayerId() {
        return guestPlayerId;
    }

    public void setGuestPlayerId(Integer guestPlayerId) {
        this.guestPlayerId = guestPlayerId;
    }

    public Integer getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Integer tournamentId) {
        this.tournamentId = tournamentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Game)) {
            return false;
        }
        Game other = (Game) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.janhric.balancergameserver.Game[ id=" + id + " ]";
    }
    
}
