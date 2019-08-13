package com.cafe24.noahshop.frontend.dto;

/**
 * @author : rdevnoah
 * @version : 1.0
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.frontend.dto
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
public class OrderDto {
    private Long memberNo;
    private Long productDetailNo;
    private int stock;

    public OrderDto() {
    }

    public OrderDto(Long memberNo, Long productDetailNo, int stock) {
        this.memberNo = memberNo;
        this.productDetailNo = productDetailNo;
        this.stock = stock;
    }

    public Long getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Long memberNo) {
        this.memberNo = memberNo;
    }

    public Long getProductDetailNo() {
        return productDetailNo;
    }

    public void setProductDetailNo(Long productDetailNo) {
        this.productDetailNo = productDetailNo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "memberNo=" + memberNo +
                ", productDetailNo=" + productDetailNo +
                ", stock=" + stock +
                '}';
    }
}
