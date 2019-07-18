package com.cafe24.noahshop.repository.impl;

import com.cafe24.noahshop.repository.AdminCategoryDao;
import com.cafe24.noahshop.vo.CategoryVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
 * 2019-07-18       rdevnoah         Initialize
 * 2019-07-18       rdevnoah         add add category implement
 *
 * </pre>
 * @since : 2019-07-18
 */
@Repository
public class AdminCategoryDaoImpl implements AdminCategoryDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public CategoryVo addParentCategory(CategoryVo vo) {
        sqlSession.insert("category.insertParent", vo);
        return vo;
    }
}
