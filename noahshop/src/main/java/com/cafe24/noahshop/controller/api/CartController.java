package com.cafe24.noahshop.controller.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.noahshop.dto.JSONResult;
import com.cafe24.noahshop.service.CartService;
import com.cafe24.noahshop.vo.ProductVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.controller.api
 * @filename : CartController.java
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
 * Jul 12, 2019     rdevnoah         test add, modify, delete
 * </pre>
 */
@RestController("cartAPIController")
@RequestMapping("/api/cart")
public class CartController {
	
	private CartService cartService;
	
	
	@ApiOperation(value="add cart to session", notes = "장바구니정보 세션저장 (회원 DB저장)")
	@ApiImplicitParams({
		@ApiImplicitParam(name="vo", value="상품상세정보", required=true, dataType="ProductVo", defaultValue="")
	})
	@PutMapping
	public JSONResult addCart(@RequestBody ProductVo vo) {
		//회원 비회원 여부 확인
		
		//고유 세션값 가져오기
		
		//세션에 정보 저장
		
		//회원은 RDB에 저장 (추후 Redis)
		//cartService.addCart(vo, sessionid);
		return JSONResult.success("return:addCart");
	}
	
	@ApiOperation(value="get Cart From session", notes = "세션에 저장된 카트정보를 통해 상품리스트 가져오기")
	@GetMapping
	public JSONResult getCart() {
		
		return JSONResult.success("return:getCart");
	}
	
	@ApiOperation(value="add order from cart and show order form", notes = "장바구니 상품 주문 처리 후 주문페이지 이동")
	@GetMapping("/orderform")
	public JSONResult addCartOrder(HttpServletRequest request) {
		
		//세션에 포함된 장바구니 정보 : 요청온 session에서 장바구니정보 가져오기
		
		return JSONResult.success("return:order form");
	}
	
	@ApiOperation(value="delete cart to session", notes = "상품 장바구니에서 삭제 세션저장 (회원 DB저장)")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="장바구니에서 삭제할 상품 번호 ex) 2:3:6:12", required=true, dataType="string", defaultValue="")
	})
	@DeleteMapping("/{no}")
	public JSONResult deleteCart(@PathVariable(value="no") String no, HttpServletRequest request) {
		// data parsing 2:4:5:6 -> 2, 4, 5, 6
		
		// session에서 삭제
		
		// 회원인 경우 DB에서도 삭제
		return JSONResult.success(no);
	}
}
