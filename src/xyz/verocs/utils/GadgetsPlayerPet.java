package xyz.verocs.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class GadgetsPlayerPet {
	
	public Player p;
	public EntityType animal;
	public boolean pedSpawned;
	
	public static List<GadgetsPlayerPet> animalList = new ArrayList<GadgetsPlayerPet>();
	
	public GadgetsPlayerPet(Player _p, EntityType _animal, boolean _pedSpawned) {
		this.p = _p;
		this.animal = _animal;
		this.pedSpawned = _pedSpawned;
	}

}
