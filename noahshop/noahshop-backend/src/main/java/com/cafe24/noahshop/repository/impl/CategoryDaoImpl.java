package com.cafe24.noahshop.repository.impl;

import com.cafe24.noahshop.repository.CategoryDao;
import com.cafe24.noahshop.vo.CategoryVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
 * 2019-07-30       rdevnoah         Initialize
 *
 * </pre>
 * @since : 2019-07-30
 */
@Repository
public class CategoryDaoImpl implements CategoryDao {
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<CategoryVo> getCategory() {
        return sqlSession.selectList("category.getCategoryList");
    }
}
