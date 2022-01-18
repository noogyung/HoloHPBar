package me.noogs.holohpbar.Configs;

import me.noogs.holohpbar.HoloHpBar;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class ConfigSetting {
    private Plugin plugin = HoloHpBar.getPlugin();

    private File langFile;
    private File configFile;
    private FileConfiguration config;
    private FileConfiguration langConfig;

    public ConfigSetting() {
        createConfig();
        createLanguageConfig();
    }

    public FileConfiguration getConfigSet(){
        return config;
    }
    public FileConfiguration getLangConfigSet(){
        return langConfig;
    }


    private void createConfig(){
        configFile = new File(plugin.getDataFolder()+File.separator+ "config.yml");
        if(!configFile.exists()){
            config.options().copyDefaults(true);
            plugin.saveConfig();
        }
        config = new YamlConfiguration();
        try{
            config.load(configFile);
            plugin.reloadConfig();
        } catch (IOException | InvalidConfigurationException exception){
            exception.printStackTrace();
        }

    }

    private void createLanguageConfig(){
        langFile = new File(plugin.getDataFolder(), "language.yml");
        if(!langFile.exists()){
            langFile.getParentFile().mkdirs();
            plugin.saveResource("language.yml", false);
        }

        langConfig = new YamlConfiguration();
        try{
            langConfig.load(langFile);
        } catch (IOException | InvalidConfigurationException exception){
            exception.printStackTrace();
        }
    }

}
//    다른 파일에서 불러올 때
//    private Configuration langConfig = new ConfigSetting().getLangConfigSet();
//    private Configuration config = new ConfigSetting().getConfigSet();