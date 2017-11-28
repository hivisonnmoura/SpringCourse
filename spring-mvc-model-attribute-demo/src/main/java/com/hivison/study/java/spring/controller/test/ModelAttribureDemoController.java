package com.hivison.study.java.spring.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelAttribureDemoController {

	
	private static Logger LOGGER = LoggerFactory.getLogger(ModelAttribureDemoController.class);
	
	@RequestMapping(value = "/home")
	public String home() {
		LOGGER.info("INSIDE home: " + System.currentTimeMillis());
		return "modelAttributeHome";
	}
	/*
	 * Test series to determine nature off the @ModelAttribute annotation (on a method)
	 */
	
	//Test1: demonstrating the usage of @ModelAttribute annotation (on a method)
	// to add multiples attributes
	@ModelAttribute
	public void modelAttributeTest1(Model model) {
		LOGGER.info("INSIDE modelAttributeTest1: " + System.currentTimeMillis());
		model.addAttribute("testdata1A", "Welcome to the @ModelAttribute Test bed !");
		model.addAttribute("testdata1B", "We will usages of the @ModelAttribute, on methods and arguments");
		
	}
}
