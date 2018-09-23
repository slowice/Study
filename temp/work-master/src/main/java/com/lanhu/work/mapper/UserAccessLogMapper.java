package com.lanhu.work.mapper;

import com.lanhu.work.pojo.UserAccessLog;

public interface UserAccessLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserAccessLog record);

    int insertSelective(UserAccessLog record);

    UserAccessLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAccessLog record);

    int updateByPrimaryKey(UserAccessLog record);
}