package com.cafe24.noahshop.vo;


import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@RedisHash("cart")
public class CartVo {

    @Id
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
