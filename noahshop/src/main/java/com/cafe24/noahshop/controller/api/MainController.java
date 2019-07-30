package com.cafe24.noahshop.controller.api;

import com.cafe24.noahshop.dto.JSONResult;
import com.cafe24.noahshop.service.MainService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.controller.api
 * @filename : MainController.java
 * @author : rdevnoah
 * @since : Jul 11, 2019
 * @version : 1.0
 * @see 
 * 
 * <pre>
 * == Modification Information ==
 * 
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * Jul 11, 2019     rdevnoah         Initialize
 * </pre>
 */
@RestController
@RequestMapping({ "/", "" })
public class MainController {

	@Autowired
	private MainService mainService;
	
	@ApiOperation(value="get main page", notes = "메인화면 가져오기")
	@GetMapping
	public JSONResult main() {
		// --------- 한 service에서 다른 repository에서 가져와서 한번에 도착
		// 진열상품목록 get
		// 주문횟수랭킹상품목록
		// 등록일기준 상품목록
		// 카테고리목록
		Map<String, Object> map = mainService.getMain();
		return JSONResult.success(map);
	}
}
