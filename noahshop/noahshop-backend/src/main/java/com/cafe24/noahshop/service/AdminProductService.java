package com.cafe24.noahshop.service;

import com.cafe24.noahshop.dto.ProductAddDto;
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
 * 2019-07-23       rdevnoah         Initialize
 * 2019-07-23       rdevnoah         add product (option, no option 구현 완료)
 * 2019-07-30       rdevnoah         getList, getDetail 구현완료
 * 2019-07-31       rdevnoah         getDetailForModify 구현완료
 * 2019-07-31       rdevnoah         modify (재고수량변경) 구현완료
 * 2019-07-31       rdevnoah         getDpMainProductList 구현완료
 * 2019-07-31       rdevnoah         addDpMainProduct 구현완료
 * 2019-07-31       rdevnoah         deleteDpMainProduct 구현완료
 *
 * </pre>
 * @since : 2019-07-23
 */
public interface AdminProductService {
    boolean addProductNoOption(ProductAddDto dto);

    boolean addProduct(ProductAddDto dto);

    List<ProductVo> getList();

    Map<String, Object> getDetailByNo(Long no);

    ProductAddDto getProductDetailForModify(Long no);

    boolean updateProductStock(ProductAddDto dto);

    List<ProductVo> getDpMainList();

    boolean addDpMainProduct(List<Long> noList);

    boolean deleteDpMainProduct(List<Long> noList);

    Map<String, Object> getAddForm();

}
