<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>FIND PASSWARD</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="../css/common.css">

<style>
#resetPW {
	text-align: center;
}
.resetPW {
	width: 500px;
	margin: auto;
	padding-top: 50px;
}
</style>
<script>
$(function() {
	$("#login").on("click",login);
})

function login() {
	location.href="login.do";
}
</script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="contents resetPW">
	<div id="resetPW">
	<p>비밀번호 수정이 완료되었습니다.</p>
	<button class="btn btn-success" id="login">로그인</button>
	</div>
</div>
</body>
</html>