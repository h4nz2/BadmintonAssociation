package badminton_association.com.example.honza.badmintonassociation.Database;

/**
 * Created by Honza on 13/12/2017.
 */

import java.sql.*;

public class MySqlConnector {
    protected Connection mConnection;

    public MySqlConnector(){
        try {
            mConnection = DriverManager.getConnection("jdbc:mysql://localhost:6000/badminton", "root", "1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
