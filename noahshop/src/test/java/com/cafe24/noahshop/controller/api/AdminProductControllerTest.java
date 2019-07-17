package com.cafe24.noahshop.controller.api;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.noahshop.vo.ProductVo;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminProductControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testAddForm() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/api/admin/product/addform").contentType(MediaType.APPLICATION_JSON));
		resultActions.andExpect(status().isOk())
					.andDo(print())
					.andExpect(jsonPath("$.result", is("success")));
		
	}
	
	@Test
	public void testAdd() throws Exception {
		ProductVo vo = new ProductVo();
		vo.setName("아디다스 져지");
		vo.setCode("123adfg32");
		vo.setMoney(23000);
		ResultActions resultActions = mockMvc.perform(put("/api/admin/product").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultActions.andExpect(status().isOk())
					.andDo(print())
					.andExpect(jsonPath("$.data.name", is("아디다스 져지")))
					.andExpect(jsonPath("$.data.money",is(23000)));
		
		//invalid 
		vo.setCode(null);
		resultActions = mockMvc.perform(put("/api/admin/product").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultActions.andExpect(status().isBadRequest())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("fail")));
	}
	
	@Test
	public void testDelete() throws Exception {
		ResultActions resultActions = mockMvc.perform(delete("/api/admin/product/{no}", 2L).contentType(MediaType.APPLICATION_JSON));
		resultActions.andExpect(status().isOk())
					.andDo(print())
					.andExpect(jsonPath("$.result", is("success")))
					.andExpect(jsonPath("$.data",is(2)));
	}
	
	@Test
	public void testModify() throws Exception {
		ProductVo vo = new ProductVo();
		vo.setName("시원한 반바지!");
		
		ResultActions resultActions = mockMvc.perform(post("/api/admin/product").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultActions.andExpect(status().isOk())
					.andDo(print())
					.andExpect(jsonPath("$.result", is("success")))
					.andExpect(jsonPath("$.data.name",is("시원한 반바지!")));
	}
}
