package com.cafe24.noahshop.repository.impl;

import com.cafe24.noahshop.repository.AdminOptionDao;
import com.cafe24.noahshop.vo.OptionVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.repository.impl
 * @author : rdevnoah
 * @since : 2019-07-17
 * @version : 1.0
 * @see <pre>
 * == Modification Information ==
 *
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * 2019-07-17       rdevnoah         Initialize
 * 2019-07-17       rdevnoah         add implement complete
 *
 * </pre>
 */
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