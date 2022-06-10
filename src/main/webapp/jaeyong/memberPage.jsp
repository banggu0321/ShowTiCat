<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MemberUpdate</title>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
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
	<h1>MemberPage</h1>
	<form action="memberUpdate.do" method="get" name="myFrom">
		<br>
		<label>아이디 : </label>
		<input value ="${member.m_id}"
			   type  ="text" disabled="disabled"><br>
			   
		<label>비밀번호 : </label>
		<input value ="${member.m_pw}"
			   type  ="text" disabled="disabled"
			   name  ="password"><br>
		
		<label>이름 : </label>
		<input value ="${member.m_name}"
			   type  ="text" disabled="disabled"
			   name  ="name"><br>
		
		<label>핸드폰 번호 : </label>
		<input value ="${member.phone}"
			   type  ="text" disabled="disabled"
			   name  ="phone"><br>
		
		<label>생일 : </label>
		<input value ="${member.birth}"
			   type  ="text" disabled="disabled"
			   name  ="birth"><br>
		
		<label>성별 : </label>		
		<input value ="${member.gender}"
			   type  ="text" disabled="disabled"><br>
		
		<label>이메일 : </label>
		<input value ="${member.email}"
			   type ="text" disabled="disabled"><br>
			
		<label>관심매장 : </label>
		<c:if test="${member!=null}">
		           "${member.place_num}"
		</c:if><br>
		<br>
		<input type="submit"
			   value="수정하기" >
 
	</form>

</body>
</html>