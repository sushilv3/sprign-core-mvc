package com.spring.guru.services;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldServiceImpl implements HelloWorldService{

	@Override
	public String getGreeting() {
		
		return "hello world";
	}

	
}
