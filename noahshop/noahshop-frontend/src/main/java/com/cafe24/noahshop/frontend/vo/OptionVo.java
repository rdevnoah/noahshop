package com.cafe24.noahshop.frontend.vo;

import org.hibernate.validator.constraints.NotEmpty;

public class OptionVo {
    private Long no;

    @NotEmpty
    private String name;

    private Long parentNo;

    private String parentName;

    //private int stock;

    public OptionVo() {
    }

    public OptionVo(Long no, @NotEmpty String name, Long parentNo, String parentName) {
        this.no = no;
        this.name = name;
        this.parentNo = parentNo;
        this.parentName = parentName;
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

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentNo() {
        return parentNo;
    }

    public void setParentNo(Long parentNo) {
        this.parentNo = parentNo;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
