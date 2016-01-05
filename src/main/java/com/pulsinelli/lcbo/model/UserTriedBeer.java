package com.pulsinelli.lcbo.model;

import java.util.Date;

public class UserTriedBeer {

    private int bid;
    private int uid;
    private Date triedOn;
    private String beerName;

    public UserTriedBeer(int bid, int uid, Date triedOn) {
        this.bid = bid;
        this.uid = uid;
        this.triedOn = triedOn;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Date getTriedOn() {
        return triedOn;
    }

    public void setTriedOn(Date triedOn) {
        this.triedOn = triedOn;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }
}
