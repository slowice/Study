package com.lanhu.work.pojo;

import java.util.Date;

/**
 * 验证码表
 * 
 * @author wcyong
 * 
 * @date 2018-08-09
 */
public class Captcha {
    private Long id;

    /**
     * 验证码
     */
    private String captcha;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 验证码类型(0:用户注册1:用户登录2找回密码3重新设置密码4号码绑定)
     */
    private Integer captchaType;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 验证码方式(0:短信1:邮件2:语音)
     */
    private Integer captchaMode;

    /**
     * 验证码有效时间(单位:秒)
     */
    private Integer captchaPeriod;

    /**
     * 验证码有效时间
     */
    private Date expireTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha == null ? null : captcha.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCaptchaType() {
        return captchaType;
    }

    public void setCaptchaType(Integer captchaType) {
        this.captchaType = captchaType;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getCaptchaMode() {
        return captchaMode;
    }

    public void setCaptchaMode(Integer captchaMode) {
        this.captchaMode = captchaMode;
    }

    public Integer getCaptchaPeriod() {
        return captchaPeriod;
    }

    public void setCaptchaPeriod(Integer captchaPeriod) {
        this.captchaPeriod = captchaPeriod;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
}