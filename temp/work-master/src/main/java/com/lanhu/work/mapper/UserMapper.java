package com.lanhu.work.mapper;

import java.util.Map;

import com.lanhu.work.pojo.User;

public interface UserMapper {


    int insert(User record);


    User thirdUserLogin(Map<String, Object> params);
    
    User login(Map<String, Object> params);


    int update(User record);
}