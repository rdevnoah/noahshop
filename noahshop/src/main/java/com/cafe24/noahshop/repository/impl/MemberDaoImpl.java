package com.cafe24.noahshop.repository.impl;

import com.cafe24.noahshop.repository.MemberDao;
import com.cafe24.noahshop.vo.MemberVo;
import com.cafe24.noahshop.vo.OrderVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


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
	public boolean insertKey(Map<String, Object> map) {
		return sqlSession.insert("member.insertKey", map) == 1;
	}

	@Override
	public boolean deleteAllKey() {
		return sqlSession.delete("member.deleteAllKey") == 1;
	}

	@Override
	public void deleteAll() {
		sqlSession.delete("member.deleteAll");
		
	}

	@Override
	public MemberVo getMemberByNo(Map<String, Object> map) {
		return sqlSession.selectOne("member.getMemberByNo", map);
	}
	
	@Override
	public String checkId(String id) {
		return sqlSession.selectOne("member.checkId", id);
	}

    @Override
    public List<OrderVo> getOrderListById(Long no) {

		return sqlSession.selectList("member.getOrderListById", no);
    }

    @Override
    public void updateMember(Map<String, Object> map) {
        sqlSession.update("member.updateMember", map);
    }

    @Override
    public OrderVo getOrderByNoMember(Map<String, Object> map) {

		return sqlSession.selectOne("member.getOrderByNoMember", map);
    }

    @Override
	public String getKeyByNo(Long no) {
		return sqlSession.selectOne("member.getKeyByNo", no);
	}
	
}
