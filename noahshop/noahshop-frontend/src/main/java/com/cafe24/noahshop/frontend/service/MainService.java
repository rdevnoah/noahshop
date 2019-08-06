package com.cafe24.noahshop.frontend.service;

import com.cafe24.noahshop.frontend.dto.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
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
public class MainService {

    private final static String API_URL = "http://localhost:8888/noahshop/v1";

    @Autowired
    private OAuth2RestTemplate restTemplate;

    public Map<String, Object> getMain(){
        Map<String, Object> result = new HashMap<>();
        JSONResultMain response = restTemplate.getForObject(API_URL, JSONResultMain.class);

        result = response.getData();
        System.out.println(result);

        return result;
    }

    private static class JSONResultMain extends JSONResult<Map<String, Object>>{}
}
