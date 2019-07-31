package com.cafe24.noahshop.repository.impl;

import com.cafe24.noahshop.repository.AdminCategoryDao;
import com.cafe24.noahshop.vo.CategoryVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class AdminCategoryDaoImpl implements AdminCategoryDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public CategoryVo addParentCategory(CategoryVo vo) {
        sqlSession.insert("category.insertParent", vo);
        return vo;
    }

    @Override
    public CategoryVo addChildCategory(CategoryVo vo) {
        sqlSession.insert("category.insertChild", vo);
        return vo;
    }

    @Override
    public List<CategoryVo> getList() {
        return sqlSession.selectList("category.getList");
    }

    @Override
    public boolean deleteChild(Long no) {
        return sqlSession.delete("category.deleteChild", no) != 0;
    }

    @Override
    public List<Long> getChildCategoryByParentNo(Long no) {
        return sqlSession.selectList("category.getChildCategoryByParentNo", no);
    }

    @Override
    public boolean deleteChildList(Long no) {
        sqlSession.delete("category.deleteChildCategoryByParentNo", no);
        return true;
    }

    @Override
    public boolean deleteParent(Long no) {
        sqlSession.delete("category.deleteParent", no);
        return true;
    }
}
