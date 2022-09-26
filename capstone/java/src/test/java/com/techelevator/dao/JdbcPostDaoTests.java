package com.techelevator.dao;

import com.techelevator.model.Post;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;

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
}
