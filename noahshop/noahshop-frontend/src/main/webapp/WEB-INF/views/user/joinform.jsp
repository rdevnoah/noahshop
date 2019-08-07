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
	<link href="${pageContext.servletContext.contextPath }/assets/css/shop-login.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath }/assets/css/shop-join.css" rel="stylesheet">

    <script src="${pageContext.request.contextPath }/assets/js/jquery/jquery.js"></script>
    <script>
        $(function(){
            $('#check-id-btn').click(function(){
                var id = $('#inputId').val();
                if(id == ''){
                    return;
                }

                /* ajax 통신 */
                $.ajax({
                    url: "${pageContext.servletContext.contextPath }/user/checkId?id=" + id,
                    type: "get",
                    dataType: "json",
                    data: "",
                    success: function(response){
                        if(response.result == "success"){
                            console.log(response);
                            //버튼 색깔 및 문자 바꾸기
                            $("#check-id-btn")
                            return;
                        }

                        if(response.result == "fail"){
                            alert('이미 존재하는 아이디입니다.\n다른 아이디를 사용해 주세요.');
                            $("#inputId").focus();
                            $("#inputId").val("");
                            return;
                        }

                    },
                    error: function(xhr, error){
                        console.error("error:" + error)
                    }
                });

                console.log(id);
            });


        })

    </script>
</head>
<body>
	<!-- Navigation -->
	<c:import url='/WEB-INF/views/includes/navigation.jsp'>
		<c:param name="active" value="login" />
	</c:import>
	<!-- /.Navigation -->

 	<div class="container">
 		<div class="card card-container">
        	<img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
            <p id="profile-name" class="profile-name-card"></p>
            <form id="login-form" method="post" action="${pageContext.servletContext.contextPath}/user/join" class="form-signin" name="loginForm">
                <span id="reauth-id" class="reauth-id"></span>
                <input type="text" id="inputId" class="form-control" placeholder="아이디" name="id" required autofocus>
                <button id="check-id-btn" class="btn btn-lg btn-primary btn-block btn-checkid">아이디중복확인</button>
                <input type="password" id="inputPassword" class="form-control" placeholder="패스워드" name="password" required>
                <input type="text" id="inputName" class="form-control" placeholder="이름" name="name" required>
                <input type="text" id="inputTel" class="form-control" placeholder="휴대폰 번호" name="tel" required>
                <input type="text" id="inputAddress" class="form-control" placeholder="주소" name="address" required>
                <input type="email" id="inputEmail" class="form-control" placeholder="Email" name="email" required>
                <button class="btn btn-lg btn-primary btn-block btn-join" type="submit">회원가입</button>
            </form><!-- /form -->
        </div>
        <!-- /.card-container -->
	</div>
	<!-- /.container -->

	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->
</body>
</html>