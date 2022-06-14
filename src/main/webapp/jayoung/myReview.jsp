<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="../css/common.css">

<script>
$(function() {
	$(".updateBtn").on("click", updateReview);
	$(".reviewBtn").on("click", insertReview);
})

function updateReview() {
	var review_num = $(this).attr("num");
	location.href="updateReview.do?review_num="+review_num;
}

function insertReview() {
	location.href="insertReview.do";
}
</script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="contents">
	<c:if test="${empty myReview}">등록한 리뷰가 없습니다.</c:if>
	
	<table class="table">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>평점</th>
				<th>한줄평</th>
				<th>작성일</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${myReview}" var="review">
			<tr>
				<td>${review.review_num}</td>
				<td>${review.show_name}</td>
				<td>${review.grade}</td>
				<td>${review.content}</td>
				<td>${review.review_date}</td>
				<td>
					<button class="btn btn-info btn-sm updateBtn" num="${review.review_num}">
						리뷰수정
					</button>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<hr>
	<button class="btn btn-outline-info reviewBtn">리뷰등록</button>
</div>
</body>
</html>