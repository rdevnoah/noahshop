package com.cafe24.noahshop.repository.impl;

import com.cafe24.noahshop.repository.OrderDao;
import com.cafe24.noahshop.vo.DeliveryVo;
import com.cafe24.noahshop.vo.OrderVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        sqlSession.insert("order.insertOrderProduct", vo);
        return vo;
    }

    @Override
    public DeliveryVo addDelivery(DeliveryVo vo) {
        sqlSession.insert("order.insertDelivery", vo);
        return vo;
    }
}
