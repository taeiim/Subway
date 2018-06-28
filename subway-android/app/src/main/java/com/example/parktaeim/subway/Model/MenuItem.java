package com.example.parktaeim.subway.Model;

/**
 * Created by parktaeim on 2018. 4. 21..
 */

public class MenuItem {
    private int menuImg;
    private String name;
    private String price;
    private float star;

    public MenuItem(int menuImg, String name, String price, float star) {
        this.menuImg = menuImg;
        this.name = name;
        this.price = price;
        this.star = star;
    }

    public int getMenuImg() {
        return menuImg;
    }

    public void setMenuImg(int menuImg) {
        this.menuImg = menuImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public float getStar() {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
    }
}
