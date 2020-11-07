package xyz.verocs.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import xyz.verocs.data.GadgetsData;
import xyz.verocs.data.NavigatorData;

public class PlayerGadgetsListener implements Listener {
    @EventHandler
    public void onInteractExtras(PlayerInteractEvent e) {
        try {
            Player player = e.getPlayer();
            if (e.getItem().getType() == Material.COMMAND_MINECART) {
                if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                    GadgetsData.openStanInv(player);
                }
            }
        } catch (Exception e1) {

        }
    }
}
