package com.cafe24.noahshop.controller.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.noahshop.dto.JSONResult;
import com.cafe24.noahshop.service.MemberService;
import com.cafe24.noahshop.vo.MemberVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.spring.web.json.Json;

/**
 * 
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.controller.api
 * @filename : MemberController.java
 * @author : rdevnoah
 * @since : Jul 12, 2019
 * @version : 1.0
 * @see 
 * 
 * <pre>
 * == Modification Information ==
 * 
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * Jul 11, 2019     rdevnoah         Initialize
 * </pre>
 */
@RestController("userAPIController")
@RequestMapping("/api/user")
public class MemberController {

	//@Autowired
	private MemberService memberService;
	
	@ApiOperation(value="check id", notes = "아이디 중복여부 확인")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id", value="아이디", required=true, dataType="string", defaultValue="")
	})
	@RequestMapping(value = "/checkId/{id}", method = RequestMethod.GET)
	public JSONResult checkId(@PathVariable(value = "id") String id) {
		
		// checkId Service
		//Boolean isExist = memberService.checkId(id);
		
		return JSONResult.success("return:checkId");
	}
	
	@ApiOperation(value="get join form", notes = "회원가입 form 가져오기")
	@RequestMapping(value="/joinForm", method = RequestMethod.GET)
	public JSONResult joinForm() {
		
		return JSONResult.success("form");
	}
	
	
	@ApiOperation(value="get join success form", notes = "회원가입성 form 가져오기")
	@RequestMapping(value="/joinsuccess", method = RequestMethod.GET)
	public JSONResult joinsuccess() {
		
		return JSONResult.success("redirect:joinsuccess");
	}

	@ApiOperation(value="join", notes = "회원가입 처리")
	@ApiImplicitParams({
		@ApiImplicitParam(name="vo", value="회원정보", required=true, dataType="MemberVo", defaultValue="")
	})
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public JSONResult join(@RequestBody @Valid MemberVo vo, BindingResult result) {
		if (result.hasErrors()) {
			// 에러 메세지 확인
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				System.out.println("Validation Error : " + error);
			}
			return JSONResult.fail("invalid Data");
		}
		
		// add service
		//MemberVo authVo = memberService.join(vo);
		
		return JSONResult.success("return:join");
	}
}
