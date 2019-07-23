package com.cafe24.noahshop.controller.api;

import com.cafe24.noahshop.dto.JSONResult;
import com.cafe24.noahshop.dto.ProductAddDto;
import com.cafe24.noahshop.service.AdminProductService;
import com.cafe24.noahshop.vo.ProductVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
 * Jul 23, 2019     rdevnoah         product add test 완료
 * </pre>
 */
@RestController("adminProductAPIController")
@RequestMapping("/api/admin/product")
public class AdminProductController {

	@Autowired
	private AdminProductService adminProductService;

	
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
	public ResponseEntity<JSONResult> add(@RequestBody @Valid ProductAddDto dto, BindingResult result) {
		
		//validation
		if (result.hasErrors()) {
			// 에러 메세지 확인
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				System.out.println("Validation Error : " + error);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("invalid data"));
			}
		}

		//Todo: Validation 체크

		//받은 상품정보 저장하기

		if ("N".equals(dto.getIsSell())){
			adminProductService.addProductNoOption(dto);

		}else{
			adminProductService.addProduct(dto);
		}

		//add service
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(dto));
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
