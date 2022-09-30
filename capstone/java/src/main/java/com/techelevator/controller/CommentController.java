package com.techelevator.controller;

import com.techelevator.dao.CommentDao;
import com.techelevator.dao.PostDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Comment;
import com.techelevator.model.Post;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

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

        commentDao.create(comment.getPost_id(), comment.getUser_id(), comment.getDescription());
    }

    //delete comment
    @DeleteMapping(path = "/comment/{commentId}")
    public void deleteComment(@PathVariable int commentId) {
        commentDao.delete(commentId);
    }

    //get all comments from postId
    @GetMapping(path = "/comment/{postId}")
    public List<Comment> getCommentsByPostId(@PathVariable int postId) {
        List<Comment> commentsOnPost = commentDao.getCommentsByPostId(postId);

        for (Comment currentComment : commentsOnPost) {

            User currentCommenter = userDao.getUserById(currentComment.getUser_id());

            currentComment.setUsername(currentCommenter.getUsername());
        }


        return commentsOnPost;
    }



}
