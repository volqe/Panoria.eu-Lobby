package xyz.verocs.listener;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import xyz.verocs.data.NavigatorData;


public class PlayerNavigatorListener implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        try {
            Player player = e.getPlayer();
            if (e.getItem().getType() == Material.BLAZE_POWDER) {
                if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                    NavigatorData.navigatorOpen(player);

                }
            }
        } catch (Exception e1) {

        }
    }


}
