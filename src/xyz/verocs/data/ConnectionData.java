package xyz.verocs.data;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import xyz.verocs.api.ActionBar;
import xyz.verocs.main.Main;
import xyz.verocs.sql.SQL;
import xyz.verocs.utils.Creator;
import xyz.verocs.utils.ItemManager;

public abstract class ConnectionData implements TextFormat {

   public static void firstJoin(Player player){
        player.playSound(player.getLocation(), Sound.FIREWORK_LAUNCH,3,3);
        player.sendTitle("§a§l" + player.getName(), "§7Willkommen auf §2Panoria.NET§8!");
        player.setHealth(6);
       player.setFoodLevel(20);
        player.setLevel(2020);
       player.setMaxHealth(6);
        SQL.addCoins(player.getUniqueId().toString(), 500);
        player.sendMessage(PREFIX + "Willkommen auf §2Panoria.NET§8!" +
                "\n" +
                "\n" +
                JOINMSG);
       Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(), new Runnable() {
           @Override
           public void run() {
               ActionBar.sendActionBar(player, "§f[§eCoinsSystem§f] §7+§6500");
               player.getInventory().setItem(0, ItemManager.createItem(Material.BLAZE_POWDER,1, 0, "§eNavigator"));
               player.getInventory().setItem(2, ItemManager.createItem(Material.FISHING_ROD, 1, 0, "§eEnterhaken"));
               player.getInventory().setItem(4, ItemManager.createItem(Material.TNT, 1, 0, "§eSilentlobby"));
               player.getInventory().setItem(6, ItemManager.createItem(Material.COMMAND_MINECART, 1, 0, "§eExtras"));
               player.getInventory().setItem(8, Creator.Headcreator("§eFreunde §8(§bComing Soon§8)", player.getName(), 1, null));
               player.setFoodLevel(20);
               player.setMaxHealth(6);
           }
       },5);

    }

   public static void normalJoin(Player player){
        player.playSound(player.getLocation(), Sound.CLICK,3,3);
        player.sendTitle("§a§l" + player.getName(), "§7Willkommen zurück§8!");
        player.setHealth(6);
       player.setMaxHealth(6);
        player.setFoodLevel(20);
        player.setLevel(2020);
       player.getInventory().setItem(0, ItemManager.createItem(Material.BLAZE_POWDER, 1, 0, "§eNavigator"));
       player.getInventory().setItem(2, ItemManager.createItem(Material.FISHING_ROD, 1, 0, "§eEnterhaken"));
       player.getInventory().setItem(4, ItemManager.createItem(Material.TNT, 1, 0, "§eSilentlobby"));
       player.getInventory().setItem(6, ItemManager.createItem(Material.COMMAND_MINECART, 1, 0, "§eExtras"));
       player.getInventory().setItem(8, Creator.Headcreator("§eFreunde §8(§bComing Soon§8)", player.getName(), 1, null));
        SQL.addCoins(player.getUniqueId().toString(), 25);
       Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(), new Runnable() {
           @Override
           public void run() {
               ActionBar.sendActionBar(player, "§f[§eCoinsSystem§f] §7+§625");
           }
       },5);
    }

    public static void firstQuit(Player player){
       SQL.addCoins(player.getUniqueId().toString(), 25);

        Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                ActionBar.sendActionBar(player, "§f[§eCoinsSystem§f] §7+§625");
            }
        },5);
    }
}
