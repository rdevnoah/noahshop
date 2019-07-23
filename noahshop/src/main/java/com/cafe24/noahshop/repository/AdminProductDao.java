package com.cafe24.noahshop.repository;

import com.cafe24.noahshop.vo.ProductDetailVo;
import com.cafe24.noahshop.vo.ProductVo;

import java.util.List;
import java.util.Map;

public interface AdminProductDao {
    Long addProduct(ProductVo vo);

    boolean addImage(Map<String, Object> image);

    boolean addProductDetail(List<ProductDetailVo> details);
}
