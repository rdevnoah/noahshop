package com.cafe24.noahshop.frontend.vo;

public class MemberVo {

    private Long no;

    private String id;


    private String password;

    private String name;

    private String tel;

    private String address;

    private String email;
    private String joinDate;
    private String role;

    private String key;

    private String cartInfo;

    public MemberVo() {
    }

    public MemberVo(Long no, String id, String password, String name, String tel, String address, String email, String joinDate, String role, String key, String cartInfo) {
        this.no = no;
        this.id = id;
        this.password = password;
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.email = email;
        this.joinDate = joinDate;
        this.role = role;
        this.key = key;
        this.cartInfo = cartInfo;
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

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCartInfo() {
        return cartInfo;
    }

    public void setCartInfo(String cartInfo) {
        this.cartInfo = cartInfo;
    }
}
