<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>FIND PASSWORD</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="css/common.css">

<script>
$(function() {
	$("#resetPW").on("submit",isChecked);

	$("#m_pw").on("keyup",checkPW);
	$("#pw2").on("keyup",checkPW);
	$("#resetBtn").on("click",reset);
});

function checkPW() {
	var pw1 = $("#m_pw").val();
	var pw2 = $("#pw2").val();

	if(pw1 != pw2) {
		$("#pwMsg").html("비밀번호를 확인하세요.");
	} else {
		$("#pwMsg").html("비밀번호 일치");
	}
}

function isChecked() {
	var pwMsg = $("#pwMsg").html();

	if(pwMsg != "비밀번호 일치") {
		alert("비밀번호를 확인하세요.");
		$("#m_pw").focus();
		return false;
	}
}

function reset() {
	$("#pwMsg").empty();
}
</script>
</head>
<body>
<jsp:include page="header.jsp"/>
<h4>FIND PASSWORD</h4> 
<hr>
<form action="resetPW.do" method="post" id="resetPW">
<input type="hidden" name="m_id" value="${member.m_id}">
<div class="form-group">
	<label>PASSWORD </label>
	<input class="form-control" type="text" name="m_pw" id="m_pw" placeholder="새로운 비밀번호">
</div>

<div class="form-group">
	<label>PASSWORD CHECK</label>
	<input class="form-control" type="text" id="pw2" placeholder="비밀번호 확인">
	<span id="pwMsg"></span>
</div>
<input type="submit" class="btn btn-success" type="submit" value="비밀번호 변경하기">
</form>
</body>
</html>