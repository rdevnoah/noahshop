package com.cafe24.noahshop.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cafe24.noahshop.config.TestAppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestAppConfig.class})
@WebAppConfiguration
public class MemberDaoTest {
	
	@Autowired
	private MemberDao memberDao;
	
	@Test
	public void init() {
		memberDao.deleteAll();
	}
	
	
	
	/*
	 * @Test public void testDI() { assertNotNull(sqlSession); }
	 */
}
