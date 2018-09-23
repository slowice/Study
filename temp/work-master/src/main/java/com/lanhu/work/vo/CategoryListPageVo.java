package com.lanhu.work.vo;

import javax.validation.constraints.NotNull;

public class CategoryListPageVo {
	
	
	@NotNull(message = "000001,pageNum为空")
	private Integer pageNum;
	
	
	@NotNull(message = "000001,pageSize为空")
	private Integer pageSize;
	
	
    private String name;


	private Integer state=1;


	public Integer getPageNum() {
		return pageNum;
	}


	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}


	public Integer getPageSize() {
		return pageSize;
	}


	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getState() {
		return state;
	}


	public void setState(Integer state) {
		this.state = state;
	}


    
	
	

}
