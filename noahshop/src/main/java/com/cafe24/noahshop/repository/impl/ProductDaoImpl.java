package com.cafe24.noahshop.repository.impl;

import com.cafe24.noahshop.repository.ProductDao;
import com.cafe24.noahshop.vo.ProductVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public ProductVo getProductByNo(Long no) {
        return sqlSession.selectOne("product.getProductByNo", no);
    }

    @Override
    public List<ProductVo> getMainProduct() {
        return sqlSession.selectList("product.getMainProduct");
    }

    @Override
    public List<ProductVo> getProductList() {
        return sqlSession.selectList("product.getProductList");
    }
}
