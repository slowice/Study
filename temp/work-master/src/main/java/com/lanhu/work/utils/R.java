package com.lanhu.work.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.lanhu.work.enums.BusErrorCode;

public class R {
	
	private static final String SUCCESS = "000000";
	
	
	private String code;
	
	@JsonInclude(Include.NON_NULL)
	private String msg;
	
	@JsonInclude(Include.NON_NULL)
	private Object data;
	
	
	private R(String msg) {
		this.msg = msg;
	}
	
	
	private R(Object data) {
		this.data = data;
	}
	
	private R(String code,String msg) {
		this.msg = msg;
		this.code = code;
	}
	
	
	
	

	
	public static R ok() {
		R r = new R("ok");
		r.setCode(SUCCESS);
		return r;
	}
	
	public static R ok(Object data) {
		R r = new R("ok");
		r.setData(data);
		r.setCode(SUCCESS);
		return r;
	}
	
	public static R error(String code,String msg) {
		R r = new R(code,msg);
		return r;
	}

	
	public static R error(BusErrorCode busErrorCode) {
		R r = new R(busErrorCode.getErrorCode(),busErrorCode.getDefaultMessage());
		return r;
	}

	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}
