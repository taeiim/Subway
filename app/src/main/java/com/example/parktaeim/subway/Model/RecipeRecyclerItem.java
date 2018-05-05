package com.example.parktaeim.subway.Model;

/**
 * Created by parktaeim on 2018. 5. 5..
 */

public class RecipeRecyclerItem {
    private String title;
    private String img;

    public RecipeRecyclerItem(String title, String img) {
        this.title = title;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
