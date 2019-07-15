package com.cafe24.noahshop.example;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.cafe24.noahshop.controller.api.MemberControllerTest;
import com.cafe24.noahshop.controller.api.OrderControllerTest;

import junit.framework.Test;
import junit.framework.TestSuite;


@RunWith(Suite.class)
@SuiteClasses({
	MemberControllerTest.class,
	OrderControllerTest.class
})
public class TestScenarioTest {
	
	public static Test suite() {
		return new TestSuite("회원 주문 시나리오 테스트");
	}
}
