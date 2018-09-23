package com.lanhu.work.vo;

import javax.validation.constraints.NotNull;

public class TopicListPageVo {
	
	
	@NotNull(message = "000001,pageNum为空")
	private Integer pageNum;
	
	
	@NotNull(message = "000001,pageSize为空")
	private Integer pageSize;
	
	
    private String name;


	private Integer state=1;
	
	
    private Integer provinceId;

    private Integer cityId;

    private Integer areaId;


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


	public Integer getProvinceId() {
		return provinceId;
	}


	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}


	public Integer getCityId() {
		return cityId;
	}


	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}


	public Integer getAreaId() {
		return areaId;
	}


	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}


    
	
	

}
