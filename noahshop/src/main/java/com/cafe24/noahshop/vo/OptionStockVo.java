package com.cafe24.noahshop.vo;


public class OptionStockVo {

    private Long optionChild1No;
    private Long optionChild2No;
    private int Stock;

    public OptionStockVo() {
    }

    public OptionStockVo(Long optionChild1No, Long optionChild2No, int stock) {
        this.optionChild1No = optionChild1No;
        this.optionChild2No = optionChild2No;
        Stock = stock;
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

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }
}
