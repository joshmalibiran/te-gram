package com.techelevator.controller;

import com.techelevator.dao.FavoriteDao;
import com.techelevator.dao.PostDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class FavoriteController {
    @Autowired
    private PostDao postDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private FavoriteDao favoriteDao;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/favorite/{postId}")
    public void createFavorite(@PathVariable int postId, Principal principal){
        int loggedInUserId = userDao.findIdByUsername(principal.getName());

        favoriteDao.create(postId, loggedInUserId);
    }

    @DeleteMapping(path= "/favorite/{postId}")
    public void deleteFavorite(@PathVariable int postId){
        favoriteDao.delete(postId);
    }

    @GetMapping(path="/favorite/{userId}")
    public List<Favorite> getFavorites(@PathVariable int userId){
        return favoriteDao.getFavoritesFromUserId(userId);
    }


}
