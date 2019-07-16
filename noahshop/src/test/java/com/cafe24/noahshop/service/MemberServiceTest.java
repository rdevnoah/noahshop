package com.cafe24.noahshop.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.hamcrest.core.IsNot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cafe24.noahshop.config.TestAppConfig;
import com.cafe24.noahshop.config.TestWebConfig;
import com.cafe24.noahshop.vo.MemberVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestAppConfig.class, TestWebConfig.class})
@WebAppConfiguration
public class MemberServiceTest {

	@Autowired
	private MemberService memberService;
	
	@Test
	public void testDI() {
		assertNotNull(memberService);
	}
	
	@Test
	public void testInsert() {
		MemberVo vo = new MemberVo(null, "zzagam2"
				, "password1", "김영호", "010-4532-3018"
				, "수원시 팔달구 우만동 85-3지 R타워 1014", "zzagam2@gmail.com", null, null);
		
		// insertService true
		MemberVo authVo = memberService.joinMember(vo);
		assertNotNull(authVo.getNo());
		assertThat(authVo.getId(), is(vo.getId()));
	}
	
	//@Test
	public void testCheckId() {
		String id = "zzagam2";
		
		// 이미 존재하는 아이디
		assertThat(memberService.checkId(id), is(false));
		
		// 존재하지 않는 아이디
		assertThat(memberService.checkId(id), is(true));
	}
}
