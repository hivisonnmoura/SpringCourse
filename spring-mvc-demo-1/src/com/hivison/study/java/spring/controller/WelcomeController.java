package com.hivison.study.java.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hivison.study.java.spring.service.GenericWelcomeService;

@Controller
public class WelcomeController {
	
	@Autowired
	private GenericWelcomeService welcomeService;
	
	@RequestMapping("/")
	public String doWelcome(Model model) {
		
		// Retrieving the processed data
		List<String> welcomeMessage = welcomeService.getWelcomeMessage("Hivison N Moura");
		
		// Add data to the model
		model.addAttribute("myWelcomeMessage", welcomeMessage);
		
		// Return logical view name
		return "welcomeNew";
	}

}
