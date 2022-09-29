package com.techelevator.dao;

import com.techelevator.model.Favorite;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFavoriteDao implements FavoriteDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcFavoriteDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean create(int postId, int userId) {
        String insertPostSql = "INSERT into favorites (post_id, user_id) VALUES (?,?);";

        return jdbcTemplate.update(insertPostSql, postId, userId) == 1;
    }

    @Override
    public boolean delete(int postId) {
        String sql = "DELETE from favorites where post_id=?";
        return jdbcTemplate.update(sql, postId) == 1;
    }

    @Override
    public List<Favorite> getFavoritesFromUserId(int userId) {
        List<Favorite> favoritesList = new ArrayList<>();

        String sql ="SELECT user_id, post_id FROM favorites WHERE user_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        while(results.next()) {
            Favorite favorite = mapRowToFavorite(results);
            favoritesList.add(favorite);
        }

        return favoritesList;
    }

    private Favorite mapRowToFavorite(SqlRowSet rs) {
        Favorite favorite = new Favorite();
        favorite.setPostId(rs.getInt("post_id"));
        favorite.setUserId(rs.getInt("user_id"));

        return favorite;
    }
}
