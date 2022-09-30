package com.techelevator.dao;

import com.techelevator.model.Like;

import java.util.List;

public interface LikeDao {

    //create
    boolean create(int postId, int userId);

   //delete
    boolean delete(int postId);

    //get likes
    List<Like> getLikesFromUserId(int userId);

    //get count of likes
    int getNumberOfLikes(int postId);

    boolean isPostLikedByUserId(int postId, int userId);
}
