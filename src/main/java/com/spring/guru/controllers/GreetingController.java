package com.spring.guru.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.guru.services.HelloWorldService;

@Controller
public class GreetingController {
	
	private HelloWorldService helloWorldService;
	
	@Autowired
	public void setHelloWorldService(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}



	public String sayHello() {
		
		String greeting = helloWorldService.getGreeting();
		System.out.println(greeting);
		return greeting;
		
	}

}
