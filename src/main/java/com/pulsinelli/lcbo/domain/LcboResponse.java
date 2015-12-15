package com.pulsinelli.lcbo.domain;

/**
 * Created by cpulsinelli on 15-12-11.
 */
import com.google.gson.annotations.SerializedName;

public class LcboResponse<T> {
    @SerializedName("status")
    public int status;

    @SerializedName("message")
    public String message;

    @SerializedName("result")
    public T result;
}