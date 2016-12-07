package com.liu.dao;

import java.util.List;
import java.util.Map;

import com.liu.model.User;
import com.liu.model.UserInfo;

public interface LoginDao {

	public User login(String userName, String password);
	public int insert(User u);
}
