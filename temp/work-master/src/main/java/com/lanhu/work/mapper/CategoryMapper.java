package com.lanhu.work.mapper;

import java.util.List;
import java.util.Map;

import com.lanhu.work.pojo.Category;

public interface CategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
    
    List<Category> listPage(Map<String, Object> params);
}