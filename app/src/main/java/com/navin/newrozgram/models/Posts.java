package com.navin.newrozgram.models;

import com.google.gson.annotations.SerializedName;

public class Posts {

    @SerializedName("id")
    private
    String Id;
    @SerializedName("username")
    private
    String username;
    @SerializedName("imageProfile")
    private
    String imageProfile;
    @SerializedName("images")
    private
    String images;
    @SerializedName("user_id")
    private
    String user_id;
    @SerializedName("description")
    private
    String description;
    @SerializedName("likes")
    private
    String likes;
    @SerializedName("comments")
    private
    String comments;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(String imageProfile) {
        this.imageProfile = imageProfile;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
