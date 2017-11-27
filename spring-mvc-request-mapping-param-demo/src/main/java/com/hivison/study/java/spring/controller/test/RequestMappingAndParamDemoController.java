package com.hivison.study.java.spring.controller.test;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/requestMappingAndParamDemo")
@Controller
public class RequestMappingAndParamDemoController {

	private static Logger LOGGER = LoggerFactory.getLogger(RequestMappingAndParamDemoController.class);

	@RequestMapping(value = "/home")
	public String home() {
		return "requestMappingAndParamHome";
	}

	// Test1: Testing @RequestParam without explicit attributes
	@RequestMapping(value = "/test1")
	public String requestMappingAndParamTest1(@RequestParam("orgname") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test1");

		return "requestMappingAndParamResults";

	}

	// Test2 testing @RequestMapping 'method' attribute
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String requestMappingAndParamTest2(@RequestParam("orgname") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test2");
		return "requestMappingAndParamResults";

	}

	// Test3 testing @RequestMapping fall back feature
	@RequestMapping(value = "*", method = RequestMethod.GET)
	// @RequestMapping(value = "*", method = {RequestMethod.GET,
	// RequestMethod.POST})
	public String requestMappingAndParamTest3() {

		return "fallback";

	}

	// Test4 testing @RequestParam 'defaultValue' attribute
	@RequestMapping(value = "/test4")
	public String requestMappingAndParamTest4(
			@RequestParam(value = "orgname", defaultValue = "Anonymous Organization") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test4");
		return "requestMappingAndParamResults";

	}

	// Test 5 testing @RequestParam without 'name or 'value' attributes
	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public String requestMappingAndParamTest5(@RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test5");
		return "requestMappingAndParamResults";

	}

	// Test 6 - subtest1 testing removal @RequestMapping ambiguity with the same base URI but with different a different parameter
	@RequestMapping(value = "/test6", params="orgname")
	public String requestMappingAndParamTest6Subtest1(@RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test6-subtest1");
		return "requestMappingAndParamResults2";

	}

	// Test 6 - subtest2 testing removal @RequestMapping ambiguity with the same base URI but with different a different parameter
	@RequestMapping(value = "/test6", params="empcount")
	public String requestMappingAndParamTest6Subtest2(@RequestParam String empcount, Model model) {
		model.addAttribute("orgname", empcount);
		model.addAttribute("testserial", "test6-subtest2");
		return "requestMappingAndParamResults2";

	}
	

	// Test 6 - subtest3 testing removal @RequestMapping multiple request params
	@RequestMapping(value = "/test6/subtest3",method= RequestMethod.GET, params= {"empcount", "orgname"})
	public String requestMappingAndParamTest6Subtest3(@RequestParam String empcount, @RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("empcount", empcount);
		model.addAttribute("testserial", "test6-subtest3");
		return "requestMappingAndParamResults2";

	}
	

	// Test 6 - subtest3 testing with multiples request params and @RequestMapping single param
	@RequestMapping(value = "/test6/subtest4",method= RequestMethod.GET, params= {"empcount", "orgname"})
	public String requestMappingAndParamTest6Subtest4(@RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test6-subtest4");
		return "requestMappingAndParamResults2";

	}
	
	// Test 7 & 8 testing @RequestParam with multiples request URI's
		@RequestMapping(value = {"/test7","test8"},method= RequestMethod.GET)
		public String requestMappingAndParamTest7And8(@RequestParam String orgname, Model model, HttpServletRequest request) {
			model.addAttribute("orgname", orgname);
			LOGGER.info(request.getRequestURL().toString());
			if(request.getRequestURL().toString().contains("test7"))
				model.addAttribute("testserial", "test7");
			else
				model.addAttribute("testserial", "test8");
			
			return "requestMappingAndParamResults2";

		}

}
