package com.cafe24.noahshop.vo;

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
 * 2019-07-29       rdevnoah         Initialize
 *
 * </pre>
 * @since : 2019-07-29
 */
public class DeliveryVo {
    private Long no;
    private String status;
    private String name;
    private String address;
    private String tel;
    private String message;

    public DeliveryVo() {
    }

    public DeliveryVo(Long no, String status, String name, String address, String tel, String message) {
        this.no = no;
        this.status = status;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.message = message;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
