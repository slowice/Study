package com.lanhu.work.mapper;

import com.lanhu.work.pojo.Captcha;

public interface CaptchaMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Captcha record);

    int insertSelective(Captcha record);

    Captcha selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Captcha record);

    int updateByPrimaryKey(Captcha record);
}