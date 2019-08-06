package com.cafe24.noahshop.frontend.vo;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

public class CategoryVo {
    private Long no;
    @NotEmpty
    private String name;
    private Long parentNo;

    private List<CategoryVo> childList;

    public CategoryVo() {
    }

    public CategoryVo(Long no, @NotEmpty String name, Long parentNo, List<CategoryVo> childList) {
        this.no = no;
        this.name = name;
        this.parentNo = parentNo;
        this.childList = childList;
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

    public List<CategoryVo> getChildList() {
        return childList;
    }

    public void setChildList(List<CategoryVo> childList) {
        this.childList = childList;
    }
}
