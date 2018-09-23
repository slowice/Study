package com.lanhu.work.pojo;

import java.util.Date;

/**
 * 用户访问日志表
 * 
 * @author wcyong
 * 
 * @date 2018-08-09
 */
public class UserAccessLog {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * token
     */
    private String token;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 访问类型(登录:1,退出:0)
     */
    private String accessType;

    /**
     * IP
     */
    private String ip;

    /**
     * uuid
     */
    private String uuid;
    
    public UserAccessLog(Long userId,String token,String accessType,String ip,String uuid) {
    	this.userId = userId;
    	this.token = token;
    	this.accessType = accessType;
    	this.ip = ip;
    	this.uuid = uuid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType == null ? null : accessType.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }
}