package com.cafe24.noahshop.service;

import org.springframework.stereotype.Service;

import com.cafe24.noahshop.vo.MemberVo;

@Service
public interface MemberService {
	boolean checkId(String id);
	MemberVo join(MemberVo vo);
}
