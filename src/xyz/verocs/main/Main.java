package xyz.verocs.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.verocs.listener.*;
import xyz.verocs.sql.MySQL;
import xyz.verocs.utils.ScoreBoard;

public class Main extends JavaPlugin {
    public static Main instance;

    @Override
    public void onEnable() {
        //mysql
        MySQL.connect();
        MySQL.createTable();
        //mysql

        instance = this;


        //plugin manager
        PluginManager pluginManager = Bukkit.getPluginManager();
        //listener
        pluginManager.registerEvents(new PlayerConnectionListener(), this);
        pluginManager.registerEvents(new PlayerNavigatorListener(), this);
        pluginManager.registerEvents(new PlayerProtectionListener(), this);
        pluginManager.registerEvents(new PlayerDeathListener(), this);
        pluginManager.registerEvents(new ChangeSlotSoundListener(), this);
        pluginManager.registerEvents(new GadgetsHookListener(), this);
        pluginManager.registerEvents(new ScoreBoard(), this);
        pluginManager.registerEvents(new GadgetsInventoryListener(), this);
        pluginManager.registerEvents(new GadgetsFlightattemptListener(), this);
        pluginManager.registerEvents(new GadgetsMoveListener(), this);
        pluginManager.registerEvents(new PlayerGadgetsListener(), this);
        //listener

        //plugin manager
    }

    @Override
    public void onDisable() {
    }


    public static Main getInstance() {
        return instance;
    }
}
