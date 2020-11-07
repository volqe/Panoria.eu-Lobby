package xyz.verocs.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import xyz.verocs.data.DeathData;

public class PlayerDeathListener implements Listener {
    @EventHandler
    public void Death(PlayerDeathEvent event){
        Player player = event.getEntity();
        DeathData.Death(player);
        event.setDeathMessage(null);
    }
}
