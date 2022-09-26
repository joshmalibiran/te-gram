package com.techelevator.dao;

import com.techelevator.model.Comment;

import java.util.List;

public interface CommentDao {
    //CRUD
    boolean create(Comment comment);
    List<Comment> getCommentsByPostId(int id);

}
