package com.cafe24.noahshop.frontend.vo;

public class ProductDetailVo {
    private Long no;
    private int stock;
    private Long optionChildNo1;
    private Long optionChildNo2;
    private String optionChild1Name;
    private String optionChild2Name;

    private Long productNo;

    public ProductDetailVo() {
    }

    public ProductDetailVo(Long no, int stock, Long optionChildNo1, Long optionChildNo2, String optionChild1Name, String optionChild2Name, Long productNo) {
        this.no = no;
        this.stock = stock;
        this.optionChildNo1 = optionChildNo1;
        this.optionChildNo2 = optionChildNo2;
        this.optionChild1Name = optionChild1Name;
        this.optionChild2Name = optionChild2Name;
        this.productNo = productNo;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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

    public String getOptionChild1Name() {
        return optionChild1Name;
    }

    public void setOptionChild1Name(String optionChild1Name) {
        this.optionChild1Name = optionChild1Name;
    }

    public String getOptionChild2Name() {
        return optionChild2Name;
    }

    public void setOptionChild2Name(String optionChild2Name) {
        this.optionChild2Name = optionChild2Name;
    }

    public Long getProductNo() {
        return productNo;
    }

    public void setProductNo(Long productNo) {
        this.productNo = productNo;
    }

    @Override
    public String toString() {
        return "ProductDetailVo{" +
                "no=" + no +
                ", stock=" + stock +
                ", optionChildNo1=" + optionChildNo1 +
                ", optionChildNo2=" + optionChildNo2 +
                ", optionChild1Name='" + optionChild1Name + '\'' +
                ", optionChild2Name='" + optionChild2Name + '\'' +
                ", productNo=" + productNo +
                '}';
    }
}