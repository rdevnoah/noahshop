package com.cafe24.noahshop.controller.api;

import com.cafe24.noahshop.vo.OrderVo;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderControllerTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testOrderForm() throws Exception{
		// 주문 페이지 가기. 필요 데이터 : 사용자 정보 : 회원인지 비회원인지.

		//test 회원 회원번호 가지고 회원 데이터 (no, 주소, 이름, 연락처 이메일, 가져와서 뿌려주기)
		ResultActions resultActions = mockMvc.perform(post("/api/order/orderform/{no}", 1L).contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("success")));
	}

	@Rollback(true)
	@Test
	public void testAddOrder() throws Exception {

		// 주문 처리

		// 회원 - no:null, member_no:1L, order_no:null, order_date:null, address:대구 광역시 수성구 시지동 청구전원아파트 102동 701호, isMember='T', password:null, payment:카드결제,
		// buyerName:null, email:zzagam2@gmail.com, status: 결제대기, buyerTel: 010-4532-3018
		// order_Product - order_no=null, poduct_detail_no=1, quantity:3


		OrderVo vo = new OrderVo();

		vo.setMemberNo(1L);
		vo.setBuyerName("김영호");
		vo.setAddress("대구 광역시 수성구 시지동 청구전원아파트 102동 701호");
		vo.setIsMember("Y");
		vo.setPayment("카드결제");
		vo.setEmail("zzagam2@gmail.com");
		vo.setStatus("결제대기");
		vo.setBuyerTel("010-4532-3018");
		vo.setPrice(23000);
		vo.setProductDetailNo(4L);
		vo.setQuantity(3);
		vo.setMessage("부재시 경비실에 맡겨주세요");

		ResultActions resultActions = mockMvc.perform(put("/api/order").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));

		resultActions.andExpect(status().isOk())
					 .andDo(print());


		// 비회원 - no:null, member_no:null, order_no:null, order_date:null, address:대구 광역시 수성구 시지동 청구전원아파트 102동 701호, isMember='N', password:"qlalfqjsgh2@", payment:카드결제,
		// buyerName:김자감, email:zzagam2@gmail.com, status: 결제대기, buyerTel: 010-1111-1111
		// order_Product - order_no=null, poduct_detail_no=1, quantity:3

		vo = new OrderVo();
		vo.setBuyerName("김자감");
		vo.setAddress("대구 광역시 수성구 시지동 청구전원아파트 102동 701호");
		vo.setIsMember("N");
		vo.setPayment("무통장입금");
		vo.setEmail("zzagam2@gmail.com");
		vo.setStatus("결제대기");
		vo.setBuyerTel("010-4532-3018");
		vo.setPrice(23000);
		vo.setProductDetailNo(4L);
		vo.setQuantity(3);
		vo.setPassword("qlalfqjsgh2@");
		vo.setMessage("문앞에 놔둬주세요");

		resultActions = mockMvc.perform(put("/api/order").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));

		resultActions.andExpect(status().isOk())
					 .andDo(print());

		
		vo.setIsMember(null);

		resultActions = mockMvc.perform(put("/api/order").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));

		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("fail")));
	}

	@Test
	public void testGetOrder() throws Exception {
		
		MockHttpSession mockSession = new MockHttpSession();
		
		// 회원
		ResultActions resultActions = mockMvc.perform(get("/api/order").contentType(MediaType.APPLICATION_JSON).session(mockSession));

		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is(("success"))));
		
		
		//비회원
		resultActions = mockMvc.perform(get("/api/order").contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is(("fail"))));
	}
	
	@Test
	public void testDeleteOrder() throws Exception {
		
		ResultActions resultActions = mockMvc.perform(delete("/api/order/delete/{no}", 2L).contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is(("success"))))
					 .andExpect(jsonPath("data", is(2)));
	}
	
	
}
