package com.cafe24.noahshop.service.impl;

import com.cafe24.noahshop.repository.MemberDao;
import com.cafe24.noahshop.service.MemberService;
import com.cafe24.noahshop.vo.MemberVo;
import com.cafe24.noahshop.vo.OrderVo;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	@Override
	public boolean checkId(String id) {
		String isModify = memberDao.checkId(id);
		// 비어있으면 아이디 중복 아닌 것.
		return isModify != null;
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
	
	@Transactional
	@Override
	public MemberVo getMemberByNo(Long no) {
		String key = memberDao.getKeyByNo(no);
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("no", no);
		map.put("key", key);
		return memberDao.getMemberByNo(map);
	}

    @Override
    public List<OrderVo> getOrderListById(Long no) {
        List<OrderVo> orderList = memberDao.getOrderListById(no);
		return orderList;
    }

    @Override
    public void updateMember(MemberVo vo) {
		Map<String, Object> map = new HashMap<>();
		String key = memberDao.getKeyByNo(vo.getNo());
		map.put("key", key);
		map.put("vo", vo);
        memberDao.updateMember(map);
    }

	@Override
	public OrderVo getOrderByNoUser(String code, String password) {
		Map<String, Object> map = new HashMap<>();
		map.put("code", code);
		map.put("password", password);
		return memberDao.getOrderByNoMember(map);
	}

}
