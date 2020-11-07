package xyz.verocs.data;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.verocs.main.Main;
import xyz.verocs.teleporter.Icon;

public abstract class NavigatorData {
    public static void navigatorOpen(Player p){
        p.updateInventory();
        p.playSound(p.getLocation(), Sound.CHEST_OPEN,3,3);
        Inventory inv = Bukkit.createInventory(null, 45, "§8Unsere §8Spiele");
        ItemStack i = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
        ItemMeta im = i.getItemMeta();
        im.setDisplayName(" ");
        i.setItemMeta(im);
        inv.setItem(0, i);
        inv.setItem(1, i);
        inv.setItem(2, i);
        inv.setItem(3, i);
        inv.setItem(4, i);
        inv.setItem(5, i);
        inv.setItem(6, i);
        inv.setItem(7, i);
        inv.setItem(8, i);
        inv.setItem(9, i);
        inv.setItem(10, i);
        inv.setItem(12, i);
        inv.setItem(14, i);
        inv.setItem(16, i);
        inv.setItem(17, i);
        inv.setItem(18, i);
        inv.setItem(19, i);
        inv.setItem(20, i);
        inv.setItem(21, i);
        inv.setItem(22, i);
        inv.setItem(23, i);
        inv.setItem(24, i);
        inv.setItem(25, i);
        inv.setItem(26, i);
        inv.setItem(27, i);
        inv.setItem(29, i);
        inv.setItem(30, i);
        inv.setItem(32, i);
        inv.setItem(33, i);
        inv.setItem(35, i);
        inv.setItem(36, i);
        inv.setItem(37, i);
        inv.setItem(38, i);
        inv.setItem(39, i);
        inv.setItem(40, i);
        inv.setItem(41, i);
        inv.setItem(42, i);
        inv.setItem(43, i);
        inv.setItem(44, i);
        p.updateInventory();
        p.openInventory(inv);
        Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                inv.setItem(11, Icon.BAUEVENT.getItem());
                p.updateInventory();
                p.playSound(p.getLocation(), Sound.CLICK,3,3);
                p.getInventory();
                return;

            }
        }, 3);

        Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                inv.setItem(13, Icon.VOYUNITY.getItem());
                p.updateInventory();
                p.playSound(p.getLocation(), Sound.CLICK,3,3);
                p.getInventory();
                return;
            }
        }, 5);

        Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                inv.setItem(15, Icon.BAUEVENT.getItem());
                p.updateInventory();
                p.playSound(p.getLocation(), Sound.CLICK,3,3);
                p.getInventory();
                return;
            }
        }, 3);


        Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                inv.setItem(28, Icon.INCOMING.getItem());
                p.updateInventory();
                p.playSound(p.getLocation(), Sound.CLICK,3,3);
                p.getInventory();
                return;
            }

        }, 9);

        Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                inv.setItem(31, Icon.INCOMING.getItem());
                p.updateInventory();
                p.playSound(p.getLocation(), Sound.CLICK,3,3);
                p.getInventory();
                return;
            }
        }, 7);

        Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                inv.setItem(34, Icon.INCOMING.getItem());
                p.updateInventory();
                p.playSound(p.getLocation(), Sound.CLICK,3,3);
                p.getInventory();
                return;
            }
        }, 9);

    }
}
