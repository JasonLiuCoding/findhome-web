package com.liu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liu.dao.RedisDataSource;
import com.liu.util.RedisTemplate;

@Service
public class RedisService {

	private volatile RedisTemplate redisTemplate;
	@Autowired
	RedisDataSource redisDataSource;
	
	public RedisTemplate getRedisTemplate(){
		if(redisTemplate == null){
			redisTemplate = new RedisTemplate(redisDataSource);
		}
		return redisTemplate;
	}
	
}
