package com.cafe24.noahshop.controller.api;

import com.cafe24.noahshop.dto.JSONResult;
import com.cafe24.noahshop.service.AdminOrderService;
import com.cafe24.noahshop.vo.OrderVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
 * 2019-07-30       rdevnoah         getDetailByNo 구현완료
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

    @ApiOperation(value = "get detail order by no", notes = "관리자 주문 리스트")
    @ApiImplicitParams({
            @ApiImplicitParam(name="no", value="상품번호", required=true, dataType="Long", defaultValue="")
    })
    @GetMapping("/detail/{no}")
    public JSONResult getDetailByNo(@PathVariable(value = "no") Long no){
        Map<String, Object> map = adminOrderService.getDetailByNo(no);

        return JSONResult.success(map);
    }


}
