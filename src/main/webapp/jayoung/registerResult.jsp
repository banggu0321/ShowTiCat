<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>JOIN ShowTiCat</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="css/common.css">

<style>
#welcome {
	text-align: center;
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
<div id="welcome">
<p>${m_id}님 회원가입이 완료되었습니다.</p>
<p>환영합니다!</p>
<button class="btn btn-light" id="login">로그인</button>
</div>
</body>
</html>