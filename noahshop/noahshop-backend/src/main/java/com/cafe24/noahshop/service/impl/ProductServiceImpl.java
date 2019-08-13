package com.cafe24.noahshop.service.impl;

import com.cafe24.noahshop.repository.CategoryDao;
import com.cafe24.noahshop.repository.OptionDao;
import com.cafe24.noahshop.repository.ProductDao;
import com.cafe24.noahshop.service.ProductService;
import com.cafe24.noahshop.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private OptionDao optionDao;

    @Autowired
    private CategoryDao categoryDao;

    @Transactional
    @Override
    public Map<String, Object> getProductDetail(Long no) {
        Map<String, Object> map = new HashMap<>();

        // product 정보
        // product Detail 정보
        // product image 정보

        ProductVo productVo = productDao.getProductByNo(no);
        map.put("productDetail", productVo);

        List<ProductDetailVo> details = productDao.getProductDetailByProductNo(no);
        map.put("details", details);

        // option 정보
        List<OptionVo> optionList = optionDao.getOptionListByProductNo(no);

        map.put("optionList", optionList);

        // get ImageList
        List<ImageVo> imageList = productDao.getProductImageListByNo(no);

        map.put("imageList", imageList);

        return map;
    }


    @Transactional
    @Override
    public Map<String, Object> getListByCategoryNo(Long categoryNo) {
        Map<String, Object> map = new HashMap<>();
        List<ProductVo> productList = productDao.getProductListByCategoryNo(categoryNo);
        map.put("productList", productList);

        List<CategoryVo> categoryList = categoryDao.getCategory();
        map.put("categoryList", categoryList);

        return map;
    }

    @Override
    public Map<String, Object> searchByKeyword(String keyword) {
        return null;
    }

    @Override
    public List<ProductVo> searchByKeywordInCategory(String keyword, Long categoryNo) {
        return null;
    }

    @Override
    public List<OptionVo> getOption2(Long productNo, Long option1No) {
        List<OptionVo> list = productDao.getOption2(productNo, option1No);
        return list;
    }


}
