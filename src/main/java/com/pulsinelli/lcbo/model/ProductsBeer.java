package com.pulsinelli.lcbo.model;

public class ProductsBeer {

    private int id;
    private int lcboProductId;

    public ProductsBeer(int id, int lcboProductId) {
        this.id = id;
        this.lcboProductId = lcboProductId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLcboProductId() {
        return lcboProductId;
    }

    public void setLcboProductId(int lcboProductId) {
        this.lcboProductId = lcboProductId;
    }
}
