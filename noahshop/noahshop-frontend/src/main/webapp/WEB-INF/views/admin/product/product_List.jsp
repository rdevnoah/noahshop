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
				<h1 class="mt-4">상품 목록</h1>
				<a href="${pageContext.servletContext.contextPath }/admin/product/addform">
					<button id="register-btn" type="button" class="btn btn-lg btn-primary btn-block btn-join btn-product-register">상품등록</button>
				</a>
				<table>
					<tr>
						<th>상품명</th>
						<th>상품코드</th>
						<th>가격</th>
						<th>등록일</th>
						<th>메인진열</th>
						<th>판매여부</th>
					</tr>
					<c:forEach items="${requestScope.productList }" var="product">
						<tr>
							<td>${product.name }</td>
							<td>${product.code }</td>
							<td>${product.price }</td>
							<td>${product.regDate }</td>
							<td>${product.dpMain }</td>
							<td>${product.isSell }</td>
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
