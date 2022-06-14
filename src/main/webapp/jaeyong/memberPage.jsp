<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MemberPage</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="../css/common.css">
<link rel="stylesheet" href="../css/memberMyPage.css">

<style>

</style>
</head>

<body>
<jsp:include page="../jayoung/header.jsp"/>
	<div class="fbx">
		<div class=mySide>
			<div class="favorite">
			<a href = "#">관심매장</a>
			</div><!-- favorite -->

			<div class="reservation">
			<a href = "#">예매</a>			
			</div><!-- reservation -->

			<div class="delete">
			<a href = "#">회원탈퇴</a>
			</div><!-- delete -->

		</div><!-- mySide -->
		
		<div class="centerHidden">
			<h1>MemberPage</h1>
	<form action="memberUpdate.do" method="get" name="myFrom">
		<br>
		<label>아이디 : </label>
		<input value ="${member.m_id}"
			   type  ="text"
			   name  ="m_id" 
			   disabled="disabled"><br><br>
			   
		<label>비밀번호 : </label>
		<input value ="${member.m_pw}"
			   type  ="password"
			   name  ="password"
 			   disabled="disabled"><br><br>
		
		<label>이름 : </label>
		<input value ="${member.m_name}"
			   type  ="text"
			   name  ="name"
 			   disabled="disabled"><br><br>
		
		<label>핸드폰 번호 : </label>
		<input value ="${member.phone}"
			   type  ="text"
			   name  ="phone"
 			   disabled="disabled"><br><br>
		
		<label>생일 : </label>
		<input value ="${member.birth}"
			   type  ="text"
			   name  ="birth"
 			   disabled="disabled"><br><br>
		
		<label>성별 : </label>		
		<input value ="${member.gender}"
			   type  ="text"
 			   disabled="disabled"><br><br>
		
		<label>이메일 : </label>
		<input value ="${member.email}"
			   type ="text"
 			   disabled="disabled"><br><br>
			
		<label>관심매장 : </label>
		<input value = "${member.place_num}"
			   type  = "text"
			   id    = "place"><br><br>
		           
		<label>포인트 : </label>
		<input value ="${member.point}"
			   type ="text"
			   name ="point"
			   id   ="point"
 			   disabled="disabled"><br>
 			   
		<input type="submit"
			   class="btn btn-outline-success"	
			   value="수정하기" >
 
	</form>
		</div><!-- centerHidden -->

		<div class="rightHidden">
		</div><!-- rightHidden -->

	</div><!-- fbx -->
</body>
</html>