package com.cafe24.noahshop.repository;

import java.util.Map;

import com.cafe24.noahshop.vo.MemberVo;

public interface MemberDao {
	public MemberVo insert(MemberVo vo);
	
	public MemberVo getMemberByNo(Map<String, Object> map);

	public void deleteAll();

	public boolean insertKey(Map<String, Object> map);

	public boolean deleteAllKey();

	public String getKeyByNo(Long no);
}
