package com.techelevator.dao;

import com.techelevator.model.Like;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcLikeDao implements LikeDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcLikeDao(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public boolean create(int postId, int userId) {
        String insertPostSql = "INSERT into likes (post_id, user_id) VALUES (?,?);";

        return jdbcTemplate.update(insertPostSql, postId, userId) == 1;
    }

    @Override
    public List<Like> getLikesFromUserId(int userId) {
        List<Like> likesList = new ArrayList<>();

        String sql ="SELECT user_id, post_id FROM likes WHERE user_id = 1;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        while(results.next()) {
            Like like = mapRowToLike(results);
            likesList.add(like);
        }

        return likesList;
    }

    private Like mapRowToLike(SqlRowSet rs) {
        Like like = new Like();
        like.setPostId(rs.getInt("post_id"));
        like.setUserId(rs.getInt("user_id"));

        return like;
    }
}
