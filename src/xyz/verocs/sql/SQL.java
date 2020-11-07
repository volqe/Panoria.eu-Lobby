package xyz.verocs.sql;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SQL {
    public static boolean playerExists(String uuid) {

        try {
            ResultSet rs = MySQL.getResult("SELECT * FROM Coins WHERE UUID= '" + uuid + "'");

            if (rs.next()) {

                return rs.getString("UUID") != null;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void createPlayer(String uuid) {

        if (!(playerExists(uuid))) {
            MySQL.update("INSERT INTO Coins(UUID, PlayerCoins) VALUES ('" + uuid + "', '0');");
        }

    }

    public static Integer getCoins(String uuid) {
        Integer i = 0;

        if (playerExists(uuid)) {

            try {
                ResultSet rs = MySQL.getResult("SELECT PlayerCoins FROM Coins WHERE UUID= '" + uuid + "'");
                if ((!rs.next()) || (Integer.valueOf(rs.getInt("PlayerCoins")) == null))
                    ;

                i = rs.getInt("PlayerCoins");

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            createPlayer(uuid);
            getCoins(uuid);
        }

        return i;
    }

    public static void setCoins(String uuid, Integer coins) {
        if (playerExists(uuid)) {
            MySQL.update("UPDATE Coins SET PlayerCoins= '" + coins + "'WHERE UUID= '" + uuid + "';");
            for (Player all : Bukkit.getOnlinePlayers()) {
            }

        } else {
            createPlayer(uuid);
            setCoins(uuid, coins);
        }

    }

    public static void addCoins(String uuid, Integer coins) {
        if (playerExists(uuid)) {
            setCoins(uuid, Integer.valueOf(getCoins(uuid).intValue() + coins.intValue()));
            for (Player all : Bukkit.getOnlinePlayers()) {
            }

        } else {
            createPlayer(uuid);
            addCoins(uuid, coins);
        }
    }

    public static void removeCoins(String uuid, Integer coins) {
        if (playerExists(uuid)) {
            setCoins(uuid, Integer.valueOf(getCoins(uuid).intValue() - coins.intValue()));
            for (Player all : Bukkit.getOnlinePlayers()) {
            }

        } else {
            createPlayer(uuid);
            removeCoins(uuid, coins);
        }
    }


}
