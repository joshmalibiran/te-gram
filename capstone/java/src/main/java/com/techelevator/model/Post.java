package com.techelevator.model;

import org.springframework.cglib.core.Local;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Post {

    private int postId;
    private int userId;
    private String postPicture;
    private String caption;
    private int likes;
    private LocalDateTime datePosted;
    //add post date

    public Post () {};

    public Post(int postId, int userId, String postPicture, String caption, int likes, LocalDateTime datePosted) {
        this.postId = postId;
        this.userId = userId;
        this.postPicture = postPicture;
        this.caption = caption;
        this.likes = likes;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public LocalDateTime getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDateTime datePosted) {
        this.datePosted = datePosted;
    }
}
