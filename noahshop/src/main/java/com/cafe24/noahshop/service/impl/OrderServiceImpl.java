package com.cafe24.noahshop.service.impl;

import com.cafe24.noahshop.repository.OrderDao;
import com.cafe24.noahshop.repository.StockDao;
import com.cafe24.noahshop.service.OrderService;
import com.cafe24.noahshop.vo.DeliveryVo;
import com.cafe24.noahshop.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StockDao stockDao;

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
}
