package xyz.verocs.data;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import xyz.verocs.utils.Creator;
import xyz.verocs.utils.ItemManager;

public abstract class LobbyInvData {

    public static void getNormInv(Player player){
        player.setHealth(6);
        player.setMaxHealth(6);
        player.setFoodLevel(20);
        player.setLevel(2020);
        player.getInventory().setItem(0, ItemManager.createItem(Material.BLAZE_POWDER, 1, 0, "§eNavigator"));
        player.getInventory().setItem(2, ItemManager.createItem(Material.FISHING_ROD, 1, 0, "§eEnterhaken"));
        player.getInventory().setItem(4, ItemManager.createItem(Material.TNT, 1, 0, "§eSilentlobby"));
        player.getInventory().setItem(6, ItemManager.createItem(Material.COMMAND_MINECART, 1, 0, "§eExtras"));
        player.getInventory().setItem(8, Creator.Headcreator("§eFreunde §8(§bComing Soon§8)", player.getName(), 1, null));
    }

}
