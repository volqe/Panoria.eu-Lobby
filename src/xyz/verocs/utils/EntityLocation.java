package xyz.verocs.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class EntityLocation {
	public Entity e;
	public Location loc;
	
	public static List<EntityLocation> eLocs = new ArrayList<EntityLocation>();
	
	public EntityLocation(Entity _e, Location _loc) {
		this.e = _e;
		this.loc = _loc;
	}

}
