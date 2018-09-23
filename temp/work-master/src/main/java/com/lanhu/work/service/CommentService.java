package com.lanhu.work.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanhu.work.mapper.CommentMapper;
import com.lanhu.work.pojo.Comment;

@Service
public class CommentService {
	
	@Autowired
	private CommentMapper commentMapper;
	
	/**
	 * 评论发送
	 * @param comment
	 * @return
	 */
	public int commentSend(Comment comment) {
		return commentMapper.insert(comment);
		
	}
	
	
	public int update(Comment comment) {
		return commentMapper.update(comment);
	}
	
	
	
	public Comment findById(Long id) {
		return commentMapper.findById(id);
	}

	
	/**
	 * 分页查询
	 * @param params
	 * @return
	 */
	public PageInfo<List<Comment>> listPage(Map<String, Object> params){
		PageHelper.startPage((Integer)params.get("pageNum"), (Integer)params.get("pageSize"));
		List<Comment> list = commentMapper.listPage(params);
		return new PageInfo(list);
	}
}
