package com.example.parktaeim.subway.Model;

/**
 * Created by parktaeim on 2018. 4. 26..
 */

public class MenuCategoryItem {
    private int categoryImgView;
    private String categoryTitle;

    public MenuCategoryItem(int categoryImgView, String categoryTitle) {
        this.categoryImgView = categoryImgView;
        this.categoryTitle = categoryTitle;
    }

    public int getCategoryImgView() {
        return categoryImgView;
    }

    public void setCategoryImgView(int categoryImgView) {
        this.categoryImgView = categoryImgView;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }
}
