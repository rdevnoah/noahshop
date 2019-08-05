package com.cafe24.noahshop.frontend.apitest;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class RestTemplateTest {
	
	
	@Test
	public void test_getForObject() {
		RestTemplate restTemplate = new RestTemplate();

		String result = restTemplate.getForObject("http://localhostL8888/v1/hello", String.class);
		System.out.println( result );
	}
}
