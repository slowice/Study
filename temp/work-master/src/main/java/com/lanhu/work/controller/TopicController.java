package com.lanhu.work.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.lanhu.work.annotation.IgnoreSecurity;
import com.lanhu.work.exception.ValidException;
import com.lanhu.work.pojo.Topic;
import com.lanhu.work.pojo.TopicFlows;
import com.lanhu.work.service.TopicFlowsService;
import com.lanhu.work.service.TopicService;
import com.lanhu.work.utils.Bean2MapUtil;
import com.lanhu.work.utils.R;
import com.lanhu.work.vo.TopicFlowListVo;
import com.lanhu.work.vo.TopicListPageVo;

@RestController
public class TopicController extends BaseController {
	
	@Autowired
	private TopicService topicService;
	
	@Autowired
	private TopicFlowsService topicFlowsService;
	
	
	/**
	 * 
	 * @param vo
	 * @param bindingResult
	 * @return
	 */
	@IgnoreSecurity
	@GetMapping(value="/v1/topic/listpage")
	public Object topicListPage(@Valid TopicListPageVo vo,BindingResult bindingResult) {
		//驗證檢驗
		if(bindingResult.hasErrors()) {
			throw new ValidException(bindingResult);
		}
		PageInfo<List<Topic>> page  = topicService.listPage(Bean2MapUtil.object2map(vo));
		return R.ok(page);
		
	}
	
	
	/**
	 * 
	 * @param vo
	 * @param bindingResult
	 * @return
	 */
	@IgnoreSecurity
	@GetMapping(value="/v1/topicFlow/list")
	public Object topicFlowList(@Valid TopicFlowListVo vo,BindingResult bindingResult) {
		//驗證檢驗
		if(bindingResult.hasErrors()) {
			throw new ValidException(bindingResult);
		}
		List<TopicFlows> list  = topicFlowsService.findAllByTopicId(vo.getTopicId());
		return R.ok(list);
		
	}
	
	
	

}
