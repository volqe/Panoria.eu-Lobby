package xyz.verocs.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.verocs.data.TextFormat;
import xyz.verocs.utils.LocationManager;


import java.io.File;

public class LocationCommand implements CommandExecutor, TextFormat {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args){
        Player p = (Player) sender;

        File ordner = new File("plugins/Lobby//");
        File file = new File("plugins//Lobby//" + args[0] + ".yml");

        if(p.hasPermission("*")){
            LocationManager.setLocation(args[0], p);
            p.sendMessage(PREFIX + "Du hast die Location §e" + args[0] + " §7gesetzt§8!");
            p.playSound(p.getLocation(), Sound.NOTE_PLING, 3, 3);
        } else {
            p.sendMessage(PERM);
        }
        return false;
    }

}
