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
	<script>
		$(function(){
			var count=0;

			var detailList = new Array();
			var nolist = new Array();

			<c:forEach items="${requestScope.productDetail.details}" var="product">
				var json=new Object();
				json.no="${product.no}";
				json.option1No="${product.optionChildNo1}";
				json.option2No="${product.optionChildNo2}";
				detailList.push(json);
			</c:forEach>

			//console.log(detailList.length);
			// for (var i=0 ; i<detailList.length ; i++){
			// 	console.log(detailList[i].no);
			// }



			$('#option1').change(function(){
				var $optionNo = $('#option1').val();
				var productNo = ${requestScope.productDetail.productDetail.no };
				$('#option2').html("<option>----------</option>");
				var list = null;
				var innerhtml="";
				/* ajax 통신 */
				$.ajax({
					url: "${pageContext.servletContext.contextPath }/product/getOption2?productNo="+productNo+"&option1No="+$optionNo,
					type: "get",
					dataType: "json",
					data: "",
					success: function(response){
						if(response.result == "success"){

							list = response.data;
							console.log(list);

							for (var i=0 ; i < list.length; i++) {
								innerhtml += "<option value=" + list[i].no + ">" + list[i].name + "</option>";
							}
							console.log(innerhtml);
							$('#option2').append(innerhtml);
							return;
						}

						if(response.result == "fail"){
							//fail code
							return;
						}
					},
					error: function(xhr, error){
						console.error("error:" + error)
					}
				});
			});

			$('#add-btn').click(function(){
				var option1 = $('#option1').val();
				var option1Name = $('#option1 option:selected').text();
				var option2 = $('#option2').val();
				var option2Name = $('#option2 option:selected').text();
				var amount = $('#order-amount').val();
				console.log(option1Name + ":" + option2Name + ":" + amount);
				var detailNo = "";


				for (var i=0 ; i<detailList.length ; i++){
					if (detailList[i].option1No == option1 && detailList[i].option2No==option2){
						detailNo = detailList[i].no;
					}
				}

				console.log(nolist);


				var innerhtml = "";

				innerhtml += "옵션1 : <input type='text' name='productList["+count+"].optionChild1Name' value='"+ option1Name +"' readOnly=true>" +
						"<input type='hidden' name='productList["+count+"].optionChildNo1' value='"+ option1 +"'>" +
						"/ 옵션2 : <input type='text' name='productList["+count+"].optionChild2Name' value='"+ option2Name +"' readOnly=true>" +
						"<input type='hidden' name='productList["+count+"].optionChildNo2' value='"+ option2 +"'>" +
						"<input type='hidden' name='productList["+count+"].no' value='"+ detailNo +"'>" +
						"/ 수량 : <input type='number' name='productList["+count+"].stock' value='"+ amount +"' readOnly=true>" +
						"<button type='button' value=''>삭제</button><br>"
				$('#order-area').append(innerhtml);
				count++;

			});
		});



	</script>

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
					<img class="card-img-top img-fluid"
						 src="${pageContext.request.contextPath}/assets/noahshop/images/${requestScope.productDetail.imageList[0].url}">
					<div class="card-body">
						<h3 class="card-title">${requestScope.productDetail.productDetail.name}</h3>
						<h4>${requestScope.productDetail.productDetail.price}</h4>
						<form action="${pageContext.servletContext.contextPath }/cart/add">
							<div>
								SIZE :
								<select id="option1">
									<option>----------</option>
									<c:forEach items="${requestScope.productDetail.optionList }" var="option">
										<c:if test="${option.parentName == 'SIZE' }">
											<option value="${option.no }">${option.name }</option>
										</c:if>
									</c:forEach>
								</select id="option2">
							</div>
							<div>
								COLOR :
								<select id="option2" name="">
									<option>----------</option>
								</select>
							</div>
							<div>
								수량 :
								<input id='order-amount' type="number" name="">
								<button id="add-btn" type="button">추가</button>
							</div>
							<%-- Todo: 장바구니, 주문 버튼 --%>
							<div id="order-area">


							</div>
							<input type="hidden" name="no" value="${requestScope.productDetail.productDetail.no}">
							<button type="submit">Add Cart</button>
							<button type="submit">Order</button>
						</form>
					</div>
					<p class="card-text">

					</p>

				</div>
				<!-- /.card -->



				<div class="card card-outline-secondary my-4">
					<div class="card-header">상세설명</div>
					<div class="card-body">
						<p class="card-text">
							${requestScope.productDetail.productDetail.description}
						</p>

					</div>
				</div>




				<div class="card card-outline-secondary my-4">
					<div class="card-header">리뷰들.</div>
					<div class="card-body">
						<p>
							Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Omnis et enim aperiam inventore, similique necessitatibus neque
							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
							Sequi mollitia, necessitatibus quae sint natus.
						</p>
						<small class="text-muted">Posted by Anonymous on 3/1/17</small>
						<hr>
						<p>
							Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Omnis et enim aperiam inventore, similique necessitatibus neque
							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
							Sequi mollitia, necessitatibus quae sint natus.
						</p>
						<small class="text-muted">Posted by Anonymous on 3/1/17</small>
						<hr>
						<p>
							Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Omnis et enim aperiam inventore, similique necessitatibus neque
							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
							Sequi mollitia, necessitatibus quae sint natus.
						</p>
						<small class="text-muted">Posted by Anonymous on 3/1/17</small>
						<hr>
						<a href="#" class="btn btn-success">Leave a Review</a>
					</div>
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
