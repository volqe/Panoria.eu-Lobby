package xyz.verocs.utils;

import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class ItemManager {
    public static ItemManager instance;
    public static ItemStack createItem(Material material, int anzahl, int subid, String displayname)
    {
        short neuesubid = (short)subid;
        ItemStack i = new ItemStack(material, anzahl, neuesubid);
        ItemMeta m = i.getItemMeta();
        m.setDisplayName(displayname);
        i.setItemMeta(m);

        return i;
    }
    public static ItemStack createItemWithID(int ID, int anzahl, int subid, String displayname)
    {
        short neuesubid = (short)subid;
        @SuppressWarnings("deprecation")
        ItemStack i = new ItemStack(ID, anzahl, neuesubid);
        ItemMeta m = i.getItemMeta();
        m.setDisplayName(displayname);
        i.setItemMeta(m);

        return i;
    }

    public static ItemStack Headcreator(String name, String owner, int anzahl, ArrayList<String> lore) {
        ItemStack playerskull = new ItemStack(Material.SKULL_ITEM,1, (short) SkullType.PLAYER.ordinal());
        SkullMeta meta = (SkullMeta) playerskull.getItemMeta();
        playerskull.setItemMeta(meta);



        return playerskull;
    }



}
