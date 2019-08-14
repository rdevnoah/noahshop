package com.cafe24.noahshop.repository.impl;

import com.cafe24.noahshop.repository.StockDao;
import com.cafe24.noahshop.vo.OrderProductVo;
import com.cafe24.noahshop.vo.OrderVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StockDaoImpl implements StockDao {

    @Autowired
    private SqlSessionTemplate sqlSession;
    @Override
    public int checkStock(OrderProductVo vo) {

        System.out.println(vo.getProductDetailNo() + ":::::::::::::::::::::::" + vo.getQuantity());

        return sqlSession.selectOne("stock.checkStockFromOrder", vo);
    }




    @Override
    public int updateStock(OrderVo vo) {
        Map<String, Object> map = new HashMap<>();
        map.put("orderProductList", vo.getOrderProductList());
        return sqlSession.update("stock.updateStockFromOrder", map);
    }
}
