package xyz.verocs.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Effect;
import org.bukkit.entity.Player;

public class GadgetsPlayer {
	
	public static List<Player> iceBoots = new ArrayList<Player>();
	public static List<Player> jumpBoots = new ArrayList<Player>();
	public static List<Player> flyBoots = new ArrayList<Player>();
	
	public static List<GadgetsPlayer> players = new ArrayList<GadgetsPlayer>();
	
	public Player p;
	public Effect e;

	public GadgetsPlayer(Player _p, Effect _e) {
		this.p = _p;
		this.e = _e;
	}
}
