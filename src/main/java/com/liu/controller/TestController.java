package com.liu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liu.model.AutoNumberType;
import com.liu.model.User;
import com.liu.service.AutoNumberService;
import com.liu.service.LogicService;
import com.liu.service.UserService;

@Controller
@RequestMapping("/mvc")
public class TestController {
	
	@Autowired
	private LogicService logicService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	AutoNumberService autoNumberService;
	
	@RequestMapping("/hello")
	public String hello(HttpServletRequest request){      
		
		System.out.println(autoNumberService.getNextNumber(AutoNumberType.User));
		System.out.println(autoNumberService.getNextNumber(AutoNumberType.User));
		System.out.println(autoNumberService.getNextNumber(AutoNumberType.User));
		System.out.println(autoNumberService.getNextNumber(AutoNumberType.User));
		System.out.println(autoNumberService.getNextNumber(AutoNumberType.User));
		System.out.println(autoNumberService.getNextNumber(AutoNumberType.User));
		System.out.println(autoNumberService.getNextNumber(AutoNumberType.User));
		
		
		
		boolean login = logicService.login("liugangxin");
		User findUser = userService.findUser("liu");
		System.out.println(login);
		request.setAttribute("name", findUser.phone);
        return "hello";
    }
	
	@RequestMapping("/add")
	public String addUser(HttpServletRequest request){      
		userService.addUser("½¿½¿", "qq10", "phone10");
        return "hello";
    }
	
}
