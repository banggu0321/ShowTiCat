<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Password Check</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="../css/common.css">

<script>
	$(function() {
		$("#m_pw").on("keyup", checkPW);
		$("#pw2").on("keyup", checkPW);

	});

	function checkPW() {
		var pw1 = $("#m_pw").val();
		var pw2 = $("#pw2").val();

		if (pw1 == pw2) {
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
	<jsp:include page="../jayoung/header.jsp" />
			<div class="contents">
		<jsp:include page="../jaeyong/mySide.jsp" />
			<h1>Password Check</h1>

			<form action="modifyPwCheck.do" method="post">
				<br> <input type="hidden" name="m_pw" id="m_pw"
					value="${member.m_pw}"><br> <label>비밀번호 확인 : </label>
				<input type="password" id="pw2" name="m_pw"> <input
					type="submit" class="btn btn-outline-success" value="확인"><br>
				<span id="pwMsg"></span>
			</form>
		</div><!-- contents -->
</body>
</html>