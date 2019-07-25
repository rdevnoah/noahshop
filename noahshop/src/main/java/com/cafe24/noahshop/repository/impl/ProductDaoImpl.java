package com.cafe24.noahshop.repository.impl;

import com.cafe24.noahshop.repository.ProductDao;
import com.cafe24.noahshop.vo.ProductVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public ProductVo getProductByNo(Long no) {
        return sqlSession.selectOne("product.getProductByNo", no);
    }
}
