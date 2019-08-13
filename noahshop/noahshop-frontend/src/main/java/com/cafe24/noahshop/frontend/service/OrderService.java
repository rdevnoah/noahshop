package com.cafe24.noahshop.frontend.service;

import com.cafe24.noahshop.frontend.dto.JSONResult;
import com.cafe24.noahshop.frontend.dto.ResponseJSONResult;
import com.cafe24.noahshop.frontend.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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
 * 2019-08-13       rdevnoah         Initialize
 *
 * </pre>
 * @since : 2019-08-13
 */
@Service
public class OrderService {

    @Autowired
    private OAuth2RestTemplate restTemplate;

    public final static String API_URL="http://localhost:8888/noahshop/v1";

    public Map<String, Object> getOrderformByUser(String cartInfo, Long memberNo){
        Map<String, Object> result = null;
        // cartInfo 파싱하고, 유저no와 detail 정보, stock을 가지로 form 가져온다.


        // 여기 로직.

        return result;
    }

    private static class JSONResultMap extends JSONResult<Map<String, Object>>{}

}
