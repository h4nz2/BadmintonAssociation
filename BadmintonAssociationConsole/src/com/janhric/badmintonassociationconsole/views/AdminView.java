/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janhric.badmintonassociationconsole.views;

import static badmintonassociationconsole.Reader.getLine;
import com.janhric.badmintonassociationconsole.controllers.AdminController;
import com.janhric.badmintonassociationconsole.controllers.ParticipateController;
import com.janhric.badmintonassociationconsole.controllers.PlayerController;
import com.janhric.badmintonassociationconsole.controllers.TournamentController;
import com.janhric.badmintonassociationconsole.controllers.VenueController;
import com.janhric.badmintonassociationconsole.entities.Admin;
import com.janhric.badmintonassociationconsole.entities.Player;
import com.janhric.badmintonassociationconsole.entities.Tournament;
import com.janhric.badmintonassociationconsole.entities.Venue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

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
        
        System.out.print("Enter name: ");
        admin.setName(getLine());
        System.out.print("Enter phone: ");
        admin.setPhone(getLine());
        System.out.print("Enter address: ");
        admin.setAddress(getLine());
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
        System.out.println("\nAdmin menu:");
        System.out.println("1 - edit my account\n"
                + "2 - list all players\n"
                + "3 - delete player\n"
                + "4 - create tournament\n"
                + "5 - add players to tournament\n"
                + "6 - create venue\n"
                + "7 - list all venues\n"
                + "0 - exit");
        
        switch(getLine()){
            case "1":
                editMyAccount();
                break;
            case "2":
                PlayerController pc = new PlayerController();
                showPlayers(pc.getAllPlayers());
                break;
            case "3":
                deletePlayer();
                break;
            case "4":
                createTournament();
                break;
            case "5":
                addPlayerToTournament();
                break;
            case "6":
                createVenueCsv();
                break;
            case "7":
                showVenues(controller.getAllVenuesCsv());
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private void editMyAccount() {
        Admin admin = controller.getAdmin();
        printAdminInfo(admin);
        controller.editAdmin(getAdminInfo(admin));
    }

    private void showPlayers(List<Player> players) {
       System.out.println("Players: name, phone, address, phone, gender");
       for( int i = 0; i < players.size(); i++){
           System.out.println(Integer.toString(i) + ": " +  players.get(i).getName() + ", " + players.get(i).getPhone() + ", " + players.get(i).getAddress() + ", " + players.get(i).getGender());
       }
    }

    private void deletePlayer() {
        PlayerController pc = new PlayerController();
        pc.deletePlayer(choosePlayer());
    }

    private void createTournament() {
        Tournament tournament = getTournamentInfo();
        TournamentController tc = new TournamentController();
        tc.createTournament(tournament);
        System.out.println("tournament created");
    }
    
    private Tournament getTournamentInfo(){
        Tournament tournament = new Tournament();
        
        System.out.print("Enter name: ");
        tournament.setName(getLine());
        System.out.print("Start date: ");
        tournament.setStartDate(getLine());
        System.out.print("Enter end date: ");
        tournament.setEndDate(getLine());
        System.out.println("Choose venue:");
        
        VenueController vc = new VenueController();
        List<Venue> venues = vc.getallVenues();
        showVenues(venues);
        
        int choice = -1;
        try {
            choice = Integer.parseInt(getLine());
        } catch (Exception e){
            System.out.println("Invalid choice.");
        }
        if(choice >= 0 && choice < venues.size())
            tournament.setVenue(venues.get(choice));
        else
            System.out.println("Invalid choice.");
        
        return tournament;
    }
    
    private void showVenues(List<Venue> venues){
       System.out.println("Venues: name, address");
       for( int i = 0; i < venues.size(); i++){
           System.out.println(Integer.toString(i) + ": " +  venues.get(i).getName() + ", " + venues.get(i).getAddress());
       }
    }

    private void addPlayerToTournament() {
        TournamentController tc = new TournamentController();
        List<Tournament> tournaments = tc.getAllTournaments();
        showTournaments(tournaments);
        
        int choice = -1;
        try {
            choice = Integer.parseInt(getLine());
        } catch (Exception e){
            System.out.println("Invalid choice.");
        }
        Tournament tournament;
        if(choice >= 0 && choice < tournaments.size())
            tournament = tournaments.get(choice);
        else{
            System.out.println("Invalid choice.");
            return;
        }
        ParticipateController pc = new ParticipateController();
        pc.newRecord(choosePlayer(), tournament);
        System.out.println("player added");
    }
    
    private void showTournaments(List<Tournament> tournaments){
       System.out.println("Tournaments: name, address");
       for( int i = 0; i < tournaments.size(); i++){
           System.out.println(Integer.toString(i) + ": " 
                   + tournaments.get(i).getName() + ", " 
                   + tournaments.get(i).getStartDate() + ", " 
                   + tournaments.get(i).getEndDate() + ", "
                   + tournaments.get(i).getVenue().getName());
       }
    }
    
    private Player choosePlayer(){
        PlayerController pc = new PlayerController();
        List<Player> players = pc.getAllPlayers();
        showPlayers(players);
        int choice = -1;
        try {
            choice = Integer.parseInt(getLine());
        } catch (Exception e){
            System.out.println("Invalid choice.");
        }
        if(choice >= 0 && choice < players.size()){
            return players.get(choice);
        }
        else{
            System.out.println("Invalid choice.");
            return null;
        }    
    }

    private void createVenueCsv() {
        controller.createVenue(getVenueInfo());
    }
    
    private Venue getVenueInfo(){
        Venue venue = new Venue();
        System.out.print("Enter name: ");
        venue.setName(getLine());
        System.out.print("Enter address: ");
        venue.setAddress(getLine());
        return venue;
    }
}
