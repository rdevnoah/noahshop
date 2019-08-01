package com.cafe24.noahshop.controller.api;

import com.cafe24.noahshop.dto.JSONResult;
import com.cafe24.noahshop.service.AdminCategoryService;
import com.cafe24.noahshop.vo.CategoryVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.controller.api
 * @filename : AdminCategoryController.java
 * @author : rdevnoah
 * @since : Jul 12, 2019
 * @version : 1.0
 * @see 
 * 
 * <pre>
 * == Modification Information ==
 * 
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * Jul 12, 2019     rdevnoah         Initialize
 * Jul 12, 2019     rdevnoah         test add, modify, delete
 * Jul 12, 2019     rdevnoah         add implement test
 * Jul 18, 2019     rdevnoah         add implement complete
 * Jul 30, 2019     rdevnoah         addParent, addChild 구현완료
 * Jul 31, 2019     rdevnoah         deleteChild, deleteParent 구현완료
 * </pre>
 */
@RestController("adminCategoryAPIController")
@RequestMapping("/api/admin/category")
public class AdminCategoryController {

	@Autowired
	private AdminCategoryService adminCategoryService;
	
	@ApiOperation(value="get Category List", notes = "카테고리 리스트 가져오기")
	@GetMapping
	public JSONResult getList() {
		List<CategoryVo> list = adminCategoryService.getList();

		return JSONResult.success(list);
	}



	@ApiOperation(value = "add parent category", notes = "상위 카테고리 등록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="vo", value="카테고리", required=true, dataType="CategoryVo", defaultValue="")
	})
	@PutMapping
	public JSONResult add(@RequestBody @Valid CategoryVo vo, BindingResult result) {
		
		if (result.hasErrors()) {
			// 에러 메세지 확인
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				System.out.println("Validation Error : " + error);
				return JSONResult.fail("invalid Data");
			}
		}

		vo = adminCategoryService.addParentCategory(vo);
		return JSONResult.success(vo);
	}


	@ApiOperation(value = "add child category", notes = "하위 카테고리 등록")
	@ApiImplicitParams({
			@ApiImplicitParam(name="vo", value="카테고리", required=true, dataType="CategoryVo", defaultValue=""),
			@ApiImplicitParam(name="parentCategoryNo", value="상위카테고리번호", required=true, dataType="String", defaultValue=""),
	})
	@PutMapping("/{no}")
	public JSONResult add(@RequestBody @Valid CategoryVo vo, @PathVariable(value = "no") Long parentCategoryNo, BindingResult result){
		if (result.hasErrors()) {
			// 에러 메세지 확인
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				System.out.println("Validation Error : " + error);
				return JSONResult.fail("invalid Data");
			}
		}

		vo.setParentNo(parentCategoryNo);
		vo = adminCategoryService.addChildCategory(vo);

		return JSONResult.success(vo);
	}


	@ApiOperation(value = "delete child category", notes = "카테고리 삭제")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="삭제할 child 카테고리 번호", required=true, dataType="long", defaultValue="")
	})
	@DeleteMapping("/child/{no}")
	public JSONResult deleteChild(@PathVariable(value = "no") Long no) {

		adminCategoryService.deleteChild(no);

		return JSONResult.success("success");
	}

	@ApiOperation(value = "delete parent category", notes = "카테고리 삭제")
	@ApiImplicitParams({
			@ApiImplicitParam(name="no", value="삭제할 parent 카테고리 번호", required=true, dataType="long", defaultValue="")
	})
	@DeleteMapping("/parent/{no}")
	public JSONResult deleteParent(@PathVariable(value = "no") Long no) {

		adminCategoryService.deleteParent(no);

		//카테고리 상품 미지정 카테고리로 이동

		return JSONResult.success("success");
	}
	
}
