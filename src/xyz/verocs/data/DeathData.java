package xyz.verocs.data;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import xyz.verocs.api.ActionBar;
import xyz.verocs.main.Main;
import xyz.verocs.utils.Creator;
import xyz.verocs.utils.ItemManager;

public abstract class DeathData {
    public static void Death(Player player){
        Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                player.getInventory().setItem(0, ItemManager.createItem(Material.BLAZE_POWDER, Bukkit.getOnlinePlayers().size(), 0, "§eNavigator"));
                player.getInventory().setItem(2, ItemManager.createItem(Material.FISHING_ROD, 1, 0, "§eEnterhaken"));
                player.getInventory().setItem(4, ItemManager.createItem(Material.TNT, 1, 0, "§eSilentlobby"));
                player.getInventory().setItem(6, ItemManager.createItem(Material.COMMAND_MINECART, 1, 0, "§eExtras"));
                player.getInventory().setItem(8, Creator.Headcreator("§eFreunde §8(§bComing Soon§8)", player.getName(), 1, null));
            }
        },3);
    }
}
