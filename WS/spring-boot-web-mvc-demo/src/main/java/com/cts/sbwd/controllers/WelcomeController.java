package com.cts.sbwd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@GetMapping({"","/","/home"})
	public String homeAction() {
		return "index";
	}
	
	@PostMapping({"","/","/home"})
	public ModelAndView greetAction(@RequestParam("unm") String userName) {
		return new ModelAndView("index", "greeting", "Hello " + userName);
	}
	
}
