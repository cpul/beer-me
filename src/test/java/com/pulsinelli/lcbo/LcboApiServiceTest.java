package com.pulsinelli.lcbo;

import com.pulsinelli.lcbo.domain.*;
import com.pulsinelli.lcbo.util.LcboUtil;
import org.junit.Test;

public class LcboApiServiceTest {

    @Test
    public void testGetStore() throws Exception {
        LcboApiService service = LcboUtil.getLcboApiService();

        LcboResponse<Store> response = service.getStore(511);
        Store store = (Store)response.result;
        System.out.println(store.name);
    }

    @Test
    public void testGetBeer() throws Exception {
        LcboApiService service = LcboUtil.getLcboApiService();
        LcboResponse<Product> product = service.getProductById(267773);
        Product product1 = product.result;

        System.out.println(product1.name);
    }
}
