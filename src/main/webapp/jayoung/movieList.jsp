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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="../css/common.css">
<link rel="stylesheet" href="css/listcss.css">

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

#movieList {
	color: red;
}
</style>
</head>

<body>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="header.jsp"/>
<div class="contents">
	<c:forEach items="${showList}" var="show">
	<div class="box">
		<div class="poster" code="${show.show_code}">
			<img alt="${show.show_name}" src="${path}/images/${show.poster}" width="250px" height="335px">
			<button class="detail btn btn-outline-secondary">상세보기</button>
		</div>
		<p class="info name">${show.show_name}</p>
		<p class="info">${show.opening_date} OPEN</p>
		<button class="reservBtn btn btn-outline-primary btn-sm reservBtn" code="${show.show_code}">예매하기</button>
	</div>
	</c:forEach>
</div>
<jsp:include page="../bang/mainUpTicket.jsp"/>
</body>
</html>