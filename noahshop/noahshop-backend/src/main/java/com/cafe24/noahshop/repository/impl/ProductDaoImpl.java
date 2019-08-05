package com.cafe24.noahshop.repository.impl;

import com.cafe24.noahshop.repository.ProductDao;
import com.cafe24.noahshop.vo.ProductVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @Override
    public List<ProductVo> getProductListByCategoryNo(Long categoryNo) {
        return sqlSession.selectList("product.getProductListByCategoryNo", categoryNo);
    }

    @Override
    public int getCountByCategoryNo(Long no) {
        return sqlSession.selectOne("product.getCountByCategoryNo", no);

    }

    @Override
    public boolean updateCategoryNoForDeleteCategory(Long no) {

        return sqlSession.update("product.updateCategoryNoForDelete", no) != 0;
    }

    @Override
    public boolean updateCategoryNoForDeleteParentCategory(List<Long> childNo) {
        Map<String, Object> map = new HashMap<>();
        map.put("noList", childNo);
        sqlSession.update("product.updateCategoryNoForDeleteParentCategory", map);
        return true;
    }
}
