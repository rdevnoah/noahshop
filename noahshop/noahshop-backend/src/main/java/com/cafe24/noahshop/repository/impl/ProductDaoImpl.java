package com.cafe24.noahshop.repository.impl;

import com.cafe24.noahshop.dto.OrderDto;
import com.cafe24.noahshop.dto.ProductDto;
import com.cafe24.noahshop.repository.ProductDao;
import com.cafe24.noahshop.vo.ImageVo;
import com.cafe24.noahshop.vo.OptionVo;
import com.cafe24.noahshop.vo.ProductDetailVo;
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

    @Override
    public List<ImageVo> getProductImageListByNo(Long no) {
        return sqlSession.selectList("product.getImageListByNo", no);
    }

    @Override
    public List<OptionVo> getOption2(Long productNo, Long option1No) {
        Map<String, Long> map = new HashMap<>();
        map.put("productNo", productNo);
        map.put("option1No", option1No);
        return sqlSession.selectList("product.getOption2", map);

    }

    @Override
    public List<ProductDetailVo> getProductDetailByProductNo(Long no) {
        List<ProductDetailVo> list = sqlSession.selectList("product.getProductDetailByProductNo", no);
        return list;
    }

    @Override
    public List<ProductDto> getCartListByProductDetailVo(List<ProductDetailVo> list) {
        Map<String, Object> map = new HashMap<>();
        map.put("productDetail", list);
        List<ProductDto> result = sqlSession.selectList("product.getCartListByProductDetailVo", map);


        for (int i=0 ; i<list.size() ; i++){
            result.get(i).setStock(list.get(i).getStock());
        }

        return result;
    }

    @Override
    public List<ProductDto> getProductListByOrderDtoList(List<OrderDto> cartList) {
        Map<String, Object> map = new HashMap<>();
        map.put("productDetailNo", cartList.get(0).getMemberNo());
        map.put("cartList", cartList);
        List<ProductDto> result = sqlSession.selectList("product.getProductListByOrderDtoList", map);

        for (int i=0 ; i< cartList.size() ; i++){
            result.get(i).setStock(cartList.get(i).getStock());
        }

        return result;

    }
}
