package com.pulsinelli.lcbo.domain;

import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {

    @SerializedName("alcohol_content")
    public Integer alcoholContent; // Divide by 100 to get percentage

    @SerializedName("bonus_reward_miles")
    public Integer bonusRewardMiles;

    @SerializedName("bonus_reward_miles_ends_on")
    public String bonusRewardMilesEndsOn;

    @SerializedName("description")
    public String description;

    @SerializedName("has_bonus_reward_miles")
    public Boolean hasBonusRewardMiles;

    @SerializedName("has_limited_time_offer")
    public Boolean hasLimitedTimeOffer;

    @SerializedName("has_value_added_promotion")
    public Boolean hasValueAddedPromotion;

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

    @SerializedName("is_discontinued")
    public Boolean isDiscontinued;

    @SerializedName("is_kosher")
    public Boolean isKosher;

    @SerializedName("is_seasonal")
    public Boolean isSeasonal;

    @SerializedName("is_vqa")
    public Boolean isVqa;

    @SerializedName("is_ocb")
    public Boolean isOcb;

    @SerializedName("limited_time_offer_ends_on")
    public String limitedTimeOfferEndsOn;

    @SerializedName("limited_time_offer_savings_in_cents")
    public Integer limitedTimeOfferSavingsInCents;

    @SerializedName("name")
    public String name;

    @SerializedName("origin")
    public String origin;

    @SerializedName("package")
    public String packageDescription;

    @SerializedName("package_unit_type")
    public String packageUnitType;

    @SerializedName("package_unit_volume_in_milliliters")
    public Integer packageUnitVolumeInMilliliters;

    @SerializedName("price_in_cents")
    public Integer priceInCents;

    @SerializedName("price_per_liter_in_cents")
    public Integer pricePerLiterInCents;

    @SerializedName("price_per_liter_of_alcohol_in_cents")
    public Integer pricePerLiterOfAlcoholInCents;

    @SerializedName("primary_category")
    public String primaryCategory;

    @SerializedName("producer_name")
    public String producerName;

    @SerializedName("regular_price_in_cents")
    public Integer regularPriceInCents;

    @SerializedName("released_on")
    public String releasedOn; // usually unspecified

    @SerializedName("secondary_category")
    public String secondaryCategory; // not always available

    @SerializedName("serving_suggestion")
    public String servingSuggestion; // not always available

    @SerializedName("style")
    public String style; // LCBO's determined style designation; not always available

    @SerializedName("tertiary_category")
    public String tertiaryCategory;

    @SerializedName("image_url")
    public String imageUrl;

    @SerializedName("image_thumb_url")
    public String imageThumbUrl;

    @SerializedName("stock_type")
    public String stockType; // LCBO or VINTAGES

    @SerializedName("sugar_content")
    public String sugarContent; // sweetness level; not always available

    @SerializedName("sugar_in_grams_per_liter")
    public Double sugarInGramsPerLiter; // not always available

    @SerializedName("tags")
    public String tags;

    @SerializedName("tasting_note")
    public String tastingNote;

    @SerializedName("total_package_units")
    public Integer totalPackageUnits;

    @SerializedName("updated_at")
    public String updatedAt;

    @SerializedName("value_added_promotion_description")
    public String valueAddedPromotionDescription;

    @SerializedName("varietal")
    public String varietal; // usually for wines only...

    @SerializedName("volume_in_milliliters")
    public String volumeInMilliliters; // total volume of all units in package

    public Integer getAlcoholContent() {
        return alcoholContent;
    }

    public Integer getBonusRewardMiles() {
        return bonusRewardMiles;
    }

    public String getBonusRewardMilesEndsOn() {
        return bonusRewardMilesEndsOn;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getHasBonusRewardMiles() {
        return hasBonusRewardMiles;
    }

    public Boolean getHasLimitedTimeOffer() {
        return hasLimitedTimeOffer;
    }

    public Boolean getHasValueAddedPromotion() {
        return hasValueAddedPromotion;
    }

    public Integer getId() {
        return id;
    }

    public Integer getInventoryCount() {
        return inventoryCount;
    }

    public Integer getInventoryPriceInCents() {
        return inventoryPriceInCents;
    }

    public Integer getInventoryVolumeInMilliliters() {
        return inventoryVolumeInMilliliters;
    }

    public Boolean getIsDead() {
        return isDead;
    }

    public Boolean getIsDiscontinued() {
        return isDiscontinued;
    }

    public Boolean getIsKosher() {
        return isKosher;
    }

    public Boolean getIsSeasonal() {
        return isSeasonal;
    }

    public Boolean getIsVqa() {
        return isVqa;
    }

    public Boolean getIsOcb() {
        return isOcb;
    }

    public String getLimitedTimeOfferEndsOn() {
        return limitedTimeOfferEndsOn;
    }

    public Date getLimitedTimeOfferEndsOnAsDate() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(limitedTimeOfferEndsOn);
    }

    public Integer getLimitedTimeOfferSavingsInCents() {
        return limitedTimeOfferSavingsInCents;
    }

    public String getName() {
        return name;
    }

    public String getOrigin() {
        return origin;
    }

    public String getPackageDescription() {
        return packageDescription;
    }

    public String getPackageUnitType() {
        return packageUnitType;
    }

    public Integer getPackageUnitVolumeInMilliliters() {
        return packageUnitVolumeInMilliliters;
    }

    public Integer getPriceInCents() {
        return priceInCents;
    }

    public Integer getPricePerLiterInCents() {
        return pricePerLiterInCents;
    }

    public Integer getPricePerLiterOfAlcoholInCents() {
        return pricePerLiterOfAlcoholInCents;
    }

    public String getPrimaryCategory() {
        return primaryCategory;
    }

    public String getProducerName() {
        return producerName;
    }

    public Integer getRegularPriceInCents() {
        return regularPriceInCents;
    }

    public String getReleasedOn() {
        return releasedOn;
    }

    public String getSecondaryCategory() {
        return secondaryCategory;
    }

    public String getServingSuggestion() {
        return servingSuggestion;
    }

    public String getStyle() {
        return style;
    }

    public String getTertiaryCategory() {
        return tertiaryCategory;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getImageThumbUrl() {
        return imageThumbUrl;
    }

    public String getStockType() {
        return stockType;
    }

    public String getSugarContent() {
        return sugarContent;
    }

    public Double getSugarInGramsPerLiter() {
        return sugarInGramsPerLiter;
    }

    public String getTags() {
        return tags;
    }

    public String getTastingNote() {
        return tastingNote;
    }

    public Integer getTotalPackageUnits() {
        return totalPackageUnits;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getValueAddedPromotionDescription() {
        return valueAddedPromotionDescription;
    }

    public String getVarietal() {
        return varietal;
    }

    public String getVolumeInMilliliters() {
        return volumeInMilliliters;
    }
}
