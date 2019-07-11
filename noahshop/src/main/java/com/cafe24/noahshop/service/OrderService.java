package com.cafe24.noahshop.service;

import org.springframework.stereotype.Service;

import com.cafe24.noahshop.vo.OrderVo;

@Service
public interface OrderService {

	String addOrder(OrderVo vo);

}
