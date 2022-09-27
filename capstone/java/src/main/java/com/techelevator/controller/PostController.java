package com.techelevator.controller;

import com.techelevator.dao.PostDao;
import com.techelevator.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class PostController {
    @Autowired
    private PostDao postDao;

    @PostMapping(path = "/post")
    public boolean createPost(@RequestBody Post post) {
        //postDao.create(post.getUserId(), post.getPostPicture(), post.getCaption(), post.get )
        return true;
    }


}
