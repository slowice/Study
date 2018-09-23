package com.lanhu.work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanhu.work.mapper.BusDocumentTemplateMapper;

@Service
public class BusDocumentTemplateService {
	
	@Autowired
	private BusDocumentTemplateMapper busDocumentTemplateMapper;

}
