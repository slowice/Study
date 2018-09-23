package com.lanhu.work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanhu.work.mapper.UploadFileConfigMapper;
import com.lanhu.work.pojo.UploadFileConfig;

@Service
public class UploadFileConfigService {
	
	@Autowired
	private UploadFileConfigMapper uploadFileConfigMapper;
	
	
	public  UploadFileConfig findByFileType(String fileType) {
		return uploadFileConfigMapper.findByFileType(fileType);
		
	}

}
