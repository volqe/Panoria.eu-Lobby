package xyz.verocs.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import xyz.verocs.data.TextFormat;

import java.io.File;
import java.io.IOException;

public class LocationManager implements TextFormat {

    public static void setLocation(String name, Player p){
        File ordner = new File("plugins//Lobby//");
        File file = new File("plugins//Lobby//" + name + ".yml");

        if(!ordner.exists()){
            ordner.mkdir();
        }
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        Location loc = p.getLocation();

        cfg.set("X", loc.getBlockX());
        cfg.set("Y", loc.getBlockY());
        cfg.set("Z", loc.getBlockZ());
        cfg.set("Welt", loc.getWorld().getName());
        cfg.set("Yaw", loc.getYaw());
        cfg.set("Pitch", loc.getPitch());

        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void useLocation(Player p, String name){
        File file = new File("plugins//Lobby//" + name + ".yml");

        if(!file.exists()){
            p.sendMessage(PREFIX + "Die Location wurde nicht gefunden§8.");
        }

        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        World welt = Bukkit.getWorld(cfg.getString("Welt"));
        double yaw = cfg.getDouble("Yaw");
        double pitch = cfg.getDouble("Pitch");

        p.teleport(new Location(welt, cfg.getDouble("X"), cfg.getDouble("Y"), cfg.getDouble("Z"), (float) yaw, (float) pitch));
    }


}

