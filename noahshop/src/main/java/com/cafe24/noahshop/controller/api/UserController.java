package com.cafe24.noahshop.controller.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.noahshop.dto.JSONResult;
import com.cafe24.noahshop.vo.MemberVo;

@RestController("userAPIController")
@RequestMapping("/api/user")
public class UserController {

	@RequestMapping(value = "/checkId/{id}", method = RequestMethod.GET)
	public JSONResult checkId(@PathVariable(value = "id") String id) {
		Boolean exist = true;

		// checkId Service

		return JSONResult.success(exist);
	}

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
		return JSONResult.success(vo);
	}
}
