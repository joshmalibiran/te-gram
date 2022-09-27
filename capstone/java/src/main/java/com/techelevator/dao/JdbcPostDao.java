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
    public boolean create(int postId, int userId, String postPicture, String caption,
                          int likes, LocalDateTime datePosted){

        String insertPostSql = "INSERT into posts (post_id, user_id, post_picture, caption, likes, date_posted) VALUES (?, ?, ?, ?, ?, ?);";

        return jdbcTemplate.update(insertPostSql, postId, userId, postPicture, caption, likes, datePosted) == 1;
    }

    @Override
    public List<Post> getPostsByUserId(int userId) {
        List<Post> posts = new ArrayList<>();
        String sql = "SELECT post_id, user_id, post_picture, caption, likes, date_posted FROM posts WHERE user_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()) {
            Post post = mapRowToPost(results);
            posts.add(post);
        }

        return posts;
    }

    //get posts and sort by date

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
        post.setLikes(rs.getInt("likes"));
        post.setDatePosted(rs.getTimestamp("date_posted").toLocalDateTime());

        return post;
    }

}
