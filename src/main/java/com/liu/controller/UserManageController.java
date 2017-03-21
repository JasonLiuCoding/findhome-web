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
import com.liu.model.UserInfo;
import com.liu.service.UserService;

@Controller
@RequestMapping("/user")
public class UserManageController {

	@Autowired
	UserService userService;

	@RequestMapping("/addUser")
	public String addUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute UserInfo u,
			@CookieValue(value = "JSESSIONID", defaultValue = "liugangxin") String sessionId) {
		if (u != null) {
			System.out.println(u.getCreateTime());
		}
		UserInfo findUser = userService.findUser(u.getName());
		if (findUser != null) {
			throw new SystemException(-500, "用户已存在");
		}
		userService.addUser(u.getName(), u.getAge(), u.getQq(), u.getPhone());
		return "success";
	}

	@RequestMapping("/findUser")
	public String findUser(String name) {
		UserInfo findUser = userService.findUser(name);
		if (findUser != null) {
			//userService.updateUser(findUser);
			userService.updateUser(findUser.getUserId(), findUser.getName(), findUser.getAge(), findUser.getQq(), findUser.getPhone());
			System.out.println(findUser.getName());
		}
		return "success";
	}

}
