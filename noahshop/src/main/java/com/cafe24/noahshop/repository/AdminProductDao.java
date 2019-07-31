package com.cafe24.noahshop.repository;

import com.cafe24.noahshop.dto.ProductAddDto;
import com.cafe24.noahshop.vo.ProductDetailVo;
import com.cafe24.noahshop.vo.ProductVo;

import java.util.List;
import java.util.Map;

/**
 * @author : rdevnoah
 * @version : 1.0
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.repository
 * @see <pre>
 *
 * == Modification Information ==
 *
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * 2019-07-23       rdevnoah         Initialize
 * 2019-07-23       rdevnoah         add product, add image, add product Detail 구현완료
 * 2019-07-30       rdevnoah         getList, getProductByNo, getProductDetailByNo 구현완료
 * 2019-07-31       rdevnoah         getDetailForModify 구현완료
 * 2019-07-31       rdevnoah         modify (재고수량변경) 구현완료
 *
 * </pre>
 * @since : 2019-07-23
 */
public interface AdminProductDao {
    Long addProduct(ProductVo vo);

    boolean addImage(Map<String, Object> image);

    boolean addProductDetail(List<ProductDetailVo> details);

    List<ProductVo> getList();

    ProductVo getProductByNo(Long no);

    List<ProductDetailVo> getProductDetailByNo(Long no);

    ProductAddDto getProductDetailForModify(Long no);

    boolean updateProductStock(ProductAddDto dto);
}
