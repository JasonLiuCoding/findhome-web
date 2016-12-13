package com.liu.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

public class MyRequestSessionWrapper extends HttpServletRequestWrapper {

	public MyRequestSessionWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public HttpSession getSession() {
		//在分布式集群项目中，从redis中获取共享的session
		System.out.println("重写了sesson获取方式，从redis获取session~~~");
		return super.getSession();
	}
	
}
