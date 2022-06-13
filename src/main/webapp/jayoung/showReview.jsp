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
<c:if test="${empty review}">아직 등록된 리뷰가 없습니다.</c:if>
<c:forEach items="${review}" var="rr">
	${rr}
</c:forEach>
</body>
</html>