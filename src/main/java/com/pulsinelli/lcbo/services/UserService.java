package com.pulsinelli.lcbo.services;

import com.pulsinelli.lcbo.model.User;
import com.pulsinelli.lcbo.util.DbUtil;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

    private Connection connection;

    public UserService() {
        connection = DbUtil.getConnection();
    }

    public void insertUser(final String username, final String email, final InputStream password, final int passwordLength) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (username, password, email) VALUES (?,?,?)");

            statement.setString(1, username);
            statement.setBinaryStream(2, password, passwordLength);
            statement.setString(3, email);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isUsernameAlreadyRegistered(final String username) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT count(*) AS user_count FROM users WHERE username = ?");
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    int count = resultSet.getInt("user_count");
                    return count > 0;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isEmailAlreadyRegistered(final String email) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT count(*) AS email_count FROM users WHERE email = ?");
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    int count = resultSet.getInt("email_count");
                    return count > 0;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getUser(final String username) {
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();


            if (resultSet != null) {
                while (resultSet.next()) {
                    InputStream passwordStream = resultSet.getBinaryStream("password");
                    String passwordHash = inputStreamToString(passwordStream);
                    user = new User(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("email"), passwordHash);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    private String inputStreamToString(final InputStream stream) throws IOException {
        StringWriter writer = new StringWriter();
        IOUtils.copy(stream, writer);
        return writer.toString();
    }
}
