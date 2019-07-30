package com.cafe24.noahshop.controller.api;

import com.cafe24.noahshop.dto.JSONResult;
import com.cafe24.noahshop.service.AdminOrderService;
import com.cafe24.noahshop.vo.OrderVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : rdevnoah
 * @version : 1.0
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.controller.api
 * @see <pre>
 *
 * == Modification Information ==
 *
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * 2019-07-30       rdevnoah         Initialize
 * 2019-07-30       rdevnoah         getOrderList 구현완료
 *
 * </pre>
 * @since : 2019-07-30
 */
@RestController
@RequestMapping("/api/admin/order")
public class AdminOrderController {

    @Autowired
    private AdminOrderService adminOrderService;

    @ApiOperation(value = "get order list by admin", notes = "관리자 주문 리스트")
    @GetMapping("/list")
    public JSONResult getOrderList(){
        List<OrderVo> list = adminOrderService.getOrderList();
        return JSONResult.success(list);
    }

}
