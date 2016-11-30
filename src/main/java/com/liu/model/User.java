package com.liu.model;

public class User {

	public int userId;
	public String name;
	public String phone;
	public String qq;

	
	public User() {
	}

	public User(int userId, String name, String phone, String qq) {
		this.userId = userId;
		this.name = name;
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


}
