package com.cafe24.noahshop.vo;

import org.hibernate.validator.constraints.NotEmpty;

public class OptionVo {
    private Long no;

    @NotEmpty
    private String name;

    private Long parentNo;

    private int stock;

    public OptionVo() {
    }

    public OptionVo(Long no, String name, Long parent_no) {
        this.no = no;
        this.name = name;
        this.parentNo = parent_no;
    }

    public OptionVo(Long no, @NotEmpty String name, Long parentNo, int stock) {
        this.no = no;
        this.name = name;
        this.parentNo = parentNo;
        this.stock = stock;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public Long getParentNo() {
        return parentNo;
    }

    public void setParentNo(Long parentNo) {
        this.parentNo = parentNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
