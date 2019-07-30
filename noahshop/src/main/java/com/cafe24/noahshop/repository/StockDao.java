package com.cafe24.noahshop.repository;

import com.cafe24.noahshop.vo.OrderVo;

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
 * 2019-07-30       rdevnoah         Initialize
 * 2019-07-30       rdevnoah         checkStock 구현 완료
 * 2019-07-30       rdevnoah         updateStock 구현 완료
 *
 * </pre>
 * @since : 2019-07-30
 */
public interface StockDao {
    int checkStock(OrderVo vo);

    int updateStock(OrderVo vo);
}
