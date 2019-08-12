package com.cafe24.noahshop.frontend.controller;

import com.cafe24.noahshop.frontend.dto.JSONResult;
import com.cafe24.noahshop.frontend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
 * 2019-08-12       rdevnoah         Initialize
 *
 * </pre>
 * @since : 2019-08-12
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/detail/{no}")
    public String getDetailByNo(@PathVariable(value = "") Long no, Model model){
        System.out.println(no);
        Map<String, Object> map = productService.getProductDetailByNo(no);
        System.out.println(map);

        model.addAttribute("productDetail", map);

        return "products/item";
    }

    @ResponseBody
    @RequestMapping("/getOption2")
    public JSONResult getOption2(Long productNo, Long option1No){
        JSONResult result = productService.getOption2(productNo, option1No);
        return result;
    }

}
