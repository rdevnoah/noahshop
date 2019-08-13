package com.cafe24.noahshop.repository;

import com.cafe24.noahshop.vo.ImageVo;
import com.cafe24.noahshop.vo.OptionVo;
import com.cafe24.noahshop.vo.ProductDetailVo;
import com.cafe24.noahshop.vo.ProductVo;

import java.util.List;

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
 * 2019-07-25       rdevnoah         Initialize
 * 2019-07-29       rdevnoah         상품 상세정보가져오기 완료
 * 2019-07-30       rdevnoah         메인 상품 리스트 가져오기 완료
 * 2019-07-30       rdevnoah         상품 리스트 가져오기 완료
 * 2019-07-30       rdevnoah         카테고리 번호 별 상품 리스트 가져오기 완료
 * 2019-07-31       rdevnoah         category 삭제하기 위해 미지정으로 cagetory_no 변경
 *
 * </pre>
 * @since : 2019-07-25
 */
public interface ProductDao {
    ProductVo getProductByNo(Long no);


    List<ProductVo> getMainProduct();

    List<ProductVo> getProductList();

    List<ProductVo> getProductListByCategoryNo(Long categoryNo);

    int getCountByCategoryNo(Long no);

    boolean updateCategoryNoForDeleteCategory(Long no);

    boolean updateCategoryNoForDeleteParentCategory(List<Long> childNo);

    List<ImageVo> getProductImageListByNo(Long no);

    List<OptionVo> getOption2(Long productNo, Long option1No);

    List<ProductDetailVo> getProductDetailByProductNo(Long no);

    List<ProductVo> getCartListByProductDetailVo(List<ProductDetailVo> list);
}
