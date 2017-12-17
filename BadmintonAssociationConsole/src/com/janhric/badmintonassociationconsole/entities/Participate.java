/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonassociationconsole.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Honza
 */
@Entity
@Table(name = "participate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Participate.findAll", query = "SELECT p FROM Participate p")
    , @NamedQuery(name = "Participate.findByPlayerID", query = "SELECT p FROM Participate p WHERE p.participatePK.playerID = :playerID")
    , @NamedQuery(name = "Participate.findByTournamentID", query = "SELECT p FROM Participate p WHERE p.participatePK.tournamentID = :tournamentID")})
public class Participate implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParticipatePK participatePK;

    public Participate() {
    }

    public Participate(ParticipatePK participatePK) {
        this.participatePK = participatePK;
    }

    public Participate(int playerID, int tournamentID) {
        this.participatePK = new ParticipatePK(playerID, tournamentID);
    }

    public ParticipatePK getParticipatePK() {
        return participatePK;
    }

    public void setParticipatePK(ParticipatePK participatePK) {
        this.participatePK = participatePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (participatePK != null ? participatePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participate)) {
            return false;
        }
        Participate other = (Participate) object;
        if ((this.participatePK == null && other.participatePK != null) || (this.participatePK != null && !this.participatePK.equals(other.participatePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.janhric.balancergameserver.Participate[ participatePK=" + participatePK + " ]";
    }
    
}
