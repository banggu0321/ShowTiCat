<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Password Check</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="../css/common.css">
<link rel="stylesheet" href="../css/memberMyPage.css">


<script>
$(function() {
	$("#m_pw").on("keyup",checkPW);
	$("#pw2").on("keyup",checkPW);

});

$(function(){
	$("#btnDelete").click(function(){
		var m_id = $(this).attr("m_mm");
		if(confirm(m_id + "삭제?"))
			location.href = "memberDelete.do?m_id="+m_id;
	});
});

function checkPW() {
    var pw1= $("#m_pw").val();
    var pw2= $("#pw2").val();
    
    if(pw1==pw2) {
            $("#pwMsg").html("pass")
        } else {
            $("#pwMsg").html("fail")	        	
        }
    
    }
 
</script>
<style>
p {
	margin: 0;
	font-size: 0.25em;
	color: tomato;
}
</style>
</head>
	<body>
	<jsp:include page="../jayoung/header.jsp"/>
	
	<div class="fbx">
		<div class=mySide>
			<div class="favorite">
			<a href = "#">관심매장</a>
			</div><!-- favorite -->

			<div class="reservation">
			<a href = "../mypage/confirm.do">예매</a>	
			</div><!-- reservation -->

			<div class="memberDetail">
			<a href = "../jaeyong/memberDetail.do">회원정보수정</a>			
			</div><!-- reservation -->

			<div class="delete">
			<a href = "../jaeyong/deletePwCheck.do">회원탈퇴</a>
			</div><!-- delete -->
		</div><!-- mySide -->
		
		<div class="centerHidden">
		<h1>Password Check</h1>
		<form action="memberDelete.do" method="post">
		<br> 
		<input type="hidden"
			   name="m_pw"
			   id="m_pw" value="${member.m_pw}"><br>
		
		<label>비밀번호 확인 : </label>
		<input type="password"
			   id="pw2"
			   name="m_pw">
		
		<input type="submit"
			   class="btn btn-outline-success"	
			   value="확인" ><br>
		<span  id="pwMsg"></span>

	</form>
		</div><!-- centerHidden -->

		<div class="rightHidden">
		</div><!-- rightHidden -->

	</div><!-- fbx -->
</body>
</html>