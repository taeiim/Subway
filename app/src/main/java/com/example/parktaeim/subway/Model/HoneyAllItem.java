package com.example.parktaeim.subway.Model;

/**
 * Created by parktaeim on 2018. 4. 24..
 */

public class HoneyAllItem {
    private String honeyName;
    private String honeyPrice;
    private String honeyInfo;
    private float starNum;
    private int starPeoCnt;
    private int heartCnt;
    private String honeyImg;

    public HoneyAllItem(String honeyName, String honeyInfo, String honeyImg) {
        this.honeyName = honeyName;
        this.honeyInfo = honeyInfo;
        this.honeyImg = honeyImg;
    }

    public HoneyAllItem(String honeyName, String honeyPrice, String honeyInfo, float starNum, int starPeoCnt, int heartCnt, String honeyImg) {
        this.honeyName = honeyName;
        this.honeyPrice = honeyPrice;
        this.honeyInfo = honeyInfo;
        this.starNum = starNum;
        this.starPeoCnt = starPeoCnt;
        this.heartCnt = heartCnt;
        this.honeyImg = honeyImg;
    }

    public String getHoneyName() {
        return honeyName;
    }

    public void setHoneyName(String honeyName) {
        this.honeyName = honeyName;
    }

    public String getHoneyPrice() {
        return honeyPrice;
    }

    public void setHoneyPrice(String honeyPrice) {
        this.honeyPrice = honeyPrice;
    }

    public String getHoneyInfo() {
        return honeyInfo;
    }

    public void setHoneyInfo(String honeyInfo) {
        this.honeyInfo = honeyInfo;
    }

    public float getStarNum() {
        return starNum;
    }

    public void setStarNum(float starNum) {
        this.starNum = starNum;
    }

    public int getStarPeoCnt() {
        return starPeoCnt;
    }

    public void setStarPeoCnt(int starPeoCnt) {
        this.starPeoCnt = starPeoCnt;
    }

    public int getHeartCnt() {
        return heartCnt;
    }

    public void setHeartCnt(int heartCnt) {
        this.heartCnt = heartCnt;
    }

    public String getHoneyImg() {
        return honeyImg;
    }

    public void setHoneyImg(String honeyImg) {
        this.honeyImg = honeyImg;
    }
}
