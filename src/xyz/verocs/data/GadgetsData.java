package xyz.verocs.data;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import xyz.verocs.main.Main;
import xyz.verocs.utils.ItemManager;

public abstract class GadgetsData {
    public static void openStanInv(Player player) {
        Inventory inv = Main.instance.getServer().createInventory(null, 27, "§8Gadget System");
        inv.setItem(11, ItemManager.createItem(Material.LEATHER_BOOTS,1, 0, "§6Boots"));
        inv.setItem(13, ItemManager.createItem(Material.BLAZE_POWDER,1, 0, "§cParticels"));
        inv.setItem(15, ItemManager.createItem(Material.SKULL_ITEM,1, 0, "§5Heads"));
        player.closeInventory();
        player.openInventory(inv);
        player.playSound(player.getLocation(), Sound.CHEST_OPEN,3,3);
    }

}
