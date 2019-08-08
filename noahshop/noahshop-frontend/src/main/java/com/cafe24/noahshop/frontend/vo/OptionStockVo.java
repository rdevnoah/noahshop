package com.cafe24.noahshop.frontend.vo;


public class OptionStockVo {

    private Long productDetailNo;

    private Long optionChild1No;
    private Long optionChild2No;
    private String optionChild1Name;
    private String optionChild2Name;
    private Integer stock;

    public OptionStockVo() {
    }

    public OptionStockVo(Long productDetailNo, Long optionChild1No, Long optionChild2No, String optionChild1Name, String optionChild2Name, Integer stock) {
        this.productDetailNo = productDetailNo;
        this.optionChild1No = optionChild1No;
        this.optionChild2No = optionChild2No;
        this.optionChild1Name = optionChild1Name;
        this.optionChild2Name = optionChild2Name;
        this.stock = stock;
    }

    public Long getProductDetailNo() {
        return productDetailNo;
    }

    public void setProductDetailNo(Long productDetailNo) {
        this.productDetailNo = productDetailNo;
    }

    public Long getOptionChild1No() {
        return optionChild1No;
    }

    public void setOptionChild1No(Long optionChild1No) {
        this.optionChild1No = optionChild1No;
    }

    public Long getOptionChild2No() {
        return optionChild2No;
    }

    public void setOptionChild2No(Long optionChild2No) {
        this.optionChild2No = optionChild2No;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "OptionStockVo{" +
                "productDetailNo=" + productDetailNo +
                ", optionChild1No=" + optionChild1No +
                ", optionChild2No=" + optionChild2No +
                ", optionChild1Name='" + optionChild1Name + '\'' +
                ", optionChild2Name='" + optionChild2Name + '\'' +
                ", stock=" + stock +
                '}';
    }
}
