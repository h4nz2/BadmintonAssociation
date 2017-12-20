/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonassociationconsole.controllers;

import static badmintonassociationconsole.BadmintonAssociationConsole.URL;
import com.janhric.badmintonassociationconsole.Gateways.AdminGateway;
import com.janhric.badmintonassociationconsole.entities.Admin;
import com.janhric.badmintonassociationconsole.views.AdminView;
import java.sql.SQLException;
import java.util.List;
import retrofit2.*;

/**
 *
 * @author Honza
 */
public class AdminController {
    private AdminView adminView;
    private AdminGateway gateway;
    private Admin admin;
    
    public AdminController(){
        adminView = new AdminView(this);
        gateway = new AdminGateway();
    }
    
    public Admin editAdmin(Admin admin){
        adminView.printAdminInfo(admin);
        admin = adminView.getAdminInfo(admin);
        return admin;
    }

    public void start() {
        adminView.showMenu();
    }

    public Admin getAdmin() {
        try{
            return gateway.getAdmin(1);
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }        
    }
    
    
    
}
