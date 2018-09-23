package com.lanhu.work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanhu.work.mapper.AdminUserMapper;




@Service
public class AdminUserService {
	
	@Autowired
	private AdminUserMapper adminUserMapper;

}
