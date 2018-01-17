package com.hivison.study.java.spring.controller.test;

import javax.jws.WebParam.Mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hivison.study.java.spring.domain.Address;

@Controller
public class ModelAttribureDemoController {

	private static Logger LOGGER = LoggerFactory.getLogger(ModelAttribureDemoController.class);

	@RequestMapping(value = "/home")
	public String home() {
		LOGGER.info("INSIDE home: " + System.currentTimeMillis());
		return "modelAttributeHome";
	}

	// Version 2 of our home() method
	@RequestMapping(value = "/home2")
	public ModelAndView home2() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("modelAttributeHome");
		mav.addObject("command", new Address());

		return mav;
	}

	// Version 3 of our home() method
	@RequestMapping(value = "/home3")
	public ModelAndView home3() {
		ModelAndView mav = new ModelAndView("modelAttributeHome");
		mav.addObject("anAddress", new Address());

		return mav;
	}

	// Version 4 of our home() method
	@RequestMapping(value = "/home4")
	public ModelAndView home4() {
		return new ModelAndView("modelAttributeHome", "anAddress", new Address("Melborne", "3000"));
	}

	// Version 5 of our home() method
	@RequestMapping(value = "/home5")
	public String home5(Model model) {
		model.addAttribute("anAddress", new Address("Brisbane", "4000"));
		return "modelAttributeHome";
	}

	/*
	 * Test series to determine nature off the @ModelAttribute annotation (on a
	 * method)
	 */

	// Test1: demonstrating the usage of @ModelAttribute annotation (on a method)
	// to add multiples attributes
	@ModelAttribute
	public void modelAttributeTest1(Model model) {
		LOGGER.info("INSIDE modelAttributeTest1: " + System.currentTimeMillis());
		model.addAttribute("testdata1A", "Welcome to the @ModelAttribute Test bed !");
		model.addAttribute("testdata1B", "We will usages of the @ModelAttribute, on methods and arguments");

	}

	// Test 2: Demostraiting the usage of the 'name' attribute of the
	// @ModelAttribute annotation (on method)
	@ModelAttribute(name = "testdata2")
	public String modelAttributeTest2() {
		LOGGER.info("INSIDE modelAttributeTest2");
		return "We will conduct a series of tests here.";
	}

	// Test3: Demonstrating the usage of the @ModelAttribute annotation (on a
	// method) to implicitly add an attribute
	// by returning it and also demonstrating the usage of the 'value' attribute of
	// the @ModelAttribute annotation (on a method)
	@ModelAttribute(value = "testdata3")
	public Address modelAttributeTest3() {
		LOGGER.info("INSIDE modelAttributeTest3");
		return new Address("Adelaide", "5000");
	}

	// Test4: Demonstrating the default naming strategy of the @NodelAttribute
	// annotation (on a method)
	@ModelAttribute
	public Address modelAttributeTest4() {
		LOGGER.info("INSIDE modelAttributeTest4");
		return new Address("Sydney", "200");
	}
	//Test 5: Testing the @ModelAttribute with 'value' attribute and default binding
	@RequestMapping(value = "/test5", method = RequestMethod.POST)
	public String modelAttributeTest5(@ModelAttribute(value = "anAddress") Address anAddress, ModelMap model){
		model.addAttribute("testdata5A", anAddress.getCity());
		model.addAttribute("testdata5B", anAddress.getZipCode());
		return "modelAttributeTest";
	}
}