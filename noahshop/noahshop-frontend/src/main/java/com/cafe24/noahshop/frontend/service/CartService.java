package com.cafe24.noahshop.frontend.service;

import com.cafe24.noahshop.frontend.dto.JSONResult;
import com.cafe24.noahshop.frontend.dto.ProductDto;
import com.cafe24.noahshop.frontend.vo.CartVo;
import com.cafe24.noahshop.frontend.vo.ProductDetailVo;
import com.cafe24.noahshop.frontend.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

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
public class CartService {

    @Autowired
    private OAuth2RestTemplate restTemplate;

    public final static String API_URL="http://localhost:8888/noahshop/v1";


    public boolean addMemberCart(CartVo cartVo) {

        ResponseEntity<JSONResult> response = null;
        JSONResult successBody = null;
        HttpEntity<CartVo> entity = new HttpEntity<>(cartVo);
        try {
            response = restTemplate.exchange(API_URL+"/api/cart", HttpMethod.PUT, entity, JSONResult.class);
            //successBody = response.getBody();
        } catch (HttpClientErrorException e){
            return false;
        }

        return true;
    }

    public List<ProductDto> getCartByCookie(String cartInfo) {
        String[] arr = cartInfo.split("/");

        List<ProductDetailVo> cartList= new ArrayList<>();

        for (int i=0 ; i<arr.length ; i++){
            String[] noAndStock = arr[i].split(":");
            ProductDetailVo vo = new ProductDetailVo();
            vo.setNo(Long.parseLong(noAndStock[0]));
            vo.setStock(Integer.parseInt(noAndStock[1]));
            cartList.add(vo);
        }


        HttpEntity<List<ProductDetailVo>> entity = new HttpEntity<>(cartList);
        ResponseEntity<JSONResultCartList> response = null;

        response = restTemplate.exchange(API_URL+"/api/cart/list", HttpMethod.POST, entity, JSONResultCartList.class);

        List<ProductDto> result = response.getBody().getData();
        return result;


    }

    private static class JSONResultCartList extends JSONResult<List<ProductDto>>{}
}
