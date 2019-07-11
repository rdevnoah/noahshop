package com.cafe24.noahshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/",""})
public class MainController {
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String main() {
		return "main/index";
	}
}
