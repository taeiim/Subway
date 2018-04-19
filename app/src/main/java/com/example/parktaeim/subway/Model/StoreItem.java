package com.example.parktaeim.subway.Model;

/**
 * Created by parktaeim on 2018. 4. 18..
 */

public class StoreItem {
    private String storeName;
    private String storeAddress;
    private String distance;

    public StoreItem(String storeName, String storeAddress) {
        this.storeName = storeName;
        this.storeAddress = storeAddress;
    }

    public StoreItem(String storeName, String storeAddress, String distance) {
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.distance = distance;
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
}
