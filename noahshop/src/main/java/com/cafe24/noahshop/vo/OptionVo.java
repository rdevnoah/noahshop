package com.cafe24.noahshop.vo;

import org.hibernate.validator.constraints.NotEmpty;

public class OptionVo {
    private Long no;

    @NotEmpty
    private String name;

    private Long parentNo;

    public OptionVo() {
    }

    public OptionVo(Long no, String name, Long parent_no) {
        this.no = no;
        this.name = name;
        this.parentNo = parent_no;
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

    public Long getParent_no() {
        return parentNo;
    }

    public void setParent_no(Long parentNo) {
        this.parentNo = parentNo;
    }

    public void setName(String name) {
        this.name = name;
    }

}
