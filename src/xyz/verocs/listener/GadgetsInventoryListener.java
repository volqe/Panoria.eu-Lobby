package xyz.verocs.listener;

import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.SkullType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;


import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import xyz.verocs.data.ConnectionData;
import xyz.verocs.data.DeathData;
import xyz.verocs.data.GadgetsData;
import xyz.verocs.data.TextFormat;
import xyz.verocs.utils.BootsPlayer;
import xyz.verocs.utils.GadgetsPlayer;
import xyz.verocs.utils.GadgetsItemManager;
import xyz.verocs.utils.GadgetsPlayerPet;

public class GadgetsInventoryListener implements Listener{
	
	
	@EventHandler
	public void onInv(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(!(e.getAction() == InventoryAction.NOTHING) && e.getSlot() == 15 && e.getView().getTitle() == "§8Gadget System") {
			p.closeInventory();
			
			Inventory headInv = Bukkit.getServer().createInventory(null, 54, "§5Heads");
			addHeads(headInv);
			
			p.openInventory(headInv);
		}
		
		
		if(!(e.getAction() == InventoryAction.NOTHING) && e.getSlot() == 13 && e.getView().getTitle() == "§8Gadget System") {
			p.closeInventory();
			
			Inventory particels = Bukkit.getServer().createInventory(null, 45, "§cParticles");
			addParticels(particels);
			
			p.openInventory(particels);
		}
		
		if(!(e.getAction() == InventoryAction.NOTHING) && e.getSlot() == 30 && e.getView().getTitle() == "§8Gadget System") {
			p.closeInventory();
			
			Inventory animals = Bukkit.getServer().createInventory(null, 54, "§aAnimals");
			addAnimals(animals);
			
			p.openInventory(animals);
		}
		
		
		if(!(e.getAction() == InventoryAction.NOTHING) && e.getSlot() == 11 && e.getView().getTitle() == "§8Gadget System") {
			p.closeInventory();
			
			Inventory bootsInv = Bukkit.getServer().createInventory(null, 9, "§6Boots");

	        ItemStack lboots = new ItemStack(Material.LEATHER_BOOTS, 1);
	        LeatherArmorMeta lch = (LeatherArmorMeta)lboots.getItemMeta();
	        lch.setColor(Color.fromRGB(0, 128, 0));
	        lch.setDisplayName("§aJump Boots");
	        lboots.setItemMeta(lch);
	        

	        ItemStack iboots = new ItemStack(Material.LEATHER_BOOTS, 1);
	        LeatherArmorMeta ich = (LeatherArmorMeta)iboots.getItemMeta();
	        ich.setColor(Color.fromRGB(0, 255, 255));
	        ich.setDisplayName("§bIce Boots");
	        iboots.setItemMeta(ich);
			
	        bootsInv.setItem(1, lboots);
	        bootsInv.setItem(3, iboots);
			addBoots(bootsInv);
			
			p.openInventory(bootsInv);
		}
		
		

		
		
		
		/*
		 *
		 * Bootsmenu
		 * 
		 */
		
		if(!(e.getAction() == InventoryAction.NOTHING) && e.getView().getTitle() == "§6Boots") {
			
			removeBootPlayerList(p);
			restoreDefaults(p);
			
			if(e.getSlot() == 0) {
				p.getEquipment().clear();
				p.getEquipment().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
				
				p.setWalkSpeed(1F);
				
				p.sendMessage(TextFormat.PREFIX + "§aDu hast die §eSpeed Boots §aausgerüstet!");
			}else if(e.getSlot() == 1) {
				
				//gadget_player.jumpBoots.add(p);
				
				BootsPlayer bp = new BootsPlayer(p, Material.LEATHER_BOOTS, 2);
				BootsPlayer.bootsPlayers.add(bp);
				
		        ItemStack lboots = new ItemStack(Material.LEATHER_BOOTS, 1);
		        LeatherArmorMeta lch = (LeatherArmorMeta)lboots.getItemMeta();
		        lch.setColor(Color.fromRGB(0, 128, 0));
		        lch.setDisplayName("§aJump Boots");
		        lboots.setItemMeta(lch);
		        
		        p.getEquipment().setBoots(lboots);
		        

		        
		        p.setAllowFlight(true);
				
				p.sendMessage(TextFormat.PREFIX + "§aDu hast die §2Jump Boots §aausgerüstet!");
			}else if(e.getSlot() == 2) {				
				p.getEquipment().clear();
				p.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS, 1));
				p.setAllowFlight(true);
				p.setFlying(true);
				
				p.sendMessage(TextFormat.PREFIX + "§aDu hast die §cFly Boots §aausgerüstet!");
			}else if(e.getSlot() == 3) {
				
				//gadget_player.iceBoots.add(p);
				
				BootsPlayer bp = new BootsPlayer(p, Material.LEATHER_BOOTS, 1);
				BootsPlayer.bootsPlayers.add(bp);
				
		        ItemStack iboots = new ItemStack(Material.LEATHER_BOOTS, 1);
		        LeatherArmorMeta ich = (LeatherArmorMeta)iboots.getItemMeta();
		        ich.setColor(Color.fromRGB(0, 255, 255));
		        ich.setDisplayName("§bIce Boots");
		        iboots.setItemMeta(ich);
		        
		        p.getEquipment().setBoots(iboots);
				p.sendMessage(TextFormat.PREFIX + "§aDu hast die §bIce Boots §aausgerüstet!");
			}else if(e.getSlot() == 4) {
				p.getEquipment().setBoots(null);
				
		        ItemStack iboots = new ItemStack(Material.DIAMOND_BOOTS, 1);
		        ItemMeta ich = iboots.getItemMeta();

		        ich.addEnchant(Enchantment.WATER_WORKER, 1, true);
		        ich.setDisplayName("§9Gucci Boots");
		        iboots.setItemMeta(ich);
				
				p.getEquipment().setBoots(iboots);				
				GadgetsPlayer pp = new GadgetsPlayer(p, Effect.SPELL);
				GadgetsPlayer.players.add(pp);
				
				p.sendMessage(TextFormat.PREFIX + "§aDu hast die §9Gucci Boots §aausgerüstet!");
			}
			else if(e.getSlot() == 8) {
				
				if(p.getEquipment().getBoots() != null) {
					removeBootPlayerList(p);
					p.getInventory().setBoots(null);
					p.sendMessage(TextFormat.PREFIX + "§cDu hast deine Schuhe ausgezogen!");
					GadgetsData.openStanInv(p);
				}
			}
			
			if(e.getSlot() != 8) {
				p.closeInventory();
			}
		}
		
		/*
		 * 
		 * Particel Inventory
		 * 
		 * */
		
		if(!(e.getAction() == InventoryAction.NOTHING) && e.getView().getTitle() == "§cParticles") {
			
			try {
				switch (e.getCurrentItem().getType()) {
				case LAVA_BUCKET:
					
					removeGadgetPlayerList(p);
					
					GadgetsPlayer lavaP = new GadgetsPlayer(p, Effect.LAVA_POP);
					GadgetsPlayer.players.add(lavaP);

					break;
				
				case WATER_BUCKET:
					
					removeGadgetPlayerList(p);
					
					GadgetsPlayer waterP = new GadgetsPlayer(p, Effect.WATERDRIP);
					GadgetsPlayer.players.add(waterP);

					break;
					
				case WEB:
					
					removeGadgetPlayerList(p);
					
					GadgetsPlayer webP = new GadgetsPlayer(p, Effect.CLOUD);
					GadgetsPlayer.players.add(webP);

					break;
					
					
				case OBSIDIAN:
					
					removeGadgetPlayerList(p);
					
					GadgetsPlayer obsP = new GadgetsPlayer(p, Effect.PARTICLE_SMOKE);
					GadgetsPlayer.players.add(obsP);

					break;
				
				case TORCH:
					
					removeGadgetPlayerList(p);
					
					GadgetsPlayer torchP = new GadgetsPlayer(p, Effect.FIREWORKS_SPARK);
					GadgetsPlayer.players.add(torchP);

					break;
					
				case REDSTONE:
					
					removeGadgetPlayerList(p);
					
					GadgetsPlayer redP = new GadgetsPlayer(p, Effect.COLOURED_DUST);
					GadgetsPlayer.players.add(redP);

					break;

				case RED_MUSHROOM:
					
					removeGadgetPlayerList(p);
					
					GadgetsPlayer mushP = new GadgetsPlayer(p, Effect.EXPLOSION);
					GadgetsPlayer.players.add(mushP);

					break;
					
				case EXP_BOTTLE:
					
					removeGadgetPlayerList(p);
					
					GadgetsPlayer xpP = new GadgetsPlayer(p, Effect.WITCH_MAGIC);
					GadgetsPlayer.players.add(xpP);

					break;
					
				case ENDER_PEARL:
					
					removeGadgetPlayerList(p);
					
					GadgetsPlayer endP = new GadgetsPlayer(p, Effect.ENDER_SIGNAL);
					GadgetsPlayer.players.add(endP);

					break;
					
				case ENCHANTMENT_TABLE:
					
					removeGadgetPlayerList(p);
					
					GadgetsPlayer instSpell = new GadgetsPlayer(p, Effect.INSTANT_SPELL);
					GadgetsPlayer.players.add(instSpell);

					break;
					
				case FLINT_AND_STEEL:
					
					removeGadgetPlayerList(p);
					GadgetsPlayer fireP = new GadgetsPlayer(p, Effect.FLAME);
					GadgetsPlayer.players.add(fireP);

					break;


					case BARRIER:
						GadgetsPlayer all = new GadgetsPlayer(p, null);
						p.closeInventory();
						p.sendMessage(TextFormat.PREFIX + "§aDu hast deine Particle entfernt.");

						break;


					case ARROW:
						GadgetsData.openStanInv(p);
				default:
					break;
				}
				
				if(e.getCurrentItem().getType() != Material.BARRIER) {

				}
				if(e.getCurrentItem().getType() != Material.ARROW) {
					GadgetsData.openStanInv(p);

				}
				
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			

			
			for(GadgetsPlayer puu : GadgetsPlayer.players) {
				System.out.println(puu.p.getName());
			}
			
		}
		
		/*
		 *
		 * Headmenu
		 * 
		 */
		
		if(!(e.getAction() == InventoryAction.NOTHING) && e.getView().getTitle() == "§5Heads") {
			
			if(e.getCurrentItem().getType() != Material.STAINED_GLASS_PANE) {
				
				if(e.getCurrentItem().getType() == Material.ARROW) {
					GadgetsData.openStanInv(p);
					e.setCancelled(true);
					return;
				}
				
				if(e.getCurrentItem().getType() == Material.BARRIER) {
					p.getInventory().setHelmet(null);
					e.setCancelled(true);
					p.closeInventory();
					return;
				}

				p.getInventory().setHelmet(null);
				p.getEquipment().setHelmet(new ItemStack(e.getCurrentItem().getType(), 1));
				p.closeInventory();
			}
		}	
		e.setCancelled(true);
	}
	
	public void addParticels(Inventory inv) {
		
		for(int i = 0; i < 45; i++) {
			inv.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)15));
		}
		
		
		GadgetsItemManager.addItem(inv, Material.LAVA_BUCKET, 1, "§cLAVA", 10);
		GadgetsItemManager.addItem(inv, Material.WATER_BUCKET, 1, "§9WATER", 12);
		GadgetsItemManager.addItem(inv, Material.WEB, 1, "§7CLOUD", 14);
		GadgetsItemManager.addItem(inv, Material.OBSIDIAN, 1, "§1OBSIDIAN", 16);
		
		GadgetsItemManager.addItem(inv, Material.TORCH, 1, "§cFIRE", 20);
		GadgetsItemManager.addItem(inv, Material.REDSTONE, 1, "§cREDSTONE", 22);
		GadgetsItemManager.addItem(inv, Material.RED_MUSHROOM, 1, "§cHEART", 24);
		
		GadgetsItemManager.addItem(inv, Material.EXP_BOTTLE, 1, "§5XP", 28);
		GadgetsItemManager.addItem(inv, Material.ENDER_PEARL, 1, "§9END", 30);
		GadgetsItemManager.addItem(inv, Material.ENCHANTMENT_TABLE, 1, "§dINSTANT SPELL", 32);
		GadgetsItemManager.addItem(inv, Material.FLINT_AND_STEEL, 1, "§cFLAME", 34);
		
		GadgetsItemManager.addItem(inv, Material.ARROW, 1, "§4Zurück", 44);
		GadgetsItemManager.addItem(inv, Material.BARRIER, 1, "§4Entferne Particle", 36);
	}
	
	public void addBoots(Inventory inv) {
		GadgetsItemManager.addItem(inv, Material.GOLD_BOOTS, 1, "§eSpeed Boots", 0); //KMDD
		GadgetsItemManager.addItem(inv, Material.DIAMOND_BOOTS, 1, "§9Gucci Boots", 4); //KMDD
		GadgetsItemManager.addItem(inv, Material.IRON_BOOTS, 1, "§cFly Boots", 2); //KMDD
		
		GadgetsItemManager.addItem(inv, Material.BARRIER, 1, "§4Entferne Boots", 8);
	}
	
	public void removeGadgetPlayerList(Player p) {
		
		List<GadgetsPlayer> backUp = new ArrayList<GadgetsPlayer>();
		backUp = GadgetsPlayer.players;
		
		GadgetsPlayer.players.clear();
		
		for(GadgetsPlayer gp : backUp) {
			if(gp.p.getName() != p.getName()) {
				GadgetsPlayer.players.add(gp);
			}
		}		
	}
	
	public void removeBootPlayerList(Player p) {
		List<BootsPlayer> bckUp = new ArrayList<BootsPlayer>();
		bckUp = BootsPlayer.bootsPlayers;
		
		BootsPlayer.bootsPlayers.clear();
		
		for(BootsPlayer bp : bckUp) {
			if(bp.p.getName() != p.getName()) {
				BootsPlayer.bootsPlayers.add(bp);
			}
		}
	}
	
	public void removeAnimal(Player p) {
		List<GadgetsPlayerPet> bckUp = new ArrayList<GadgetsPlayerPet>();
		bckUp = GadgetsPlayerPet.animalList;
		
		GadgetsPlayerPet.animalList.clear();
		
		for(GadgetsPlayerPet bp : bckUp) {
			if(bp.p.getName() != p.getName()) {
				GadgetsPlayerPet.animalList.add(bp);
			}
		}
	}
	
	public void restoreDefaults(Player p) {
		p.setFlying(false);
		p.setAllowFlight(false);
		DeathData.Death(p);
		GadgetsPlayer.iceBoots.remove(p);
		GadgetsPlayer.jumpBoots.remove(p);
		p.setWalkSpeed(0.2F);
	}
	

	
	public static ItemStack getCustomHead(OfflinePlayer p) {
		ItemStack Skull = new ItemStack(Material.SKULL_ITEM,1 , (short) SkullType.PLAYER.ordinal());
		
		org.bukkit.inventory.meta.SkullMeta skullMeta = (org.bukkit.inventory.meta.SkullMeta) Skull.getItemMeta();
		skullMeta.setDisplayName("§b" + p.getName());
		skullMeta.setOwner(p.getName());
		Skull.setItemMeta(skullMeta);
		
		return Skull;
	}
	
	@SuppressWarnings("deprecation")
	public static void addAnimals(Inventory inv) {
		inv.setItem(0, new ItemStack((Material.MONSTER_EGG), 1, EntityType.PIG.getTypeId()));
		inv.setItem(1, new ItemStack((Material.MONSTER_EGG), 1, EntityType.SHEEP.getTypeId()));
		inv.setItem(2, new ItemStack((Material.MONSTER_EGG), 1, EntityType.COW.getTypeId()));
		inv.setItem(3, new ItemStack((Material.MONSTER_EGG), 1, EntityType.CHICKEN.getTypeId()));
		inv.setItem(4, new ItemStack((Material.MONSTER_EGG), 1, EntityType.WOLF.getTypeId()));
		inv.setItem(5, new ItemStack((Material.MONSTER_EGG), 1, EntityType.MUSHROOM_COW.getTypeId()));
		inv.setItem(6, new ItemStack((Material.MONSTER_EGG), 1, EntityType.OCELOT.getTypeId()));
		inv.setItem(7, new ItemStack((Material.MONSTER_EGG), 1, EntityType.HORSE.getTypeId()));
		inv.setItem(8, new ItemStack((Material.MONSTER_EGG), 1, EntityType.RABBIT.getTypeId()));
	}
	
	@SuppressWarnings("deprecation")
	public static void addHeads(Inventory inv) {
		
		
		for(int i = 0; i < 54; i++) {
			inv.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)15));
		}
		
		
		inv.setItem(1, getCustomHead(Bukkit.getOfflinePlayer("UBCAzer")));
		GadgetsItemManager.addItem(inv, Material.CHEST, 1, "§eChest", 3);
		GadgetsItemManager.addItem(inv, Material.TNT, 1, "§4TNT", 5);
		GadgetsItemManager.addItem(inv, Material.DROPPER, 1, "§7Dropper", 7);
		
		GadgetsItemManager.addItem(inv, Material.DISPENSER, 1, "§7Dispensre", 9);
		GadgetsItemManager.addItem(inv, Material.MINECART, 1, "§8Minecart", 11);
		GadgetsItemManager.addItem(inv, Material.NOTE_BLOCK, 1, "§fNoteblock", 13);
		GadgetsItemManager.addItem(inv, Material.FURNACE, 1, "§8Furnace", 15);
		inv.setItem(17, getCustomHead(Bukkit.getOfflinePlayer("volqeYT")));
		
		GadgetsItemManager.addItem(inv, Material.ENCHANTMENT_TABLE, 1, "§dEnchantment Tabel", 19);
		GadgetsItemManager.addItem(inv, Material.ENDER_PORTAL_FRAME, 1, "§5End Portal", 21);
		GadgetsItemManager.addItem(inv, Material.ENDER_CHEST, 1, "§5Ender Chest", 23);
		GadgetsItemManager.addItem(inv, Material.BEACON, 1, "§bBeacon", 25);
		
		GadgetsItemManager.addItem(inv, Material.REDSTONE_LAMP_OFF, 1, "§cRedstone Lamp Off", 27);
		GadgetsItemManager.addItem(inv, Material.REDSTONE_BLOCK, 1, "§cRedstone Block", 29);
		GadgetsItemManager.addItem(inv, Material.PISTON_BASE, 1, "§fPiston", 31);
		GadgetsItemManager.addItem(inv, Material.ANVIL, 1, "§7Anvil", 33);
		GadgetsItemManager.addItem(inv, Material.SLIME_BLOCK, 1, "§aSlime", 35);
		
		GadgetsItemManager.addItem(inv, Material.BEDROCK, 1, "§0Bedrock", 37);
		GadgetsItemManager.addItem(inv, Material.BOOKSHELF, 1, "§eBookshelf", 39);
		GadgetsItemManager.addItem(inv, Material.ICE, 1, "§bIce", 41);
		GadgetsItemManager.addItem(inv, Material.PUMPKIN, 1, "§6Pumpkin", 43);
		
		
		GadgetsItemManager.addItem(inv, Material.BARRIER, 1, "§4Entferne Head", 45);
		GadgetsItemManager.addItem(inv, Material.ARROW, 1, "§4Zurück", 53);
	}

}
