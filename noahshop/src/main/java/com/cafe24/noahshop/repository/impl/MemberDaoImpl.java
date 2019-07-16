package com.cafe24.noahshop.repository.impl;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.noahshop.repository.MemberDao;
import com.cafe24.noahshop.vo.MemberVo;

/**
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.repository.impl
 * @filename : MemberDaoImpl.java
 * @author : rdevnoah
 * @since : Jul 16, 2019
 * @version : 1.0
 * @see 
 * 
 * <pre>
 * == Modification Information ==
 * 
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * Jul 16, 2019     rdevnoah         Initialize
 * Jul 16, 2019     rdevnoah         insert test
 * Jul 16, 2019     rdevnoah         test data ENCRYPT, DECRYPT
 * </pre>
 */
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
	public String getKeyByNo(Long no) {
		return sqlSession.selectOne("member.getKeyByNo", no);
	}
	
}
