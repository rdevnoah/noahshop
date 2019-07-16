package com.cafe24.noahshop.repository;

import com.cafe24.noahshop.vo.MemberVo;

public interface MemberDao {
	public MemberVo insert(MemberVo vo);
	
	public MemberVo getMemberByNo(Long no);

	public void deleteAll();
}
