<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Shop Homepage - Start Bootstrap Template</title>
	<!-- Bootstrap core CSS -->
	<link href="${pageContext.servletContext.contextPath }/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="${pageContext.servletContext.contextPath }/assets/css/shop-item.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath }/assets/js/jquery/jquery.js"></script>


</head>

<body>
	<!-- Navigation -->
	<c:import url='/WEB-INF/views/includes/navigation.jsp'>
		<c:param name="active" value="shopping" />
	</c:import>
	<!-- /.Navigation -->

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="col-lg-3">
				<h1 class="my-4">Shop Name</h1>
				<div class="list-group">
					<a href="#" class="list-group-item active">Category 1</a>
					<a href="#" class="list-group-item">Category 2</a>
					<a href="#" class="list-group-item">Category 3</a>
				</div>
			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">
				<h1>주문 작성하기</h1>
				<form action="${pageContext.servletContext.contextPath }/order/add">
					<div class="card card-outline-secondary my-4">
						<div class="card-header">
							<h3 class="card-title">주문 상품 정보</h3>
						</div>

						<div class="card-body">
							<p class="card-text">
								<table>
									<tr>
										<th>
											상품명
										</th>
										<th>
											상품코드
										</th>
										<th>
											수량
										</th>
										<th>
											가격
										</th>
									</tr>
									<c:forEach items="${requestScope.info.productList}" var="product" varStatus="status">
										<tr>
											<td>
												<input type="hidden" name="orderProductList[${status.index}].productDetailNo" value="${product.productDetailNo}">
												<input type="hidden" name="orderProductList[${status.index}].quantity" value="${product.stock}">
													${product.name }
											</td>
											<td>
													${product.code }
											</td>
											<td>
													${product.stock }
											</td>
											<td>
													${product.price }
											</td>
										</tr>
									</c:forEach>

								</table>

							</p>
						</div>
						<div class="card-footer">
							총 결재 금액 : ${requestScope.info.totalPrice }
							<input type="hidden" name="price" value="${requestScope.info.totalPrice }">
						</div>



					</div>
					<!-- /.card -->

					<div class="card card-outline-secondary my-4">
						<div class="card-header">
							<h3 class="card-title">주문자 정보</h3>
						</div>

						<div class="card-body">
							<p class="card-text">
							<div>
								주문자 : <input type="text" value="${requestScope.info.memberInfo.name }">
							</div>
							<div>
								연락처 : <input type="text" value="${requestScope.info.memberInfo.tel }">
							</div>
							<div>
								이메일 : <input type="text" value="${requestScope.info.memberInfo.email }">
							</div>
							<div>
								주소 : <input type="text" value="${requestScope.info.memberInfo.address }">
							</div>
							</p>
						</div>

					</div>
					<div class="card card-outline-secondary my-4">
						<div class="card-header">
							<h3 class="card-title">배송지 정보</h3>
						</div>

						<div class="card-body">
							<p class="card-text">
							<div>
								<input type="hidden" name="memberNo" value="${requestScope.info.memberInfo.no}">
								받는 분 : <input type="text" name="buyerName" value="${requestScope.info.memberInfo.name }">

							</div>
							<div>
								연락처 : <input type="text" name="buyerTel" value="${requestScope.info.memberInfo.tel }">
							</div>
							<div>
								이메일 : <input type="text" name="email" value="${requestScope.info.memberInfo.email }">
							</div>
							<div>
								주소 : <input type="text" name="address" value="${requestScope.info.memberInfo.address }">
							</div>
							<div>
								배송 메세지 :
								<select name="message">
									<option value="부재시 경비실에 맡겨주세요">부재시 경비실에 맡겨주세요</option>
									<option value="배송 전에 연락 주세요">배송 전에 연락 주세요</option>
									<option value="문앞에 두세요">문앞에 두세요</option>
								</select>
							</div>
							</p>
						</div>

					</div>

					<div class="card card-outline-secondary my-4">
						<div class="card-header">
							<h3 class="card-title">결제 정보</h3>
						</div>

						<div class="card-body">
							<p class="card-text">
							<div>
								결제방식 :
								<select name="payment">
									<option value="">-------------</option>
									<option value="무통장입금">무통장 입금</option>
									<option value="카드결제">카드 결제</option>
								</select>
							</div>
							</p>
						</div>
						<div class="card-footer">
							<button type="submit" class="btn btn-primary btn-sm">
								주문하기
							</button>

						</div>
					</div>
				</form>



			</div>
			<!-- /.col-lg-9 -->
		</div>
		<!-- row -->

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->
</body>

</html>
