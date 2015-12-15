package com.pulsinelli.lcbo;

import com.pulsinelli.lcbo.domain.*;
import retrofit.http.GET;
import retrofit.http.Path;

public interface LcboApi {

    @GET("/stores/{store_id}")
    LcboResponse<Store> getStore(@Path("store_id") int storeId);

    @GET("/stores/{store_id}/products/{product_id}/inventory")
    LcboResponse<Inventory> getProductInventoryForStore(@Path("product_id") int productId, @Path("store_id") int storeId);

    @GET("/products/{product_id}")
    LcboResponse<Product> getProductById(@Path("product_id") int productId);
}
