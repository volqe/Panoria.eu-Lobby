package xyz.verocs.listener;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

public class ChangeSlotSoundListener implements Listener {
    @EventHandler
    public void onChange(PlayerItemHeldEvent e) {
        Player p = e.getPlayer();
        if (p.getLocation().getWorld().getName().equals("world")) {
            p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);

        }

    }
}
