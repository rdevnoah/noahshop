package com.cafe24.noahshop.service.impl;


import com.cafe24.noahshop.dto.ProductDto;
import com.cafe24.noahshop.repository.CartRepository;
import com.cafe24.noahshop.repository.ProductDao;
import com.cafe24.noahshop.service.CartService;
import com.cafe24.noahshop.service.ProductService;
import com.cafe24.noahshop.vo.CartVo;
import com.cafe24.noahshop.vo.ProductDetailVo;
import com.cafe24.noahshop.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductDao productDao;

    @Override
    public boolean addCart(CartVo vo) {
        // redis add
        cartRepository.save(vo);
        return true;
    }

    @Override
    public String fetchCartByNo(Long no) {
        Optional<CartVo> cartInfo = cartRepository.findById(no.toString());

        String info = cartInfo.orElse(new CartVo()).getProductInfo();

        return info;

    }

    @Override
    public List<ProductDto> getCartListByProductDetailVo(List<ProductDetailVo> list) {
        List<ProductDto> result = productDao.getCartListByProductDetailVo(list);

        return result;
    }
}
