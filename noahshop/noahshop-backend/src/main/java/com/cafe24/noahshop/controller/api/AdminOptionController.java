package com.cafe24.noahshop.controller.api;

import com.cafe24.noahshop.dto.JSONResult;
import com.cafe24.noahshop.service.AdminOptionService;
import com.cafe24.noahshop.vo.OptionVo;
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
 * @filename : AdminOptionController.java
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
 * Jul 17, 2019     rdevnoah         add parent, child option complete
 * Jul 18, 2019     rdevnoah         add parent, child option 수정
 * </pre>
 */
@RestController("adminOptionAPIController")
@RequestMapping("/api/admin/option")
public class AdminOptionController {

	@Autowired
	private AdminOptionService adminOptionService;


	@ApiOperation(value = "add parent option", notes = "상위 옵션 등록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="vo", value="옵션", required=true, dataType="OptionVo", defaultValue="")
	})
	@PutMapping
	public JSONResult add(@RequestBody @Valid OptionVo vo, BindingResult result) {
		if (result.hasErrors()) {
			// 에러 메세지 확인
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				System.out.println("Validation Error : " + error);
				return JSONResult.fail("invalid Data");
			}
		}

		OptionVo addResult = adminOptionService.addParentOption(vo);

		return JSONResult.success(addResult);
	}

	@ApiOperation(value = "add child option", notes = "하위 옵션 등록")
	@ApiImplicitParams({
			@ApiImplicitParam(name="vo", value="옵션", required=true, dataType="OptionVo", defaultValue=""),
			@ApiImplicitParam(name="no", value="상위옵션 번호", required=true, dataType="long", defaultValue="")
	})
	@PutMapping("/{no}")
	public JSONResult add(@RequestBody @Valid OptionVo vo, @PathVariable(value = "no") Long parentNo, BindingResult result){
		if (result.hasErrors()) {
			// 에러 메세지 확인
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				System.out.println("Validation Error : " + error);
				return JSONResult.fail(error.getDefaultMessage());
			}
		}
		vo.setParentNo(parentNo);
		OptionVo addResult = adminOptionService.addChildOption(vo);

		return JSONResult.success(parentNo);
	}
	
	@ApiOperation(value = "modify option", notes = "옵션 정보 변경")
	@ApiImplicitParams({
		@ApiImplicitParam(name="vo", value="변경할 옵션 정보", required=true, dataType="OptionVo", defaultValue="")
	})
	@PostMapping
	public JSONResult modify(@RequestBody OptionVo vo) {
		
		// modify
		return JSONResult.success(vo);
	}
	
	@ApiOperation(value = "delete option", notes = "옵션 삭제")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="삭제할 옵션 번호", required=true, dataType="long", defaultValue="")
	})
	@DeleteMapping("/{no}")
	public JSONResult delete(@PathVariable(value = "no") Long no) {

		//delete
		
		//카테고리 상품 미지정 카테고리로 이동
		
		return JSONResult.success(no);
	}
}
