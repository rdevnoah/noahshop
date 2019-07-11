package com.cafe24.noahshop.controller.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.noahshop.dto.JSONResult;
import com.cafe24.noahshop.service.CartService;
import com.cafe24.noahshop.vo.ProductVo;

@RestController("cartAPIController")
@RequestMapping("/api/cart")
public class CartController {
	
	private CartService cartService;
	
	@RequestMapping(method = RequestMethod.PUT)
	public JSONResult addCart(@RequestBody ProductVo vo) {
		//회원 비회원 여부 확인
		
		//고유 세션값 가져오기
		
		//세션에 정보 저장
		
		//회원은 RDB에 저장 (추후 Redis)
		//cartService.addCart(vo, sessionid);
		return JSONResult.success("return:addCart");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public JSONResult getCart() {
		
		return JSONResult.success("return:getCart");
	}
	
	@RequestMapping(value="/order/{sessionCart}", method = RequestMethod.PUT)
	public JSONResult addCartOrder(@PathVariable(value="sessionCart") String sessionCart) {
		
		//세션에 포함된 장바구니 정보 : sessionCart
		
		return JSONResult.success("return:addCartOrder");
	}
}
