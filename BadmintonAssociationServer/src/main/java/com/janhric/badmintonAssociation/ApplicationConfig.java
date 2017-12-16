/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonAssociation;
import com.janhric.badmintonAssociation.REST.AdminRest;
import com.janhric.badmintonAssociation.REST.ParticipateRest;
import com.janhric.badmintonAssociation.REST.PlayerRest;
import com.janhric.badmintonAssociation.REST.TournamentRest;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/BadmintonAssociationServer")
public class ApplicationConfig extends Application{
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        resources.add(AdminRest.class);
        resources.add(PlayerRest.class);
        resources.add(TournamentRest.class);
        resources.add(ParticipateRest.class);
        return resources;
    }
}
 