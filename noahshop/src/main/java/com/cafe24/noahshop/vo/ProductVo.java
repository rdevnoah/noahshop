package com.cafe24.noahshop.vo;

public class ProductVo {
	private Long no;
	private Long categoryNo;
	private String code;
	private String name;
	private int money;
	private String description;
	private String regDate;
	private String dpMain;
	private String isSell;

	public ProductVo() {
	}

	public ProductVo(Long no, Long categoryNo, String code, String name, int money, String description, String regDate,
			String dpMain, String isSell) {
		super();
		this.no = no;
		this.categoryNo = categoryNo;
		this.code = code;
		this.name = name;
		this.money = money;
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

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
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
