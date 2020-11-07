package xyz.verocs.listener;

import com.mysql.jdbc.Connection;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import xyz.verocs.data.ConnectionData;
import xyz.verocs.data.TextFormat;
import xyz.verocs.main.Main;
import xyz.verocs.sql.SQL;
import xyz.verocs.utils.ScoreBoard;

public class PlayerConnectionListener implements Listener, TextFormat {
    @EventHandler
    public void Join(PlayerJoinEvent event){
        Player player = event.getPlayer();

        if(!SQL.playerExists(player.getUniqueId().toString())){
            ConnectionData.firstJoin(player);
            event.setJoinMessage(null);
            Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    player.sendMessage(ConnectionData.JOINMSG);
                    ScoreBoard.sendScoreboard(player);
                }
            },3);
        } else {
            event.setJoinMessage(null);
            Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    ConnectionData.normalJoin(player);
                    player.sendMessage(ConnectionData.JOINMSG);
                    ScoreBoard.sendScoreboard(player);
                }
            },3);
        }



    }
    @EventHandler
    public void Quit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        if(!SQL.playerExists(player.getUniqueId().toString())){
            event.setQuitMessage(null);
            Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    ConnectionData.firstQuit(player);
                    ScoreBoard.sendScoreboard(player);
                }
            },3);

        } else {
            event.setQuitMessage(null);
        }
    }

}
