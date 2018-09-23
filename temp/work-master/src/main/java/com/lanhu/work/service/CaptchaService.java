package com.lanhu.work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanhu.work.mapper.CaptchaMapper;

@Service
public class CaptchaService {
	
	@Autowired
	private CaptchaMapper captchaMapper;

}
