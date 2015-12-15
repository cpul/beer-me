package com.pulsinelli.lcbo.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {

    public static java.sql.Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        }
        InputStream stream = DbUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(stream);
            String driver = properties.getProperty("dbDriver");
            String dbUrl = properties.getProperty("dbUrl");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");

            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(dbUrl, username, (password == null || password.equals("") ? null : password));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
