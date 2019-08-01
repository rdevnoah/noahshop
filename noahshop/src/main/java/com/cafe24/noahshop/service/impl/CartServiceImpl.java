package com.cafe24.noahshop.service.impl;


import com.cafe24.noahshop.repository.CartRepository;
import com.cafe24.noahshop.service.CartService;
import com.cafe24.noahshop.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public boolean addCart(CartVo vo) {
        // redis add
        cartRepository.save(vo);
        return false;
    }

    @Override
    public String fetchCartByNo(Long no) {
        Optional<CartVo> cartInfo = cartRepository.findById(no.toString());
        String info = cartInfo.orElse(new CartVo()).getProductInfo();

        return info;

    }
}
