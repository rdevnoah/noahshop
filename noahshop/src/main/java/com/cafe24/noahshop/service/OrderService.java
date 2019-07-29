package com.cafe24.noahshop.service;

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
 * 2019-07-29       rdevnoah         Initialize
 * 2019-07-29       rdevnoah         addMemberOrder complete
 *
 * </pre>
 * @since : 2019-07-29
 */
public interface OrderService {
    OrderVo addMemberOrder(OrderVo vo);

    String orderCodeGenerator(String date);


}
