package com.lanhu.work.vo;

import javax.validation.constraints.NotBlank;

public class FileUploadVo {
	
	
	@NotBlank(message = "000001,fileType为空")
	private String fileType;

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	
	

}
