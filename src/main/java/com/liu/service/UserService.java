package com.liu.service;

import com.liu.model.User;

public interface UserService {

	public User findUser(String name);
	
	public int addUser(String name,String qq, String phone);
	
	public int updateUser(int id, String name,String qq, String phone);
	
	public int delete(int id);
}
