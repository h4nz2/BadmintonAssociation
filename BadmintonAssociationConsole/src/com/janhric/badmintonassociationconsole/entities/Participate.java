/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonassociationconsole.entities;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Honza
 */
public class Participate implements Serializable {

    private static final long serialVersionUID = 1L;
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
