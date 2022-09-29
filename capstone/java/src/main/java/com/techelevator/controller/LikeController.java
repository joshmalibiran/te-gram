package com.techelevator.controller;


import com.techelevator.dao.LikeDao;
import com.techelevator.dao.PostDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class LikeController {
    @Autowired
    private PostDao postDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private LikeDao likeDao;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/like/{id}")
    public void createLike(@PathVariable int id, @RequestBody Like like, Principal principal){
        int loggedInUserId = userDao.findIdByUsername(principal.getName());

        likeDao.create(id, loggedInUserId);
    }

    //GET LIKES BY USER ID
}
