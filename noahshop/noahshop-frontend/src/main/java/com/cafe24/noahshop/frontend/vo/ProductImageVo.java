package com.cafe24.noahshop.frontend.vo;


public class ProductImageVo {
    private Long no;
    private String url;

    public ProductImageVo() {
    }

    public ProductImageVo(Long no, String url) {
        this.no = no;
        this.url = url;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
