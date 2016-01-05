package com.pulsinelli.lcbo.services;

import com.pulsinelli.lcbo.domain.Store;
import com.pulsinelli.lcbo.util.DbUtil;

import java.sql.Connection;

/**
 * Created by cpulsinelli on 16-01-03.
 */
public class StoreService {

    private Connection connection;

    public StoreService() {
        connection = DbUtil.getConnection();
    }

    public void setHomeStoreForUserId(int storeId, int userId) {

    }

    public boolean userHasHomeStore(int userId) {

        return true;
    }

    public Store getHomeStoreForUserId(int userId) {

        return null;
    }
}
