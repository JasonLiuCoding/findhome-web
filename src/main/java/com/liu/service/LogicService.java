package com.liu.service;

import com.liu.model.User;

public interface LogicService {
	public User login(String name, String password);
	public int insert(User u);
}
