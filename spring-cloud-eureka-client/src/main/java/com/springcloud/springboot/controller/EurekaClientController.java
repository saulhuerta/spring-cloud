package com.springcloud.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping("/restservices")
public class EurekaClientController {
	
	@Autowired
    @Lazy
    private EurekaClient eurekaClient;
	
	@Value("${spring.application.name}")
	private String applicationName;
	
	
	@GetMapping("/greeting")
	public String greeting() {
		return String.format("Hello!", eurekaClient.getApplication(applicationName).getName());
	}

}
