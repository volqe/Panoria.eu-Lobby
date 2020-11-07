package xyz.verocs.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Fish;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.util.Vector;

public class GadgetsHookListener implements Listener {
    @EventHandler
    public void PlayerFish(PlayerFishEvent e)
    {
        e.getPlayer().getItemInHand().setDurability((short)0);
        Player p = e.getPlayer();
        Fish h = e.getHook();
        if (((e.getState().equals(PlayerFishEvent.State.IN_GROUND)) || (e.getState().equals(PlayerFishEvent.State.CAUGHT_ENTITY))
                || (e.getState().equals(PlayerFishEvent.State.FAILED_ATTEMPT))) && (Bukkit.getWorld(e.getPlayer().getWorld().getName()).getBlockAt(h.getLocation().getBlockX(),
                h.getLocation().getBlockY() - 1, h.getLocation().getBlockZ()).getType()
                != Material.AIR) && (Bukkit.getWorld(e.getPlayer().getWorld().getName()).getBlockAt(h.getLocation().getBlockX(), h.getLocation().getBlockY() - 1,
                h.getLocation().getBlockZ()).getType() != Material.STATIONARY_WATER))
        {
            Location lc = p.getLocation();
            Location to = e.getHook().getLocation();
            lc.setY(lc.getY() + 0.1D);
            p.teleport(lc);
            double g = -0.13D;
            double t;
            double d = t = to.distance(lc);
            double v_x = (4.0D + 0.04D * t) * (to.getX() - lc.getX()) / t;
            double v_y = (0.6D + 0.03D * t) * (to.getY() - lc.getY()) / t - -0.1D * t;
            double v_z = (4.0D + 0.04D * t) * (to.getZ() - lc.getZ()) / t;
            Vector v = p.getVelocity();
            v.setX(v_x);
            v.setY(v_y);
            v.setZ(v_z);
            p.setVelocity(v);
            p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1.0F, 1.0F);
        }
    }
}
