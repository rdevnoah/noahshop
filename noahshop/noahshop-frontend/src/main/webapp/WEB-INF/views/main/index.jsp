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
	<link href="${pageContext.servletContext.contextPath }/assets/css/shop-homepage.css" rel="stylesheet">

</head>
<body>
	<!-- Navigation -->
	<c:import url='/WEB-INF/views/includes/navigation.jsp'>
		<c:param name="active" value="shopping" />
	</c:import>
	<!-- /.Navigation -->
	
	<div class="container">
		<div class="row">

			<div class="col-lg-3">
				<h1 class="my-4">Noahshop</h1>
				<div class="list-group">
					<c:forEach items="${requestScope.main.categoryList}" var="parentCategory">
						<a href="#" class="list-group-item">${parentCategory.name }</a>
						<c:forEach items="${parentCategory.childList}" var="childCategory">
							<a href="#" class="list-group-item">&nbsp; &nbsp; &nbsp; &nbsp; ${childCategory.name }</a>
						</c:forEach>
					</c:forEach>
				</div>
			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">
				<div id="carouselExampleIndicators" class="carousel slide my-4"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>


					</ol>
					<div class="carousel-inner" role="listbox">
						<div class="carousel-item active">
							<img class="d-block img-fluid" src="http://placehold.it/900x350"
								alt="First slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="http://placehold.it/900x350"
								alt="Second slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="http://placehold.it/900x350"
								alt="Third slide">
						</div>

					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
				<div class="row menu-title">Best Items</div>
				<div class="row">
					<c:forEach items="${requestScope.main.mainProductList }" var="product">
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="card h-100">
								<a href="${pageContext.servletContext.contextPath}/product/detail/${product.no}"><img class="card-img-top"
									src="${pageContext.request.contextPath}/assets/noahshop/images/${product.imageList[0].url}" alt=""></a>
								<div class="card-body">
									<h4 class="card-title">
										<a href="#">${product.name }</a>
									</h4>
									<h5>₩ ${product.price}</h5>
								</div>
								<div class="card-footer">
									<small class="text-muted">
										<c:forEach items="${product.optionStockVo }" var="optionChild">
											${optionChild.optionChild1Name }
										</c:forEach>
									</small>
								</div>
							</div>
						</div>
					</c:forEach>

				</div>
				<div class="row menu-title">All Items</div>
				<div class="row">
					<c:forEach items="${requestScope.main.productList }" var="product">
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="card h-100">
								<a href="#"><img class="card-img-top"
												 src="${pageContext.request.contextPath}/assets/noahshop/images/${product.imageList[0].url}" alt=""></a>
								<div class="card-body">
									<h4 class="card-title">
										<a href="#">${product.name }</a>
									</h4>
									<h5>₩ ${product.price}</h5>
								</div>
								<div class="card-footer">
									<small class="text-muted">
										<c:forEach items="${product.optionStockVo }" var="optionChild">
											${optionChild.optionChild1Name }
										</c:forEach>
									</small>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.col-lg-9 -->
			
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container -->

	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->
</body>

</html>
