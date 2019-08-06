package com.cafe24.noahshop.frontend.vo;

public class CartVo {

    private Long memberNo;

    private String productInfo;

    public CartVo() {
    }

    public CartVo(Long memberNo, String productInfo) {
        this.memberNo = memberNo;
        this.productInfo = productInfo;
    }

    public Long getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Long memberNo) {
        this.memberNo = memberNo;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }
}
