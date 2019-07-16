package com.cafe24.noahshop.service;

import com.cafe24.noahshop.vo.MemberVo;


public interface MemberService {
	boolean checkId(String id);
	MemberVo joinMember(MemberVo vo);
	MemberVo getMemberByNo(Long no);
}
