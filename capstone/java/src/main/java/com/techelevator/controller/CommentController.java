package com.techelevator.controller;

import com.techelevator.dao.CommentDao;
import com.techelevator.dao.PostDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class CommentController {
    @Autowired
    private PostDao postDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private CommentDao commentDao;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/comment/{postId}")
    public void createComment(@PathVariable int postId, @RequestBody Comment comment, Principal principal){

        commentDao.create(comment);
    }



}
