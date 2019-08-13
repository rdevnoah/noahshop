package com.cafe24.noahshop.service.impl;

import com.cafe24.noahshop.dto.OrderDto;
import com.cafe24.noahshop.repository.MemberDao;
import com.cafe24.noahshop.repository.OrderDao;
import com.cafe24.noahshop.repository.ProductDao;
import com.cafe24.noahshop.repository.StockDao;
import com.cafe24.noahshop.service.OrderService;
import com.cafe24.noahshop.vo.DeliveryVo;
import com.cafe24.noahshop.vo.MemberVo;
import com.cafe24.noahshop.vo.OrderVo;
import com.cafe24.noahshop.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StockDao stockDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private MemberDao memberDao;

    @Transactional
    @Override
    public OrderVo addOrder(OrderVo vo) {

        // 재고 확인을 통해 재고에서 구매량 뺀 값이 0보다 작으면 return error. (throw transaction?)

        //todo: code Generate

        vo.setOrderCode(orderCodeGenerator(vo.getBuyerTel()));
        //1. order 테이블 insert
        vo = orderDao.addOrder(vo);

        //2. order_product 테이블 insert
        vo = orderDao.addOrderProduct(vo);

        //3. delivery 테이블 insert
        DeliveryVo deliveryVo = new DeliveryVo();
        deliveryVo.setNo(vo.getNo());
        deliveryVo.setName(vo.getBuyerName());
        deliveryVo.setAddress(vo.getAddress());
        deliveryVo.setMessage(vo.getMessage());
        deliveryVo.setStatus("배송준비중");
        deliveryVo.setTel(vo.getBuyerTel());

        deliveryVo = orderDao.addDelivery(deliveryVo);

        stockDao.updateStock(vo);

        return vo;
    }


    @Override
    public String orderCodeGenerator(String tel) {
        String result = "GeneratedCode";
        return result;
    }

    @Override
    public Map<String, Object> getOrderForm(Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();

        String key = memberDao.getKeyByNo((Long)params.get("memberNo"));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("no", (Long)params.get("memberNo"));
        map.put("key", key);
        MemberVo vo = memberDao.getMemberByNo(map);
        result.put("memberInfo", vo);

        List<ProductVo> productList = productDao.getProductListByOrderDtoList((List<OrderDto>) params.get("cartList"));
        result.put("productList", productList);
        int cost = 0;
        for (ProductVo pvo : productList){
            cost += pvo.getPrice() * pvo.getOptionStockVo().get(0).getStock();
        }
        result.put("totalPrice", cost);

        return result;
    }
}
