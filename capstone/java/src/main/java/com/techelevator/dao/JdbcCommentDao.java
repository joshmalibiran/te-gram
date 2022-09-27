package com.techelevator.dao;

import com.techelevator.model.Comment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCommentDao implements CommentDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcCommentDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean create(Comment comment)  {
        String sql = "insert into comments(post_id, user_id, comment_description, date_posted) values(?,?,?,?)";
        return jdbcTemplate.update(sql, comment.getPost_id(), comment.getUser_id(), comment.getDescription(), LocalDateTime.now()) == 1;
    }

    public Comment getCommentByCommentId(int id)    {
        String sql = "select comment_id, post_id, user_id, comment_description, date_posted from comments where comment_id = ?";
        Comment comment = jdbcTemplate.queryForObject(sql, Comment.class, id);
        return comment;
    }

    public List<Comment> getCommentsByPostId(int id)   {
        List<Comment> list = new ArrayList<>();
        String sql = "select comment_id, post_id, user_id, comment_description, date_posted from comments where post_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while (results.next())  {
            Comment comment = mapRowToComment(results);
            list.add(comment);
        }

        return list;
    }

    public boolean delete(int id)   {
        String sql = "delete from comments where comment_id = ?";
        jdbcTemplate.update(sql, id);

        return getCommentByCommentId(id) == null;
    }

    private Comment mapRowToComment(SqlRowSet rs)   {
        Comment comment = new Comment();
        comment.setId(rs.getInt("comment_id")) ;
        comment.setPost_id(rs.getInt("post_id"));
        comment.setUser_id(rs.getInt("user_id"));
        comment.setDescription(rs.getString("comment_description"));
        comment.setDate_posted(rs.getTimestamp("date_posted").toLocalDateTime());
        return comment;
    }

}
