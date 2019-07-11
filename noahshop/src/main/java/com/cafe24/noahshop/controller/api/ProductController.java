package com.cafe24.noahshop.controller.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.noahshop.dto.JSONResult;
import com.cafe24.noahshop.service.ProductService;

@RestController("productAPIController")
@RequestMapping("/api/product")
public class ProductController {

	//@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/detail/{no}", method = RequestMethod.GET)
	public JSONResult getDetail(@PathVariable Long no) {
		
		//상품상세정보
		//productService.getDetail(no);
		return JSONResult.success("return:detail");
	}
	
	@RequestMapping(value="/search/{keyword}", method = RequestMethod.GET)
	public JSONResult search(@PathVariable(value="keyword") String keyword) {
		// 카테고리내 검색어 포함개수
		// 상품 전체 키워드 포함 List
		//productService.searchByKeyword(keyword);
		return JSONResult.success("return:search");
	}
	
	@RequestMapping(value="/search/{keyword}/{categoryNo}", method=RequestMethod.GET)
	public JSONResult categorySearch(@PathVariable(value="keyword") String keyword, @PathVariable(value="categoryNo") Long categoryNo) {
		// 카테고리 내 키워드 포함 List
		//productService.searchByKeywordInCategory(keyword, categoryNo);
		return JSONResult.success("return:categorySearch");
	}
}
