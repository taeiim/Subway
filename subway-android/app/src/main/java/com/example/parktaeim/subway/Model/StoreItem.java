package com.example.parktaeim.subway.Model;

/**
 * Created by parktaeim on 2018. 4. 18..
 */

public class StoreItem {
    private String storeName;
    private String storeAddress;
    private String distance;
    private String storeOpeningTime;
    private String storeTellNum;

    public StoreItem(String storeName, String storeAddress, String distance, String storeOpeningTime, String storeTellNum) {
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.distance = distance;
        this.storeOpeningTime = storeOpeningTime;
        this.storeTellNum = storeTellNum;
    }

    public StoreItem(String storeName, String storeAddress, String storeOpeningTime, String storeTellNum) {
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storeOpeningTime = storeOpeningTime;
        this.storeTellNum = storeTellNum;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getStoreOpeningTime() {
        return storeOpeningTime;
    }

    public void setStoreOpeningTime(String storeOpeningTime) {
        this.storeOpeningTime = storeOpeningTime;
    }

    public String getStoreTellNum() {
        return storeTellNum;
    }

    public void setStoreTellNum(String storeTellNum) {
        this.storeTellNum = storeTellNum;
    }
}
