package com.techelevator.dao;

import com.techelevator.model.Post;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPostDao implements PostDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPostDao(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate;}

    @Override
    public boolean create(int userId, String postPicture, String caption){

        String insertPostSql = "INSERT into posts (user_id, post_picture, caption, date_posted) VALUES (?, ?, ?, ?)";

        return jdbcTemplate.update(insertPostSql, userId, postPicture, caption, LocalDateTime.now()) == 1;
    }

    @Override
    public List<Post> getPostsByUserId(int userId) {
        List<Post> posts = new ArrayList<>();
        String sql = "SELECT post_id, user_id, post_picture, caption, date_posted FROM posts WHERE user_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()) {
            Post post = mapRowToPost(results);
            posts.add(post);
        }

        return posts;
    }



    //get posts and sort by date


    public Post getPostByPostId(int id) {
        Post post = null;
        String sql = "select post_id, user_id, post_picture, caption, date_posted FROM posts WHERE post_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next())  {
            post = mapRowToPost(results);
        }

        return post;
    }

    public boolean delete(int id)   {
        String sql = "delete from posts where post_id = ?";
        jdbcTemplate.update(sql, id);

        return getPostByPostId(id) == null;
    }

    @Override
    public List<Post> getRecentPosts() {
        List<Post> posts = new ArrayList<>();
        String sql = "SELECT post_id, user_id, post_picture, caption, date_posted FROM posts";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Post post = mapRowToPost(results);
            posts.add(post);
        }

        return posts;
    }




//    @Override
//    public int likePost (int postId) {
//        String sql = "UPDATE posts SET likes = likes + 1 WHERE post_id = ? RETURNING likes;";
//
//        int newLikeTotal = jdbcTemplate.update(sql, postId);
//
//        return newLikeTotal;
//    }

    private Post mapRowToPost(SqlRowSet rs) {
        Post post = new Post();
        post.setPostId(rs.getInt("post_id"));
        post.setUserId(rs.getInt("user_id"));
        post.setPostPicture(rs.getString("post_picture"));
        post.setCaption(rs.getString("caption"));
        post.setDatePosted(rs.getTimestamp("date_posted").toLocalDateTime());

        return post;
    }

}
