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
<link rel="stylesheet" href="common.css">

<script>
$(function() {
	$("#joinForm").on("submit",isChecked);
	$("#check").hide();
	
	$("#m_id").on("keyup",checkID);
	$("#m_pw").on("keyup",checkPW);
	$("#pw2").on("keyup",checkPW);
	$("#resetBtn").on("click",reset);
	$("#sendSMS").on("click",sendSMS);
	
});

function checkPW() {
	var pw1 = $("#m_pw").val().trim();
	var pw2 = $("#pw2").val().trim();
	
	if(pw1==null||pw1==''){
		$("#pwMsg").html("PW는 필수입력입니다.");
	}else if(pw1 != pw2) {
		$("#pwMsg").html("비밀번호를 확인하세요.");
	} else {
		$("#pwMsg").html("비밀번호 일치");
	}
}

function checkID() {
	var m_id = $("#m_id").val().trim();
	if(m_id==""||m_id==null) {
		$("#idMsg").html("ID는 필수입력입니다.");
		return;
	}
	$.ajax({
		url:"idCheck.do",
		data:{"m_id":m_id},
		success: function(resData) {
			if(resData==0) {
				$("#idMsg").html("사용가능한 ID입니다.");
			}else {
				$("#idMsg").html("이미 사용중인 ID입니다.");	
			}
		},
		fail: function() {}
	});
}

function isChecked() {
	var idMsg = $("#idMsg").html().trim();
	var pwMsg = $("#pwMsg").html().trim();

	var name = $("#m_name").val();
	var email = $("#email").val();
	var phone = $("#phone").val();
	var random = $("#random").val();
	
	if(idMsg != "사용가능한 ID입니다.") {
		$("#m_id").focus();
		return false;
	}else if(pwMsg != "비밀번호 일치") {
		$("#m_pw").focus();
		return false;
	}else if(name==null||name==''){
		$("#m_name").focus();
		return false;
	}else if(email==null||email==''){
		$("#email").focus();
		return false;
	}else if(phone==null||phone==''){
		$("#phone").focus();
		return false;
	}else if(random==null||random==''){
		return false;
	}	
}

function sendSMS() {
	var phone = $("#phone").val();
	if(phone==null||phone=='') {
		alert("연락처를 먼저 입력해주세요.");
		return;
	}
	$("#check").show();
}

function reset() {
	$("#idMsg").empty();
	$("#pwMsg").empty();
}
</script>
</head>

<body>
<jsp:include page="header.jsp"/>

<h4>JOIN ShowTiCat</h4>
<hr>
<form action="insert.do" method="post" id="joinForm">
<div class="form-group">
	<label>ID </label>
	<input class="form-control" type="text" name="m_id" id="m_id">
	<span id="idMsg"></span>
</div>

<div class="form-group">
	<label>PASSWORD </label>
	<input class="form-control" type="text" name="m_pw" id="m_pw">
</div>

<div class="form-group">
	<label>PASSWORD CHECK</label>
	<input class="form-control" type="text" id="pw2" placeholder="비밀번호 확인">
	<span id="pwMsg"></span>
</div>

<div class="form-group">
	<label>NAME </label>
	<input class="form-control" type="text" name="m_name" id="m_name">
</div>

<div class="form-group">
	<label>EMAIL </label>
	<input class="form-control" type="email" name="email" id="email" placeholder="abcdef@showticat.com">
</div>

<div class="form-group">
	<label>PHONE </label>
	<input class="form-control" type="text" name="phone" id="phone" placeholder="하이픈(-)제외 11자리 입력" pattern="[01]{2}[01679]{1}[0-9]{7,8}">
	<input class="btn btn-outline-danger" type="button" id="sendSMS" value="인증번호받기">
	
	<div id="check">
		<label>인증번호 :</label>
		<input class="form-control" type="text" name="random" id="random" placeholder="인증번호 입력" >
		<input class="btn btn-outline-danger" type="button" id="checkNum" value="인증하기">
		<div id="msg"></div>
	</div>
</div>

<div class="form-group">
	<label>BIRTHDAY </label>
	<input class="form-control" type="date" name="birth">
</div>

<div class="form-group form-check-inline">
	<label>GENDER </label>
	<label class="form-check-inline">
		<input class="form-check-input" type="radio" name="gender" value="M">남
	</label>
	<label class="form-check-inline">
		<input class="form-check-input" type="radio" name="gender" value="W">여
	</label>
</div>
<br>
<input type="submit" class="btn btn-success" value="회원가입" id="submitBtn">
<input type="reset" class="btn btn-secondary" value="초기화" id="resetBtn">
</form>

</body>
</html>