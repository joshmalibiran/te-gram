package com.techelevator.model;

public class Favorite {
    private int postId;
    private int userId;

    public Favorite () {

    };

    public Favorite(int postId, int userId) {
        this.postId = postId;
        this.userId = userId;
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
}
