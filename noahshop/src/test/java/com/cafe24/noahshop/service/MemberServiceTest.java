package com.cafe24.noahshop.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cafe24.noahshop.config.TestAppConfig;
import com.cafe24.noahshop.config.TestWebConfig;
import com.cafe24.noahshop.repository.MemberDao;
import com.cafe24.noahshop.vo.MemberVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestAppConfig.class, TestWebConfig.class})
@WebAppConfiguration
public class MemberServiceTest {

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MemberService memberService;
	
	@Test
	public void testDI() {
		assertNotNull(memberService);
	}
	
	//@Before
	public void deleteDB() {
		memberDao.deleteAll();
		memberDao.deleteAllKey();
	}
	
	//@Test
	public void testInsert() {
		MemberVo vo = new MemberVo(null, "zzagam2"
				, "password1", "김영호", "010-4532-3018"
				, "수원시 팔달구 우만동 85-3지 R타워 1014", "zzagam2@gmail.com", null, null);
		
		//test insert and selectKey
		MemberVo authVo = memberService.joinMember(vo);
		assertNotNull(authVo.getNo());
		assertThat(authVo.getId(), is(vo.getId()));
		
		
		//test get(복호화)
		
		  MemberVo getMember = memberService.getMemberByNo(authVo.getNo());
		  assertThat(vo.getName(), is(getMember.getName()));
		 
		
	}
	
	
	
	
	@Test
	public void testCheckId() {
		String id = "zzagam2";
		
		// 이미 존재하는 아이디
		assertThat(memberService.checkId(id), is(true));
		
		id = "asdfasag";
		// 존재하지 않는 아이디
		assertThat(memberService.checkId(id), is(false));
	}
}
