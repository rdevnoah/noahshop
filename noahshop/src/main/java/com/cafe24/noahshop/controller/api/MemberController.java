package com.cafe24.noahshop.controller.api;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.noahshop.dto.JSONResult;
import com.cafe24.noahshop.service.MemberService;
import com.cafe24.noahshop.vo.MemberVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.controller.api
 * @filename : MemberController.java
 * @author : rdevnoah
 * @since : Jul 11, 2019
 * @version : 1.0
 * @see
 * 
 *      <pre>
 * == Modification Information ==
 * 
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * Jul 11, 2019     rdevnoah         Initialize
 * Jul 12, 2019     rdevnoah         test modify, login, logout
 *      </pre>
 */
@RestController("userAPIController")
@RequestMapping("/api/user")
public class MemberController {

	@Autowired
	private MessageSource messageSource;
	
	// @Autowired
	private MemberService memberService;

	@ApiOperation(value = "check id", notes = "아이디 중복여부 확인")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "아이디", required = true, dataType = "string", defaultValue = "") })
	@GetMapping("/checkId/{id}")
	public JSONResult checkId(@PathVariable(value = "id") String id) {

		// checkId Service
		// Boolean isExist = memberService.checkId(id);

		return JSONResult.success("return:checkId");
	}

	@ApiOperation(value = "get join form", notes = "회원가입 form 가져오기")
	@GetMapping("/joinform")
	public JSONResult joinForm() {

		return JSONResult.success("form");
	}

	@ApiOperation(value = "get join success form", notes = "회원가입성 form 가져오기")
	@GetMapping("/joinsuccess")
	public JSONResult joinsuccess() {

		return JSONResult.success("redirect:joinsuccess");
	}

	@ApiOperation(value = "join", notes = "회원가입 처리")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "vo", value = "회원정보", required = true, dataType = "MemberVo", defaultValue = "") })
	@PutMapping
	public ResponseEntity<JSONResult> join(@RequestBody @Valid MemberVo vo, BindingResult result) {
		if (result.hasErrors()) {
			// 에러 메세지 확인
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				System.out.println("Validation Error : " + error);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("invalid Data"));
			}
		}

		// add service (add member + add salt + add key)
		// MemberVo authVo = memberService.join(vo);

		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("return:join"));
	}

	@ApiOperation(value = "get modify form", notes = "회원정보수정 폼 가져오기")
	@GetMapping("/modifyform")
	public JSONResult modifyForm(HttpServletRequest request) {

		// 세션에 저장된 인증 사용자의 정보 DB에서 가져오기
		return JSONResult.success("return:modifyForm");
	}

	@ApiOperation(value = "modify member info", notes = "회원정보 수정")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "vo", value = "수정할 회원정보", required = true, dataType = "MemberVo", defaultValue = "") })
	@PostMapping
	public ResponseEntity<JSONResult> modify(@RequestBody @Valid MemberVo vo, BindingResult result) {
		if (result.hasErrors()) {
			// 에러 메세지 확인
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				System.out.println("Validation Error : " + error);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("invalid data"));
			}
		}

		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}

	@ApiOperation(value = "get login form", notes = "로그인 폼 가져오기")
	@GetMapping("/loginform")
	public JSONResult loginform() {

		return JSONResult.success("return:loginform");
	}

	@ApiOperation(value = "login", notes = "로그인 처리하기")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "아이디", required = true, dataType = "string", defaultValue = ""),
			@ApiImplicitParam(name = "password", value = "패스워드", required = true, dataType = "string", defaultValue = "") })
	@PostMapping("/login")
	public ResponseEntity<JSONResult> login(@RequestBody MemberVo vo, HttpServletRequest request) {
		
		
		// validation
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<MemberVo>> validatorResults = validator.validateProperty(vo, "id");
		
		if(validatorResults.isEmpty() == false) {
			for(ConstraintViolation<MemberVo> validatorResult : validatorResults) {
				String message = validatorResult.getMessage();
				//String message = messageSource.getMessage("", null, LocaleContextHolder.getLocale());
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(message)); 
			}
		}

		// login service logic

		//MemberVo authUser = new MemberVo();
		
		return ResponseEntity.ok().body(JSONResult.success(vo));
	}
	
	@ApiOperation(value = "logout", notes = "로그아웃 처리하기")
	@GetMapping("/logout")
	public JSONResult logout(HttpServletRequest request) {
		
		//session invalidate
		
		return JSONResult.success("return:do logout and go main page");
	}
}
