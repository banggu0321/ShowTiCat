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

<style>
.birth {
	padding-right: 10px;
}
</style>
<script>
$(function() {
    var now = new Date();
    var year = now.getFullYear();
    var mon = (now.getMonth() + 1) > 9 ? ''+(now.getMonth() + 1) : '0'+(now.getMonth() + 1); 
    var day = (now.getDate()) > 9 ? ''+(now.getDate()) : '0'+(now.getDate());           
    //년도 selectbox만들기               
    for(var i = 1900 ; i <= year ; i++) {
        $('#year').append('<option value="'+i+'">' + i + '</option>');    
    }

    // 월별 selectbox 만들기            
    for(var i=1; i <= 12; i++) {
        var mm = i > 9 ? i : "0"+i ;            
        $('#month').append('<option value="'+mm+'">' + mm + '</option>');    
    }
    
    // 일별 selectbox 만들기
    for(var i=1; i <= 31; i++) {
        var dd = i > 9 ? i : "0"+i ;            
        $('#day').append('<option value="'+dd+'">' + dd+ '</option>');    
    }
    $("#year  > option[value="+year+"]").attr("selected", "true");        
    $("#month  > option[value="+mon+"]").attr("selected", "true");    
    $("#day  > option[value="+day+"]").attr("selected", "true");  
})
</script>
</head>

<body>
<jsp:include page="header.jsp"/>

<h4>JOIN ShowTiCat</h4>
<hr>
<form action="test.do" method="post" id="joinForm">
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
	<input class="form-control" type="text" name="email1" id="email1" placeholder="이메일">
	<span>@</span>
	<input class="form-control" name="email2" id="email2" readonly="readonly">
	<select class="form-control" id="select">
		<option value="" disabled selected>E-Mail 선택</option>
		<option>naver.com</option>
		<option>gmail.com</option>
		<option>nate.com</option>
		<option>hanmail.net</option>
		<option value="directly">직접 입력하기</option>
	</select>
</div>

<div class="form-group">
	<label>PHONE </label>
	<input class="form-control" type="text" name="phone" id="phone" placeholder="하이픈(-)제외 11자리 입력" pattern="[01]{2}[01679]{1}[0-9]{7,8}">
	<input class="btn btn-outline-danger" type="button" id="sendSMS" value="인증번호받기">
</div>

<div id="check" class="form-group">
	<label>인증번호 </label>
	<input class="form-control" type="text" name="random" id="random" placeholder="인증번호 입력" >
	<input class="btn btn-outline-danger" type="button" id="checkNum" value="인증하기">
	<span id="msg"></span>
</div>

<div class="form-group">
	<label>BIRTHDAY </label>
	<select class="form-control" id="year" name="year"></select><span class="birth">년 </span>
	<select class="form-control" id="month" name="month"></select><span class="birth">월 </span>
	<select class="form-control" id="day" name="day"></select><span class="birth">일 </span>
</div>

<div class="form-group form-check-inline">
	<label>GENDER </label>
	<label class="form-check-inline">
		<input class="form-check-input" type="radio" name="gender" value="M" checked="checked">남
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