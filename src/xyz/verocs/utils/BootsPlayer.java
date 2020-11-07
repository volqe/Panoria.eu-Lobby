package xyz.verocs.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class BootsPlayer {
	
	public static List<BootsPlayer> bootsPlayers = new ArrayList<BootsPlayer>();
	
	public Player p;
	public Material m;
	public int id;
	
	public BootsPlayer(Player _p, Material _boot, int _id){
		this.p = _p;
		this.m = _boot;
		this.id = _id;
	}

}
