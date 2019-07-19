package com.cafe24.noahshop.vo;

import org.hibernate.validator.constraints.NotEmpty;

public class ProductVo {
	private Long no;
	private Long categoryNo;
	
	@NotEmpty
	private String code;
	private String name;
	private int price;
	private String description;
	private String regDate;
	private String dpMain;
	private String isSell;

	private String optionParentName;
	private String optionChildName;
	private int stock;



	public ProductVo() {
	}

	public ProductVo(Long no, Long categoryNo, String code, String name, int price, String description, String regDate,
			String dpMain, String isSell) {
		super();
		this.no = no;
		this.categoryNo = categoryNo;
		this.code = code;
		this.name = name;
		this.price = price;
		this.description = description;
		this.regDate = regDate;
		this.dpMain = dpMain;
		this.isSell = isSell;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public Long getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
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

	public String getOptionParentName() {
		return optionParentName;
	}

	public void setOptionParentName(String optionParentName) {
		this.optionParentName = optionParentName;
	}

	public String getOptionChildName() {
		return optionChildName;
	}

	public void setOptionChildName(String optionChildName) {
		this.optionChildName = optionChildName;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
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
	
}
