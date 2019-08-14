package com.cafe24.noahshop.service;

import com.cafe24.noahshop.dto.ProductDto;
import com.cafe24.noahshop.vo.CartVo;
import com.cafe24.noahshop.vo.ProductDetailVo;
import com.cafe24.noahshop.vo.ProductVo;

import java.util.List;

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
 * 2019-07-31       rdevnoah         Initialize
 * 2019-07-31       rdevnoah         addCart 구현 완료
 * 2019-07-31       rdevnoah         fetchCartByNo 구현 완료
 *
 * </pre>
 * @since : 2019-07-31
 */
public interface CartService {


	boolean addCart(CartVo vo);

    String fetchCartByNo(Long no);

    List<ProductDto> getCartListByProductDetailVo(List<ProductDetailVo> list);
}
