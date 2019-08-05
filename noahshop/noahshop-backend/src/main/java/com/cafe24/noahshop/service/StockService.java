package com.cafe24.noahshop.service;

import com.cafe24.noahshop.exception.StockException;
import com.cafe24.noahshop.vo.OrderVo;

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
 * 2019-07-30       rdevnoah         Initialize
 * 2019-07-30       rdevnoah         checkStock 구현 완료
 *
 * </pre>
 * @since : 2019-07-30
 */
public interface StockService {

    void checkStock(OrderVo vo) throws StockException;
}
