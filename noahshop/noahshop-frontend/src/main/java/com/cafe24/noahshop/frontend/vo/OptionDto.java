package com.cafe24.noahshop.frontend.vo;

import java.util.List;

/**
 * @author : rdevnoah
 * @version : 1.0
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.vo
 * @see <pre>
 *
 * == Modification Information ==
 *
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * 2019-08-08       rdevnoah         Initialize
 *
 * </pre>
 * @since : 2019-08-08
 */
public class OptionDto {
    private Long no;
    private String name;

    List<OptionDto> childList;

    public OptionDto() {
    }

    public OptionDto(Long no, String name, List<OptionDto> childList) {
        this.no = no;
        this.name = name;
        this.childList = childList;
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

    public List<OptionDto> getChildList() {
        return childList;
    }

    public void setChildList(List<OptionDto> childList) {
        this.childList = childList;
    }
}
