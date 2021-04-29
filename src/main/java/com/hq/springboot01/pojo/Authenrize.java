package com.hq.springboot01.pojo;

public class Authenrize {
    private  int authenrizeId;
    private String authenrizeName;
    private boolean enable;

    public int getAuthenrizeId() {
        return authenrizeId;
    }

    public void setAuthenrizeId(int authenrizeId) {
        this.authenrizeId = authenrizeId;
    }

    public String getAuthenrizeName() {
        return authenrizeName;
    }

    public void setAuthenrizeName(String authenrizeName) {
        this.authenrizeName = authenrizeName;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
