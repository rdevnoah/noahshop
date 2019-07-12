package com.cafe24.noahshop.controller.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
 * @since : Jul 12, 2019
 * @version : 1.0
 * @see 
 * 
 * <pre>
 * == Modification Information ==
 * 
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * Jul 11, 2019     rdevnoah         Initialize
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
	@RequestMapping(value="/orderform", method = RequestMethod.POST)
	public JSONResult orderform(@RequestBody ProductVo vo) {
		// 선택한 상품 상세정보를 통해 orderform으로 이동처리
		return JSONResult.success("return:orderform");
	}
	
	@ApiOperation(value="add order", notes = "상품 주문처리")
	@ApiImplicitParams({
		@ApiImplicitParam(name="vo", value="주문처리할 정보", required=true, dataType="OrderVo", defaultValue="")
	})
	@RequestMapping(method = RequestMethod.PUT)
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
}
