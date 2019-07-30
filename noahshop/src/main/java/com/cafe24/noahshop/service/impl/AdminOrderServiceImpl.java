package com.cafe24.noahshop.service.impl;

import com.cafe24.noahshop.dto.OrderProductDetailDto;
import com.cafe24.noahshop.repository.AdminOrderDao;
import com.cafe24.noahshop.service.AdminOrderService;
import com.cafe24.noahshop.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminOrderServiceImpl implements AdminOrderService {

    @Autowired
    private AdminOrderDao adminOrderDao;

    @Override
    public List<OrderVo> getOrderList() {
        return adminOrderDao.getOrderList();
    }

    @Override
    public Map<String, Object> getDetailByNo(Long no) {
        Map<String, Object> map = new HashMap<>();

        // 주문한 상품 상세정보 : order_product, product_detail
        List<OrderProductDetailDto> productDetailDto = adminOrderDao.getDetailByNo(no);
        map.put("productList", productDetailDto);


        return map;
    }
}
