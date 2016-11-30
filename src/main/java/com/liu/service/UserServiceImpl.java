package com.liu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liu.dao.UserDao;
import com.liu.model.AutoNumberType;
import com.liu.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	UserDao userMapping;//数据库调用方式1
	
	@Resource
	DataSource dataSource;//数据库调用方式2
	
	@Resource
	SqlSessionFactory sqlSessionFactory;//数据库调用方式2
	
	@Autowired
	AutoNumberService autoNumberService;
	
	private Logger log = LoggerFactory.getLogger(UserServiceImpl.class); 
	@Override
	public User findUser(String name) {
		
		
		if(userMapping.findNum(name)>0){
			log.error("hahhahahhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"+userMapping.findNum(name));
		}
		User findUser = userMapping.findUser("aa");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("name", "aa");
		int num = userMapping.findNum2(paramsMap);
		System.out.println(num);
		
		//插入
		User u = new User(3,"cc","qq3","phone3");
		//userMapping.insert(u);
		
		
		u = new User(4,"dd","qq4","phone4");
		//userMapping.insert2(u);
		
		u.name = "newName4";
		u.qq = "newQQ4";
		userMapping.update(u);
		userMapping.delete(3);
		return findUser;
	}
	
	public void getAllUser(){
		List<User> allUser = userMapping.getAllUser();
		System.out.println(allUser.size());
		SqlSession session = sqlSessionFactory.openSession();
		try {
		 session.selectOne("org.mybatis.example.BlogMapper.selectBlog", 101);
		} finally {
		  session.close();
		}
	}
	
	//其他调用方式
	public void findUser(){
		JdbcTemplate jdbcTemplateObject =  new JdbcTemplate(dataSource);
		Integer queryForObject = jdbcTemplateObject.queryForObject("select userId from user where name='aa'",Integer.class);
		System.out.println(queryForObject);
	}

	@Transactional
	@Override
	public int addUser(String name, String qq, String phone) {
		int nextId = autoNumberService.getNextNumber(AutoNumberType.User);
		userMapping.insert(new User(nextId, name, phone, qq));
		return 0;
	}

	@Override
	public int updateUser(int id, String name, String qq, String phone) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
