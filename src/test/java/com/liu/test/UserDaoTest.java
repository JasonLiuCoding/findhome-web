package com.liu.test;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import com.liu.dao.UserInfoDao;
import com.liu.model.UserInfo;

public class UserDaoTest {

	@Test
	public void findUser(){
		SqlSession sqlSession = getSessionFactory().openSession();  
		UserInfoDao userMapper = sqlSession.getMapper(UserInfoDao.class);  
		UserInfo user = userMapper.findUser("liu");
		Assert.assertNotNull("û�ҵ����", user);
	}
	
	//Mybatis ͨ��SqlSessionFactory��ȡSqlSession, Ȼ�����ͨ��SqlSession����ݿ���н���
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
		UserInfoDao userMapper = sqlSession.getMapper(UserInfoDao.class);  
		UserInfo user = userMapper.findUser("liu");
		Assert.assertNotNull("û�ҵ����", user);
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
