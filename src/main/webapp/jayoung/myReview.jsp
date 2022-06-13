<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
리뷰!!!!!
<hr>
<c:if test="${empty myReview}">등록한 리뷰가 없습니다.</c:if>
<c:forEach items="${myReview}" var="review">
	${review}
	<button class="btn btn-info updateBtn">리뷰수정</button>
</c:forEach>
</body>
</html>