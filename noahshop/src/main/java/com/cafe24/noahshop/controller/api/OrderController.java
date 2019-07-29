package com.cafe24.noahshop.controller.api;

import com.cafe24.noahshop.dto.JSONResult;
import com.cafe24.noahshop.service.MemberService;
import com.cafe24.noahshop.service.OrderService;
import com.cafe24.noahshop.vo.MemberVo;
import com.cafe24.noahshop.vo.OrderVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

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
	
	@Autowired
	private OrderService orderService;

	@Autowired
	private MemberService memberService;
	
	@ApiOperation(value="show order form", notes = "회원 주문정보입력창 이동")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="사용자정보", required=true, dataType="long", defaultValue="")
	})
	@PostMapping("/orderform/{no}")
	public JSONResult orderform(@PathVariable(value = "no") Long no) {

		//회원정보 가져오기
		MemberVo vo = memberService.getMemberByNo(no);
		return JSONResult.success(vo);
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
				return JSONResult.fail("invalid data");
			}
		}


		vo = orderService.addMemberOrder(vo);


			
		return JSONResult.success(vo);
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
