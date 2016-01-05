package com.pulsinelli.lcbo.services;

import com.pulsinelli.lcbo.model.User;
import com.pulsinelli.lcbo.model.UserTriedBeer;
import com.pulsinelli.lcbo.util.DbUtil;

import javax.jws.soap.SOAPBinding;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class BeerService {

    private Connection connection;

    public BeerService() {
        connection = DbUtil.getConnection();
    }

    public ArrayList<Integer> getProductIdsOfTriedBeers(final User user) {
        ArrayList<Integer> beerIds = new ArrayList<Integer>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM beers_user_tried WHERE uid = ? ORDER BY tried_on_date DESC");
            statement.setInt(1, user.getId());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet != null) {
                while (resultSet.next()) {
                    beerIds.add(resultSet.getInt("bid"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return beerIds;
    }

    public ArrayList<UserTriedBeer> getBeersUserTried(final User user) {
        ArrayList<UserTriedBeer> userTriedBeers = new ArrayList<UserTriedBeer>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM beers_user_tried WHERE uid = ? ORDER BY tried_on_date DESC");
            statement.setInt(1, user.getId());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet != null) {
                while (resultSet.next()) {
                    UserTriedBeer temp = new UserTriedBeer(resultSet.getInt("bid"), resultSet.getInt("uid"), resultSet.getDate("tried_on_date"));
                    userTriedBeers.add(temp);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userTriedBeers;
    }

    public boolean hasBeerBeenTriedBefore(final User user, final Integer bid) {

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM beers_user_tried WHERE uid = ? AND bid = ?");
            statement.setInt(1, user.getId());
            statement.setInt(2, bid);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet != null) {
                while (resultSet.next()) {
                    int uid = resultSet.getInt("uid");
                    int beerId = resultSet.getInt("bid");
                    return uid == user.getId() && beerId == bid;
                }
                return false;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;    // assume they tried it
    }

    public void setBeerUserTried(final User user, final Integer productId, final Integer rating, Date date) {

        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO beers_user_tried (uid, bid, rating, tried_on_date) VALUES (?,?,?,?) ");
            statement.setInt(1, user.getId());
            statement.setInt(2, productId);
            if (rating == null) {
                statement.setNull(3, Types.TINYINT);
            } else {
                statement.setInt(3, rating);
            }

            if (date == null) {
                date = new Date();
            }
            statement.setDate(4, new java.sql.Date(date.getTime()));

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getBeerIdForBeerProductId(final int productId) {

        Integer bid = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT id FROM products_beer WHERE lcbo_product_id = ?");
            statement.setInt(1, productId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet != null) {
                while (resultSet.next()) {
                    bid = resultSet.getInt("id");
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bid;
    }

    public Integer getLcboProductIdForBeerId(final int id) {

        Integer bid = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT lcbo_product_id FROM products_beer WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet != null) {
                while (resultSet.next()) {
                    bid = resultSet.getInt("lcbo_product_id");
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bid;
    }

    public ArrayList<Integer> getLcboBeerIdsNotYetTried(final User user) {

        ArrayList<Integer> notYetTriedBeers = new ArrayList<Integer>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT beers.lcbo_product_id FROM products_beer beers LEFT JOIN beers_user_tried tried ON tried.bid = beers.id AND tried.uid = ? WHERE tried.id IS NULL");
            statement.setInt(1, user.getId());

            ResultSet resultSet = statement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    notYetTriedBeers.add(resultSet.getInt("lcbo_product_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notYetTriedBeers;
    }
}
