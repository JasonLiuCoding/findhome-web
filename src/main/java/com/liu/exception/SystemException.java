package com.liu.exception;

public class SystemException extends BaseException{

	public SystemException(int resultCode, String msg) {
		super(resultCode, msg);
	}
	
	public SystemException(int resultCode, Throwable e) {
		super(resultCode, e);
	}

}
