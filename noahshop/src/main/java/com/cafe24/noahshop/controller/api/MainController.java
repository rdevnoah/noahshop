package com.cafe24.noahshop.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.noahshop.dto.JSONResult;
import com.cafe24.noahshop.service.ProductService;

@RestController
@RequestMapping({ "/", "" })
public class MainController {
	
	private ProductService productService;
	@RequestMapping(value = "", method = RequestMethod.GET)
	public JSONResult main() {
		// --------- 한 service에서 다른 repository에서 가져와서 한번에 도착
		// 진열상품목록 get
		// 주문횟수랭킹상품목록
		// 등록일기준 상품목록
		// 카테고리목록
		//productService.getMain();
		return JSONResult.success("success");
	}
}
