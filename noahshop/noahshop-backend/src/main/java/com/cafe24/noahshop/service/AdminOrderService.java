package com.cafe24.noahshop.service;

import com.cafe24.noahshop.vo.OrderVo;

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
 * 2019-07-30       rdevnoah         Initialize
 * 2019-07-30       rdevnoah         getOrderList 구현완료
 * 2019-07-30       rdevnoah         getDetailByNo 구현완료
 *
 * </pre>
 * @since : 2019-07-30
 */
public interface AdminOrderService {
    List<OrderVo> getOrderList();

    Map<String, Object> getDetailByNo(Long no);
}
