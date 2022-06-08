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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="common.css">

<script>
$(function() {
	$("#findForm").on("submit",isEmpty);
	$("#check").hide();
	$("#findPW").on("click", findPW);
	$("#sendSMS").on("click",sendSMS);
	$("#checkNum").on("click",checkNum);
})

function findPW() {
	location.href="findPW.do";
}

var code="";
function sendSMS() {
	var phone = $("#phone").val();
	if(phone==null||phone=='') {
		alert("연락처를 입력해주세요.");
		$("#phone").focus();
		return;
	}

	$("#check").show();
	$.ajax({
		url:"randomNumCheck.do?phone="+phone,
		success:function(data) {
			alert("인증번호를 발송하였습니다.");
			$("#phone").attr("readonly",true);
			code = data;
		}
	})
}

function isEmpty() {
	var name = $("#m_name").val();
	var phone = $("#phone").val();
	var msg = $("#msg").html();
	
	if(name==null||name=='') {
		$("#m_name").focus();
		return false;
	}else if(phone==null||phone=='') {
		$("#phone").focus();
		return false;
	}else if(msg!="인증성공") {
		alert("휴대폰 인증을 해주세요.");
		$("#random").focus();
		return false;
	}
}

function checkNum() {
	var input = $("#random").val();
	if(input == code) {
		$("#msg").html("인증성공");
	}else {
		$("#msg").html("인증실패");
	}
}
</script>

</head>
<body>
<jsp:include page="header.jsp"/>
<h4>FIND ID</h4> 
<hr>
<form action="findID.do" method="post" id="findForm">
<div class="form-group">
	<label>이름 :</label>
	<input class="form-control" type="text" name="m_name" id="m_name">
</div>

<div class="form-group">
	<label>휴대전화 :</label>
	<input class="form-control" type="text" name="phone" id="phone" placeholder="하이픈(-)제외 11자리 입력" pattern="[01]{3}[0-9]{8}">
	<input class="btn btn-outline-danger" type="button" id="sendSMS" value="인증번호받기">
	
	<div id="check">
		<label>인증번호 :</label>
		<input class="form-control" type="text" name="random" id="random" placeholder="인증번호 입력" >
		<input class="btn btn-outline-danger" type="button" id="checkNum" value="인증하기">
		<span id="msg"></span>
	</div>
</div>

<input class="btn btn-success" type="submit" value="아이디 찾기">
</form> <hr>
<button id="findPW" class="btn btn-outline-success">비밀번호 찾기</button>
</body>
</html>