package com.waylanpunch.mymagazine.service;

import com.waylanpunch.mymagazine.pojo.Comment;

import java.util.List;

public interface ICommentService {

    List<Comment> findAllComments();
}
