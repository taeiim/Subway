package com.example.parktaeim.subway.Model;

/**
 * Created by parktaeim on 2018. 4. 17..
 */

public class HoneyRankItem {
    private String name;
    private String desc;
    private float star;
    private int starPeoCnt;
    private int heartCnt;
    private String img;

    public HoneyRankItem(String name, String desc, float star, int starPeoCnt, int heartCnt, String img) {
        this.name = name;
        this.desc = desc;
        this.star = star;
        this.starPeoCnt = starPeoCnt;
        this.heartCnt = heartCnt;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getStar() {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
