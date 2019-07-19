package com.cafe24.noahshop.controller.api;

import com.cafe24.noahshop.vo.OptionVo;
import com.cafe24.noahshop.vo.ProductVo;
import com.google.gson.Gson;
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

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

		ProductVo productVo = new ProductVo();
		OptionVo parentOption = new OptionVo();

		// 메인 진열 X 판매 X
		productVo.setCategoryNo(1L);
		productVo.setName("멜라토닌 반팔티셔츠");
		productVo.setPrice(14000);
		productVo.setDescription("HTML 문서");
		productVo.setDpMain("N");
		productVo.setIsSell("N");

		productVo.setOptionParentName("SIZE");
		productVo.setOptionChildName("L");
		productVo.setStock(230);


		ResultActions resultActions = mockMvc.perform(put("/api/admin/product").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(productVo)));

		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.data.name", is("아디다스 져지")))
					 .andExpect(jsonPath("$.data.money",is(23000)));
		
		//invalid 
		productVo.setCode(null);
		resultActions = mockMvc.perform(put("/api/admin/product").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(productVo)));

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
