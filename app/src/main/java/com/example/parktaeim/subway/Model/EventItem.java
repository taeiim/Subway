package com.example.parktaeim.subway.Model;

/**
 * Created by parktaeim on 2018. 4. 18..
 */

public class EventItem {
    private String eventTitle;
    private String eventPeriod;
    private String smallImg;
    private String bigImg;

    public EventItem(String eventTitle, String eventPeriod, String bigImg) {
        this.eventTitle = eventTitle;
        this.eventPeriod = eventPeriod;
        this.bigImg = bigImg;
    }

    public EventItem(String eventTitle, String eventPeriod, String smallImg, String bigImg) {
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

    public String getSmallImg() {
        return smallImg;
    }

    public void setSmallImg(String smallImg) {
        this.smallImg = smallImg;
    }

    public String getBigImg() {
        return bigImg;
    }

    public void setBigImg(String bigImg) {
        this.bigImg = bigImg;
    }
}
