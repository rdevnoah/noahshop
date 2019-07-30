package com.cafe24.noahshop.dto;


import com.cafe24.noahshop.vo.OptionStockVo;
import com.cafe24.noahshop.vo.ProductImageVo;

import java.util.List;

public class ProductAddDto {
    private String name;
    private int price;
    private String description; //html 문서 내용

    private List<ProductImageVo> image;

    private String dpMain;
    private String isSell;

    private Long categoryNo;


    private List<OptionStockVo> optionStockVoList;

    public ProductAddDto() {
    }



    public ProductAddDto(String name, int price, String description, List<ProductImageVo> image, String dpMain, String isSell, Long categoryNo, List<OptionStockVo> optionStockVoList) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.dpMain = dpMain;
        this.isSell = isSell;
        this.categoryNo = categoryNo;
        this.optionStockVoList = optionStockVoList;
    }


    public Long getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(Long categoryNo) {
        this.categoryNo = categoryNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProductImageVo> getImage() {
        return image;
    }

    public void setImage(List<ProductImageVo> image) {
        this.image = image;
    }

    public String getDpMain() {
        return dpMain;
    }

    public void setDpMain(String dpMain) {
        this.dpMain = dpMain;
    }

    public String getIsSell() {
        return isSell;
    }

    public void setIsSell(String isSell) {
        this.isSell = isSell;
    }

    public List<OptionStockVo> getOptionStockVoList() {
        return optionStockVoList;
    }

    public void setOptionStockVoList(List<OptionStockVo> optionStockVoList) {
        this.optionStockVoList = optionStockVoList;
    }

}
