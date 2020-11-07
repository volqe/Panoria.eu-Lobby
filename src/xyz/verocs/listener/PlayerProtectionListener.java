package xyz.verocs.listener;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;

public class PlayerProtectionListener implements Listener {
    @EventHandler
    public void onEn(EntityDamageByEntityEvent e){
        e.setCancelled(true);
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        e.setDeathMessage(null);
    }
    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        if(p.getGameMode() == GameMode.CREATIVE){
            e.setCancelled(false);
        }else{
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onBreaak(BlockPlaceEvent e){
        Player p = e.getPlayer();
        if(p.getGameMode() == GameMode.CREATIVE){
            e.setCancelled(false);
        }else{
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onHunger(FoodLevelChangeEvent e){
        e.setCancelled(true);
    }
    @EventHandler
    public void i(InventoryClickEvent e){
        Player p = (Player)e.getWhoClicked();
        if(p.getGameMode() == GameMode.CREATIVE){
            e.setCancelled(false);
        }else{
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void ond(PlayerDropItemEvent e){
        Player p = e.getPlayer();
        if(p.getGameMode() == GameMode.CREATIVE){
            e.setCancelled(false);
        }else{
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void on(PlayerInteractAtEntityEvent e){
        e.setCancelled(false);
    }
    @EventHandler
    public void ona(PlayerInteractEntityEvent e){
        e.setCancelled(false);
    }
    @EventHandler
    public void onDa(EntityDamageEvent e){
        e.setCancelled(true);
    }
    @EventHandler
    public void onDaass(EntityDamageByBlockEvent e){
        e.setCancelled(true);
    }
    @EventHandler(ignoreCancelled = true)
    public void onWeizen(PlayerInteractEvent e) {
        try{

            if(e.getAction().equals(Action.PHYSICAL) && e.getClickedBlock().getType().equals(Material.SOIL)){
                e.setCancelled(true);
                return;

            }
            if(e.getPlayer().getGameMode() == GameMode.CREATIVE){
                e.setCancelled(false);
                return;
            }else{
                if(e.getItem().getType() != Material.FISHING_ROD){
                    e.setCancelled(true);
                }
            }
            if(e.getAction().equals(Action.PHYSICAL) && e.getClickedBlock().getType().equals(Material.SOIL)){
                e.setCancelled(true);
            }

        }catch(Exception e1){}
    }
    @EventHandler(ignoreCancelled = true)
    public void onEntitiy(PlayerInteractEntityEvent e){
        e.setCancelled(false);
    }


    @EventHandler
    public void onWeatherChange(org.bukkit.event.weather.WeatherChangeEvent paramWeatherChangeEvent) {
        paramWeatherChangeEvent.setCancelled(true);
    }

    @EventHandler
    public void PickUp(PlayerPickupItemEvent event){
        event.setCancelled(true);
    }

}
