package com.pulsinelli.lcbo.domain;

import com.google.gson.annotations.SerializedName;

public class LcboResponse<T> {
    @SerializedName("status")
    public int status;

    @SerializedName("message")
    public String message;

    @SerializedName("result")
    public T result;
}