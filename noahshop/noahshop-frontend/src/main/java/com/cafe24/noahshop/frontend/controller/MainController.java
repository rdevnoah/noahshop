package com.cafe24.noahshop.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping( {"/", "/main"} )
	public String main() {
		return "main/index";
	}
}
