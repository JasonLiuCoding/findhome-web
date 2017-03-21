package com.liu.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liu.dao.LoginDao;
import com.liu.dao.UserInfoDao;
import com.liu.model.AutoNumberType;
import com.liu.model.User;
import com.liu.model.UserInfo;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	UserInfoDao userMapping;// 数据库调用方式1

	@Resource
	DataSource dataSource;// 数据库调用方式2

	@Resource
	LoginDao loginDao;

	@Resource
	SqlSessionFactory sqlSessionFactory;// 数据库调用方式2

	@Autowired
	AutoNumberService autoNumberService;

	private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Cacheable(value="userCache",condition="#name.length() <= 15")
	@Override
	public UserInfo findUser(String name) {
		UserInfo findUser = userMapping.findUser(name);
		// UserInfo findUser = findUser2(name);
		return findUser;
	}

	// 其他调用方式
	private UserInfo findUser2(String name) {
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		UserInfo user = jdbcTemplateObject.queryForObject("select userId,name,age,phone,qq from userInfo where name=?",
				new Object[] { name }, new RowMapper<UserInfo>() {
					@Override
					public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
						return new UserInfo(rs.getInt("userId"), rs.getString("name"), rs.getInt("age"), rs
								.getString("phone"), rs.getString("qq"));
					}
				});
		return user;
	}

	public void getAllUser() {
		List<UserInfo> allUser = userMapping.getAllUser();
		System.out.println(allUser.size());
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.selectOne("org.mybatis.example.BlogMapper.selectBlog", 101);
		} finally {
			session.close();
		}
	}

	@Transactional
	@Override
	public int addUser(String name, int age, String qq, String phone) {
		int nextId = autoNumberService.getNextNumber(AutoNumberType.User);
		userMapping.insert(new UserInfo(nextId, name, age, phone, qq));
		loginDao.insert(new User(nextId, name, "password"));// 先初始化一个
		return 0;
	}

	@CacheEvict(value="userCache",key="#name")
	@Override
	public int updateUser(int userId, String name, int age, String qq, String phone) {
		//userMapping.update(new UserInfo(userId, name, age, phone, qq));
		return 0;
	}
	
	//@CachePut(value="userCache",key="#userI.getName()")//更新缓存，即保存方法正常执行
	@CacheEvict(value="userCache",key="#userI.getName()")
	public int updateUser(UserInfo userI) {
		//userMapping.update(userI);//xml没有配置，这里只是测试缓存用
		return 0;
	}

	@Override
	public int delete(int id) {
		return userMapping.delete(id);
	}

}
