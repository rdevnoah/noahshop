package com.cafe24.noahshop.repository;

import com.cafe24.noahshop.vo.DeliveryVo;
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
 * 2019-07-29       rdevnoah         Initialize
 * 2019-07-29       rdevnoah         addOrder complete
 * 2019-07-29       rdevnoah         addOrderProduct complete
 * 2019-07-29       rdevnoah         addDelivery complete
 *
 * </pre>
 * @since : 2019-07-29
 */
public interface OrderDao {
    OrderVo addOrder(OrderVo vo);

    OrderVo addOrderProduct(OrderVo vo);

    DeliveryVo addDelivery(DeliveryVo vo);
}
