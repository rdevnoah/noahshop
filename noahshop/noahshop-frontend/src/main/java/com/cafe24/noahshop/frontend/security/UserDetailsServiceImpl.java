package com.cafe24.noahshop.frontend.security;

import java.util.Arrays;
import java.util.Map;

import com.cafe24.noahshop.frontend.dto.JSONResult;
import com.cafe24.noahshop.frontend.dto.ResponseJSONResult;
import com.cafe24.noahshop.frontend.service.MemberService;
import com.cafe24.noahshop.frontend.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Component;

import com.cafe24.noahshop.frontend.repository.UserDao;
import com.cafe24.noahshop.frontend.vo.UserVo;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;


@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private OAuth2RestTemplate restTemplate;

	public final static String API_URL="http://localhost:8888/noahshop/v1";

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

		MemberVo vo = new MemberVo();
		vo.setId(name);

		ResponseEntity<JSONResultAuth> response = null;
		JSONResultAuth successBody = null;
		try {
			response = restTemplate.postForEntity(API_URL + "/api/user/login/auth", vo, JSONResultAuth.class);
			successBody = response.getBody();
		} catch (HttpClientErrorException e){
			System.out.println(e);
		}
		MemberVo responseVo = successBody.getData();

		SecurityUser securityUser = new SecurityUser();

		if(responseVo != null) {
			securityUser.setNo(responseVo.getNo());
			securityUser.setName(responseVo.getId());
			securityUser.setUsername(responseVo.getName());
			securityUser.setPassword(responseVo.getPassword());
			securityUser.setAuthorities(Arrays.asList(new SimpleGrantedAuthority(responseVo.getRole())));
			securityUser.setCartString(responseVo.getCartInfo());
			System.out.println("**********************************************************" + securityUser.getCartString());
		}
		return securityUser;

	}
	private static class JSONResultAuth extends JSONResult<MemberVo>
	{};
}
