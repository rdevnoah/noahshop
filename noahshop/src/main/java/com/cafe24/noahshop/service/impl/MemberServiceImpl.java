package com.cafe24.noahshop.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.noahshop.repository.MemberDao;
import com.cafe24.noahshop.service.MemberService;
import com.cafe24.noahshop.vo.MemberVo;

/**
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.service.impl
 * @filename : MemberServiceImpl.java
 * @author : rdevnoah
 * @since : Jul 16, 2019
 * @version : 1.0
 * @see
 * 
 *      <pre>
 * == Modification Information ==
 * 
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * Jul 16, 2019     rdevnoah         Initialize
 * Jul 16, 2019     rdevnoah         insert test
 * Jul 16, 2019     rdevnoah         insert test (encrypt, decrypt)
 *      </pre>
 */
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	@Override
	public boolean checkId(String id) {
		boolean isModify = true;
		// dao
		return isModify;
	}

	@Transactional
	@Override
	public MemberVo joinMember(MemberVo vo) {
		// make random key;
		String key = RandomStringUtils.randomAlphanumeric(16);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key", key);
		map.put("member", vo);
		vo.setKey(key);
		MemberVo joinUser = memberDao.insert(vo);
		memberDao.insertKey(map);
		return joinUser;
	}

	@Override
	public MemberVo getMemberByNo(Long no) {
		String key = memberDao.getKeyByNo(no);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("key", key);
		MemberVo vo = memberDao.getMemberByNo(map);
		return vo;
	}

}
