<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberUpdate</title>
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
		
		$("#updateForm").on("submit",(function(){
			var pwMsg = $("#pwMsg").html();
			if(pwMsg != "pass"){
				return false;
			}
		}));
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
</head>
<body>
	<jsp:include page="../jayoung/header.jsp" />
	<div class="contents">
		<jsp:include page="../jaeyong/mySide.jsp" />
		<h1>MemberUpdate</h1>
		<form action="memberUpdate.do" method="post" id="updateForm"><br>
		<label>아이디 : ${member.m_id} </label>
		<input type="hidden"
			   name="m_id"
			   value="${member.m_id}"
			   readonly="readonly"><br><br>
			   
		<label>비밀번호 : </label>
		<input type="password"
               name="m_pw"
               id="m_pw"><br>
               
		<label>비밀번호확인 : </label>
		<input type="password"
			   id="pw2">
			   <span id="pwMsg"></span><br><br>
			   
			   <label>이름 : </label>
        <input type="text"
               name="m_name"
			   value="${member.m_name}"><br>
			<br> <label>핸드폰 번호 : </label>
			
		<input type="text"
			   name="phone"
			pattern="[01]{2}[01679]{1}[0-9]{7,8}"
			  value="${member.phone}">
			<p>-를 빼고 숫자만 입력해주세요</p>

		<label>생일 : </label>
		<input type="date"
			   name="birth"
			  value="${member.birth}"><br><br>
				   
		<label>성별 : </label>
		<label>
		<input type="radio"
			   name="gender"
			  value="M" ${member.gender=="M"?"checked":""}>남
		</label>
		<label>
		<input type="radio"
			   name="gender"
			  value="W" ${member.gender=="W"?"checked":""}>여
		</label><br>
		<label>이메일 : </label>
		<input type="email"
		       name="email"
			  value="${member.email}">
		<p>ex) ShowTiCat@gamil.com</p>
<%-- 
		<label>관심매장 : </label>
		    <select name="items">
			<option value="#"></option>
			<option value="범계">범계</option>
			<option value="송파">송파</option>
			<option value="수원">수원</option>
			<option value="스타필드시티위례">스타필드시티위례</option>
			<option value="영등포">영등포</option>
			<option value="일산">일산</option>
			<option value="평촌">평촌</option>
		</select> <br><br>
		<label>포인트 : ${member.point} </label>
		<input type="hidden"
		       name="point" value="${member.point}"> <br>
		       --%> 
	   
	    <input  type="submit"
	            class="btn btn-outline-success"
	            value="수정완료">

<%-- 		<input type="button"
		      class="btn btn-outline-success"
			   m_mm="${member.m_id}"
			  value="회원탈퇴"
			  id="btnDelete"> --%>
		</form>
	</div>
	<!-- contents -->
</body>
</html>