package com.example.parktaeim.subway.Model;

/**
 * Created by parktaeim on 2018. 4. 18..
 */

public class EventItem {
    private String eventTitle;
    private String eventPeriod;
    private int smallImg;
    private int bigImg;

    public EventItem(String eventTitle, String eventPeriod, int bigImg) {
        this.eventTitle = eventTitle;
        this.eventPeriod = eventPeriod;
        this.bigImg = bigImg;
    }

    public EventItem(String eventTitle, String eventPeriod, int smallImg, int bigImg) {
        this.eventTitle = eventTitle;
        this.eventPeriod = eventPeriod;
        this.smallImg = smallImg;
        this.bigImg = bigImg;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventPeriod() {
        return eventPeriod;
    }

    public void setEventPeriod(String eventPeriod) {
        this.eventPeriod = eventPeriod;
    }

    public int getSmallImg() {
        return smallImg;
    }

    public void setSmallImg(int smallImg) {
        this.smallImg = smallImg;
    }

    public int getBigImg() {
        return bigImg;
    }

    public void setBigImg(int bigImg) {
        this.bigImg = bigImg;
    }
}
