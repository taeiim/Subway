package com.example.parktaeim.subway.Model;

/**
 * Created by parktaeim on 2018. 4. 23..
 */

public class MenuStuffItem {
    private String stuffImg;
    private String stuffText;

    public MenuStuffItem(String stuffImg, String stuffText) {
        this.stuffImg = stuffImg;
        this.stuffText = stuffText;
    }

    public String getStuffImg() {
        return stuffImg;
    }

    public void setStuffImg(String stuffImg) {
        this.stuffImg = stuffImg;
    }

    public String getStuffText() {
        return stuffText;
    }

    public void setStuffText(String stuffText) {
        this.stuffText = stuffText;
    }
}
