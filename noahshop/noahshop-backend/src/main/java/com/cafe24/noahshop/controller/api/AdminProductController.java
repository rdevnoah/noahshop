package com.cafe24.noahshop.controller.api;

import com.cafe24.noahshop.dto.JSONResult;
import com.cafe24.noahshop.dto.ProductAddDto;
import com.cafe24.noahshop.service.AdminProductService;
import com.cafe24.noahshop.vo.OptionStockVo;
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

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

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
 * Jul 30, 2019     rdevnoah         getList, getDetail 구현완료
 * Jul 31, 2019     rdevnoah         getDetailForModify 구현완료
 * Jul 31, 2019     rdevnoah         modify(재고수량변경) 구현완료
 * Jul 31, 2019     rdevnoah         getDpMainProductList 구현완료
 * Jul 31, 2019     rdevnoah         addDpMainProduct구현완료
 * Jul 31, 2019     rdevnoah         deleteDpMainProduct구현완료
 *
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

		Map<String, Object> map = adminProductService.getAddForm();

		return JSONResult.success(map);
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

		if (dto.getNoOptionStock() != null){
			adminProductService.addProductNoOption(dto);

		}else{
			adminProductService.addProduct(dto);
		}


		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(dto));
	}

	@ApiOperation(value = "get product list by admin", notes = "관리자 상품 리스트")
	@GetMapping("/list")
	public JSONResult getProductList() {
		List<ProductVo> list = adminProductService.getList();
		return JSONResult.success(list);
	}


	@ApiOperation(value = "get product's detail info by no", notes = "관리자 상품 상세정보 가져오기")
	@ApiImplicitParam(name="no", value="상품번호", required = true, dataType = "long", defaultValue = "")
	@GetMapping("/detail/{no}")
	public JSONResult getDetailByNo(@PathVariable(value = "no") Long no) {

		Map<String, Object> map = adminProductService.getDetailByNo(no);

		return JSONResult.success(map);
	}

	@ApiOperation(value = "get product's detail for modify form", notes = "수정하기 위해 상품 정보 가져오기")
	@ApiImplicitParam(name="no", value="상품번호", required = true, dataType = "long", defaultValue = "")
	@GetMapping("/modifyform/{no}")
	public JSONResult modifyForm(@PathVariable(value = "no") Long no) {

		ProductAddDto dto = adminProductService.getProductDetailForModify(no);
		return JSONResult.success(dto);
	}



	@ApiOperation(value = "delete product by admin", notes = "관리자 상품 삭제")
	@ApiImplicitParam(name="no", value="상품번호", required = true, dataType = "long", defaultValue = "")
	@DeleteMapping("/{no}")
	public JSONResult delete(@PathVariable(value = "no") Long no) {
		
		// delete 처리
		return JSONResult.success(no);
	}
	
	@PostMapping
	@ApiOperation(value = "modify product info by admin", notes = "상품정보 변경 : 수량")
	@ApiImplicitParam(name="dto", value = "변경할 상품 정보", required = true, dataType = "ProductAddDto", defaultValue = "")
	public JSONResult modify(@RequestBody ProductAddDto dto) {
		//modify : 수량
		adminProductService.updateProductStock(dto);


		return JSONResult.success(dto);
	}

	@ApiOperation(value = "get DP Main Products list", notes = "메인진열된 상품리스트 가져오기")
	@GetMapping("/dpmain")
	public JSONResult getDpMainProduct(){
		List<ProductVo> list = adminProductService.getDpMainList();
		return JSONResult.success(list);
	}

	@ApiOperation(value = "add DP Main Products list", notes = "메인진열 상품 추가하기")
	@ApiImplicitParam(name="noList", value = "추가 할 상품 번호 리스트", required = true, dataType = "List", defaultValue = "")
	@PutMapping("/dpmain")
	public JSONResult addDpMainProduct(@RequestBody List<Long> noList){
		adminProductService.addDpMainProduct(noList);


		return JSONResult.success(noList);
	}

	@ApiOperation(value = "delete DP Main Products list", notes = "메인진열 상품 제거하기")
	@ApiImplicitParam(name="noList", value = "추가할 상품 번호 리스트", required = true, dataType = "List", defaultValue = "")
	@DeleteMapping("/dpmain")
	public JSONResult deleteDpMainProduct(@RequestBody List<Long> noList){
		adminProductService.deleteDpMainProduct(noList);


		return JSONResult.success(noList);
	}
}
