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
import com.lanhu.work.pojo.Category;
import com.lanhu.work.service.CategoryService;
import com.lanhu.work.utils.Bean2MapUtil;
import com.lanhu.work.utils.R;
import com.lanhu.work.vo.CategoryListPageVo;

@RestController
public class CategoryController extends BaseController {
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 
	 * @param vo
	 * @param bindingResult
	 * @return
	 */
	@IgnoreSecurity
	@GetMapping(value="/v1/category/listpage")
	public Object categoryListPage(@Valid CategoryListPageVo vo,BindingResult bindingResult) {
		//驗證檢驗
		if(bindingResult.hasErrors()) {
			throw new ValidException(bindingResult);
		}
		PageInfo<List<Category>> page  = categoryService.listPage(Bean2MapUtil.object2map(vo));
		return R.ok(page);
		
	}

}
