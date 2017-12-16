/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonAssociation.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Honza
 */
@Embeddable
public class ParticipatePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "playerID")
    private int playerID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tournamentID")
    private int tournamentID;

    public ParticipatePK() {
    }

    public ParticipatePK(int playerID, int tournamentID) {
        this.playerID = playerID;
        this.tournamentID = tournamentID;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public int getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(int tournamentID) {
        this.tournamentID = tournamentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) playerID;
        hash += (int) tournamentID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParticipatePK)) {
            return false;
        }
        ParticipatePK other = (ParticipatePK) object;
        if (this.playerID != other.playerID) {
            return false;
        }
        if (this.tournamentID != other.tournamentID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.janhric.balancergameserver.ParticipatePK[ playerID=" + playerID + ", tournamentID=" + tournamentID + " ]";
    }
    
}
