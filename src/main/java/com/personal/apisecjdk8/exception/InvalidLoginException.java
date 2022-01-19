package com.personal.apisecjdk8.exception;

public class InvalidLoginException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4368422824108512426L;

	private String msg;
	
	public InvalidLoginException() {
		super();
	}

	public InvalidLoginException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
