package com.cafe24.noahshop.service.impl;


import com.cafe24.noahshop.exception.StockException;
import com.cafe24.noahshop.repository.StockDao;
import com.cafe24.noahshop.service.StockService;
import com.cafe24.noahshop.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockDao stockDao;

    @Override
    public void checkStock(OrderVo vo) throws StockException {
        int stock = stockDao.checkStock(vo);
        if (stock < 0){
            throw new StockException("재고가 부족합니다.");
        }
    }
}
