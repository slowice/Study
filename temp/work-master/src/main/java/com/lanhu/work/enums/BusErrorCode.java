package com.lanhu.work.enums;

public enum BusErrorCode {		
	// 业务错误 由 系统自定义
	UPLOADFILE_CONFIG_ISNULL_ERROR("300000", "文件类型没有配置!"), 
	UPLOAD_FILE_IS_NULL("300001","请选择要上传的文件！"),
	UPLOAD_OVER_LIMIT("300002","上传的文件超过规定文件的大小!"),
	UPLOAD_FILE_SUF_ERROR("300003","上传的文件类型不对!"),
	FILE_UPLOAD_ERROR("300004","文件上传失败"),
	;
	
	private String code;

	private String defaultMessage;

	BusErrorCode(String code, String defaultMessage) {
		this.code = code;
		this.defaultMessage = defaultMessage;
	}

	public String getErrorCode() {
		return this.code;
	}

	public String getDefaultMessage() {
		return defaultMessage;
	}

}
