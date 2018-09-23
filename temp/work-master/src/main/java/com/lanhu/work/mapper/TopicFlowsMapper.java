package com.lanhu.work.mapper;

import java.util.List;

import com.lanhu.work.pojo.TopicFlows;

public interface TopicFlowsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TopicFlows record);

    int insertSelective(TopicFlows record);

    TopicFlows selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TopicFlows record);

    int updateByPrimaryKey(TopicFlows record);
    
    
    List<TopicFlows> findAllByTopicId(Long topicId);
}