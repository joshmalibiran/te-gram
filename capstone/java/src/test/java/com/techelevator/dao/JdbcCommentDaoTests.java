package com.techelevator.dao;

import com.techelevator.model.Comment;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcCommentDaoTests extends BaseDaoTests{
    protected static final Comment comment1 = new Comment(1, 1, 1, "comment");


    private JdbcCommentDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcCommentDao(jdbcTemplate);
    }

    @Test
    public void create_creates_a_comment()    {
        boolean wasCreated = sut.create(comment1);
        Assert.assertTrue(wasCreated);
    }

}
