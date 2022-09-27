package com.techelevator.dao;

import com.techelevator.model.Comment;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.DataValidationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;


public class JdbcCommentDaoTests extends BaseDaoTests{
    protected static final Comment comment1 = new Comment(1, 1, 1, "comment", LocalDateTime.now());
    protected static final Comment comment2 = new Comment(1, 1, 1, null, LocalDateTime.now());


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

    @Test(expected = DataIntegrityViolationException.class)
    public void create_comment_with_null_description()    {
        sut.create(comment2);
    }

    @Test
    public void get_comment_by_comment_id() {
        Comment returned = sut.getCommentByCommentId(1);
        Assert.assertEquals(returned.getId(), 1);
    }

}
