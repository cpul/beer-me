package com.pulsinelli.lcbo.domain;

import com.google.gson.annotations.SerializedName;

public class Inventory {

    @SerializedName("product_id")
    public Integer productId;

    @SerializedName("store_id")
    public Integer storeId;

    @SerializedName("is_dead")
    public Boolean isDead;

    @SerializedName("quantity")
    public Integer quantity;

    @SerializedName("updated_on")
    public String updatedOn;

    @SerializedName("updated_at")
    public String updatedAt;

    public Integer getProductId() {
        return productId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public Boolean getIsDead() {
        return isDead;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
