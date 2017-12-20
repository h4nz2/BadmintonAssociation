/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonassociationconsole.views;

import static badmintonassociationconsole.Reader.getLine;
import com.janhric.badmintonassociationconsole.controllers.AdminController;
import com.janhric.badmintonassociationconsole.entities.Admin;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Honza
 */
public class AdminView {
    private AdminController controller;
    
    
    public AdminView(AdminController controller){
        this.controller = controller;
    }
    
    public Admin getAdminInfo(){
        Admin admin = new Admin();
        
        try{
            System.out.print("Enter name: ");
            admin.setName(getLine());
            System.out.print("Enter phone: ");
            System.out.print("Enter address: ");
        } catch (Exception e){
            e.printStackTrace();
        }
        return admin;
    }
    
    public Admin getAdminInfo(Admin admin){
        
            System.out.print("Enter name: ");
            admin.setName(getLine());
            System.out.print("Enter phone: ");
            admin.setPhone(getLine());
            System.out.print("Enter address: ");
            admin.setAddress(getLine());
        
        return admin;
    }
    
    public void printAdminInfo(Admin admin){
        System.out.print("Name: ");
        System.out.println(admin.getName());
        System.out.print("Phone: ");
        System.out.println(admin.getPhone());
        System.out.print("Address: ");
        System.out.println(admin.getAddress());
    }

    public void showMenu() {
        System.out.println("Admin menu:");
        System.out.println("1 - edit my account\n"
                + "2 - players\n"
                + "3 - tournaments"
                + "0 - exit");
        
        switch(getLine()){
            case "1":
                editMyAccount();
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private void editMyAccount() {
        controller.editAdmin(getAdminInfo(controller.getAdmin()));
    }
    
}
