package com.lanhu.work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanhu.work.mapper.UserAccessLogMapper;

@Service
public class UserAccessLogService {
	
	@Autowired
	private UserAccessLogMapper userAccessLogMapper;

}
