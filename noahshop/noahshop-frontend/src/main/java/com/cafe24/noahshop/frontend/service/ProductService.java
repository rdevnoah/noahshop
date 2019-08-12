package com.cafe24.noahshop.frontend.service;

import com.cafe24.noahshop.frontend.dto.JSONResult;
import com.cafe24.noahshop.frontend.vo.OptionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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
 * 2019-08-12       rdevnoah         Initialize
 *
 * </pre>
 * @since : 2019-08-12
 */
@Service
public class ProductService {
    private final static String API_URL = "http://localhost:8888/noahshop/v1";

    @Autowired
    private OAuth2RestTemplate restTemplate;

    public Map<String, Object> getProductDetailByNo(Long no){
        Map<String, Object> result = new HashMap<>();

        JSONResultProductDetail response = restTemplate.getForObject(API_URL+"/api/product/detail/"+no, JSONResultProductDetail.class);
        result = response.getData();
        return result;
    }

    public JSONResult getOption2(Long productNo, Long option1No) {

        JSONResultOption2List response = restTemplate.getForObject(API_URL+"/api/product/getOption2?productNo="+productNo+"&option1No="+option1No
                                                                , JSONResultOption2List.class);
        return response;
    }

    public static class JSONResultProductDetail extends JSONResult<Map<String, Object>>{}
    public static class JSONResultOption2List extends JSONResult<List<OptionVo>>{}

}
