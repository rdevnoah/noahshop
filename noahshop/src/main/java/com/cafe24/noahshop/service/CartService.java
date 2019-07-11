package com.cafe24.noahshop.service;

import com.cafe24.noahshop.vo.ProductVo;

public interface CartService {

	boolean addCart(ProductVo vo, String sessionid);

}
