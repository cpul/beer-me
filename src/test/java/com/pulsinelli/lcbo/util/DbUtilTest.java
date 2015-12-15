package com.pulsinelli.lcbo.util;

import org.junit.Test;

import java.sql.Connection;

public class DbUtilTest {

    @Test
    public void testConnection() throws Exception {

        Connection connection = DbUtil.getConnection();
        assert connection != null;

    }
}
