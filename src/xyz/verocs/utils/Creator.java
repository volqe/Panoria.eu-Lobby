package xyz.verocs.utils;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class Creator {

    public static ItemStack itemcreator(Material material, String name, int anzahl, short subid,
                                        ArrayList<String> lore) {
        ItemStack item = new ItemStack(material, anzahl, subid);
        ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setDisplayName(name);
        itemmeta.setLore(lore);
        item.setItemMeta(itemmeta);
        return item;
    }

    public static ItemStack enchantcreator(Material material, String name, int anzahl, short subid,
                                           ArrayList<String> lore, Enchantment enchant, int zahl) {
        ItemStack item = new ItemStack(material, anzahl, subid);
        ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setDisplayName(name);
        itemmeta.setLore(lore);
        itemmeta.addEnchant(enchant, zahl, true);
        item.setItemMeta(itemmeta);
        return item;
    }

    public static ItemStack Headcreator(String name, String owner, int anzahl, ArrayList<String> lore) {
        ItemStack head = new ItemStack(Material.SKULL_ITEM, anzahl, (short) 3);
        SkullMeta headmeta = (SkullMeta) head.getItemMeta();
        headmeta.setDisplayName(name);
        headmeta.setOwner(owner);
        headmeta.setLore(lore);
        head.setItemMeta(headmeta);
        ItemStack playerskull = new ItemStack(Material.SKULL_ITEM,1, (short) SkullType.PLAYER.ordinal());
        SkullMeta meta = (SkullMeta) playerskull.getItemMeta();
        playerskull.setItemMeta(meta);
        return head;
    }

    public static ItemStack bootscreator(String name, Color color) {
        ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta imeta = (LeatherArmorMeta) item.getItemMeta();
        imeta.setDisplayName(name);
        imeta.setColor(color);
        item.setItemMeta(imeta);
        return item;
    }



    public static ItemStack Headcreator(String setOwner, int i, short anzahl, Object lore) {
        // TODO Auto-generated method stub
        return null;
    }

    public static ItemStack Headcreator(Material skullItem, int i, short s) {
        // TODO Auto-generated method stub
        return null;
    }




}
