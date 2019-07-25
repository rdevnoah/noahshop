package com.cafe24.noahshop.service.impl;

import com.cafe24.noahshop.repository.OptionDao;
import com.cafe24.noahshop.repository.ProductDao;
import com.cafe24.noahshop.service.ProductService;
import com.cafe24.noahshop.vo.OptionVo;
import com.cafe24.noahshop.vo.ProductVo;
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

    @Transactional
    @Override
    public Map<String, Object> getProductDetail(Long no) {
        Map<String, Object> map = new HashMap<>();

        // product 정보
        // product Detail 정보
        // product image 정보

        ProductVo productVo = productDao.getProductByNo(no);
        map.put("productDetail", productVo);
        // option 정보
        List<OptionVo> optionList = optionDao.getOptionListByProductNo(no);

        map.put("optionList", optionList);


        //Todo: getImage in getProductDetail();
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
    public Map<String, Object> getMain() {
        return null;
    }
}