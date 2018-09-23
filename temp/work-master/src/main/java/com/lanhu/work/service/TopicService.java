package com.lanhu.work.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanhu.work.mapper.TopicMapper;
import com.lanhu.work.pojo.Topic;

@Service
public class TopicService {
	
	@Autowired
	private TopicMapper topicMapper;
	
	/**
	 * 分页查询
	 * @param params
	 * @return
	 */
	public PageInfo<List<Topic>> listPage(Map<String, Object> params){
		PageHelper.startPage((Integer)params.get("pageNum"), (Integer)params.get("pageSize"));
		List<Topic> list = topicMapper.listPage(params);
		return new PageInfo(list);
	}

}
