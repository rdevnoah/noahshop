package com.cafe24.noahshop.controller.api;

import com.cafe24.noahshop.dto.JSONResult;
import com.cafe24.noahshop.service.ProductService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.controller.api
 * @filename : ProductController.java
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
 * Jul 11, 2019     rdevnoah         Initialize
 * Jul 12, 2019     rdevnoah         test search
 * Jul 25, 2019     rdevnoah         getDetail 이미지 제외 구현 완료
 * Jul 30, 2019     rdevnoah         getListByCategoryNo 구현 완료
 * </pre>
 */
@RestController("productAPIController")
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@ApiOperation(value="get product's detail info", notes = "상품 상세정보 가져오기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="상품번호", required=true, dataType="long", defaultValue="")
	})
	@GetMapping("/detail/{no}")
	public JSONResult getDetail(@PathVariable Long no) {

		//상품상세정보
		Map<String, Object> map = productService.getProductDetail(no);

		return JSONResult.success(map);
	}

	@ApiOperation(value="get product List by CategoryNo", notes = "카테고리별 상품 리스트 가져오기")
	@ApiImplicitParams({
			@ApiImplicitParam(name="categoryNo", value="카테고리번호", required=true, dataType="long", defaultValue="")
	})
	@GetMapping("/{categoryNo}")
	public JSONResult getListByCategoryNo(@PathVariable(value = "categoryNo") Long categoryNo){

		Map<String, Object> map = productService.getListByCategoryNo(categoryNo);

		return JSONResult.success(map);
	}



	@ApiOperation(value="search by keyword", notes = "키워드를 통해 상품 검색")
	@ApiImplicitParams({
		@ApiImplicitParam(name="keyword", value="검색 키워드", required=true, dataType="string", defaultValue="")
	})
	@GetMapping("/search/{keyword}")
	public JSONResult search(@PathVariable(value="keyword") String keyword) {
		// 카테고리내 검색어 포함개수
		// 상품 전체 키워드 포함 List
		//productService.searchByKeyword(keyword);
		return JSONResult.success("return:search");
	}
	
	@ApiOperation(value="search by keyword from category", notes = "키워드를 통해 카테고리내의 상품 검색")
	@ApiImplicitParams({
		@ApiImplicitParam(name="keyword", value="검색 키워드", required=true, dataType="string", defaultValue=""),
		@ApiImplicitParam(name="categoryNo", value="카테고리 번호", required=true, dataType="long", defaultValue="")
	})
	@GetMapping("/search/{keyword}/{categoryNo}")
	public JSONResult categorySearch(@PathVariable(value="keyword") String keyword, @PathVariable(value="categoryNo") Long categoryNo) {
		// 카테고리 내 키워드 포함 List
		//productService.searchByKeywordInCategory(keyword, categoryNo);
		return JSONResult.success("return:categorySearch");
	}
}
