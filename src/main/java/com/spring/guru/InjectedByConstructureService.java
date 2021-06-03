package com.spring.guru;

import org.springframework.stereotype.Component;

@Component
public class InjectedByConstructureService {

	private HelloWorldService helloWorldService;

	public InjectedByConstructureService(HelloWorldService helloWorldService) {

		this.helloWorldService = helloWorldService;
	}

	public void getMessage() {
		helloWorldService.sayHello();

	}

}
