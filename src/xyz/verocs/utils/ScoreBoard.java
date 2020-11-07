package xyz.verocs.utils;

import net.minecraft.server.v1_8_R3.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import xyz.verocs.data.PermsDataScore;
import xyz.verocs.sql.SQL;


public class ScoreBoard extends PermsDataScore implements Listener {
    public static boolean isSneaking;

    @EventHandler
    public void setIsSneaking(PlayerToggleSneakEvent event){
        Player player = event.getPlayer();
            if (player.isSneaking()) {
                isSneaking = true;
                ScoreBoard.sendScoreboard(player);
            } else {
                isSneaking = false;
                ScoreBoard.sendScoreboard(player);
            }

            //event end

    }
    public static void sendScoreboard(Player p) {
        String name;

        if(!isSneaking == true){
            name = p.getName();
        } else {
            name = "Panoria";
        }
        getPerms(p);
        Scoreboard board = new Scoreboard();
        ScoreboardObjective obj = board.registerObjective("§a" + name, IScoreboardCriteria.b);
        PacketPlayOutScoreboardObjective removepacket = new PacketPlayOutScoreboardObjective(obj, 1);
        PacketPlayOutScoreboardObjective createpacket = new PacketPlayOutScoreboardObjective(obj, 0);
        PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1, obj);
        obj.setDisplayName("§a" + name);
        if(isSneaking == true) {
            ScoreboardScore s1 = new ScoreboardScore(board, obj, "  ");
            ScoreboardScore s2 = new ScoreboardScore(board, obj, "§7Dein Rang§8:");
            ScoreboardScore s3 = new ScoreboardScore(board, obj, RangPrefix);
            ScoreboardScore s4 = new ScoreboardScore(board, obj, "     ");
            ScoreboardScore s5 = new ScoreboardScore(board, obj, "§7Deine Coins§8:");
            ScoreboardScore s6 = new ScoreboardScore(board, obj, "§a" + SQL.getCoins(p.getUniqueId().toString()));
            ScoreboardScore s7 = new ScoreboardScore(board, obj, "      ");
            ScoreboardScore s8 = new ScoreboardScore(board, obj, "§7Unser TeamSpeak§8:");
            ScoreboardScore s9 = new ScoreboardScore(board, obj, "§aPanoria.NET");

            s1.setScore(8);
            s2.setScore(7);
            s3.setScore(6);
            s4.setScore(5);
            s5.setScore(4);
            s6.setScore(3);
            s7.setScore(2);
            s8.setScore(1);
            s9.setScore(0);


            PacketPlayOutScoreboardScore ps1 = new PacketPlayOutScoreboardScore(s1);
            PacketPlayOutScoreboardScore ps2 = new PacketPlayOutScoreboardScore(s2);
            PacketPlayOutScoreboardScore ps3 = new PacketPlayOutScoreboardScore(s3);
            PacketPlayOutScoreboardScore ps4 = new PacketPlayOutScoreboardScore(s4);
            PacketPlayOutScoreboardScore ps5 = new PacketPlayOutScoreboardScore(s5);
            PacketPlayOutScoreboardScore ps6 = new PacketPlayOutScoreboardScore(s6);
            PacketPlayOutScoreboardScore ps7 = new PacketPlayOutScoreboardScore(s7);
            PacketPlayOutScoreboardScore ps8 = new PacketPlayOutScoreboardScore(s8);
            PacketPlayOutScoreboardScore ps9 = new PacketPlayOutScoreboardScore(s9);

            sPacket.sendPacket(p, removepacket);
            sPacket.sendPacket(p, createpacket);
            sPacket.sendPacket(p, display);

            sPacket.sendPacket(p, ps1);
            sPacket.sendPacket(p, ps2);
            sPacket.sendPacket(p, ps3);
            sPacket.sendPacket(p, ps4);
            sPacket.sendPacket(p, ps5);
            sPacket.sendPacket(p, ps6);
            sPacket.sendPacket(p, ps7);
            sPacket.sendPacket(p, ps8);
            sPacket.sendPacket(p, ps9);
        } else {
            ScoreboardScore s1 = new ScoreboardScore(board, obj, "  ");
            ScoreboardScore s2 = new ScoreboardScore(board, obj, "§7Dein Rang§8:");
            ScoreboardScore s3 = new ScoreboardScore(board, obj, RangPrefix);
            ScoreboardScore s4 = new ScoreboardScore(board, obj, "     ");
            ScoreboardScore s5 = new ScoreboardScore(board, obj, "§7Deine Coins§8:");
            ScoreboardScore s6 = new ScoreboardScore(board, obj, "§2" + SQL.getCoins(p.getUniqueId().toString()));
            ScoreboardScore s7 = new ScoreboardScore(board, obj, "      ");
            ScoreboardScore s8 = new ScoreboardScore(board, obj, "§7Unser TeamSpeak§8:");
            ScoreboardScore s9 = new ScoreboardScore(board, obj, "§2Panoria.NET");

            s1.setScore(8);
            s2.setScore(7);
            s3.setScore(6);
            s4.setScore(5);
            s5.setScore(4);
            s6.setScore(3);
            s7.setScore(2);
            s8.setScore(1);
            s9.setScore(0);


            PacketPlayOutScoreboardScore ps1 = new PacketPlayOutScoreboardScore(s1);
            PacketPlayOutScoreboardScore ps2 = new PacketPlayOutScoreboardScore(s2);
            PacketPlayOutScoreboardScore ps3 = new PacketPlayOutScoreboardScore(s3);
            PacketPlayOutScoreboardScore ps4 = new PacketPlayOutScoreboardScore(s4);
            PacketPlayOutScoreboardScore ps5 = new PacketPlayOutScoreboardScore(s5);
            PacketPlayOutScoreboardScore ps6 = new PacketPlayOutScoreboardScore(s6);
            PacketPlayOutScoreboardScore ps7 = new PacketPlayOutScoreboardScore(s7);
            PacketPlayOutScoreboardScore ps8 = new PacketPlayOutScoreboardScore(s8);
            PacketPlayOutScoreboardScore ps9 = new PacketPlayOutScoreboardScore(s9);

            sPacket.sendPacket(p, removepacket);
            sPacket.sendPacket(p, createpacket);
            sPacket.sendPacket(p, display);

            sPacket.sendPacket(p, ps1);
            sPacket.sendPacket(p, ps2);
            sPacket.sendPacket(p, ps3);
            sPacket.sendPacket(p, ps4);
            sPacket.sendPacket(p, ps5);
            sPacket.sendPacket(p, ps6);
            sPacket.sendPacket(p, ps7);
            sPacket.sendPacket(p, ps8);
            sPacket.sendPacket(p, ps9);

        }



    }


}