package com.cafe24.noahshop.frontend.vo;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

public class OrderVo {
	private Long no;
	private Long memberNo;
	private String orderCode;
	private String orderDate;
	private String address;
	@NotEmpty
	private String isMember;
	private String password;
	private String payment;
	private int price;
	private String buyerName;
	private String email;
	private String status;
	private String buyerTel;

	private Long orderNo;
	private Long productDetailNo;
	private int quantity;

	private String message;

	private String deliveryStatus;

	private List<OrderProductVo> orderProductList;



	public OrderVo() {
	}


	public OrderVo(Long no, Long memberNo, String orderCode, String orderDate, String address, String isMember, String password, String payment, int price, String buyerName, String email, String status, String buyerTel, Long orderNo, Long productDetailNo, int quantity, String message, String deliveryStatus, List<OrderProductVo> orderProductList) {
		this.no = no;
		this.memberNo = memberNo;
		this.orderCode = orderCode;
		this.orderDate = orderDate;
		this.address = address;
		this.isMember = isMember;
		this.password = password;
		this.payment = payment;
		this.price = price;
		this.buyerName = buyerName;
		this.email = email;
		this.status = status;
		this.buyerTel = buyerTel;
		this.orderNo = orderNo;
		this.productDetailNo = productDetailNo;
		this.quantity = quantity;
		this.message = message;
		this.deliveryStatus = deliveryStatus;
		this.orderProductList = orderProductList;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public Long getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIsMember() {
		return isMember;
	}

	public void setIsMember(String isMember) {
		this.isMember = isMember;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBuyerTel() {
		return buyerTel;
	}

	public void setBuyerTel(String buyerTel) {
		this.buyerTel = buyerTel;
	}

	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	public Long getProductDetailNo() {
		return productDetailNo;
	}

	public void setProductDetailNo(Long productDetailNo) {
		this.productDetailNo = productDetailNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<OrderProductVo> getOrderProductList() {
		return orderProductList;
	}

	public void setOrderProductList(List<OrderProductVo> orderProductList) {
		this.orderProductList = orderProductList;
	}

	@Override
	public String toString() {
		return "OrderVo{" +
				"no=" + no +
				", memberNo=" + memberNo +
				", orderCode='" + orderCode + '\'' +
				", orderDate='" + orderDate + '\'' +
				", address='" + address + '\'' +
				", isMember='" + isMember + '\'' +
				", password='" + password + '\'' +
				", payment='" + payment + '\'' +
				", price=" + price +
				", buyerName='" + buyerName + '\'' +
				", email='" + email + '\'' +
				", status='" + status + '\'' +
				", buyerTel='" + buyerTel + '\'' +
				", orderNo=" + orderNo +
				", productDetailNo=" + productDetailNo +
				", quantity=" + quantity +
				", message='" + message + '\'' +
				", deliveryStatus='" + deliveryStatus + '\'' +
				", orderProductList=" + orderProductList +
				'}';
	}
}

