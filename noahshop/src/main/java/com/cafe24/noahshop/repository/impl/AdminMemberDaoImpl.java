package com.cafe24.noahshop.repository.impl;

import com.cafe24.noahshop.repository.AdminMemberDao;
import com.cafe24.noahshop.vo.MemberVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminMemberDaoImpl implements AdminMemberDao {

    @Autowired
    private SqlSessionTemplate sqlSession;
    @Override
    public List<MemberVo> getMemberList() {
        return sqlSession.selectList("adminMember.getMemberList");
    }

    @Override
    public  List<MemberVo> searchMemberById(String id) {
        return sqlSession.selectList("adminMember.searchMemberById", id);
    }
}
