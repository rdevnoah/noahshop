<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Shop Homepage - Start Bootstrap Template</title>
	<!-- Bootstrap core CSS -->
	<link href="${pageContext.servletContext.contextPath }/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="${pageContext.servletContext.contextPath }/assets/css/shop-admin.css" rel="stylesheet">

	<style>
		.btn-product-register {
			position: absolute;
			background-color: #0b61fe;
			width: 105px;
			top: 78px;
			left: 80%;
		}

	</style>
</head>
<body>

	<div class="d-flex" id="wrapper">

		<!-- Sidebar -->
		<c:import url='/WEB-INF/views/admin/includes/sidebar.jsp'>
			<c:param name="active" value="shopping" />
		</c:import>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">
			
			<!-- navigation -->
			<c:import url='/WEB-INF/views/admin/includes/navigation.jsp' />
			<!-- /navigation -->

			<div class="container-fluid">
				<h1 class="mt-4">주문 목록</h1>

				<table>
					<tr>
						<th>주문자이름</th>
						<th>회원여부</th>
						<th>주문날짜</th>
						<th>연락처</th>
						<th>결제방식</th>
						<th>결제상태</th>
						<th>배송상태</th>
						<th>결제금액</th>
					</tr>
					<c:forEach items="${requestScope.list }" var="order">
						<tr>
							<td>${order.buyerName }</td>
							<td>${order.isMember }</td>
							<td>${order.orderDate }</td>
							<td>${order.buyerTel }</td>
							<td>${order.payment }</td>
							<td>${order.status }</td>
							<td>${order.deliveryStatus }</td>
							<td>${order.price }</td>
							<td><a href="${pageContext.servletContext.contextPath }/admin/order/detail/${order.no}">상세보기</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<!-- /#page-content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- Bootstrap core JavaScript -->
	<script src="${pageContext.servletContext.contextPath }/assets/js/jquery/jquery.min.js"></script>
	<script src="${pageContext.servletContext.contextPath }/assets/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Menu Toggle Script -->
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
	</script>

</body>

</html>
