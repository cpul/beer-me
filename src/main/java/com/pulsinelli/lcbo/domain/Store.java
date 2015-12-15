package com.pulsinelli.lcbo.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by cpulsinelli on 15-12-11.
 */
public class Store {

    @SerializedName("address_line_1")
    public String address1;

    @SerializedName("address_line_2")
    public String address2;

    @SerializedName("city")
    public String city;

    @SerializedName("fax")
    public String fax;

    @SerializedName("has_beer_cold_room")
    public Boolean hasBeerColdRoom;

    @SerializedName("has_bilingual_services")
    public Boolean hasBilingualServices;

    @SerializedName("has_parking")
    public Boolean hasParking;

    @SerializedName("has_product_consultant")
    public Boolean hasProductConsultant;

    @SerializedName("has_special_occasion_permits")
    public Boolean hasSpecialOccasionPermits;

    @SerializedName("has_tasting_bar")
    public Boolean hasTaskingBar;

    @SerializedName("has_transit_access")
    public Boolean hasTransitAccess;

    @SerializedName("has_vintages_corner")
    public Boolean hasVintagesCorner;

    @SerializedName("has_wheelchair_accessability")
    public Boolean hasWheelchairAccessability;

    @SerializedName("id")
    public Integer id;

    @SerializedName("inventory_count")
    public Integer inventoryCount;

    @SerializedName("inventory_price_in_cents")
    public Integer inventoryPriceInCents;

    @SerializedName("inventory_volume_in_milliliters")
    public Integer inventoryVolumeInMilliliters;

    @SerializedName("is_dead")
    public Boolean isDead;

    @SerializedName("latitude")
    public Double latitude;

    @SerializedName("longitude")
    public Double longitude;

    @SerializedName("name")
    public String name;

    @SerializedName("postal_code")
    public String postalCode;

    @SerializedName("products_count")
    public Integer productsCount;

    @SerializedName("store_no")
    public Integer storeNumber;

    @SerializedName("sunday_close")
    public Integer sundayClose;

    @SerializedName("monday_close")
    public Integer mondayClose;

    @SerializedName("tuesday_close")
    public Integer tuesdayClose;

    @SerializedName("wednesday_close")
    public Integer wednesdayClose;

    @SerializedName("thursday_close")
    public Integer thursdayClose;

    @SerializedName("friday_close")
    public Integer fridayClose;

    @SerializedName("saturday_close")
    public Integer saturdayClose;

    @SerializedName("sunday_open")
    public Integer sundayOpen;

    @SerializedName("monday_open")
    public Integer mondayOpen;

    @SerializedName("tuesday_open")
    public Integer tuesdayOpen;

    @SerializedName("wednesday_open")
    public Integer wednesdayOpen;

    @SerializedName("thursday_open")
    public Integer thursdayOpen;

    @SerializedName("friday_open")
    public Integer fridayOpen;

    @SerializedName("saturday_open")
    public Integer saturdayOpen;

    @SerializedName("tags")
    public String tags;

    @SerializedName("telephone")
    public String telephoneNumber;

    @SerializedName("updated_at")
    public String updatedAt;






}
