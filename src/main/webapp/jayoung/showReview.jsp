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
	table-layout: fixed;
}
.n, .b, .d, .t {
	text-align: center;
}
.n {
	width: 6%;
	text-align: center;
}
.c {
	width: 67%;
	text-align: center;
}
.d {
	width: 11%;
}
</style>
</head>
<body>
<c:if test="${empty reviewList}">아직 등록된 리뷰가 없습니다.</c:if>
<c:if test="${!empty reviewList}">
<table class="table">
	<thead>
		<tr>
			<th class="n">번호</th>
			<th class="n">평점</th>
			<th class="c">한줄평</th>
			<th class="d">작성일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${reviewList}" var="review">
			<tr>
				<td class="n">${review.review_num}</td>
				<td class="n">${review.grade}</td>
				<td>${review.content}</td>
				<td class="d">${review.review_date}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</c:if>
</body>
</html>