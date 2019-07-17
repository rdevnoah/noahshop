package com.cafe24.noahshop.controller.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp() {
		System.out.println("makemockMVC");
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testDetail() throws Exception {
		ResultActions resultActions = mockMvc
				.perform(get("/api/product/detail/{no}", 2L).contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	public void testSearch() throws Exception {
		ResultActions resultActions = mockMvc
				.perform(get("/api/product/search/{keyword}", "청바지").contentType(MediaType.APPLICATION_JSON));
		resultActions.andExpect(status().isOk())
		.andDo(print());
		
		resultActions = mockMvc
				.perform(get("/api/product/search/{keyword}/{categoryNo}", "청바지", 2L).contentType(MediaType.APPLICATION_JSON));
		resultActions.andExpect(status().isOk())
		.andDo(print());
		
	}
	
	

}
