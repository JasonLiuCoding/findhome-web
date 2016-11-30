package com.liu.service;

import org.springframework.stereotype.Service;

@Service
public class LogicServiceImpl implements LogicService{

	@Override
	public boolean login(String name){
		System.out.println(name);
		return true;
	}

}
