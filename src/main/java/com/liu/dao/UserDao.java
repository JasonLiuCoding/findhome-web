package com.liu.dao;

import java.util.List;
import java.util.Map;

import com.liu.model.User;

public interface UserDao {

	public User findUser(String name);
	public int findNum(String name);
	public int findNum2(Map<String, Object> paramsMap);
	public List<User> getAllUser();
	
	public int insert(User u);
	public int insert2(User u);
	public int update(User u);
	public int delete(int userId);
}
