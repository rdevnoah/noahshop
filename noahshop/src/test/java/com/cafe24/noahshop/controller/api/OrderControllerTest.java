package com.cafe24.noahshop.controller.api;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.noahshop.config.AppConfig;
import com.cafe24.noahshop.config.TestWebConfig;
import com.cafe24.noahshop.vo.OrderVo;
import com.cafe24.noahshop.vo.ProductVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, TestWebConfig.class })
@WebAppConfiguration
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
		ProductVo vo = new ProductVo();
		vo.setName("청바지!!");
		
		ResultActions resultActions = mockMvc
				.perform(post("/api/order/orderform").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));

		resultActions.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.result", is("success")));
	}
	
	@Test
	public void testAddOrder() throws Exception {
		OrderVo vo = new OrderVo();
		vo.setAddress("대구대구대구대구");
		vo.setIsMember("T");

		ResultActions resultActions = mockMvc
				.perform(put("/api/order").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));

		resultActions.andExpect(status().isOk()).andDo(print());
		
		vo.setIsMember(null);
		resultActions = mockMvc
				.perform(put("/api/order").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));

		resultActions.andExpect(status().isOk())
					.andDo(print())
					.andExpect(jsonPath("$.result", is("fail")));
	}

	@Test
	public void testGetOrder() throws Exception {
		
		MockHttpSession mockSession = new MockHttpSession();
		
		// 회원
		ResultActions resultActions = mockMvc
				.perform(get("/api/order").contentType(MediaType.APPLICATION_JSON).session(mockSession));

		resultActions.andExpect(status().isOk())
					.andDo(print())
					.andExpect(jsonPath("$.result", is(("success"))));
		
		
		//비회원
		resultActions = mockMvc
				.perform(get("/api/order").contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk())
					.andDo(print())
					.andExpect(jsonPath("$.result", is(("fail"))));
	}
	
	@Test
	public void testDeleteOrder() throws Exception {
		
		ResultActions resultActions = mockMvc
				.perform(delete("/api/order/delete/{no}", 2L).contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk())
					.andDo(print())
					.andExpect(jsonPath("$.result", is(("success"))))
					.andExpect(jsonPath("data", is(2)));
	}
	
	
}
