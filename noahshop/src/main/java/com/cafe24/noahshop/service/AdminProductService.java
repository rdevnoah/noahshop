package com.cafe24.noahshop.service;

import com.cafe24.noahshop.dto.ProductAddDto;

public interface AdminProductService {
    boolean addProductNoOption(ProductAddDto dto);

    boolean addProduct(ProductAddDto dto);
}
