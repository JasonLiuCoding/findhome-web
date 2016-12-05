package com.liu.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UserInfo {

	private int userId;
	private String name;
	private int age;
	private String phone;
	private String qq;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createTime;

	
	public UserInfo() {
	}

	public UserInfo(int userId, String name, int age, String phone, String qq) {
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.qq = qq;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


}
