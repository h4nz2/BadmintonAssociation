/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonassociationconsole.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Honza
 */
@Entity
@Table(name = "game")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Game.findAll", query = "SELECT g FROM Game g")
    , @NamedQuery(name = "Game.findById", query = "SELECT g FROM Game g WHERE g.id = :id")
    , @NamedQuery(name = "Game.findByMatchDate", query = "SELECT g FROM Game g WHERE g.matchDate = :matchDate")
    , @NamedQuery(name = "Game.findByHomeScore", query = "SELECT g FROM Game g WHERE g.homeScore = :homeScore")
    , @NamedQuery(name = "Game.findByGuestscore", query = "SELECT g FROM Game g WHERE g.guestscore = :guestscore")
    , @NamedQuery(name = "Game.findByHomePlayerId", query = "SELECT g FROM Game g WHERE g.homePlayerId = :homePlayerId")
    , @NamedQuery(name = "Game.findByGuestPlayerId", query = "SELECT g FROM Game g WHERE g.guestPlayerId = :guestPlayerId")
    , @NamedQuery(name = "Game.findByTournamentId", query = "SELECT g FROM Game g WHERE g.tournamentId = :tournamentId")})
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "matchDate")
    @Temporal(TemporalType.DATE)
    private Date matchDate;
    @Column(name = "homeScore")
    private Integer homeScore;
    @Column(name = "guestscore")
    private Integer guestscore;
    @Column(name = "homePlayerId")
    private Integer homePlayerId;
    @Column(name = "guestPlayerId")
    private Integer guestPlayerId;
    @Column(name = "tournamentId")
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
