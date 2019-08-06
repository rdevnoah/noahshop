package com.cafe24.noahshop.service.impl;

import com.cafe24.noahshop.repository.CategoryDao;
import com.cafe24.noahshop.repository.ProductDao;
import com.cafe24.noahshop.service.MainService;
import com.cafe24.noahshop.vo.CategoryVo;
import com.cafe24.noahshop.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryDao categoryDao;

    @Transactional
    @Override
    public Map<String, Object> getMain() {

        Map<String, Object> map = new HashMap<>();

        //진열상품
        List<ProductVo> mainProduct = productDao.getMainProduct();
        map.put("mainProductList", mainProduct);

        //나머지 상품
        List<ProductVo> productList = productDao.getProductList();
        map.put("productList", productList);

        //카테고리목록
        List<CategoryVo> categoryList = categoryDao.getCategory();
        map.put("categoryList", categoryList);
        return map;
    }
}
