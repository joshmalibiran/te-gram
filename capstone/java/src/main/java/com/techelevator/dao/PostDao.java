package com.techelevator.dao;

import com.techelevator.model.Post;

import java.time.LocalDateTime;
import java.util.List;

public interface PostDao {

    boolean create(int postId, int userId, String postPicture, String caption, int likes, LocalDateTime datePosted);

    //like post (increment likes++)
//    int likePost (int postId);


    //get post by userId
    List<Post> getPostsByUserId(int userId);

    //get post by postId





    //add post to favorites (do this in favorite table??)


}
