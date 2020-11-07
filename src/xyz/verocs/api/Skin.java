package xyz.verocs.api;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import xyz.verocs.main.Main;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.logging.Level;

public class Skin {

	String uuid;
	String name;
	String value;
	String signatur;

	Skin(String uuid) {
		this.uuid = uuid;
		load();
	}

	@SuppressWarnings("resource")
	private void load() {
		try {
			// Get the name from SwordPVP
			URL url = new URL("https://sessionserver.mojang.com/session/minecraft/profile/" + uuid + "?unsigned=false");
			URLConnection uc = url.openConnection();
			uc.setUseCaches(false);
			uc.setDefaultUseCaches(false);
			uc.addRequestProperty("User-Agent", "Mozilla/5.0");
			uc.addRequestProperty("Cache-Control", "no-cache, no-store, must-revalidate");
			uc.addRequestProperty("Pragma", "no-cache");

			// Parse it
			String json = new Scanner(uc.getInputStream(), "UTF-8").useDelimiter("\\A").next();
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(json);
			JSONArray properties = (JSONArray) ((JSONObject) obj).get("properties");
			for (int i = 0; i < properties.size(); i++) {
				try {
					JSONObject property = (JSONObject) properties.get(i);
					String name = (String) property.get("name");
					String value = (String) property.get("value");
					String signature = property.containsKey("signature") ? (String) property.get("signature") : null;

					this.name = name;
					this.value = value;
					this.signatur = signature;

				} catch (Exception e) {
					Bukkit.getLogger().log(Level.WARNING, "Failed to apply auth property", e);
				}
			}
		} catch (Exception e) {
			; // Failed to load skin
		}
	}

	public String getSkinValue() {
		return value;
	}

	public String getSkinName() {
		return name;
	}

	public String getSkinSignatur() {
		return signatur;
	}

	@SuppressWarnings("deprecation")
	public static void switchSkin(Player p, String SkinName) {

		GameProfile gp = ((CraftPlayer) p).getProfile();
		gp.getProperties().clear();
		Skin skin = new Skin(Bukkit.getOfflinePlayer(SkinName).getUniqueId().toString().replace("-", ""));

		if (skin.getSkinName() != null) {
			gp.getProperties().put(skin.getSkinName(),
					new Property(skin.getSkinName(), skin.getSkinValue(), skin.getSkinSignatur()));
		}

		Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {

			@Override
			public void run() {
				for(Player all : Bukkit.getOnlinePlayers()) {
					all.hidePlayer(p);
				}
			}
		}, 1);

		Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {

			@Override
			public void run() {
				for(Player all : Bukkit.getOnlinePlayers()) {
					all.showPlayer(p);
				}
			}
		}, 15);
	}
}