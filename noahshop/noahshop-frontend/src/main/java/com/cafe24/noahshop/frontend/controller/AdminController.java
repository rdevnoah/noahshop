package com.cafe24.noahshop.frontend.controller;

import com.cafe24.noahshop.frontend.dto.ProductAddDto;
import com.cafe24.noahshop.frontend.service.AdminService;
import com.cafe24.noahshop.frontend.vo.MemberVo;
import com.cafe24.noahshop.frontend.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
 * 2019-08-08       rdevnoah         Initialize
 *
 * </pre>
 * @since : 2019-08-08
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping({"","/"})
    public String main(){
        return "admin/index";
    }

    @RequestMapping("/product/addform")
    public String addProductForm(Model model){
        Map<String, Object> map = adminService.getAddProductForm();
        model.addAttribute("map", map);
        return "admin/product/register_form";
    }

    @RequestMapping("/product/list")
    public String productList(Model model){
        List<ProductVo> list = adminService.getProductList();
        model.addAttribute("productList", list);
        return "admin/product/product_List";
    }

    @RequestMapping("/user/list")
    public String memberList(Model model){
        List<MemberVo> list = adminService.getMemberList();
        model.addAttribute("memberList", list);
        return "admin/user/user_list";
    }

    @RequestMapping("/product/add")
    public String addProduct(ProductAddDto dto){
        adminService.addProductService(dto);
        return "redirect:/admin/product/list";
    }
}
