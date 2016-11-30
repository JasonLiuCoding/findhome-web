package com.liu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.liu.exception.SystemException;
import com.liu.model.User;
import com.liu.service.UserService;
@Controller
@RequestMapping("/user")
public class UserManageController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/addUser")
	public String addUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute User u, @CookieValue(value="JSESSIONID", defaultValue="liugangxin") String sessionId){
		userService.addUser(u.getName(), u.qq, u.phone);
		if(u!=null){
			throw new SystemException(500, "名字不能为空");
		}
		return "success";
	}
	
	
}
