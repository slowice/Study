package com.lanhu.work.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanhu.work.mapper.CategoryMapper;
import com.lanhu.work.pojo.Category;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	/**
	 * 分页查询
	 * @param params
	 * @return
	 */
	public PageInfo<List<Category>> listPage(Map<String, Object> params){
		PageHelper.startPage((Integer)params.get("pageNum"), (Integer)params.get("pageSize"));
		List<Category> list = categoryMapper.listPage(params);
		return new PageInfo(list);
	}

}
