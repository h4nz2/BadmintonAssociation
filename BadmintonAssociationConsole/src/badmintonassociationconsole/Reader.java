/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badmintonassociationconsole;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Honza
 */
public class Reader {
    public static String getLine(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
    
}
