package com.cafe24.noahshop.frontend.controller;

import com.cafe24.noahshop.frontend.security.SecurityUser;
import com.cafe24.noahshop.frontend.service.OrderService;
import com.cafe24.noahshop.frontend.vo.OrderProductVo;
import com.cafe24.noahshop.frontend.vo.OrderVo;
import com.cafe24.noahshop.frontend.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * 2019-08-13       rdevnoah         Initialize
 *
 * </pre>
 * @since : 2019-08-13
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orderform")
    public String orderform(HttpServletRequest request, Model model){
        HttpSession session = request.getSession(false);
        Map<String, Object> map = new HashMap<>();

        String cartInfo = "";

        //회원 주문의 경우
        if (session != null && session.getAttribute("authUser") != null){
            SecurityUser authUser = (SecurityUser)session.getAttribute("authUser");
            Cookie[] cookies = request.getCookies();
            for (int i=0 ; i<cookies.length ; i++){
                if (cookies[i].getName().equals(authUser.getName())){
                    cartInfo = cookies[i].getValue();
                    break;
                }
            }


            map = orderService.getOrderformByUser(cartInfo, authUser.getNo());
        }

        //Todo: 비회원 주문



        model.addAttribute("info", map);

        return "order/orderform";
    }

    @RequestMapping("/add")
    public String add(OrderVo vo, @AuthenticationPrincipal SecurityUser authUser, HttpServletRequest request, HttpServletResponse response){


        if (authUser != null){
            //회원

            vo.setIsMember("Y");

            boolean result = orderService.addOrder(vo);
            Cookie[] cookies = request.getCookies();

            String cartInfo = "";
            for (int i=0 ; i<cookies.length ; i++){
                if (cookies[i].getName().equals(authUser.getName())){
                    cartInfo=cookies[i].getValue();
                    break;
                }
            }

            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ cartInfo : " + cartInfo);
            for (OrderProductVo ovo : vo.getOrderProductList()){
                String no = ovo.getProductDetailNo().toString();
                int quantity = ovo.getQuantity();
                String oneCart = no + ":" + quantity + "/";
                if (cartInfo.contains(oneCart)){
                    cartInfo = cartInfo.replaceFirst(oneCart, "");
                }
            }

            Cookie cartCookie = new Cookie(authUser.getName(), cartInfo);
            cartCookie.setPath("/");
            response.addCookie(cartCookie);


        }

        return "redirect:/";
    }
}
