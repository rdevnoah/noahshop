package com.cafe24.noahshop.vo;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

public class ProductVo {
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
	private List<OptionStockVo> optionStockVo;

	private List<ImageVo> imageList;

	public ProductVo() {
	}

	public ProductVo(Long no, @NotEmpty String code, String name, int price, String description, Long categoryNo, String regDate, String dpMain, String isSell, List<OptionStockVo> optionStockVo, List<ImageVo> imageList) {
		this.no = no;
		this.code = code;
		this.name = name;
		this.price = price;
		this.description = description;
		this.categoryNo = categoryNo;
		this.regDate = regDate;
		this.dpMain = dpMain;
		this.isSell = isSell;
		this.optionStockVo = optionStockVo;
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

	public List<OptionStockVo> getOptionStockVo() {
		return optionStockVo;
	}

	public void setOptionStockVo(List<OptionStockVo> optionStockVo) {
		this.optionStockVo = optionStockVo;
	}

	public List<ImageVo> getImageList() {
		return imageList;
	}

	public void setImageList(List<ImageVo> imageList) {
		this.imageList = imageList;
	}
}
