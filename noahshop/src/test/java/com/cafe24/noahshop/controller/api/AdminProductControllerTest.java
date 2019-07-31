package com.cafe24.noahshop.controller.api;

import com.cafe24.noahshop.dto.ProductAddDto;
import com.cafe24.noahshop.repository.AdminProductDao;
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
	private AdminProductDao adminProductDao;

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
	public void testModifyForm() throws Exception{
		ResultActions resultActions = mockMvc.perform(get("/api/admin/product/modifyform/{no}", 2L).contentType(MediaType.APPLICATION_JSON));

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

		// 판매여부 N, 메인DP N, OPTION 없음 // 따라서 dto에 instance V stock 값이 존재
		dto.setNoOptionStock(120);

		ResultActions resultActions = mockMvc.perform(put("/api/admin/product").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(dto)));

		resultActions.andExpect(status().isOk())
					 .andDo(print());

		// 판매여부 Y, OPTION 있음
		dto.setNoOptionStock(null);
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
	public void testGetList() throws Exception{
		ResultActions resultActions = mockMvc.perform(get("/api/admin/product/list").contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk())
				.andDo(print())
				.andExpect(jsonPath("$.result", is("success")));
	}

	@Test
	public void testGetDetailByNo() throws Exception{
		ResultActions resultActions = mockMvc.perform(get("/api/admin/product/detail/{no}", 1L).contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk())
				.andDo(print())
				.andExpect(jsonPath("$.result", is("success")));
	}

	
	@Test
	public void testDelete() throws Exception {
		ResultActions resultActions = mockMvc.perform(delete("/api/admin/product/{no}", 2L).contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("success")))
					 .andExpect(jsonPath("$.data",is(2)));
	}

	@Rollback(true)
	@Test
	public void testModify() throws Exception {

		// 재고만 변경 가능 // 옵션있는상품
		ProductAddDto dto = adminProductDao.getProductDetailForModify(1L);

		List<OptionStockVo> options = dto.getOptionStockVoList();
		List<OptionStockVo> updated = new ArrayList<>();

		for (int i=0 ; i<options.size() ; i++){
			OptionStockVo vo = options.get(i);
			vo.setStock(2000);
			updated.add(vo);

		}

		dto.setOptionStockVoList(updated);

		ResultActions resultActions = mockMvc.perform(post("/api/admin/product").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(dto)));

		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("success")));


		// 변경 확인
		resultActions = mockMvc.perform(get("/api/admin/product/modifyform/{no}", 1L).contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk())
				.andDo(print())
				.andExpect(jsonPath("$.result", is("success")));



		//옵션없는상품
		dto = adminProductDao.getProductDetailForModify(2L);
		for (int i=0 ; i<options.size() ; i++){
			OptionStockVo vo = options.get(i);
			vo.setStock(3000);
			updated.add(vo);

		}


	}
}
