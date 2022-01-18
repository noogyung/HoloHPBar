package me.noogs.holohpbar;

import com.lkeehl.tagapi.TagAPI;
import me.noogs.holohpbar.Listener.playerJoinEvent;
import me.noogs.holohpbar.Configs.ConfigSetting;
import me.noogs.holohpbar.Utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;


public final class HoloHpBar extends JavaPlugin {

    private static HoloHpBar plugin;
    private PlayerUtils playerUtils;
    public static HashMap<Player, BukkitTask> bartasks = new HashMap();


    @Override
    public void onEnable() {
        getLogger().info("Holo HP Bar Plugin has started.");

        plugin = this;

        //Config 파일
        new ConfigSetting();

        TagAPI.onEnable(plugin);

        //Player Init
        playerUtils = new PlayerUtils();
        playerUtils.playerInit();


        //Command
        getCommand("hhb").setExecutor(new mainCommand());

        //Event
        Bukkit.getPluginManager().registerEvents(new playerJoinEvent(), plugin);
    }

    @Override
    public void onDisable() {
        playerUtils = new PlayerUtils();
        //Player Init
        for(Player online : Bukkit.getOnlinePlayers()){
            TagAPI.removeTag(online);
        }

        getLogger().info("Holo HP Bar Plugin has stopped");
    }

    public static HoloHpBar getPlugin(){return plugin;}

}
