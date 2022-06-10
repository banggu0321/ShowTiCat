<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Show List</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="css/common.css">

<script>
$(function() {
	$(".reservBtn").on("click", reservation);
	$(".poster").on("click", showDetail);
})

function reservation() {
	var code = $(this).attr("code");
	location.href="reservation.do?show_code="+code;
}

function showDetail() {
	var code = $(this).attr("code");
	location.href="showDetail.do?show_code="+code;
}
</script>
<style>
.poster {
	position: relative;
	overflow: hidden;
}
.poster:hover img{
	opacity: 0.3;
}
.poster .detail {
	opacity: 0;
	transform: translateX(-50%) translateY(-50%);
	position: absolute;
	top: 50%;
	left: 50%;
	display: flex;
	text-align: center;
	font-weight: bold;
}
.poster:hover .detail {
	opacity: 1;
}
.box {
	border: 2px gray solid;
	display: inline-block;
	margin: 50px;
	padding: 10px;
}
.info {
	margin: 10px 20px 10px 20px;
	text-align: center;
}
.reservBtn {
	margin: 0 auto;
	display:block;
}
a:hover {
	text-decoration: none;
}
</style>
</head>

<body>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="header.jsp"/>
<h4>Show List | 
	<a href="showAllList.do">전체보기</a> | 
	<a href="showList.do?category=영화">영화</a> | 
	<a href="showList.do?category=공연">공연</a> |
</h4>
<hr>
<c:forEach items="${showList}" var="show">
<div class="box">
	<div class="poster" code="${show.show_code}">
		<img alt="${show.show_name}" src="${path}/images/${show.poster}" width="225px" height="300px">
		<button class="detail btn btn-outline-secondary">상세보기</button>
	</div>
	<p class="info">${show.show_name}</p>
	<p class="info">${show.opening_date} OPEN</p>
	<button class="reservBtn btn btn-outline-primary btn-sm reservBtn" code="${show.show_code}">예매하기</button>
</div>
</c:forEach>
</body>
</html>