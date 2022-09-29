package com.techelevator.dao;

import com.techelevator.model.Comment;

import java.util.List;

public interface CommentDao {
    //CRUD
//    boolean create(Comment comment);
    boolean create(int postId, int userId, String description);

    List<Comment> getCommentsByPostId(int id);

    boolean delete(int id);

}
