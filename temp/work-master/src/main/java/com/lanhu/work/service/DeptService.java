package com.lanhu.work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanhu.work.mapper.DeptMapper;

@Service
public class DeptService {
	
	@Autowired
	private DeptMapper deptMapper;

}
