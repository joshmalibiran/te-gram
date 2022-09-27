package com.techelevator.dao;

import com.techelevator.model.Post;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.util.List;

public class JdbcPostDaoTests extends BaseDaoTests{
    protected static final Post post = new Post(1,1,"LINK","WOO",0, LocalDateTime.now());

    private JdbcPostDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcPostDao(jdbcTemplate);
    }

    @Test
    public void create_post_creates_a_post() {
        Post newPost = new Post (2,1,"asdf","asdf",4, LocalDateTime.now());

        boolean postWasCreated = sut.create(newPost.getPostId(), newPost.getUserId(), newPost.getPostPicture(),
                newPost.getCaption(), newPost.getLikes(), newPost.getDatePosted());

        Assert.assertTrue(postWasCreated);


    }

    @Test
    public void get_posts_by_user_id_returns_posts() {
//        boolean createNewPost = sut.create(2,3, "link", "caption", 5, LocalDateTime.now());
//        boolean createSecondPost = sut.create(3,3, "link", "caption", 5, LocalDateTime.now());
        int expectedListLength = 1;

        List<Post> postlist = sut.getPostsByUserId(1);

        Assert.assertEquals(expectedListLength, postlist.size());





    }
}
