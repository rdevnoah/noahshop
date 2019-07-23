package com.cafe24.noahshop.controller.api;

import com.cafe24.noahshop.dto.ProductAddDto;
import com.cafe24.noahshop.vo.OptionStockVo;
import com.cafe24.noahshop.vo.ProductImageVo;
import com.cafe24.noahshop.vo.ProductVo;
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

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
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
	@Rollback(true)
	public void testAdd() throws Exception {

		ProductAddDto dto = new ProductAddDto();
		dto.setName("Sample T-shirts");

		dto.setDescription("sample Product Description");

		List<ProductImageVo> images = new ArrayList<ProductImageVo>();
		ProductImageVo image = new ProductImageVo();
		image.setUrl("url1");
		images.add(image);

		image = new ProductImageVo();
		image.setUrl("url2");
		images.add(image);

		dto.setImage(images);

		dto.setCategoryNo(1L);
		dto.setIsSell("N");
		dto.setDpMain("N");

		// 판매여부 N, 메인DP N, OPTION 없음

		ResultActions resultActions = mockMvc.perform(put("/api/admin/product").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(dto)));

		resultActions.andExpect(status().isOk())
					 .andDo(print());

		// 판매여부 Y, OPTION 있음
		dto.setIsSell("Y");
		List<OptionStockVo> optionList = new ArrayList<OptionStockVo>();
		OptionStockVo option = new OptionStockVo();
		option.setOptionChild1No(1L);
		option.setOptionChild1No(4L);
		option.setStock(230);
		optionList.add(option);
		option = new OptionStockVo();
		option.setOptionChild1No(2L);
		option.setOptionChild2No(4L);
		option.setStock(120);
		optionList.add(option);

		dto.setOptionStockVoList(optionList);
		resultActions = mockMvc.perform(put("/api/admin/product").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(dto)));
		resultActions.andExpect(status().isOk());



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
