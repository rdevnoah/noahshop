package com.cafe24.noahshop.service.impl;


import com.cafe24.noahshop.exception.StockException;
import com.cafe24.noahshop.repository.StockDao;
import com.cafe24.noahshop.service.StockService;
import com.cafe24.noahshop.vo.OrderProductVo;
import com.cafe24.noahshop.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockDao stockDao;

    @Override
    public void checkStock(OrderVo vo) throws StockException {

        for (OrderProductVo ovo : vo.getOrderProductList()){
            int stock = stockDao.checkStock(ovo);

            //Todo: 어떤 상품으 재고가 부족한지.
            if (stock < 0){
                throw new StockException("재고가 부족합니다.");
            }
        }


    }
}
