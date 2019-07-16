package com.cafe24.noahshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.noahshop.repository.MemberDao;
import com.cafe24.noahshop.service.MemberService;
import com.cafe24.noahshop.vo.MemberVo;

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

	@Override
	public MemberVo joinMember(MemberVo vo) {
		return memberDao.insert(vo);
	}

}
