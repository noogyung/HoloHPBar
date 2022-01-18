package me.noogs.holohpbar.Utils;

import com.lkeehl.tagapi.TagAPI;
import com.lkeehl.tagapi.api.Tag;
import me.noogs.holohpbar.HoloHpBar;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;


public class refreshBar {
    private Tag tag;

    public refreshBar(Entity entity) {
        BukkitTask task = HoloHpBar.bartasks.get(entity);
        if (task != null) {
            task.cancel();
            HoloHpBar.bartasks.remove(entity);
        }
        BukkitTask newtask = null;

        tag = TagAPI.getTag(entity);
        if(tag != null){
            tag.removeTag();
            HoloHpBar.bartasks.remove(entity);
        }

        if(newtask != null){
            HoloHpBar.bartasks.put((Player) entity, newtask);
        }
    }
}
