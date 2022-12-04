package com.mycom.myhouse.exception;

public class LoginException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public LoginException(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
	
}
