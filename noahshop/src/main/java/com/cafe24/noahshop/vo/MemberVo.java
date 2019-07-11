package com.cafe24.noahshop.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class MemberVo {
	
	private Long no;
	
	@NotEmpty
	@Length(min = 4, max = 12)
	private String id;
	
	@Length(min = 8, max = 16)
	private String password;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String tel;
	
	@NotEmpty
	private String address;
	
	@NotEmpty
	private String email;
	private String regDate;
	private String role;
	
	public MemberVo() {}

	public MemberVo(Long no, String id, String password, String name, String tel, String address, String email,
			String regDate, String role) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.email = email;
		this.regDate = regDate;
		this.role = role;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
