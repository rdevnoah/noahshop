package com.cafe24.noahshop.controller.api;

import static org.hamcrest.CoreMatchers.is;
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
import com.cafe24.noahshop.vo.MemberVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, TestWebConfig.class })
@WebAppConfiguration
public class MemberControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp() {
		System.out.println("makemockMVC");
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testJoin() throws Exception {

		// checkId
		ResultActions resultActions = mockMvc
				.perform(get("/api/user/checkId/{id}", "aaaa").contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.result", is("success")));

		// insert member (invalid data)
		MemberVo vo = new MemberVo(null, "asdfasdf", "asdf", "aaa", "1123412313", "asdfasdfasdfasdf",
							"asdfasf@asdfas.com", null, null);

		resultActions = mockMvc
				.perform(put("/api/user").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.result", is("fail")))
				.andExpect(jsonPath("$.message", is("invalid Data")));

		// insert member (valid data)
		vo = new MemberVo(null, "asdfasfasdf", "ajskdlfjg", "aaa", "1123412313", "asdfasdfasdfasdf",
							"asdfasf@asdfas.com", null, null);
		resultActions = mockMvc
				.perform(put("/api/user").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions.andExpect(status().isOk())
					.andDo(print())
					.andExpect(jsonPath("$.result", is("success")));
	}

	@Test
	public void testJoinForm() throws Exception {
		ResultActions resultActions = mockMvc
				.perform(get("/api/user/joinform").contentType(MediaType.APPLICATION_JSON));
		resultActions.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.result", is("success")));
	}

	@Test
	public void testJoinSuccess() throws Exception {
		ResultActions resultActions = mockMvc
				.perform(get("/api/user/joinsuccess").contentType(MediaType.APPLICATION_JSON));
		resultActions.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.result", is("success")));
	}

	@Test
	public void testModifyForm() throws Exception {
		ResultActions resultActions = mockMvc
				.perform(get("/api/user/modifyform").contentType(MediaType.APPLICATION_JSON));
		resultActions.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.result", is("success")));
	}

	@Test
	public void testmodify() throws Exception {
		MemberVo vo = new MemberVo();
		vo.setId("zzagam2");
		vo.setAddress("수원시 팔달구 우만동");
		vo.setName("김영호");
		vo.setPassword("ghghghghghgh");
		vo.setEmail("test@test.com");
		vo.setTel("010-1111-1111");

		ResultActions resultActions = mockMvc.perform(post("/api/user").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(vo)));
		
		resultActions.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.result", is("success")))
					.andExpect(jsonPath("$.data.tel", is("010-1111-1111")))
					.andExpect(jsonPath("$.data.email", is("test@test.com")));
	}

	@Test
	public void testLoginForm() throws Exception {
		ResultActions resultActions = mockMvc
				.perform(get("/api/user/loginform").contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk())
					.andDo(print())
					.andExpect(jsonPath("$.result", is("success")));
	}

	@Test
	public void testLogin() throws Exception {

		// valid data test
		String id = "zzagam2";
		String password = "aaaaaaaaaa";
		ResultActions resultActions = mockMvc.perform(post("/api/user/login").param("id", id)
				.param("password", password).contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk())
					.andDo(print())
					.andExpect(jsonPath("$.result", is("success")));

		// invalid data test

		/*
		 * id = "zz"; password = "aa"; resultActions =
		 * mockMvc.perform(post("/api/user/login").param("id", id).param("password",
		 * password) .contentType(MediaType.APPLICATION_JSON));
		 * 
		 * resultActions.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath(
		 * "$.result", is("fail")));
		 */

	}
	
	@Test
	public void testLogout() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/api/user/logout").contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk())
					.andDo(print())
					.andExpect(jsonPath("$.result", is("success")));
	}

}
