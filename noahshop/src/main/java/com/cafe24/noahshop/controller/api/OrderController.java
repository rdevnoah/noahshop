package com.cafe24.noahshop.controller.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.noahshop.dto.JSONResult;
import com.cafe24.noahshop.service.OrderService;
import com.cafe24.noahshop.vo.OrderVo;

@RestController("orderAPIController")
@RequestMapping("/api/order")
public class OrderController {
	
	//@Autowired
	private OrderService orderService;
	
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
