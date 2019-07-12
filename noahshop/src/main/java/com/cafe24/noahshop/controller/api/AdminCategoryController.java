package com.cafe24.noahshop.controller.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.noahshop.dto.JSONResult;
import com.cafe24.noahshop.vo.CategoryVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.controller.api
 * @filename : AdminCategoryController.java
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
 * Jul 12, 2019     rdevnoah         Initialize
 * Jul 12, 2019     rdevnoah         test add, modify, delete
 * </pre>
 */
@RestController("adminCategoryAPIController")
@RequestMapping("/api/admin/category")
public class AdminCategoryController {
	
	
	@ApiOperation(value="get add Category Form", notes = "카테고리 등록 폼 가져오기")
	@GetMapping("/addform")
	public JSONResult addForm() {
		return JSONResult.success("result:addform");
	}
	
	@ApiOperation(value = "add category", notes = "카테고리 등록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="vo", value="카테고리", required=true, dataType="CategoryVo", defaultValue="")
	})
	@PutMapping
	public JSONResult add(@RequestBody @Valid CategoryVo vo, BindingResult result) {
		
		if (result.hasErrors()) {
			// 에러 메세지 확인
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				System.out.println("Validation Error : " + error);
			}
			return JSONResult.fail("invalid Data");
		}
		return JSONResult.success(vo);
	}
	
	@ApiOperation(value = "modify category", notes = "카테고리 정보 변경")
	@ApiImplicitParams({
		@ApiImplicitParam(name="vo", value="변경할 카테고리 정보", required=true, dataType="CategoryVo", defaultValue="")
	})
	@PostMapping
	public JSONResult modify(@RequestBody CategoryVo vo) {
		
		// modify
		return JSONResult.success(vo);
	}
	
	@ApiOperation(value = "delete category", notes = "카테고리 삭제")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="삭제할 카테고리 번호", required=true, dataType="long", defaultValue="")
	})
	@DeleteMapping("/{no}")
	public JSONResult delete(@PathVariable(value = "no") Long no) {

		//delete
		
		//카테고리 상품 미지정 카테고리로 이동
		
		return JSONResult.success(no);
	}
	
}