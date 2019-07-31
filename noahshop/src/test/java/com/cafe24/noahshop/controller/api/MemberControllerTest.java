package com.cafe24.noahshop.controller.api;

import com.cafe24.noahshop.vo.MemberVo;
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
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp() {
		System.out.println("makemockMVC");
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Rollback(true)
	@Test
	public void testJoin() throws Exception {

		// checkId insert data()
		MemberVo checkVo = new MemberVo(null, "q77q78", "qntlfwkd1!", "김노아", "010-4444-3333", "천안시 서북구 두정동"
				, "ehfhfhdehd@naver.com", null, null);
		
		
		ResultActions resultActions = mockMvc.perform(put("/api/user").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(checkVo)));

		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("success")))
					 .andExpect(jsonPath("$.data.id", is("q77q78")));
		
		
		// check used Id
		resultActions = mockMvc.perform(get("/api/user/checkId/{id}", "q77q78").contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("fail")))
					 .andExpect(jsonPath("$.message", is("이미 사용중인 아이디입니다.")));
		
		// check unused Id
		resultActions = mockMvc.perform(get("/api/user/checkId/{id}", "unused123").contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("success")))
					 .andExpect(jsonPath("$.data", is("unused123")));
		
		// checkId Validation (invalid)
		
		resultActions = mockMvc.perform(get("/api/user/checkId/{id}", "as").contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("fail")));
		 
		// checkId Validation (invalid)
		
		resultActions = mockMvc.perform(get("/api/user/checkId/{id}", " ").contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("fail")));
		
		
		// checkId Validation (invalid)
		
		resultActions = mockMvc.perform(get("/api/user/checkId/{id}", "asdlfhaldjksflahsdlfkadfj").contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("fail")));
		
		
		// checkId Validation (Valid)
		
		resultActions = mockMvc.perform(get("/api/user/checkId/{id}", "ghgh123").contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("success")))
					 .andExpect(jsonPath("$.data", is("ghgh123")));

		// insert member (invalid data)
		MemberVo vo = new MemberVo(null, "", "password1!!", "김영호", "010-4532-3018", "대구시 수성구 시지동",
							"zzagam2@gmail.com", null, null);

		resultActions = mockMvc.perform(put("/api/user").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions.andExpect(status().isBadRequest())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("fail")));

		// insert member (valid data)
		vo = new MemberVo(null, "zzagam2", "qntlfwkd1!", "김영호", "112-3412-3313", "경기도 수원시 팔달구 우만동",
							"zzagam2@gmail.com", null, null);

		resultActions = mockMvc.perform(put("/api/user").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("success")))
					 .andExpect(jsonPath("$.data.name", is("김영호")));
		
		
	}

	@Test
	public void testGetOrderList() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/api/user/orderlist/{no}", 1L).contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("success")));
	}


	@Test
	public void testGetOrderByNoUser() throws Exception {

		ResultActions resultActions = mockMvc.perform(get("/api/user/order/nomember").contentType(MediaType.APPLICATION_JSON)
														.param("code", "sampleordercode3")
														.param("password", "비밀번호1"));

		resultActions.andExpect(status().isOk())
				.andDo(print())
				.andExpect(jsonPath("$.result", is("success")));
	}

	@Test
	public void testJoinForm() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/api/user/joinform").contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("success")));
	}

	@Test
	public void testJoinSuccess() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/api/user/joinsuccess").contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("success")));
	}

	@Test
	public void testModifyForm() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/api/user/modifyform/{no}", 1L).contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("success")));
	}

	@Rollback(true)
	@Test
	public void testModify() throws Exception {
		MemberVo vo = new MemberVo();
		vo.setNo(1L);
		vo.setId("zzagam2");
		vo.setAddress("미국 플로리다주");
		vo.setName("김똥개");
		vo.setPassword("qntlfwkd1!");
		vo.setEmail("test@test.com");
		vo.setTel("010-1111-1111");

		ResultActions resultActions = mockMvc.perform(put("/api/user/modify").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));

		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("success")));
		
		// invalid
		vo.setTel(null);

		resultActions = mockMvc.perform(put("/api/user/modify").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));

		resultActions.andDo(print())
					 .andExpect(status().isBadRequest())
					 .andExpect(jsonPath("$.result", is("fail")));
		
	}


	@Test
	public void testLoginForm() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/api/user/loginform").contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("success")));
	}

	@Test
	public void testLogin() throws Exception {

		// valid data test
		String id = "zzagam2";
		String password = "qntlfwkd1!";
		// 임시로 tel을 null validator 추가해준 test
		
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setPassword(password);
		
		ResultActions resultActions = mockMvc.perform(post("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));

		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("success")))
					 .andExpect(jsonPath("$.data.id", is("zzagam2")));

		// invalid data test
		
		
		vo.setId("zzagam2");
		vo.setPassword("qntlfwkd11");

		resultActions = mockMvc.perform(post("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));

		resultActions.andExpect(status().isBadRequest())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("fail")));

		/*
		 * id = "zz"; password = "aa"; resultActions =
		 * mockMvc.perform(post("/api/user/login").param("id", id).param("password",
		 * password) .contentType(MediaType.APPLICATION_JSON));
		 * 
		 * resultActions.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath(
		 * "$.result", is("fail")));
		 */

	}

	
}
