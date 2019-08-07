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

            $('#inputId').change(function(){
                $('#confirmId').val('false');
                $("#check-id-btn").css('background-color', '#ef420fa6');
                $("#check-id-btn").val("아이디중복확인");
            })

            $('#check-id-btn').click(function(){
                var id = $('#inputId').val();
                if(id == ''){
                    return;
                }
                /* ajax 통신 */
                $.ajax({
                    url: "${pageContext.servletContext.contextPath }/user/checkId/" + id,
                    type: "get",
                    dataType: "json",
                    data: "",
                    success: function(response){
                        if(response.result == "success"){
                            alert("사용 가능한 아이디입니다.");
                            console.log(response);
                            $("#check-id-btn").css('background-color', '#82EF2B');
                            $("#check-id-btn").text("아이디 확인 완료");
                            $('#confirmId').val('true');
                            return;
                        }

                        if(response.result == "fail"){
                            alert(response.message);
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


            $('#submit-btn').click(function(){
                var $confirmId = $('#confirmId').val();
                console.log('clicked');
                var $password1 = $('#inputPassword').val();
                var $password2 = $('#inputPassword2').val();
                if ($password1 == $password2){
                    $('#confirmPassword').val('true')
                }else{
                    $('#confirmPassword').val('false');
                }
                var $confirmPassword = $('#confirmPassword').val();

                if ($confirmPassword == 'false'){
                    alert('패스워드와 패스워드 확인 값이 일치하지 않습니다.')
                    $('#inputPassword').val('');
                    $('#inputPassword2').val('');
                    $('#inputPassword').focus();
                    return;
                }else if ($confirmId == 'false'){
                    alert('아이디 중복 확인을 하세요');
                    $('#inputId').focus();
                    return;
                }else{
                    $('#join-form').submit();
                }


            });




        });




    </script>
</head>
<body>
	<!-- Navigation -->
	<c:import url='/WEB-INF/views/includes/navigation.jsp'>
		<c:param name="active" value="join" />
	</c:import>
	<!-- /.Navigation -->

 	<div class="container">
 		<div class="card card-container">
        	<img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
            <p id="profile-name" class="profile-name-card"></p>
            <form id="join-form" method="post" action="${pageContext.servletContext.contextPath}/user/join" class="form-signin" name="joinForm">
                <span id="reauth-id" class="reauth-id"></span>
                <input type="text" id="inputId" class="form-control" placeholder="아이디" name="id" required autofocus>
                <button id="check-id-btn" class="btn btn-lg btn-primary btn-block btn-checkid" type="button">아이디중복확인</button>
                <input type="hidden" id="confirmId" value="false">
                <input type="password" id="inputPassword" class="form-control" placeholder="패스워드" name="password" required>
                <input type="password" id="inputPassword2" class="form-control" placeholder="패스워드확인" name="passwordConfirm" required>
                <input type="hidden" id="confirmPassword" value="false">
                <input type="text" id="inputName" class="form-control" placeholder="이름" name="name" required>
                <input type="text" id="inputTel" class="form-control" placeholder="휴대폰 번호" name="tel" required>
                <input type="text" id="inputAddress" class="form-control" placeholder="주소" name="address" required>
                <input type="email" id="inputEmail" class="form-control" placeholder="Email" name="email" required>
                <button id="submit-btn" class="btn btn-lg btn-primary btn-block btn-join" type="button">회원가입</button>
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