package com.example.parktaeim.subway.Model;

/**
 * Created by parktaeim on 2018. 4. 30..
 */

public class ReviewItem {
    private String profileImg;
    private String writerName;
    private String writeDate;
    private float reviewRatingNum;
    private int heartCnt;
    private String reviewContent;

    public ReviewItem(String profileImg, String writerName, String writeDate, float reviewRatingNum, int heartCnt, String reviewContent) {
        this.profileImg = profileImg;
        this.writerName = writerName;
        this.writeDate = writeDate;
        this.reviewRatingNum = reviewRatingNum;
        this.heartCnt = heartCnt;
        this.reviewContent = reviewContent;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(String writeDate) {
        this.writeDate = writeDate;
    }

    public float getReviewRatingNum() {
        return reviewRatingNum;
    }

    public void setReviewRatingNum(float reviewRatingNum) {
        this.reviewRatingNum = reviewRatingNum;
    }

    public int getHeartCnt() {
        return heartCnt;
    }

    public void setHeartCnt(int heartCnt) {
        this.heartCnt = heartCnt;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }
}
