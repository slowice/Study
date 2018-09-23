package com.lanhu.work.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanhu.work.exception.ValidException;
import com.lanhu.work.utils.R;
/**
 * 統一異常處理
 * @author liuyi
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private  final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	private static final String VALID_EXCEPTION_CODE = "100000";

	private static final String EXCEPTION_CODE = "200000";

	@ExceptionHandler(value = ValidException.class)
	@ResponseBody
	public Object validExceptionHandler(ValidException e) {
		FieldError error = null;
		String errorMsg = null;
		String errorCode = null;
		if (e.getBindingResult().hasErrors()) {
			error = e.getBindingResult().getFieldErrors().get(0);
		}
		//解析异常消息数据
		if(error != null) {
			errorMsg = error.getDefaultMessage();
			if(errorMsg != null && errorMsg.contains(",")) {
				errorCode = errorMsg.split(",")[0];
				errorMsg = error.getField()+errorMsg.split(",")[1];
			}
			if(errorCode == null) {
				errorCode = VALID_EXCEPTION_CODE;
			}
			if(errorMsg == null) {
				errorMsg = "valid error";
			}
		}
		logger.error(errorMsg,e);
		
		return R.error(errorCode,errorMsg);
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Object exceptionHandler(Exception e) {
		logger.error("系统异常稍后再试!",e);
		return R.error(EXCEPTION_CODE, "系统异常稍后再试!");
	}

}
