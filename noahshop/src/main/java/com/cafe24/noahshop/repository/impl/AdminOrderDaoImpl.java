package com.cafe24.noahshop.repository.impl;

import com.cafe24.noahshop.dto.OrderProductDetailDto;
import com.cafe24.noahshop.repository.AdminOrderDao;
import com.cafe24.noahshop.vo.OrderVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminOrderDaoImpl implements AdminOrderDao {

    @Autowired
    private SqlSessionTemplate sqlSession;
    @Override
    public List<OrderVo> getOrderList() {
        return sqlSession.selectList("adminOrder.getList");
    }

    @Override
    public List<OrderProductDetailDto> getDetailByNo(Long no) {
        return sqlSession.selectList("adminOrder.getDetailByNo", no);
    }
}
