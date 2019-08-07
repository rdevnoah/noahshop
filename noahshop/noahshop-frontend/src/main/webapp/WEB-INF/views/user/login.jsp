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

    <script src="${pageContext.request.contextPath }/assets/js/jquery/jquery.js"></script>
    <script>

        <%--$(function(){--%>
        <%--    $("#login-form").submit(function(e){--%>
        <%--        e.preventDefault();--%>

        <%--        var params = "id=" + $("#inputId").val() + "&password=" + $("#inputPassword").val();--%>
        <%--        console.log(params);--%>
        <%--        $.ajax({--%>
        <%--            url: "${pageContext.request.contextPath }/user/auth",--%>
        <%--            type: "post",--%>
        <%--            //dataType: "json",--%>
        <%--            data: params,--%>
        <%--            success: function(response){--%>
        <%--                console.log(response);--%>
        <%--            },--%>
        <%--            error: function(jqXHR, status, e){--%>
        <%--                console.error(status + ":" + e);--%>
        <%--            }--%>
        <%--        });--%>

        <%--    })--%>

        <%--})--%>

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
            <form id="login-form" method="post" action="${pageContext.servletContext.contextPath}/user/auth" class="form-signin" name="loginForm">
                <span id="reauth-id" class="reauth-id"></span>
                <input type="text" id="inputId" class="form-control" placeholder="아이디" name="id" required autofocus>
                <input type="password" id="inputPassword" class="form-control" placeholder="패스워드" name="password" required>
                <div id="remember" class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> 자동 로그인
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">로그인</button>
            </form><!-- /form -->
            <a href="javascript:loginForm.submit();" class="forgot-password">
                비밀번호를 잊으셨습니까?
            </a>
        </div>
        <!-- /.card-container -->
	</div>
	<!-- /.container -->

	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->
</body>
</html>