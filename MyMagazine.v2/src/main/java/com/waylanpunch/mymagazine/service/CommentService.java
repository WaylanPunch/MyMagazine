package com.waylanpunch.mymagazine.service;

import com.waylanpunch.mymagazine.dao.CommentMapper;
import com.waylanpunch.mymagazine.pojo.Comment;
import com.waylanpunch.mymagazine.pojo.CommentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * A New Class Created By Waylan Punch
 * https://github.com/WaylanPunch
 *
 * @author Waylan Punch
 * @date 2019/3/16 17:07
 */
@Service
public class CommentService implements ICommentService {

    @Autowired
    private CommentMapper commentMapper;


    @Override
    public List<Comment> findAllComments() {
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andCommentIdIsNotNull();
        return commentMapper.selectByExample(commentExample);
    }
}
