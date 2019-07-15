package com.cafe24.noahshop.controller.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.noahshop.dto.JSONResult;
import com.cafe24.noahshop.vo.ProductVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.controller.api
 * @filename : AdminProductController.java
 * @author : rdevnoah
 * @since : Jul 11, 2019
 * @version : 1.0
 * @see 
 * 
 * <pre>
 * == Modification Information ==
 * 
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * Jul 12, 2019     rdevnoah         Initialize
 * Jul 12, 2019     rdevnoah         test add, delete, modify
 * </pre>
 */
@RestController("adminProductAPIController")
@RequestMapping("/api/admin/product")
public class AdminProductController {
	
	@ApiOperation(value = "get add product form", notes = "상품등록 폼 가져오기")
	@GetMapping("/addform")
	public JSONResult addform() {
		
		//get add form
		
		return JSONResult.success("return:addform");
	}
	
	@ApiOperation(value = "add product by admin", notes = "관리자 상품 등록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="vo", value="상품정보", required=true, dataType="ProductVo", defaultValue="")
	})
	@PutMapping
	public ResponseEntity<JSONResult> add(@RequestBody @Valid ProductVo vo, BindingResult result) {
		
		//validation
		if (result.hasErrors()) {
			// 에러 메세지 확인
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				System.out.println("Validation Error : " + error);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("invalid data"));
			}
		}
		
		//add service
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}
	
	@ApiOperation(value = "delete product by admin", notes = "관리자 상품 삭제")
	@ApiImplicitParam(name="no", value="상품번호", required = true, dataType = "long", defaultValue = "")
	@DeleteMapping("/{no}")
	public JSONResult delete(@PathVariable(value = "no") Long no) {
		
		// delete 처리
		return JSONResult.success(no);
	}
	
	@PostMapping
	@ApiOperation(value = "modify product info by admin", notes = "상품정보 변경 : 수량, 이름, 카테고리 etc")
	@ApiImplicitParam(name="vo", value = "변경할 상품 정보", required = true, dataType = "ProductVo", defaultValue = "")
	public JSONResult modify(@RequestBody ProductVo vo) {
		//modify : 수량, 이름, 카테고리 etc
		
		return JSONResult.success(vo);
	}
}
