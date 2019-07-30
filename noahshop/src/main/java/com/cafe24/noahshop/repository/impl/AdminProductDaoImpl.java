package com.cafe24.noahshop.repository.impl;

import com.cafe24.noahshop.dto.ProductAddDto;
import com.cafe24.noahshop.repository.AdminProductDao;
import com.cafe24.noahshop.vo.ProductDetailVo;
import com.cafe24.noahshop.vo.ProductVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : rdevnoah
 * @version : 1.0
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.repository.impl
 * @see <pre>
 *
 * == Modification Information ==
 *
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * 2019-07-23       rdevnoah         Initialize
 * 2019-07-23       rdevnoah         add product, add image, add product Detail 구현완료
 *
 * </pre>
 * @since : 2019-07-23
 */
@Repository
public class AdminProductDaoImpl implements AdminProductDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public Long addProduct(ProductVo vo) {
        sqlSession.insert("adminProduct.insertProduct", vo);
        return vo.getNo();
    }

    @Override
    public boolean addImage(Map<String, Object> image) {
        return sqlSession.insert("adminProduct.insertImage", image) != 0;
    }

    @Override
    public boolean addProductDetail(List<ProductDetailVo> details) {
        Map<String, Object> map = new HashMap<>();
        map.put("list", details);
        return sqlSession.insert("adminProduct.insertProductDetail", map) != 0;
    }

    @Override
    public List<ProductVo> getList() {

        return sqlSession.selectList("adminProduct.getList");
    }

    @Override
    public ProductVo getProductByNo(Long no) {
        return sqlSession.selectOne("adminProduct.getProductByNo", no);
    }

    @Override
    public List<ProductDetailVo> getProductDetailByNo(Long no) {
        return sqlSession.selectList("adminProduct.getProductDetailByNo", no);
    }

    @Override
    public ProductAddDto getProductDetailForModify(Long no) {

        return sqlSession.selectOne("adminProduct.getProductDetailForModify", no);
    }
}
