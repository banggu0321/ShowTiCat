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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="../css/common.css">

<script>
$(function() {
	$("#loginForm").on("submit", isEmpty);
	
	$("#findID").on("click", findID);
	$("#findPW").on("click", findPW);
})

function findID() {
	location.href="findID.do";
}

function findPW() {
	location.href="findPW.do";
}

function isEmpty() {
	var id = $("#m_id").val();
	var pw = $("#m_pw").val();
	
	if(id==null||id=='') {
		$("#m_id").focus();
		return false;
	}else if(pw==null||pw=='') {
		$("#m_pw").focus();
		return false;
	}
}
</script>

</head>

<body>
<jsp:include page="header.jsp"/>
<div class="contents">
	<form action="login.do" method="post" id="loginForm">
	<div class="form-group">
		<label>아이디 </label>
		<input class="form-control" type="text" name="m_id" id="m_id">
	</div>
	
	<div class="form-group">
		<label>비밀번호 </label>
		<input class="form-control" type="password" name="m_pw" id="m_pw">
	</div>
	
	<input class="btn btn-success" type="submit" value="로그인">
	</form> <hr>
	<button id="findID" class="btn btn-outline-success">아이디 찾기</button>
	<button id="findPW" class="btn btn-outline-success">비밀번호 찾기</button>
</div>
</body>
</html>