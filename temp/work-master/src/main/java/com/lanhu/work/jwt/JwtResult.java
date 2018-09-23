package com.lanhu.work.jwt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JwtResult {
	
	private String state;
	
	private Object data;
	
	public JwtResult(String state,Object data) {
		
		this.state = state;
		this.data = data;
	}
	

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}

	
	/**
	 * 根据token返回userId
	 * @return
	 */
	public Long getUserId() {
		Long userId = null;
		JSONObject jsonObj = null;
		if(data != null) {
			jsonObj = JSON.parseObject(data.toString());
		}
		if(jsonObj != null) {
			userId = jsonObj.getLong("uid");
		}
		return userId;
	}
	
	

}
