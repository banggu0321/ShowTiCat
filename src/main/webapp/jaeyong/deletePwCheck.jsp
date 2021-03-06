<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Password Check</title>
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
		
		$("#PWCheck").on("click",(function(){
			var m_pw = $("#pw2").val();
			//var message = "";
			//alert(m_pw);
			$.ajax({
				url : "memberPwCheck.do", //어디로
				data : {
					"m_pw" : m_pw
				}, //가져갈 data{key,value}
				type : "post",
				//datatype : "json",
				success : function(responseData) {
					//alert("responsedata : "+ responseData);
					//message = responseData;
					if(responseData != "Y"){
						alert("비밀번호가 일치하지 않습니다.");
						location.reload();
					}else{
						location.href="memberDelete.do";
					}
				}
			});
			//return message;
		}));
	});
</script>
<style>
p {
	margin: 0;
	font-size: 0.25em;
	color: tomato;
}

.delete a {
	font-weight: bold;
	color:red;
}

</style>
</head>
<body>
	<jsp:include page="../jayoung/header.jsp" />
	<div class="contents">
		<jsp:include page="../jaeyong/mySide.jsp" />
		<h1>Password Check</h1>
			<label>비밀번호 확인 : </label>
			<input type="password" id="pw2" name="m_pw"> 
			<button type="submit" class="btn btn-outline-success" id="PWCheck">확인</button>
	</div><!-- contents -->
</body>
</html>