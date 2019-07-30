package com.cafe24.noahshop.repository.impl;

import com.cafe24.noahshop.repository.StockDao;
import com.cafe24.noahshop.vo.OrderVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StockDaoImpl implements StockDao {

    @Autowired
    private SqlSessionTemplate sqlSession;
    @Override
    public int checkStock(OrderVo vo) {
        return sqlSession.selectOne("stock.checkStockFromOrder", vo);
    }

    @Override
    public int updateStock(OrderVo vo) {
        return sqlSession.update("stock.updateStockFromOrder", vo);
    }
}
