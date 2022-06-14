<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Member</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="../css/common.css">

<script>
$(function ()delete{
	$("#m_pw").on("keyup",checkPW);
	$("#pw2").on("keyup",checkPW);
	$("#delete").on("click",Delete);
});
	function Delete() {
	
	}
		
	function checkPW() {
		<c:if>${member.m_pw}</c:if><br>
		var pw2 = $("#pw2").val();

		if (pw1==pw2) {
			$("#pwMsg").html("pass");
		} else {
			$("#pwMsg").html("fail");
	}
}
		function memberDelete() {
			location.href = "/jaeyong/memberDelete.java";
	}
}
</script>
</head>

<body>
<jsp:include page="../jayoung/header.jsp"/>
	<h1>MemberDelete</h1>
	<form action="/jaeyong/memberDelete.do" method="post">
	
		<label>비밀번호 : </label>
		<input type="text"
			   value="${member.m_pw}"
			   name="m_pw"
			   id="m_pw"><br>
			   
		<label>비밀번호 확인 : </label>
		<input type="text"
			   id="pw2">
		<span  id="pwMsg"></span><br>
		
		<input type="submit"
			   value="회원탈퇴">
	</form>

</body>
</html>