<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <script src="${pageContext.request.contextPath }/assets/js/jquery/jquery.js"></script>
    <script>
        var sel_file;
        var count=0;
        $(function(){
            $("#chosenImg").on("change", handleImgFileSelect);

            $('input[name="isOption"]').change(function(){
                var checked = $('input[name="isOption"]:checked').val();
                console.log(checked);
                if (checked == 'N'){
                    $('#isOption').hide();

                }else {
                    $('#isOption').show();
                    $('#isNotOptionStock').hide();
                }
                
            });

            //1. 추가버튼 누르면 선택된 라디오값으로 innerhtml 생성해서
            $('#add-option-btn').click(function(){
                var optionNo1 = $('input[name="optionNo1"]:checked').val();
                var optionName1 = $('input[name="optionNo1"]:checked').next().text();
                var optionNo2 = $('input[name="optionNo2"]:checked').val();
                var optionName2 = $('input[name="optionNo2"]:checked').next().text();
                var stock = $('#isOptionStock').val();
                $('#isOptionStock').val('');

                console.log(optionNo1 + ":" + optionNo2 + ":" + stock + ":"+optionName1 + ":" + optionName2);

                var innerhtml = "<label>"+optionName1 +"</label>\n" +
                    "                    <input type='hidden' name='optionStockVoList["+count+"].optionChild1No' value='"+optionNo1 +"'>\n" +
                    "                    <label>/</label>\n" +
                    "                    <label>"+optionName2 +"</label>\n" +
                    "                    <input type='hidden' name='optionStockVoList["+count+"].optionChild2No' value='"+optionNo2 +"'>\n" +
                    "                    <label>/</label>\n" +
                    "                    <label>"+stock +"</label>\n" +
                    "                    <input type='hidden' name='optionStockVoList["+count+"].stock' value='"+stock+"'><br>";

                console.log(innerhtml);
                $('#optionResult').append(innerhtml);
                count++;

            });


            //2. #optionResult div에 append 한다.

            //3. 선택된 라디오 값들 선택 해제 한다.


        });

        function handleImgFileSelect(e){
            var files = e.target.files;
            var filesArr = Array.prototype.slice.call(files);

            filesArr.forEach(function(f){
                if (!f.type.match("image.*")){
                    alert("확장자는 이미지만 가능합니다.");
                    return;
                }

                sel_file = f;

                var reader = new FileReader();
                reader.onload = function(e){
                    $("#preView").attr("src", e.target.result);
                }
                reader.readAsDataURL(f);
            });
        }

    </script>
    <style>
        .register-table{
            text-align: left;

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
            <h1>상품등록폼</h1>
            <form method="post" action="${pageContext.servletContext.contextPath}/admin/product/add" enctype="multipart/form-data">
                <div>카테고리 선택</div>
                <div>
                    <c:forEach items="${requestScope.map.categoryList}" var="parentCategory">
                        <div>${parentCategory.name }</div>
                        <div>
                            <c:forEach items="${parentCategory.childList }" var="childCategory">
                                <input type="radio" name="categoryNo" value="${childCategory.no} ">${childCategory.name}
                            </c:forEach>
                        </div>
                    </c:forEach>
                </div>
                <div> 상품명 : <input type="text" name="name"> </div>


                <div>이미지 등록 </div>
                <div><img id="preView" src=""></div></tr>
                <div><input id="chosenImg" type="file" name="multipartFile"></div>

                <div>옵션등록</div>
                <div>
                    <input type="radio" name="isOption" value="Y"> 옵션있음
                    <input type="radio" name="isOption" value="N"> 옵션없음
                </div>
                <div id="isOption" style="display:none;">
                    <div>
                        ${requestScope.map.optionList[1].name}
                    </div>

                    <div>
                        <c:forEach items="${requestScope.map.optionList[1].childList}" var="childOption">
                            <label>
                                <input type="radio" name="optionNo1" value="${childOption.no}">
                                <label>${childOption.name}</label>
                            </label>
                        </c:forEach>
                    </div>
                    <div>
                        ${requestScope.map.optionList[2].name}
                    </div>


                    <div>
                        <c:forEach items="${requestScope.map.optionList[2].childList}" var="childOption">
                            <label>
                                <input type="radio" name="optionNo2" value="${childOption.no}">
                                <label>${childOption.name}</label>
                            </label>
                        </c:forEach>
                    </div>
                    <div>수량 : <input id="isOptionStock" type="number"></div>
                    <label><button type="button" id="add-option-btn">추가</button></label>
                </div>

                <div id="isNotOptionStock">
                    수량 : <input type="number" name="noOptionStock">
                </div>

                <div id="optionResult">
<%--                    <label>XS</label>--%>
<%--                    <input type='hidden' name='optionStockVoList[0].optionChild1No' value='xxxx'>--%>
<%--                    <label>/</label>--%>
<%--                    <label>BLACK</label>--%>
<%--                    <input type='hidden' name='optionStockVoList[0].optionChild2No' value='xxxx'>--%>
<%--                    <label>/</label>--%>
<%--                    <label>1000</label>--%>
<%--                    <input type='hidden' name='optionStockVoList[0].stock' value='xxxx'>--%>
                </div>

                <div>
                    가격 : <input type="number" name="price" value="">
                </div>


                <div>상품설명 : <textarea name="description"></textarea></div>


                <div>메인진열여부 : Y <input type="radio" name="dpMain" value="Y">    N<input type="radio" name="dpMain" value="N"></div>


                <div>판매여부 : Y <input type="radio" name="isSell" value="Y">    N<input type="radio" name="isSell" value="N"></div>

                <div><button class="btn btn-lg btn-primary btn-block btn-join" type="submit">등록</button></div>

            </table>
            </form>




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
