package com.lanhu.work.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.lanhu.work.annotation.IgnoreSecurity;
import com.lanhu.work.exception.ValidException;
import com.lanhu.work.pojo.Comment;
import com.lanhu.work.service.CommentService;
import com.lanhu.work.utils.Bean2MapUtil;
import com.lanhu.work.utils.R;
import com.lanhu.work.vo.CommentSendVo;
import com.lanhu.work.vo.FrontCommentListPageVo;

@RestController
public class CommentController extends BaseController {
	
	@Autowired
	private CommentService commentService;
	
	@IgnoreSecurity
	@PostMapping(value="/v1/comment/send")
	public Object commentSend(@Valid CommentSendVo vo,BindingResult bindingResult) {
		
		//驗證檢驗
		if(bindingResult.hasErrors()) {
			throw new ValidException(bindingResult);
		}
		Comment comment = new Comment();
		//属性赋值
		BeanUtils.copyProperties(vo, comment);
		//设置评论状态（待审核）
		comment.setCommentState(0);
		//发送评论
		commentService.commentSend(comment);
		return R.ok();
		
	}
	
	
	@IgnoreSecurity
	@GetMapping(value="/v1/comment/listPage")
	public Object commentListPage(@Valid FrontCommentListPageVo vo,BindingResult bindingResult) {
		
		//驗證檢驗
		if(bindingResult.hasErrors()) {
			throw new ValidException(bindingResult);
		}
		PageInfo<List<Comment>> page  = commentService.listPage(Bean2MapUtil.object2map(vo));
		return R.ok(page);
		
	}
	
	
	

}
