package com.techelevator.controller;

import com.techelevator.dao.PostDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class PostController {
    @Autowired
    private PostDao postDao;
    @Autowired
    private UserDao userDao;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/post")
    public void createPost(@RequestBody Post post, Principal principal) {
        int loggedInUserId = userDao.findIdByUsername(principal.getName());

        postDao.create(loggedInUserId, post.getPostPicture(), post.getCaption());
    }

    @GetMapping(path = "/post")
    public List<Post> getAllPosts() {
        return postDao.getRecentPosts();
    }

    @DeleteMapping(path = "/post/{id}")
    public void deletePost(@PathVariable int id) {
        postDao.delete(id);
    }

    @GetMapping(path = "/post/{id}")
    public Post getPostByPostId(@PathVariable int id) {
        return postDao.getPostByPostId(id);
    }

    @GetMapping(path = "/like")
    public List<Post> getLikedPosts(Principal principal){
        int loggedInUserId = userDao.findIdByUsername(principal.getName());
        return postDao.getAllLikedPosts(loggedInUserId);
    }

}
