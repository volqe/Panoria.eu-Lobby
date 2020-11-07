package xyz.verocs.utils;

import net.minecraft.server.v1_8_R3.Packet;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class sPacket {
	public static void sendPacket(Player p, Packet<?> packet) {
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
	}
}
