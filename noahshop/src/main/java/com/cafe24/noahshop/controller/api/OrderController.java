package com.cafe24.noahshop.controller.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.noahshop.dto.JSONResult;
import com.cafe24.noahshop.service.OrderService;
import com.cafe24.noahshop.vo.OrderVo;
import com.cafe24.noahshop.vo.ProductVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.controller.api
 * @filename : OrderController.java
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
 * Jul 12, 2019     rdevnoah         test add, get, delete
 * </pre>
 */
@RestController("orderAPIController")
@RequestMapping("/api/order")
public class OrderController {
	
	//@Autowired
	private OrderService orderService;
	
	
	@ApiOperation(value="show order form", notes = "주문정보입력창 이동")
	@ApiImplicitParams({
		@ApiImplicitParam(name="vo", value="상품상세정보", required=true, dataType="ProductVo", defaultValue="")
	})
	@PostMapping("/orderform")
	public JSONResult orderform(@RequestBody ProductVo vo) {
		// 선택한 상품 상세정보를 통해 orderform으로 이동처리
		return JSONResult.success("return:orderform");
	}
	
	@ApiOperation(value="add order", notes = "상품 주문처리")
	@ApiImplicitParams({
		@ApiImplicitParam(name="vo", value="주문처리할 정보", required=true, dataType="OrderVo", defaultValue="")
	})
	@PutMapping
	public JSONResult addOrder(@Valid @RequestBody OrderVo vo, BindingResult result) {
		
		//validation
		if (result.hasErrors()) {
			// 에러 메세지 확인
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				System.out.println("Validation Error : " + error);
			}
		}
		
		//order service
		//String orderCode = orderService.addOrder(vo);
			
		return JSONResult.success("return:addOrder");
	}
	
	@ApiOperation(value = "get Order", notes = "주문내역 가져외-회원:모든 주문, 비회원:로그인+주문조회정보입력페이지 이동")
	@GetMapping
	public JSONResult getOrder(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		//비회원인 경우 
		if (session == null) {
			
			// 비회원 주문조회 포함한 로그인 페이지 이동
			
			return JSONResult.fail("unidentified User: goto enter order password page");
		}
		
		
		return JSONResult.success("return:order");
	}
	
	@ApiOperation(value = "delete order", notes = "결제대기인 상품 주문 취소")
	@ApiImplicitParam(name = "vo", value = "주문취소 하고 싶은 주문의 번호")
	@DeleteMapping("/delete/{no}")
	public JSONResult deleteOrder(@PathVariable(value = "no") Long no) {
		
		// no에 따른 주문의 상태가 '결제대기' 인 경우에만 삭제 : service에서 처리
		
		return JSONResult.success(no);
		
	}
}
