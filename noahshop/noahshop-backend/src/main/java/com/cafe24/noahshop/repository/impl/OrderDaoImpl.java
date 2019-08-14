package com.cafe24.noahshop.repository.impl;

import com.cafe24.noahshop.repository.OrderDao;
import com.cafe24.noahshop.vo.DeliveryVo;
import com.cafe24.noahshop.vo.OrderVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public OrderVo addOrder(OrderVo vo) {
        sqlSession.insert("order.insertOrder", vo);
        return vo;
    }

    @Override
    public OrderVo addOrderProduct(OrderVo vo) {
        Map<String, Object> map = new HashMap<>();
        map.put("vo", vo);
        map.put("orderProductList", vo.getOrderProductList());
        sqlSession.insert("order.insertOrderProduct", map);
        return vo;
    }

    @Override
    public DeliveryVo addDelivery(DeliveryVo vo) {
        sqlSession.insert("order.insertDelivery", vo);
        return vo;
    }
}
