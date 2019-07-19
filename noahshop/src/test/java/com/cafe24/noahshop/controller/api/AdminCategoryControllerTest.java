package com.cafe24.noahshop.controller.api;

import com.cafe24.noahshop.vo.CategoryVo;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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
public class AdminCategoryControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testAddCategoryForm() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/api/admin/category/addform").contentType(MediaType.APPLICATION_JSON));
		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("success")));
	}

	@Rollback(true)
	@Test
	public void testAdd() throws Exception {
		CategoryVo vo = new CategoryVo();
		vo.setName("TOP");
		ResultActions resultActions = mockMvc.perform(put("/api/admin/category").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("success")))
					 .andExpect(jsonPath("$.data.name", is("TOP")));


		// check Validation
		vo.setName(null);
		resultActions = mockMvc.perform(put("/api/admin/category").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("fail")));

		// check child Category Add
		vo.setName("나시");
		resultActions = mockMvc.perform(put("/api/admin/category/{no}", 1L).contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("success")))
					 .andExpect(jsonPath("$.data.name", is("나시")));
	}
	
	@Test
	public void testModify() throws Exception {
		CategoryVo vo = new CategoryVo();
		vo.setName("상의입니다.");
		ResultActions resultActions = mockMvc.perform(post("/api/admin/category").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.data.name", is("상의입니다.")));
	}
	
	@Test
	public void testDelete() throws Exception {
		ResultActions resultActions = mockMvc.perform(delete("/api/admin/category/{no}", 2L).contentType(MediaType.APPLICATION_JSON));
		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.data", is(2)));
	}
}
