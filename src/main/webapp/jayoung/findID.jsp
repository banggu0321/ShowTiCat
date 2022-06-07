<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>FIND ID</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="common.css">

<script>
$(function() {
	$("form").on("submit",isEmpty);
	$("#findPW").on("click", findPW);
	$("#sendSMS").on("click",sendSMS);
})

function findPW() {
	location.href="findPW.do";
}

function sendSMS() {
	$("#check").css('display','block');
	var phone = $(".phone").val();
	if(phone==null||phone=='') {
		alert("연락처를 먼저 입력해주세요.");
		return;
	}
	$.ajax({
		url:"randonNumCheck.do",
		data:{"phone",phone},
		success: function() {
			
		},
		fail: function() {}
	});
}

function isEmpty() {
	
}
</script>

<style>
#check {

}
</style>
</head>
<body>
<h1>FIND ID</h1> 
<hr>
<form action="findID.do" method="post">
<div class="form-group">
	<label>이름 :</label>
	<input class="form-control" type="text" name="m_name">
</div>

<div class="form-group">
	<label>휴대전화 :</label>
	<input class="form-control" type="text" name="phone" placeholder="하이픈(-)제외 11자리 입력" pattern="[01]{3}[0-9]{8}">
	<input class="btn btn-outline-danger" type="button" id="sendSMS" value="인증번호받기">
	
	<div id="check">
		<label>인증번호 :</label>
		<input class="form-control" type="text" name="random" id="random" placeholder="인증번호 입력" >
		<input class="btn btn-outline-danger" type="button" id="checkNum" value="인증하기">
	</div>
</div>

<input class="btn btn-success" type="submit" value="아이디 찾기">
</form> <hr>
<button id="findPW" class="btn btn-outline-success">비밀번호 찾기</button>
</body>
</html>