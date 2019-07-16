package com.cafe24.noahshop.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cafe24.noahshop.config.TestAppConfig;
import com.cafe24.noahshop.vo.MemberVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestAppConfig.class})
@WebAppConfiguration
public class MemberDaoTest {
	
	@Autowired
	private MemberDao memberDao;
	
	@Test
	public void init() {
		memberDao.deleteAll();
		memberDao.deleteAllKey();
	}
	
	
	//@Test
	public void testInsertKey() {
		MemberVo vo = new MemberVo();
		vo.setId("zzagam2");
		String generateKey = RandomStringUtils.randomAlphanumeric(16);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("key", generateKey);
		map.put("member", vo);
		
		assertTrue(memberDao.insertKey(map));
	}
	
	//@Test
	public void testCheckID() {
		String unusedId = "asdfasdf";
		assertNull(memberDao.checkId(unusedId));
		
		String usedId = "q77q78";
		assertNotNull(memberDao.checkId(usedId));
	}
}
