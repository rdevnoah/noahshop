package com.cafe24.noahshop.frontend.controller;

import com.cafe24.noahshop.frontend.dto.JSONResult;
import com.cafe24.noahshop.frontend.service.MemberService;
import com.cafe24.noahshop.frontend.vo.MemberVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.internal.org.objectweb.asm.TypeReference;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
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
			return "error/login_fail";
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
	@GetMapping("/checkId/{id}")
	public JSONResult checkId(@PathVariable String id){
		return memberService.checkId(id);
	}

	@PostMapping("/join")
	public String join(MemberVo vo, Model model) throws IOException {
		JSONResult<MemberVo> result = memberService.join(vo);
		if ("fail".equals(result.getResult())){
			String jsonStr = result.getMessage();
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> map = new HashMap<>();
			map = mapper.readValue(jsonStr, Map.class);
			model.addAttribute("message", map);
			return "error/join_fail";
		}

		return "redirect:/user/joinsuccess";
	}

	@RequestMapping("/joinsuccess")
	public String joinSuccess(){
		return "user/joinsuccess";
	}

}
