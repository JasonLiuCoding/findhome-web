package com.liu.test;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import com.liu.dao.UserDao;
import com.liu.model.User;

public class UserDaoTest {

	@Test
	public void findUser(){
		SqlSession sqlSession = getSessionFactory().openSession();  
		UserDao userMapper = sqlSession.getMapper(UserDao.class);  
		User user = userMapper.findUser("liu");
		Assert.assertNotNull("没找到数据", user);
	}
	
	//Mybatis 通过SqlSessionFactory获取SqlSession, 然后才能通过SqlSession与数据库进行交互
    private static SqlSessionFactory getSessionFactory() {  
        SqlSessionFactory sessionFactory = null;  
        String resource = "spring-mybatis.xml";  
        try {  
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources  
                    .getResourceAsReader(resource));
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return sessionFactory;  
    } 
    
    @Test
	public void findUser2(){
		SqlSession sqlSession = getSessionFactory2().openSession();  
		UserDao userMapper = sqlSession.getMapper(UserDao.class);  
		User user = userMapper.findUser("liu");
		Assert.assertNotNull("没找到数据", user);
	}
    private static SqlSessionFactory getSessionFactory2() {  
        SqlSessionFactory sessionFactory = null;  
        String resource = "spring-mybatis.xml";  
        try {  
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources  
                    .getResourceAsReader(resource));
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return sessionFactory;  
    } 
}
