package com.cafe24.noahshop.frontend.dto;

/**
 * @author : rdevnoah
 * @version : 1.0
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.dto
 * @see <pre>
 *
 * == Modification Information ==
 *
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * 2019-07-30       rdevnoah         Initialize
 *
 * </pre>
 * @since : 2019-07-30
 */
public class OrderProductDetailDto {
    private Long orderNo;
    private Long productDetailNo;
    private int quantity;

    private Long optionChildNo1;
    private Long optionChildNo2;

    private String optionChildName1;
    private String optionChildName2;

    private String productName;

    public OrderProductDetailDto() {
    }

    public OrderProductDetailDto(Long orderNo, Long productDetailNo, int quantity, Long optionChildNo1, Long optionChildNo2, String optionChildName1, String optionChildName2, String productName) {
        this.orderNo = orderNo;
        this.productDetailNo = productDetailNo;
        this.quantity = quantity;
        this.optionChildNo1 = optionChildNo1;
        this.optionChildNo2 = optionChildNo2;
        this.optionChildName1 = optionChildName1;
        this.optionChildName2 = optionChildName2;
        this.productName = productName;
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

    public Long getOptionChildNo1() {
        return optionChildNo1;
    }

    public void setOptionChildNo1(Long optionChildNo1) {
        this.optionChildNo1 = optionChildNo1;
    }

    public Long getOptionChildNo2() {
        return optionChildNo2;
    }

    public void setOptionChildNo2(Long optionChildNo2) {
        this.optionChildNo2 = optionChildNo2;
    }

    public String getOptionChildName1() {
        return optionChildName1;
    }

    public void setOptionChildName1(String optionChildName1) {
        this.optionChildName1 = optionChildName1;
    }

    public String getOptionChildName2() {
        return optionChildName2;
    }

    public void setOptionChildName2(String optionChildName2) {
        this.optionChildName2 = optionChildName2;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
