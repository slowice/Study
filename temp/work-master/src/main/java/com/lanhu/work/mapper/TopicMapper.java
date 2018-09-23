package com.lanhu.work.mapper;

import java.util.List;
import java.util.Map;

import com.lanhu.work.pojo.Topic;

public interface TopicMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Topic record);

    int insertSelective(Topic record);

    Topic selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKey(Topic record);
    
    List<Topic> listPage(Map<String, Object> params);
}