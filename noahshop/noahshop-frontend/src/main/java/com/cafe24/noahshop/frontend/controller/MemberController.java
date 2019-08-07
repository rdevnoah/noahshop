package com.cafe24.noahshop.frontend.controller;

import com.cafe24.noahshop.frontend.dto.JSONResult;
import com.cafe24.noahshop.frontend.service.MemberService;
import com.cafe24.noahshop.frontend.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping( "/user"  )
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping( "/loginform" )
	public String loginform() {

		return "user/login";
	}

	@PostMapping("/login")
	public String login(MemberVo vo, HttpServletRequest request, Model model){

		JSONResult<Map<String, Object>> result = memberService.login(vo);

		if ("fail".equals(result.getResult())){
			model.addAttribute("message", result.getMessage());
			return "/error/login_fail";
		}

		if ("success".equals(result.getResult())){
			HttpSession session = request.getSession(true);
			session.setAttribute("authVo", result.getData().get("authVo"));
		}

		return "redirect:/";
	}

	@GetMapping("/joinform")
	public String joinform(){
		return "user/joinform";
	}

	@ResponseBody
	@GetMapping("/checkId")
	public JSONResult checkId(@RequestParam(value="id", required = true, defaultValue = "") String id){
		return memberService.checkId(id);
	}

}
