package xyz.verocs.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.verocs.teleporter.Icon;

import java.util.ArrayList;

public class HeadBuilder {

	ItemStack item;
	ItemMeta meta;

	public HeadBuilder() {

	}

	public HeadBuilder(Material mat) {

		item = new ItemStack(mat);
		meta = item.getItemMeta();

	}

	public HeadBuilder(ItemStack ite) {

		item = ite;
		meta = item.getItemMeta();

	}
	public HeadBuilder setSubID(short id) {

		item.setDurability(id);
		return this;

	}

	public HeadBuilder addEnchantment(Enchantment ench, int s) {

		meta.addEnchant(ench, s, true);
		return this;
	}

	public HeadBuilder addGlow() {

		meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		return this;
	}

	public HeadBuilder HideAll() {

		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);

		return this;
	}
	public HeadBuilder setLoreLobby(Icon icon, int spieler, boolean desc) {

		ArrayList<String> l = new ArrayList<>();

		l.add("§7Spieler Online: §e" + spieler);
		l.add("§7");
		if (desc == true) {
			switch (icon) {
				case INCOMING:

				l.add("");

				break;

			default:
				break;
			}

		}
		l.add("§eLinksklick §7» §6Server Anzeigen");
		l.add("§eShift-Linksklick §7» §6Quickjoin");
		l.add("§eRechtsklick §7» §6Beschreibung");
		
		meta.setLore(l);
		return this;

	}
	public HeadBuilder setName(String name) {

		meta.setDisplayName(name);
		return this;

	}

	public HeadBuilder setAmount(int amount) {

		item.setAmount(amount);
		return this;

	}


	public HeadBuilder addLore(String lore) {

		ArrayList<String> l;
		if (meta.getLore() != null) {
			l = (ArrayList<String>) meta.getLore();
		} else {
			l = new ArrayList<>();

		}
		l.add(lore);
		meta.setLore(l);
		return this;
	}

	public HeadBuilder setStatsLore(String title, int stats) {

		ArrayList<String> l = new ArrayList<>();

		l.add("        " + title + "");
		l.add("§7§oLinksklick um Titel zu wählen!");
		l.add("§7");

		meta.setLore(l);
		return this;
	}

	public HeadBuilder setEnchantLore(int s) {

		ArrayList<String> l = new ArrayList<>();

		l.add("§7§oLinksklick zum Verzaubern");
		l.add("§7§lKosten: §a" + s * 10 + "§2 Level");

		meta.setLore(l);
		return this;
	}

	public HeadBuilder setPrice(int price) {

		ArrayList<String> l = new ArrayList<>();

		l.add("        §a§lEinkaufen");
		l.add("§7§oLinksklick um 1 zukaufen!");
		l.add("§7§lKosten:§6 " + price + " §6§lⓉ");
		l.add("§7");
		l.add("§7§oLinksklick + shift um §916§7§o zukaufen!");
		l.add("§7§lKosten:§6 " + price * 16 + " §6§lⓉ");

		meta.setLore(l);
		return this;
	}

	public HeadBuilder setWorth(int price) {

		ArrayList<String> l;
		if (meta.getLore() != null) {
			l = (ArrayList<String>) meta.getLore();
		} else {
			l = new ArrayList<>();

		}
		if (price == 0)
			return this;

		l.add("§7");
		l.add("        §c§lVerkaufen");
		l.add("§7§oRechtsklick zum verkaufen!");
		l.add("§7§lWert:§6 " + price + " §6§lⓉ");
		l.add("§7");
		l.add("§7§oRechtsklick + shift um §916§7§o zuverkaufen!");
		l.add("§7§lWert:§6 " + price * 16 + " §6§lⓉ");

		meta.setLore(l);
		return this;
	}

	public ItemStack build() {

		item.setItemMeta(meta);
		return item;
	}

}
