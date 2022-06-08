<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>LOGIN</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="common.css">

<script>
$(function() {
	$("#findID").on("click", findID);
	$("#findPW").on("click", findPW);
})

function findID() {
	location.href="findID.do";
}

function findPW() {
	location.href="findPW.do";
}
</script>
</head>

<body>
<jsp:include page="header.jsp"/>
<h4>LOGIN</h4> 
<hr>
<form action="login.do" method="post">
<div class="form-group">
	<label>아이디 :</label>
	<input class="form-control" type="text" name="m_id" value="ja0">
</div>

<div class="form-group">
	<label>비밀번호 :</label>
	<input class="form-control" type="text" name="m_pw" value="1234">
</div>

<input class="btn btn-success" type="submit" value="로그인">
</form> <hr>
<button id="findID" class="btn btn-outline-success">아이디 찾기</button>
<button id="findPW" class="btn btn-outline-success">비밀번호 찾기</button>
</body>
</html>