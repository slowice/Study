package com.lanhu.work.mapper;

import java.util.List;
import java.util.Map;

import com.lanhu.work.pojo.Comment;

public interface CommentMapper {

    int insert(Comment record);


    Comment findById(Long commentId);

    int update(Comment record);
    
    List<Comment> listPage(Map<String, Object> params);

}