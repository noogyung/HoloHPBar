package me.noogs.holohpbar.Configs;

public class HPStyleSet {

    String color;
    boolean enable;
    boolean nameEnable;
    String style;
    boolean alwaysShownEnable;
    int hideTime;

    public HPStyleSet(boolean enable, String color, boolean nameEnable, String style, boolean alwaysShownEnable, int hideTime){
        this.color = color;
        this.enable = enable;
        this.nameEnable = nameEnable;
        this.style = style;
        this.alwaysShownEnable = alwaysShownEnable;
        this.hideTime = hideTime;
    }

//    //set
//    public void setEnable(boolean enable){
//        this.enable = enable;
//    }
//
//    public void setColor(String color){
//        this.color = color;
//    }
//
//    public void setNameEnable(boolean nameEnable){
//        this.nameEnable = nameEnable;
//    }
//
//    public void setStyle(String style){
//        this.style = style;
//    }
//
//    public void setAlwaysShownEnable(boolean alwaysShownEnable){
//        this.alwaysShownEnable = alwaysShownEnable;
//    }
//
//    public void setHideTime(int hideTime){
//        this.hideTime = hideTime;
//    }

    //get
    public boolean getEnable(){
        return enable;
    }

    public String getColor(){
        return color;
    }

    public boolean getNameEnable(){
        return nameEnable;
    }

    public String getStyle(){
        return style;
    }

    public boolean getAlwaysShownEnable(){
        return alwaysShownEnable;
    }

    public int getHideTime(){
        return hideTime;
    }





}
