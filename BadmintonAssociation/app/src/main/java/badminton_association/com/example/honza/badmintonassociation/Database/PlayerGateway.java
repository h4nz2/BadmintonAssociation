package badminton_association.com.example.honza.badmintonassociation.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.*;

import badminton_association.com.example.honza.badmintonassociation.Models.Enum;
import badminton_association.com.example.honza.badmintonassociation.Models.Player;

/**
 * Created by Honza on 13/12/2017.
 */

public class PlayerGateway extends MySqlConnector {
    public PlayerGateway(){
        super();
    }

    public Player getPlayer(int id){
        try {
            PreparedStatement query = mConnection.prepareStatement("select * from player where id = ?");
            query.setString(1, Integer.toString(id));
            ResultSet resultSet = query.executeQuery();

            if(!resultSet.first())
                return null;

            return new Player(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("phone"),
                    resultSet.getString("address"),
                    Enum.Gender.fromInteger(resultSet.getInt("gender"))
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
