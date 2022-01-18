package me.noogs.holohpbar.Listener;

import com.lkeehl.tagapi.api.Tag;
import me.noogs.holohpbar.Configs.HPStyleSet;
import me.noogs.holohpbar.HoloHpBar;
import me.noogs.holohpbar.Utils.PlayerUtils;
import me.noogs.holohpbar.Configs.Styling;
import me.noogs.holohpbar.Utils.Targeter;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;

public class playerJoinEvent implements Listener {

    private HPStyleSet hpStyleSet;
    private Plugin plugin = HoloHpBar.getPlugin();
    private PlayerUtils playerUtils = new PlayerUtils();
    private Player player;
    private boolean isTask = false;
    private Tag tag;
    private Player lookTarget;


    @EventHandler
    public void onPlayerBar(PlayerJoinEvent event){
        player = event.getPlayer();
        LivingEntity entity = player;

        hpStyleSet = new Styling().getHPStyle(entity);

        if(hpStyleSet.getEnable()){
            for (Player online : Bukkit.getOnlinePlayers()){
                playerUtils.Checker(online, hpStyleSet);
            }
        }
    }

    @EventHandler
    public void movePlayer(PlayerMoveEvent event){
        player = event.getPlayer();
        if(Targeter.getTargetEntity(player)!=null){
            if(Targeter.getTargetEntity(player)instanceof LivingEntity){
                hpStyleSet = new Styling().getHPStyle(player);
                LivingEntity targetEntity = (LivingEntity) Targeter.getTargetEntity(player);
                if(hpStyleSet.getAlwaysShownEnable()){
                    playerUtils.Updater(player);
                }
                else{
                    if(!(player.getLocation().distanceSquared(targetEntity.getLocation())<=80)){
                        playerUtils.hpBarRemover(targetEntity);
                    }
                    else
                    {
                        playerUtils.Updater(player);
                    }
                }
            }
        }
//
//        lookTarget = (Player) Targeter.getTargetEntity(player);
//        if(hpStyleSet.getEnable()){
//
//                if(Targeter.getTargetEntity(player) == null){
//                    if (isTask == false) {
//                        LivingEntity finalLookTarget = lookTarget;
//                        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
//                            @Override
//                            public void run() {
//                                new refreshBar(finalLookTarget);
//                                isTask = false;
//                            }
//                        }, hpStyleSet.getHideTime());
//                    }
//                    isTask = true;
//                }
//                else if (Targeter.getTargetEntity(player).getType() == player.getType()){
//                    tag = TagAPI.getTag(Targeter.getTargetEntity(player));
//                    if(tag == null){
//                        playerUtils.Checker(lookTarget, hpStyleSet);
//                    }
//                    else {
//                        playerUtils.Updater(lookTarget);
//                    }
//                }
//            }
//        }
    }
}
