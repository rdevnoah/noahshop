package com.cafe24.noahshop.controller.api;

import com.cafe24.noahshop.vo.OptionVo;
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
public class AdminOptionControllerTest {
private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Rollback(true)
	@Test
	public void testAdd() throws Exception {

		OptionVo vo = new OptionVo();
		// 상위옵션 add test
		vo.setName("COLOR");
		ResultActions resultActions = mockMvc.perform(put("/api/admin/option").contentType(MediaType.APPLICATION_JSON)
																							.content(new Gson().toJson(vo)));
		resultActions.andExpect(status().isOk())
					.andDo(print())
					.andExpect(jsonPath("$.data.name", is(vo.getName())));

		// test Validation
		vo.setName(null);
		resultActions = mockMvc.perform(put("/api/admin/option").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultActions.andExpect(status().isOk())
					.andDo(print())
					.andExpect(jsonPath("$.result", is("fail")));


		// 하위옵션 (테스트시 parentNo 잘 넣어서 테스트하기.(자동화 방법 찾자))
		// 하위옵션 add test
		vo.setName("XXS");

		resultActions = mockMvc.perform(put("/api/admin/option/{no}", 1).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(vo)));
		resultActions.andExpect(status().isOk())
				.andDo(print())
				.andExpect(jsonPath("$.data", is(1)));
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
