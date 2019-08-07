package com.cafe24.noahshop.frontend.apitest;

import com.cafe24.noahshop.frontend.config.AppConfig;
import com.cafe24.noahshop.frontend.config.WebConfig;
import com.cafe24.noahshop.frontend.config.app.AppSecurityConfig;
import com.cafe24.noahshop.frontend.config.app.OAuth2ClientConfig;
import com.cafe24.noahshop.frontend.config.web.MVCConfig;
import com.cafe24.noahshop.frontend.dto.JSONResult;
import com.cafe24.noahshop.frontend.vo.MemberVo;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, MVCConfig.class, OAuth2ClientConfig.class, AppSecurityConfig.class})
@WebAppConfiguration
public class RestTemplateTest {

	private static final String API_URL = "http://localhost:8888/noahshop/v1";


	@Autowired
	private OAuth2RestTemplate restTemplate;




	@Test
	public void test_getForObject() {

		MemberVo vo = new MemberVo();

		JSONResult<Map<String, Object>> result = restTemplate.getForObject(API_URL, JSONResult.class);
		System.out.println(result.getData().get("productList"));;
	}

	@Test
	public void testLoginAPI(){

		MemberVo vo = new MemberVo();
		vo.setId("user3");
		vo.setPassword("qlalfqjsgh1!");
		ResponseEntity<LoginJSONResult> response = null;
		LoginJSONResult successBody = null;
		try {
			response = restTemplate.postForEntity(API_URL + "/api/user/login", vo, LoginJSONResult.class);
			successBody = response.getBody();
			//restTemplate.postForObject(API_URL+"/api/user/login", vo, LoginJSONResult.class);
		} catch (HttpClientErrorException e){
			System.out.println(e.getResponseBodyAsString());
		}


		System.out.println(successBody.getData().get("authVo"));


		//System.out.println("---------"+response.getBody().getMessage());


	}


	private static class LoginJSONResult extends JSONResult<Map<String, Object>>{
	}

}
