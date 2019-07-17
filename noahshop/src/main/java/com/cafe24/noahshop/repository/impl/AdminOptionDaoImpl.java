package com.cafe24.noahshop.repository.impl;

import com.cafe24.noahshop.repository.AdminOptionDao;
import com.cafe24.noahshop.vo.OptionVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminOptionDaoImpl implements AdminOptionDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public OptionVo addParentOption(OptionVo vo) {
        sqlSession.insert("option.insertParent", vo);
        return vo;
    }

    @Override
    public OptionVo addChildOption(OptionVo vo) {
        sqlSession.insert("option.insertChild", vo);
        return vo;
    }
}
