/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badmintonassociationconsole;

import static badmintonassociationconsole.Reader.getLine;
import com.janhric.badmintonassociationconsole.controllers.AdminController;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Honza
 */
public class BadmintonAssociationConsole {
    public static String URL = "http://192.168.0.102:28429/BadmintonAssociationServer/";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("*** Badminton association ***\n");
        System.out.println("1 - Admin menu\n"
                + "2 - Player menu\n"
                + "0 - Exit");    
        String choice;
        while(!"0".equals(choice = getLine())){            
            switch(choice){
                case "1":
                    AdminController adminController = new AdminController();
                    adminController.start();
                    break;
                case "2":
                    break;
                case "0":
                    break;
                default:
                    System.out.println("!!! Invalid choice. !!!");
            }
            System.out.println("*** Badminton association ***\n");
            System.out.println("1 - Admin menu\n"
                    + "2 - Player menu\n"
                    + "0 - Exit");
        }
            
        }
    
    
}