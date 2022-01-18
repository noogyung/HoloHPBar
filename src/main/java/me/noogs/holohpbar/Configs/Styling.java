package me.noogs.holohpbar.Configs;

import me.noogs.holohpbar.HoloHpBar;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.LivingEntity;
import org.bukkit.plugin.Plugin;

import java.util.Iterator;

public class Styling {
    private Plugin plugin = HoloHpBar.getPlugin();
    private Configuration config = new ConfigSetting().getConfigSet();
    private Configuration langConfig = new ConfigSetting().getLangConfigSet();

    private String dhb = "HP Bar.";

    public HPStyleSet getHPStyle(LivingEntity entity){

        boolean mhbEnable = config.getBoolean(dhb + "enable");
        String mhbColor = config.getString(dhb +"color");
        boolean mhbDisplayName = config.getBoolean(dhb + "nameEnable");
        String mhbStyle = config.getString(dhb + "style");
        boolean mhbAlways = config.getBoolean(dhb + "alwaysShownEnable");
        int mhbHideTime = config.getInt(dhb + "hideTime");

        String cStyleType = "stylesType.";

        Iterator var4 = config.getConfigurationSection(cStyleType).getKeys(false).iterator();

        while (var4.hasNext()){
            String item = (String) var4.next();
            try{
                if (Class.forName("org.bukkit.entity." + item).isInstance(entity)){
                    boolean cEnable = config.getBoolean(cStyleType + item + ".enable");
                    String cColor = config.getString(cStyleType + item + ".color");
                    boolean cNameEnable = config.getBoolean(cStyleType + item + ".nameEnable");
                    String cStyle = config.getString(cStyleType + item + ".style");
                    boolean cAlways = config.getBoolean(cStyleType + item + ".alwaysShownEnable");
                    int cHideTime = config.getInt(cStyleType + item + ".hideTime");
                    mhbEnable = cEnable;
                    if(cColor != null) mhbColor = cColor;
                    mhbDisplayName = cNameEnable;
                    if(cStyle != null) mhbStyle = cStyle;
                    mhbAlways = cAlways;
                    mhbHideTime = cHideTime;
                    break;
                }
            }catch (Exception var8) {
                plugin.getLogger().severe(item + langConfig.getString("isNotEntity"));
                break;
            }
        }
        return new HPStyleSet(mhbEnable,mhbColor,mhbDisplayName,mhbStyle,mhbAlways,mhbHideTime);
    }
}
