package com.pulsinelli.lcbo.util;

import com.pulsinelli.lcbo.LcboApiService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LcboUtil {

    private static LcboApiService lcboApiService = null;

    public static LcboApiService getLcboApiService() {
        if (lcboApiService != null) {
            return lcboApiService;
        }
        InputStream stream = LcboUtil.class.getClassLoader().getResourceAsStream("lcbo.properties");
        Properties properties = new Properties();

        try {
            properties.load(stream);
            String apiKey = properties.getProperty("key");
            lcboApiService = new LcboApiService(apiKey);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lcboApiService;
    }
}
