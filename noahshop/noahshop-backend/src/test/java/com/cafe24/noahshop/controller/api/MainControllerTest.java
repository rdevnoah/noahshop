package com.cafe24.noahshop.controller.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MainControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private FilterChainProxy springSecurityFilterChain;

	private String accessToken;
	
	@Before
	public void setUp() throws Exception {

		mockMvc = MockMvcBuilders.webAppContextSetup(wac).addFilter(springSecurityFilterChain).build();

		// Access Token
		if(accessToken != null) {
			return;
		}

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

//        params.add("grant_type", "password");
//        params.add("username", "test");
//        params.add("password", "5678");
//        ResultActions result = mockMvc
//        	.perform( post("/oauth/token")
//        		.params(params)
//        		.header("Authorization", "Basic " + new String(Base64.encode(("pjmall:").getBytes())))
//        		.accept(MediaType.APPLICATION_JSON))
//        	.andDo(print())
//    		.andExpect(status().isOk());

		params.add("grant_type", "client_credentials");
		params.add("scope", "read");
		params.add("scope", "write");

		ResultActions result = mockMvc
				.perform( post("/oauth/token")
						.params(params)
						.header("Authorization", "Basic " + new String(Base64.encode(("noahshop:1234").getBytes())))
						.accept("application/json; charset=UTF-8")
						.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());

		String resultString = result.andReturn().getResponse().getContentAsString();

		JacksonJsonParser jsonParser = new JacksonJsonParser();
		accessToken = jsonParser.parseMap(resultString).get("access_toke" + "n").toString();
	}
	
	@Test
	public void testDI() {
		assertNotNull(wac);
		assertNotNull(mockMvc);
	}
	
	@Test
	public void testgetMain() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/").contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("success")));
		
		resultActions = mockMvc.perform(get("").contentType(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk())
					 .andDo(print())
					 .andExpect(jsonPath("$.result", is("success")));
	}
	
}
