package com.techelevator.controller;


import com.techelevator.dao.LikeDao;
import com.techelevator.dao.PostDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Like;
import com.techelevator.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

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
    public void createLike(@PathVariable int id, Principal principal){
        int loggedInUserId = userDao.findIdByUsername(principal.getName());

        likeDao.create(id, loggedInUserId);
    }

    @DeleteMapping(path= "/like/{id}")
    public void deleteLike(@PathVariable int id){
        likeDao.delete(id);
    }


    @GetMapping(path="/like/{id}")
    public int getLikes(@PathVariable int id){
        return likeDao.getNumberOfLikes(id);
    }

    @GetMapping(path ="/isLiked/{id}")
    public boolean isLiked(@PathVariable int id, Principal principal){
        int userId = userDao.findIdByUsername(principal.getName());

        return likeDao.isPostLikedByUserId(id,userId);
    }

//    @GetMapping(path="/like")
//    public List<Post> getAllLikedPost(){
//        return l
//    }

}
