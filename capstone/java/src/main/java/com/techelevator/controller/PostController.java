package com.techelevator.controller;

import com.techelevator.dao.CommentDao;
import com.techelevator.dao.LikeDao;
import com.techelevator.dao.PostDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Post;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class PostController {
    @Autowired
    private PostDao postDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private LikeDao likeDao;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/post")
    public void createPost(@RequestBody Post post, Principal principal) {
        int loggedInUserId = userDao.findIdByUsername(principal.getName());

        postDao.create(loggedInUserId, post.getPostPicture(), post.getCaption());
    }

    @GetMapping(path = "/post")
    public List<Post> getAllPosts() {
        //loop through and set usernames
        List<Post> allPosts = postDao.getRecentPosts();

        for (Post currentPost : allPosts) {

            //add likes to post
            currentPost.setNumOfLikes(likeDao.getNumberOfLikes(currentPost.getPostId()));

            //add comments to post
            currentPost.setCommentsOnPost(commentDao.getCommentsByPostId(currentPost.getPostId()));

            //store currentPostOwner useraccount
            User currentPostOwner = userDao.getUserById(currentPost.getUserId());

            currentPost.setUsername(currentPostOwner.getUsername());
        }


        return allPosts;
    }

    @DeleteMapping(path = "/post/{id}")
    public void deletePost(@PathVariable int id) {
        postDao.delete(id);
    }

    @GetMapping(path = "/post/{postId}")
    public Post getPostByPostId(@PathVariable int postId) {

        Post post = postDao.getPostByPostId(postId);
        User postOwner = userDao.getUserById(post.getUserId());
        post.setUsername(postOwner.getUsername());

        //set comments on post
        post.setCommentsOnPost(commentDao.getCommentsByPostId(postId));

        //set numOfLikes on post
        post.setNumOfLikes(likeDao.getNumberOfLikes(postId));


        return post;
    }

//    @GetMapping(path = "profile/{userId}")
//    public List<Post> getPostsByUserId(@PathVariable int userId) {
//        List<Post> allUserPosts = new ArrayList<>();
//        allUserPosts = postDao.getPostsByUserId(userId);
//
//        for (Post currentPost : allUserPosts) {
//
//            //add likes to post
//            currentPost.setNumOfLikes(likeDao.getNumberOfLikes(currentPost.getPostId()));
//
//            //add comments to post
//            currentPost.setCommentsOnPost(commentDao.getCommentsByPostId(currentPost.getPostId()));
//
//            //store currentPostOwner useraccount
//            User currentPostOwner = userDao.getUserById(currentPost.getUserId());
//
//            currentPost.setUsername(currentPostOwner.getUsername());
//        }
//
//
//        return allUserPosts;
//    }

    @GetMapping(path = "profile/{username}")
    public List<Post> getPostsByUserId(@PathVariable String username) {
        List<Post> allUserPosts = new ArrayList<>();
        allUserPosts = postDao.getPostsByUsername(username);

        for (Post currentPost : allUserPosts) {

            //add likes to post
            currentPost.setNumOfLikes(likeDao.getNumberOfLikes(currentPost.getPostId()));

            //add comments to post
            currentPost.setCommentsOnPost(commentDao.getCommentsByPostId(currentPost.getPostId()));

            //store currentPostOwner useraccount
            User currentPostOwner = userDao.getUserById(currentPost.getUserId());

            currentPost.setUsername(username);
        }


        return allUserPosts;
    }

    @GetMapping(path = "/like")
    public List<Post> getLikedPosts(Principal principal){
        int loggedInUserId = userDao.findIdByUsername(principal.getName());

        // loop through and set usernames
        List<Post> allPosts = postDao.getAllLikedPosts(loggedInUserId);

        for (Post currentPost : allPosts) {

            //add likes to post
            currentPost.setNumOfLikes(likeDao.getNumberOfLikes(currentPost.getPostId()));

            //add comments to post
            currentPost.setCommentsOnPost(commentDao.getCommentsByPostId(currentPost.getPostId()));

            //store currentPostOwner useraccount
            User currentPostOwner = userDao.getUserById(currentPost.getUserId());

            currentPost.setUsername(currentPostOwner.getUsername());
        }

        return allPosts;
    }

    @GetMapping(path = "/favorite")
    public List<Post> getFavoritedPosts(Principal principal){
        int loggedInUserId = userDao.findIdByUsername(principal.getName());

        // loop through and set usernames
        List<Post> allPosts = postDao.getAllFavoritedPosts(loggedInUserId);

        for (Post currentPost : allPosts) {

            //add likes to post
            currentPost.setNumOfLikes(likeDao.getNumberOfLikes(currentPost.getPostId()));

            //add comments to post
            currentPost.setCommentsOnPost(commentDao.getCommentsByPostId(currentPost.getPostId()));

            //store currentPostOwner useraccount
            User currentPostOwner = userDao.getUserById(currentPost.getUserId());

            currentPost.setUsername(currentPostOwner.getUsername());
        }

        return allPosts;
    }

    @GetMapping(path="/results/{username}")
    public List<User> getListOfUsersByUsername(@PathVariable String username) {
        List<User> allUsersByUsername = new ArrayList<>();
        allUsersByUsername = userDao.getUsersByUsername(username);


        for (User users : allUsersByUsername) {
            users.setUsername(users.getUsername());
        }

        return allUsersByUsername;
    }

}
