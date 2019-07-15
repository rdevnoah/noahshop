package com.cafe24.noahshop.vo;

import org.hibernate.validator.constraints.NotEmpty;

public class OptionVo {
	private Long no;
	
	@NotEmpty
	private String name;

	public OptionVo() {
	}

	public OptionVo(Long no, String name) {
		super();
		this.no = no;
		this.name = name;
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

}
