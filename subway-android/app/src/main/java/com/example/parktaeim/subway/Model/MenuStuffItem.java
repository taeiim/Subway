package com.example.parktaeim.subway.Model;

/**
 * Created by parktaeim on 2018. 4. 23..
 */

public class MenuStuffItem {
    private int stuffImg;
    private String stuffText;

    public MenuStuffItem(int stuffImg, String stuffText) {
        this.stuffImg = stuffImg;
        this.stuffText = stuffText;
    }

    public int getStuffImg() {
        return stuffImg;
    }

    public void setStuffImg(int stuffImg) {
        this.stuffImg = stuffImg;
    }

    public String getStuffText() {
        return stuffText;
    }

    public void setStuffText(String stuffText) {
        this.stuffText = stuffText;
    }
}
