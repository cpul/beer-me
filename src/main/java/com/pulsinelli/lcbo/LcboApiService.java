package com.pulsinelli.lcbo;

import com.pulsinelli.lcbo.domain.Inventory;
import com.pulsinelli.lcbo.domain.LcboResponse;
import com.pulsinelli.lcbo.domain.Product;
import com.pulsinelli.lcbo.domain.Store;
import retrofit.ErrorHandler;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.http.Path;

import javax.xml.ws.http.HTTPException;

public class LcboApiService implements LcboApi {

    private final LcboApi lcboApi;

    public LcboApiService(String token) {
        TokenInterceptor interceptor = new TokenInterceptor(token);
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("https://lcboapi.com")
                .setRequestInterceptor(interceptor)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        lcboApi = adapter.create(LcboApi.class);
    }

    public LcboResponse<Store> getStore(int storeId) {
        return lcboApi.getStore(storeId);
    }

    public LcboResponse<Inventory> getProductInventoryForStore(int productId, int storeId) {
        return lcboApi.getProductInventoryForStore(productId, storeId);
    }

    public LcboResponse<Product> getProductById(int productId) {
        return lcboApi.getProductById(productId);
    }

    private static class TokenInterceptor implements RequestInterceptor {
        public static final String AUTHORIZATION = "Authorization";
        private final String authToken;

        public TokenInterceptor(String apiKey) {
            this.authToken = String.format("Token %s", apiKey);
        }

        public void intercept(RequestFacade requestFacade) {
            requestFacade.addHeader(AUTHORIZATION, authToken);
        }
    }
}
