<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.left {
	float:left;
	padding-right: 20px;
}
.right {
	float:right;
	padding-right: 20px;
}
</style>
<script>
$(function() {	
	$("#loginH").on("click",login);
	$("#logoutH").on("click",logout);
	$("#joinH").on("click",join);
	$("#myPage").on("click",myPage);
	
})

function login() {
	location.href="login.do";
}

function logout() {
	location.href="logout.do";
}

function join() {
	location.href="insert.do";
}

function myPage() {
	location.href="../jjjjjjjjyyyyyyyy/memberPage.jsp";
}
</script>

<style>
a:hover {
	text-decoration: none;
}
h1 a {
	color:black;
}
</style>
</head>
<body>
<h1 class="left" id="mainH"><a href="main.go">Show TiCat</a></h1>
<div>
	<span class="right">
		<c:if test="${member != null}">
			<p id="user">${member.m_name}님 로그인</p>
		</c:if>	
	</span>
	<span class="right">
		<c:if test="${member != null}">
			<button class="btn btn-light" id="logoutH">로그아웃</button>			
			<button class="btn btn-light" id="myPage">마이페이지</button>
		<%-- <a class="right" href="${path}/logout"><button class="btn btn-light">로그아웃</button></a> --%>
		</c:if>
		<c:if test="${member == null}">
			<button class="btn btn-light" id="loginH">로그인</button>
			<button class="btn btn-light" id="joinH">회원가입</button>
		</c:if>
	</span>
	<form action="result.do" class="right" id="formH">
		<input class="form-control" type="text" name="word" id="searchH" value="${word}">
		<input class="btn btn-success" type="submit" value="검색">
	</form>
<hr>
</div>
</body>
</html>