package com.navin.newrozgram.models;

import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("img")
    private
    String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
