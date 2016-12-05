package com.liu.dao;

import java.util.List;
import java.util.Map;

import com.liu.model.UserInfo;

public interface UserInfoDao {

	public UserInfo login(Map<String, Object> paramsMap);
	public UserInfo findUser(String name);
	public int findNum(String name);
	public List<UserInfo> getAllUser();
	
	public int insert(UserInfo u);
	public int insert2(UserInfo u);
	public int update(UserInfo u);
	public int delete(int userId);
}
