package me.noogs.holohpbar.Utils;

import me.noogs.holohpbar.Configs.HPStyleSet;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;

public class HPType {
    private int entityHP;
    private int entityMaxHP;
    String symbolFull;
    String symbolHalf;
    String result;

    private int doubleToInt(double i){
        int resultInt = (int) Math.round(i);
        return resultInt;
    }

    private double perToDouble(double max, double i, int full){
        double resultInt;
        resultInt = ( i / (max / full));
        return resultInt;
    }

    public String barStyle(LivingEntity entity, HPStyleSet hpStyleSet){

        String getStyles = hpStyleSet.getStyle();
        switch (getStyles){
            case "text" :
                intHPBar(entity);
                break;
            case "<3" :
                symbolFull = "♥";
                symbolHalf = "♡";
                symbolHPBar(entity,symbolFull,symbolHalf);
                break;
            case "l" :
                symbolFull = ChatColor.BOLD +"‖";
                symbolHalf = "︱";
                symbolHPBar(entity,symbolFull,symbolHalf);
                break;
            case "0" :
                symbolFull = "●";
                symbolHalf = ChatColor.BOLD+"◐";
                symbolHPBar(entity,symbolFull,symbolHalf);
                break;
            default:
                break;
        }
        return result;
    }

    public void intHPBar(LivingEntity entity){

        entityHP = doubleToInt(entity.getHealth());
        entityMaxHP = doubleToInt(entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());

        result = entityHP + "/" + entityMaxHP;
    }

    private void symbolHPBar(LivingEntity entity, String symF, String symH){
        int fullHp = 10;
        entityHP = doubleToInt(entity.getHealth());
        entityMaxHP = doubleToInt(entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());

        double perHP = perToDouble(entityMaxHP,entityHP,fullHp);

        String blackHeart = "";
        String colorHeart = "";
        String halfHeart = "";

        if (perHP - Math.floor(perHP) > 0  && perHP - Math.floor(perHP) < 1){
            for(int i = 0; i < Math.floor(perHP) ; i++){
                colorHeart += symF;
            }
            halfHeart += symH;
        }
        else{
            for(int i = 0; i < doubleToInt(perHP); i++){
                colorHeart += symF;
            }
        }

        for(int i = 0; i < fullHp - doubleToInt(perHP); i ++){
            blackHeart += symF;
        }

        result = ChatColor.RED + colorHeart + halfHeart + ChatColor.BLACK + blackHeart;
    }

}
