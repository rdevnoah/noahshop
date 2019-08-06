package com.cafe24.noahshop.frontend.service;

import com.cafe24.noahshop.frontend.dto.JSONResult;
import com.cafe24.noahshop.frontend.dto.ResponseJSONResult;
import com.cafe24.noahshop.frontend.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author : rdevnoah
 * @version : 1.0
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.frontend.service
 * @see <pre>
 *
 * == Modification Information ==
 *
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * 2019-08-06       rdevnoah         Initialize
 *
 * </pre>
 * @since : 2019-08-06
 */
@Service
public class MemberService {

    @Autowired
    private OAuth2RestTemplate restTemplate;

    public final static String API_URL="http://localhost:8888/noahshop/v1";

    public JSONResult login(MemberVo vo){

        ResponseEntity<JSONResultLogin> response = null;
        JSONResultLogin successBody = null;
        try {
            response = restTemplate.postForEntity(API_URL + "/api/user/login", vo, JSONResultLogin.class);
            successBody = response.getBody();
            //restTemplate.postForObject(API_URL+"/api/user/login", vo, LoginJSONResult.class);
        } catch (HttpClientErrorException e){
            return ResponseJSONResult.fail(e.getResponseBodyAsString());
        }

        return successBody;
    }

    static class JSONResultLogin extends JSONResult<Map<String, Object>>
    {};

}
