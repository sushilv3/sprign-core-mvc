package com.spring.guru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring.guru.controllers.GreetingController;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
//		HelloWorldImpl hw = (HelloWorldImpl) ctx.getBean(HelloWorldImpl.class);
//		InjectedByConstructureService constructureService = (InjectedByConstructureService)ctx.getBean("injectedByConstructureService");
//		constructureService.getMessage();
//		
//		SetterBasedService setterBasedService = (SetterBasedService)ctx.getBean("setterBasedService");
//		
//		setterBasedService.getmessage();
	
		
//		GreetingController gc = (GreetingController)ctx.getBean("greetingController");
//		
//		gc.sayHello();
		
		
		//show all beans managened by spring 
//		System.out.println("************ Beans *******************");
//		System.out.println(ctx.getBeanDefinitionCount());
//		System.out.println(ctx.getBeanDefinitionNames());
		
//		String[] beanNames = ctx.getBeanDefinitionNames();
//		for(String name: beanNames) {
//			System.out.println(name);
//		}
//		for(String name:ctx.getBeanDefinitionNames()) {
//			System.out.println(name);
//		}
	}

}
