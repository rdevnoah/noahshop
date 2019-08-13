package com.cafe24.noahshop.frontend.vo;

import java.util.List;

/**
 * @author : rdevnoah
 * @version : 1.0
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.frontend.vo
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
public class ProductAddVo {
    private Long no;

    private List<ProductDetailVo> productList;

    public ProductAddVo() {
    }

    public ProductAddVo(Long no, List<ProductDetailVo> productList) {
        this.no = no;
        this.productList = productList;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public List<ProductDetailVo> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductDetailVo> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "ProductAddVo{" +
                "no=" + no +
                ", productList=" + productList +
                '}';
    }
}
