package com.cafe24.noahshop.service.impl;

import com.cafe24.noahshop.repository.AdminOrderDao;
import com.cafe24.noahshop.service.AdminOrderService;
import com.cafe24.noahshop.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminOrderServiceImpl implements AdminOrderService {

    @Autowired
    private AdminOrderDao adminOrderDao;

    @Override
    public List<OrderVo> getOrderList() {
        return adminOrderDao.getOrderList();
    }
}
