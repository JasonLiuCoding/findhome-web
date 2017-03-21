package com.liu.dao;

import org.apache.ibatis.annotations.Param;

import com.liu.model.User;

public interface LoginDao {

	public User login(String userName, String password);
	public User login2(@Param("name")String userName, @Param("password")String password);
	public int insert(User u);
}
