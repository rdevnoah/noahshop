package com.cafe24.noahshop.frontend.controller;

import com.cafe24.noahshop.frontend.dto.ProductAddDto;
import com.cafe24.noahshop.frontend.security.SecurityUser;
import com.cafe24.noahshop.frontend.service.CartService;
import com.cafe24.noahshop.frontend.vo.CartVo;
import com.cafe24.noahshop.frontend.vo.ProductAddVo;
import com.cafe24.noahshop.frontend.vo.ProductDetailVo;
import com.cafe24.noahshop.frontend.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author : rdevnoah
 * @version : 1.0
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.frontend.controller
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
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/add")
    public String addCart(ProductAddVo vo, HttpServletRequest request, HttpServletResponse response){

        // productAddVo에서 cartInfo parsing 하기

        String parsingCart = parsingCartInfo(vo);

        // 1. 회원
        // 회원 전용 쿠키 발급
        HttpSession session = request.getSession(false);
        SecurityUser authUser = null;
        if (session != null && session.getAttribute("authUser") != null){
            authUser = (SecurityUser)session.getAttribute("authUser");
            CartVo cartVo = new CartVo();
            cartVo.setMemberNo(authUser.getNo());
            cartVo.setProductInfo(parsingCart);

            cartService.addMemberCart(cartVo);

            Cookie[] cookies = request.getCookies();
            String cartInfo = getCartCookieValue(cookies, authUser.getName());
            Cookie cartCookie = new Cookie(authUser.getName(), cartInfo + parsingCart);
            response.addCookie(cartCookie);
            return "redirect:/";
        }

        // 2. 비회원
        // 비회원 전용 쿠키 발급 후 사용
        Cookie[] cookies = request.getCookies();
        String cartInfo = getCartCookieValue(cookies, "noMemberCartInfo");
        response.addCookie(new Cookie("noMemberCartInfo", cartInfo+parsingCart));

        return "redirect:/";
    }

    @GetMapping
    public String getCartList(HttpServletRequest request, Model model){

        Cookie[] cookies = request.getCookies();

        String cartInfo = "";
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("authUser") != null){
            SecurityUser authUser = (SecurityUser) session.getAttribute("authUser");
            cartInfo = getCartCookieValue(cookies, authUser.getName());
        } else{
            cartInfo = getCartCookieValue(cookies, "noMemberCartInfo");
        }

        if ("".equals(cartInfo)){
            return "products/cart";
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + cartInfo);
        List<ProductVo> list = cartService.getCartByCookie(cartInfo);


        model.addAttribute("cartList", list);


        return "products/cart";
    }


    private String parsingCartInfo(ProductAddVo vo) {


        StringBuilder sb = new StringBuilder();

        for (ProductDetailVo detailVo : vo.getProductList()){
            String no = detailVo.getNo().toString();
            String stock = String.valueOf(detailVo.getStock());
            sb.append(no + ":" + stock + "/");
        }


        return sb.toString();
    }

    private String getCartCookieValue(Cookie[] cookies, String key){
        String result="";
        for(int i=0 ; i<cookies.length ; i++){
            if (cookies[i].getName().equals(key)){
                result = cookies[i].getValue();
                break;
            }
        }
        return result;
    }
}
