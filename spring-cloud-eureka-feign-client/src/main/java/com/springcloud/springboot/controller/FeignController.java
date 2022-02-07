package com.springcloud.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.springcloud.springboot.wsclient.GreetingClient;

@EnableFeignClients
@Controller
public class FeignController{

    @Autowired
    private GreetingClient greetingClient;

    @RequestMapping("/get-greeting")
    public String greeting(Model model) {
    	  	
    	model.addAttribute("greeting", greetingClient.greeting());

        return "greeting-view";
    }

}
