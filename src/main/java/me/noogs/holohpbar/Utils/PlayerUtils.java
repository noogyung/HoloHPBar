package me.noogs.holohpbar.Utils;

import com.lkeehl.tagapi.TagAPI;
import com.lkeehl.tagapi.api.Tag;
import me.noogs.holohpbar.Configs.HPStyleSet;
import me.noogs.holohpbar.Configs.Styling;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;


public class PlayerUtils {
    private HPStyleSet hpStyleSet;
    private HPType hpType = new HPType();
    private Tag tag;

    public void playerInit(){
        for(Player online : Bukkit.getOnlinePlayers()){
            hpStyleSet = new Styling().getHPStyle(online);
            Checker(online, hpStyleSet);
        }
    }

    public void enabled(Player player, HPStyleSet hpStyleSet){
        tag = Tag.create(player);

        tag.addTagLine(10).setGetName(pl -> player.getName());
        tag.addTagLine(9).setGetName(pl -> hpType.barStyle(player, hpStyleSet)).setKeepSpaceWhenNull(pl -> false);
        tag.giveTag();
    }

    public void nameDisable(Player player, HPStyleSet hpStyleSet){
        tag = Tag.create(player);
        tag.addTagLine(9).setGetName(pl -> hpType.barStyle(player,hpStyleSet)).setKeepSpaceWhenNull(pl -> false);
        tag.giveTag();
    }

    public void Checker(Player player, HPStyleSet hpStyleSet){
        if (!hpStyleSet.getNameEnable()){
            nameDisable(player, hpStyleSet);
        }
        else{
            enabled(player, hpStyleSet);
        }
    }

    public void hpBarRemover(LivingEntity entity){
        hpStyleSet = new Styling().getHPStyle(entity);
        tag = TagAPI.getTag(entity);
        if(tag != null){
            if(hpStyleSet.getNameEnable()){
                tag.getTagLines().remove(1);
            }
            else{
                tag.removeTag();
            }

        }
    }

    public void Updater(Player player){
        if(tag != null){
            tag.updateTag();
        }else{
            hpStyleSet = new Styling().getHPStyle(player);
            Checker(player, hpStyleSet);
        }
    }
}
