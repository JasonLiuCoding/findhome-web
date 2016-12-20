package com.liu.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Repository("redisDataSource")
public class RedisDataSource {

	private static final Logger log = LoggerFactory.getLogger(RedisDataSource.class);
	@Autowired
	public ShardedJedisPool shardedJedisPool;
	
	public ShardedJedis getRedisClient(){
		ShardedJedis resource = null;
		try {
			resource = this.shardedJedisPool.getResource();
		} catch (Exception e) {
			log.error("Redis getRedisClient error!", e);
		}
		return resource;
	}
	
	public void returnResource(ShardedJedis shardedJedis){
		shardedJedisPool.returnResource(shardedJedis);
	}
	
	public void returnResource(ShardedJedis shardedJedis, boolean broken) {  
        if (broken) {  
               shardedJedisPool.returnBrokenResource(shardedJedis);  
           } else {  
               shardedJedisPool.returnResourceObject(shardedJedis);  
           }  
       } 
	
}
