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

				<div class="card mt-4">
					<div class="card-body">
						<h1>카트정보 !!</h1>
						<table>
							<tr>
								<th>
									상품명
								</th>
								<th>
									상품코드
								</th>
								<th>
									가격
								</th>
								<th>
									수량
								</th>
							</tr>
							<c:forEach items="${requestScope.cartList}" var="product">
								<tr>
									<td>${product.name }</td>
									<td>${product.code }</td>
									<td>${product.price }</td>
									<td>${product.stock }</td>
								</tr>
							</c:forEach>
						</table>
						<a href="${pageContext.servletContext.contextPath }/order/orderform"><button type="button">주문</button></a>
					</div>
					<p class="card-text">

					</p>

				</div>
				<!-- /.card -->

			</div>
			<!-- /.col-lg-9 -->

		</div>

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->
</body>

</html>
