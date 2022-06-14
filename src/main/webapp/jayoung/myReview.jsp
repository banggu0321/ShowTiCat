<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
리뷰!!!!!
<hr>
<c:if test="${empty myReview}">등록한 리뷰가 없습니다.</c:if>
<c:forEach items="${myReview}" var="review">
	${review.review_num} | ${show.show_name} | ${review.grade} | ${review.content}
	<button class="btn btn-info updateBtn" num="${review.review_num}">리뷰수정</button>
</c:forEach>
<hr>
<button class="btn btn-outline-info reviewBtn">리뷰등록</button>
</body>
</html>