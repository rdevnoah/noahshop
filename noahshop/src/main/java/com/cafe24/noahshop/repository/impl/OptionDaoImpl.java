package com.cafe24.noahshop.repository.impl;

import com.cafe24.noahshop.repository.OptionDao;
import com.cafe24.noahshop.vo.OptionVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OptionDaoImpl implements OptionDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<OptionVo> getOptionListByProductNo(Long no) {
        return sqlSession.selectList("option.getListByProductNo", no);
    }
}
