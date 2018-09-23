package com.lanhu.work.enums;

public enum UploadFileType {
	
	FAVICON("favicon", "用户头像"), 
	FEEDBACK("feedback", "用户反馈"),
	COMMENT("comment", "用户评论"),
	;
	private String fileType;

	private String msg;
	
	UploadFileType(String fileType, String msg) {
		this.fileType = fileType;
		this.msg = msg;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
	
}
