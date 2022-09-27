package com.techelevator.controller;

import com.techelevator.dao.PostDao;
import com.techelevator.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class PostController {
    @Autowired
    private PostDao postDao;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/post")
    public void createPost(@RequestBody Post post) {
        postDao.create(post.getUserId(), post.getPostPicture(), post.getCaption());
    }

    @GetMapping(path = "/post")
    public List<Post> getAllPosts() {
        return postDao.getRecentPosts();
    }

    @DeleteMapping(path = "/post/{id}")
    public void deletePost(@PathVariable int id) {
        postDao.delete(id);
    }

}
