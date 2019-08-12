package com.cafe24.noahshop.service;

import com.cafe24.noahshop.vo.OptionVo;
import com.cafe24.noahshop.vo.ProductVo;

import java.util.List;
import java.util.Map;

/**
 * @author : rdevnoah
 * @version : 1.0
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.service
 * @see <pre>
 *
 * == Modification Information ==
 *
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * 2019-07-25       rdevnoah         Initialize
 * 2019-07-25       rdevnoah         image 제외 get detail 완료
 * 2019-07-30       rdevnoah         getListByCategoryNo 구현 완료
 *
 * </pre>
 * @since : 2019-07-25
 */
public interface ProductService {
	Map<String, Object> getProductDetail(Long no);
	//Todo: getImage in getProductDetail();
    Map<String, Object> getListByCategoryNo(Long categoryNo);

	Map<String, Object> searchByKeyword(String keyword);

	List<ProductVo> searchByKeywordInCategory(String keyword, Long categoryNo);

    List<OptionVo> getOption2(Long productNo, Long option1No);
}
