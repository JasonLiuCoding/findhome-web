package com.liu.service;

import com.liu.model.UserInfo;

public interface UserService {

	public UserInfo findUser(String name);
	
	public int addUser(String name, int age, String qq, String phone);
	
	public int updateUser(int id, String name, int age, String qq, String phone);
	
	public int delete(int id);
}
