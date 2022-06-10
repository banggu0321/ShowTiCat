<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>

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
</head>
<body>
<div>
<c:set var="path" value="${pageContext.request.contextPath}"/>
	<span class="right">
		<c:if test="${member != null}">
			${member.m_name}님 로그인
		</c:if>	
		<c:if test="${member == null}">
			Guest
		</c:if>	
	</span>
	<span>
		<c:if test="${member != null}">
		<a class="right" href="${path}/jaeyong/memberPage.jsp"><button class="btn btn-light">마이페이지</button></a>
		<a class="right" href="${path}/logout"><button class="btn btn-light">로그아웃</button></a>
			
		</c:if>
		<c:if test="${member == null}">
			<a class="right" href="${path}/jayoung/login.do"><button class="btn btn-light">로그인</button></a>
			<a class="right" href="${path}/jayoung/insert.do"><button class="btn btn-light">회원가입</button></a>
		</c:if>	
	</span>
	<a class="right" href="${path}/jayoung/main.jsp"><button class="btn btn-light">MAIN</button></a>
</div>
<c:if test="${member != null}">
	<hr>
	<p>${member}</p>
</c:if>
</body>
</html>