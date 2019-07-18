package com.cafe24.noahshop.vo;

import org.hibernate.validator.constraints.NotEmpty;

public class CategoryVo {
    private Long no;
    @NotEmpty
    private String name;
    private Long parentNo;

    public CategoryVo() {
    }


    public CategoryVo(Long no, String name, Long parentNo) {
        this.no = no;
        this.name = name;
        this.parentNo = parentNo;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public Long getParentNo() {
        return parentNo;
    }

    public void setParentNo(Long parentNo) {
        this.parentNo = parentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
