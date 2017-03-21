package com.liu.controller;

import javax.jms.Destination;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.liu.model.User;
import com.liu.mq.MQSender;
import com.liu.service.LogicService;
import com.liu.service.RedisService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LogicService logicService;

	@Autowired
	private RedisService redisService;

	@RequestMapping("/index")
	public String index(HttpServletRequest req) {
		String sessionId = req.getSession().getId();
		User loginUser = (User) req.getSession().getAttribute("user");
		if(loginUser!=null){
			String name = loginUser.getUserName();
		}
		return "login";
	}

	@RequestMapping("/login")
	public String login(@RequestParam String userName, @RequestParam String password, HttpServletRequest req,
			ModelMap model, @CookieValue(value = "JSESSIONID", defaultValue = "liugangxin") String sessionId) {
		if (isEmpty(userName) || isEmpty(password)) {
			combineModelMap(model, userName, password);
			return "login";
		}

		User loginUser = logicService.login(userName, password);
		if (loginUser == null) {
			combineModelMap(model, userName, password);
			//return "login";
			throw new RuntimeException();
		}

		req.getSession().setAttribute("user", loginUser);
		//mqSender.sendMessage(String.format("%s登录了~", userName));
		return "success";
	}

	private void combineModelMap(ModelMap model, String userName, String password) {
		model.put("userName", userName == null ? "" : userName);
		model.put("password", password == null ? "" : password);
	}

	private boolean isEmpty(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		return false;
	}
}
