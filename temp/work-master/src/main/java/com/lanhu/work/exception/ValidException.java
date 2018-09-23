package com.lanhu.work.exception;

import org.springframework.validation.BindingResult;

/**
 * 
 * @author liuyi
 *
 */
public class ValidException extends RuntimeException {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private BindingResult bindingResult;
	
	public ValidException(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}

	public BindingResult getBindingResult() {
		return bindingResult;
	}

	public void setBindingResult(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}
	
	

}
