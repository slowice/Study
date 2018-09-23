package com.lanhu.work.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanhu.work.mapper.TopicFlowsMapper;
import com.lanhu.work.pojo.TopicFlows;

@Service
public class TopicFlowsService {
	
	@Autowired
	private TopicFlowsMapper topicFlowsMapper;
	
	/**
	 * 
	 * @param topicId
	 * @return
	 */
	public List<TopicFlows> findAllByTopicId(Long topicId){
		List<TopicFlows> list = topicFlowsMapper.findAllByTopicId(topicId);
		return list;
	}

}
