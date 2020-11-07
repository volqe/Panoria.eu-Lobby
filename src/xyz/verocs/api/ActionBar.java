package xyz.verocs.api;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import xyz.verocs.main.Main;

import java.util.HashMap;

public class ActionBar {
    private static final HashMap<String, Integer> Count = new HashMap();

    public ActionBar() {
    }

    public static void sendActionBar(Player player, String Nachricht) {
        String NachrichtNeu = Nachricht.replace("_", " ");
        String s = ChatColor.translateAlternateColorCodes('&', NachrichtNeu);
        IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + s + "\"}");
        PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte)2);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(bar);
    }

    public static void sendActionBarTime(final Player player, final String Nachricht, final Integer Zeit) {
        String NachrichtNeu = Nachricht.replace("_", " ");
        if (!Count.containsKey(player.getName())) {
            String s = ChatColor.translateAlternateColorCodes('&', NachrichtNeu);
            IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + s + "\"}");
            PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte)2);
            ((CraftPlayer)player).getHandle().playerConnection.sendPacket(bar);
        }

        Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {
            public void run() {
                String s = ChatColor.translateAlternateColorCodes('&', "�");
                IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + s + "\"}");
                PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte)2);
                ((CraftPlayer)player).getHandle().playerConnection.sendPacket(bar);
                if (!ActionBar.Count.containsKey(player.getName())) {
                    ActionBar.Count.put(player.getName(), 0);
                }

                int count = (Integer)ActionBar.Count.get(player.getName());
                int newCount = count + 20;
                ActionBar.Count.put(player.getName(), newCount);
                if (newCount < Zeit - 20) {
                    ActionBar.wait(player, Nachricht, Zeit);
                } else {
                    ActionBar.Count.remove(player.getName());
                }

            }
        }, 10L);
    }

    private static void wait(final Player player, final String Nachricht, final Integer Zeit) {
        Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {
            public void run() {
                ActionBar.sendActionBarTime(player, Nachricht, Zeit);
            }
        }, 10L);
    }
}
