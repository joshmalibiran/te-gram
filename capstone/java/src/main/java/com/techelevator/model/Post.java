package com.techelevator.model;

import org.springframework.cglib.core.Local;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Post {

    private int postId;
    private int userId;
    private String username;
    private String postPicture;
    private String caption;
    private LocalDateTime datePosted;
    //add post date

    public Post () {};

    public Post(int postId, int userId,String postPicture, String caption, LocalDateTime datePosted) {
        this.postId = postId;
        this.userId = userId;
        this.postPicture = postPicture;
        this.caption = caption;
        this.datePosted = datePosted;
//        this.rating = rating;
        //add post date
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPostPicture() {
        return postPicture;
    }

    public void setPostPicture(String postPicture) {
        this.postPicture = postPicture;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public LocalDateTime getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDateTime datePosted) {
        this.datePosted = datePosted;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}


