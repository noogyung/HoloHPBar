package me.noogs.holohpbar;

import me.noogs.holohpbar.Configs.ConfigSetting;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.Plugin;

public class mainCommand implements CommandExecutor {
    private Plugin plugin = HoloHpBar.getPlugin();
    private Configuration langConfig = new ConfigSetting().getLangConfigSet();
    private Configuration config = new ConfigSetting().getConfigSet();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if(args.length > 0){
            String inputCMD = args[0];
            switch (inputCMD){
                case "reload":
                    plugin.onDisable();
                    plugin.onEnable();

                    sender.sendMessage(ChatColor.GREEN+ langConfig.getString("reloadMessage"));
                    break;

                case "test":
                    sender.sendMessage(config.getString("test"));
                    break;
                default:
                    break;
            }
        }
        return true;
    }
}
