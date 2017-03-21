package com.liu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liu.dao.LoginDao;
import com.liu.model.User;

@Service
public class LogicServiceImpl implements LogicService {

	@Autowired
	private LoginDao dao;
	
	@Autowired
	RedisService redisService;
	

	@Override
	public User login(String userName, String password) {
		//User u = dao.login(userName, password);
		User u = dao.login2(userName, password);
		return u;
	}

	@Override
	public int insert(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

}
