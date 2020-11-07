package xyz.verocs.data;

import org.bukkit.entity.Player;

public abstract class PermsDataScore {

    public static void getPerms(Player player) {
        if(player.hasPermission("panoria.owner")){
            RangPrefix = "§4Owner";
        }
        if(player.hasPermission("panoria.admin")){
            RangPrefix = "§cAdmin";
        }
        else {
            RangPrefix = "§7Spieler";
         }

        return;

    }

    public static String RangPrefix;
}
