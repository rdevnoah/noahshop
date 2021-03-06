package com.cafe24.noahshop.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.cafe24.noahshop.validator.constraints.ValidPassword;
import com.cafe24.noahshop.validator.constraints.ValidTel;

@JsonDeserialize
public class MemberVo {

    private Long no;

    @NotEmpty
    @Length(min = 4, max = 12)
    private String id;


    @NotEmpty
    @ValidPassword
    private String password;

    @NotEmpty
    private String name;

    @NotEmpty
    @ValidTel
    private String tel;

    @NotEmpty
    private String address;

    @NotEmpty
    private String email;
    private String joinDate;
    private String role;

    private String cartInfo;

    private String key;

    public MemberVo() {
    }

    public MemberVo(Long no, String id, String password, String name, String tel, String address, String email,
                    String joinDate, String role) {
        super();
        this.no = no;
        this.id = id;
        this.password = password;
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.email = email;
        this.joinDate = joinDate;
        this.role = role;
    }

    public String getCartInfo() {
        return cartInfo;
    }

    public void setCartInfo(String cartInfo) {
        this.cartInfo = cartInfo;
    }

    public Long getNo() {
        return no;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate= joinDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
