package xyz.verocs.sql;

import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {
    public static String passwd = "Mfetr34_fetio2E25r";
    public static String database = "Panoria";
    public static String user = "panoria";
    public static String host = "localhost";
    public static int port = 3306;
    public static Connection con;

    public static void connect(){
        if(!isConnect()){
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, passwd);
                Bukkit.getConsoleSender().sendMessage("MySQL wurde aktiviert!");
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    public static void disconnect(){
        if(isConnect()) {
            try {
                con.close();
                ;
                Bukkit.getConsoleSender().sendMessage("MySQL wurde deaktiviert!");
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    public static boolean isConnect(){
        return con != null;

    }

    public static void createTable(){
        if(isConnect()){
            try {
                con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS Players(UUID varchar(64));");
                con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS Coins(UUID varchar(64), PlayerCoins int);");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void update(String qry){
        if(isConnect()){
            try {
                con.createStatement().executeUpdate(qry);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static ResultSet getResult(String qry){
        if(isConnect()){
            try {
                return con.createStatement().executeQuery(qry);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
            return null;
    }


}
