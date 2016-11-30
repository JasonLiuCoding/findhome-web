package com.liu.dao;

import java.util.Map;

import com.liu.model.AutoNumberItem;

public interface AutoNumberDao {

	public AutoNumberItem select(String autoNumberType);
	public int update(Map<String,Object> params);
	public int insert(AutoNumberItem item);
	
}
