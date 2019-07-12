package com.cafe24.noahshop.controller.api;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.noahshop.config.AppConfig;
import com.cafe24.noahshop.config.TestWebConfig;
import com.cafe24.noahshop.vo.ProductVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, TestWebConfig.class })
@WebAppConfiguration
public class CartControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testadd() throws Exception {

		ProductVo vo = new ProductVo();
		ResultActions resultActions = mockMvc
				.perform(put("/api/cart").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultActions.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testget() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/api/cart").contentType(MediaType.APPLICATION_JSON));
		resultActions.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testCartOrder() throws Exception {
		ResultActions resultActions = mockMvc
				.perform(get("/api/cart/orderform").contentType(MediaType.APPLICATION_JSON));
		resultActions.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testDeleteCart() throws Exception {
		ResultActions resultActions = mockMvc.perform(delete("/api/cart/{no}", "2:4:5:6").contentType(MediaType.APPLICATION_JSON));
		resultActions.andExpect(status().isOk())
					.andDo(print())
					.andExpect(jsonPath("$.result", is("success")));
	}

}
