package com.cafe24.noahshop.controller.api;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import com.cafe24.noahshop.config.TestAppConfig;
import com.cafe24.noahshop.config.TestWebConfig;
import com.cafe24.noahshop.vo.CategoryVo;
import com.cafe24.noahshop.vo.OptionVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestAppConfig.class, TestWebConfig.class})
@WebAppConfiguration
public class AdminOptionControllerTest {
private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testAdd() throws Exception {
		OptionVo vo = new OptionVo();
		vo.setName("상의");
		ResultActions resultActions = mockMvc.perform(put("/api/admin/option").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultActions.andExpect(status().isOk())
					.andDo(print())
					.andExpect(jsonPath("$.data.name", is("상의")));
		
		vo.setName(null);
		resultActions = mockMvc.perform(put("/api/admin/option").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultActions.andExpect(status().isOk())
					.andDo(print())
					.andExpect(jsonPath("$.result", is("fail")));
	}
	
	@Test
	public void testModify() throws Exception {
		OptionVo vo = new OptionVo();
		vo.setName("사이즈");
		ResultActions resultActions = mockMvc.perform(post("/api/admin/option").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultActions.andExpect(status().isOk())
					.andDo(print())
					.andExpect(jsonPath("$.data.name", is("사이즈")));
	}
	
	@Test
	public void testDelete() throws Exception {
		ResultActions resultActions = mockMvc.perform(delete("/api/admin/option/{no}", 2L).contentType(MediaType.APPLICATION_JSON));
		resultActions.andExpect(status().isOk())
					.andDo(print())
					.andExpect(jsonPath("$.data", is(2)));
	}
}
