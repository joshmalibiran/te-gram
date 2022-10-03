package com.techelevator.dao;

import com.techelevator.model.Favorite;
import com.techelevator.model.Like;

import java.util.List;

public interface FavoriteDao {
    //create
    boolean create(int postId, int userId);

    //delete
    boolean delete(int postId);

    //get likes
    List<Favorite> getFavoritesFromUserId(int userId);

    boolean isPostFavoritedByUserId(int postId, int userId);

}
