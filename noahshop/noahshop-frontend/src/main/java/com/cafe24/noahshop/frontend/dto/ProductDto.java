package com.cafe24.noahshop.frontend.dto;


import com.cafe24.noahshop.frontend.vo.ImageVo;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * @author : rdevnoah
 * @version : 1.0
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.dto
 * @see <pre>
 *
 * == Modification Information ==
 *
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * 2019-07-25       rdevnoah         Initialize
 *
 * </pre>
 * @since : 2019-07-25
 */
public class ProductDto {
    private Long no;
    @NotEmpty
    private String code;
    private String name;
    private int price;
    private String description;
    private Long categoryNo;
    private String regDate;
    private String dpMain;
    private String isSell;

    private Long productDetailNo;

    private Long optionChild1No;
    private Long optionChild2No;
    private int stock;

    private List<ImageVo> imageList;

    public ProductDto() {
    }

    public ProductDto(Long no, String code, String name, int price, String description, Long categoryNo, String regDate, String dpMain, String isSell, Long productDetailNo, Long optionChild1No, Long optionChild2No, int stock, List<ImageVo> imageList) {
        this.no = no;
        this.code = code;
        this.name = name;
        this.price = price;
        this.description = description;
        this.categoryNo = categoryNo;
        this.regDate = regDate;
        this.dpMain = dpMain;
        this.isSell = isSell;
        this.productDetailNo = productDetailNo;
        this.optionChild1No = optionChild1No;
        this.optionChild2No = optionChild2No;
        this.stock = stock;
        this.imageList = imageList;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Long getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(Long categoryNo) {
        this.categoryNo = categoryNo;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<ImageVo> getImageList() {
        return imageList;
    }

    public void setImageList(List<ImageVo> imageList) {
        this.imageList = imageList;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "no=" + no +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", categoryNo=" + categoryNo +
                ", regDate='" + regDate + '\'' +
                ", dpMain='" + dpMain + '\'' +
                ", isSell='" + isSell + '\'' +
                ", productDetailNo=" + productDetailNo +
                ", optionChild1No=" + optionChild1No +
                ", optionChild2No=" + optionChild2No +
                ", stock=" + stock +
                ", imageList=" + imageList +
                '}';
    }
}
