package com.cafe24.noahshop.frontend.vo;

/**
 * @author : rdevnoah
 * @version : 1.0
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.vo
 * @see <pre>
 *
 * == Modification Information ==
 *
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * 2019-07-29       rdevnoah         Initialize
 *
 * </pre>
 * @since : 2019-07-29
 */
public class OrderProductVo {
    private Long orderNo;
    private Long productDetailNo;
    private int quantity;

    public OrderProductVo() {
    }

    public OrderProductVo(Long orderNo, Long productDetailNo, int quantity) {
        this.orderNo = orderNo;
        this.productDetailNo = productDetailNo;
        this.quantity = quantity;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public Long getProductDetailNo() {
        return productDetailNo;
    }

    public void setProductDetailNo(Long productDetailNo) {
        this.productDetailNo = productDetailNo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
