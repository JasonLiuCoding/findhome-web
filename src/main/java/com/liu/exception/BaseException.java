package com.liu.exception;

public class BaseException extends RuntimeException {
	private static final long serialVersionUID = 6726968191605259087L;
	private int resultCode;
	private String msg;

	public BaseException(int resultCode, String msg) {
		super(msg);
		this.resultCode = resultCode;
		this.msg = msg;
	}

	public BaseException(int resultCode, Throwable e) {
		super(e);
		this.resultCode = resultCode;
		this.msg = e.getMessage();
	}

	public int getCode() {
		return resultCode;
	}

	public void setCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
