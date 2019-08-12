package com.cafe24.noahshop.frontend.controller;

import com.cafe24.noahshop.frontend.security.SecurityUser;
import com.cafe24.noahshop.frontend.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class MainController {

	@Autowired
	private MainService mainService;

	@RequestMapping( {"/", "/main"} )
	public String main(Model model) {

		Map<String, Object> mainData = mainService.getMain();
		
		model.addAttribute("main", mainData);

		return "main/index";
	}
}
