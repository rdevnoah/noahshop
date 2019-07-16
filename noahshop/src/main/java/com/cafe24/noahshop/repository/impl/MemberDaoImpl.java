package com.cafe24.noahshop.repository.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cafe24.noahshop.repository.MemberDao;
import com.cafe24.noahshop.vo.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public MemberVo insert(MemberVo vo) {
		sqlSession.insert("member.insert", vo);
		return vo;
	}

	@Override
	public void deleteAll() {
		sqlSession.delete("member.deleteAll");
		
	}

	@Override
	public MemberVo getMemberByNo(Long no) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean checkId(String id) {
		return true;
	}
	
}
