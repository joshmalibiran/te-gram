package com.techelevator.model;

import java.time.LocalDateTime;

public class Comment {
    private int id;
    private int post_id;
    private int user_id;
    private String username;
    private String description;
    private LocalDateTime date_posted;

    public Comment(){}

    public Comment(int id, int post_id, int user_id, String description, LocalDateTime date_posted) {
        this.id = id;
        this.post_id = post_id;
        this.user_id = user_id;
        this.description = description;
        this.date_posted = date_posted;
    }

    public LocalDateTime getDate_posted() {
        return date_posted;
    }

    public void setDate_posted(LocalDateTime date_posted) {
        this.date_posted = date_posted;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
