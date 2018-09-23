package com.lanhu.work.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lanhu.work.jwt.Jwt;
import com.lanhu.work.mapper.UserAccessLogMapper;
import com.lanhu.work.mapper.UserMapper;
import com.lanhu.work.pojo.User;
import com.lanhu.work.pojo.UserAccessLog;
import com.lanhu.work.vo.ThirdUserloginVo;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	
	@Autowired
	private UserAccessLogMapper userAccessLogMapper;
	
	
	public int insert(User record) {
		return userMapper.insert(record);
	}


	public User thirdUserLogin(String openId,String userType) {
		Map<String, Object> params = new HashMap<>();
		params.put("openId", openId);
		params.put("userType", userType);
		return userMapper.thirdUserLogin(params);
	}
    
	public User login(Map<String, Object> params) {
		return userMapper.login(params);
	}


	public int update(User record) {
		return userMapper.update(record);
	}
	
	@Transactional
	public void thirdUserLogin(User user,ThirdUserloginVo vo) {
		User updateUser = new User();
		//如果是新增用户
		if(user.getId() == null) {
			//新增用户
			insert(user);
		}
		//颁布token
		user.setToken(Jwt.createToken(user.getId()));
		//更新用户记录
		updateUser.setId(user.getId());
		updateUser.setLoginNum(user.getLoginNum()==null?0:user.getLoginNum()+1);
		updateUser.setOldLoginIp(user.getLoginIp());
		updateUser.setLoginIp(vo.getIp());
		updateUser.setOldLoginTime(user.getLoginTime());
		userMapper.update(updateUser);
		//新增登陆日志
		UserAccessLog log = new UserAccessLog(user.getId(), user.getToken(), "1", vo.getIp(), vo.getUuid());
		userAccessLogMapper.insert(log);
	}

}
