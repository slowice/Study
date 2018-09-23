package com.lanhu.work.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.lanhu.work.validator.rule.Sex;
import com.lanhu.work.validator.rule.UserType;

public class ThirdUserloginVo {
	
	
	   /**
     * 用户类型(1平台注册用户2微信用户3微博用户4QQ用户)
     */
	@NotBlank(message = "000001,为空")
	@UserType(message = "000005,应该为{1 2 3 4}")
    private String userType;

    /**
     * 昵称
     */
	@Length(max = 100, message = "000002,过长")
    private String nickName;

    /**
     * 性别(0:未知;1:男;2:女)
     */
	@NotNull(message = "000001,为空")
	@Sex(message = "000005,应该为{0 1 2}")
    private Integer sex;

    /**
     * 头像
     */
	@Length(max = 500, message = "000002,过长")
    private String avatar;


    /**
     * 第三方Id
     */
	@NotBlank(message = "000001,为空")
	@Length(max = 50, message = "000002,过长")
    private String openId;
    
	@Length(max = 100, message = "000002,过长")
    private String uuid;
    
    private String ip;


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public Integer getSex() {
		return sex;
	}


	public void setSex(Integer sex) {
		this.sex = sex;
	}


	public String getAvatar() {
		return avatar;
	}


	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	public String getOpenId() {
		return openId;
	}


	public void setOpenId(String openId) {
		this.openId = openId;
	}


	public String getUuid() {
		return uuid;
	}


	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}



}
