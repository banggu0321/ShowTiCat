<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.table {
	margin-bottom: 100px;
}

</style>
</head>
<body>
<c:if test="${empty reviewList}">아직 등록된 리뷰가 없습니다.</c:if>
<c:if test="${!empty reviewList}">
<table class="table">
	<thead>
		<tr>
			<th>번호</th>
			<th>평점</th>
			<th>한줄평</th>
			<th>작성일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${reviewList}" var="review">
			<tr>
				<td>${review.review_num}</td>
				<td>${review.grade}</td>
				<td id="content">${review.content}</td>
				<td>${review.review_date}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</c:if>
</body>
</html>