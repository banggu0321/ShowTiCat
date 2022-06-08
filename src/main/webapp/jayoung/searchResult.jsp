<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Result</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="common.css">

<script>
$(function() {
	$(".reservBtn").on("click", reservation);
	$(".detailBtn").on("click", showDetail);
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
div img{
	float:left;
	margin: 0px 20px 20px 20px;

}
div .title {
	font-size: 20px;
}

.detailBtn, .reservBtn {
	margin-right: 20px;
}
h1 {
	float:left;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<h4>검색결과</h4>
<hr>
<c:choose>
	<c:when test="${result!=null}">
		<c:forEach items="${result}" var="show">
			<div>
				<img alt="${show.show_name}" src="../${show.poster}" width="225px" height="300px">
				<p class="title">${show.show_name}</p>
				<p class="info">${show.opening_date} OPEN</p>
				<button class="btn btn-primary detailBtn" code="${show.show_code}">상세보기</button>
				<button class="btn btn-outline-primary reservBtn" code="${show.show_code}">예매하기</button>
			</div>
			<hr>
		</c:forEach>
	</c:when>
	<c:otherwise>
		<p>"${word}"에 대한 검색결과가 없습니다.</p>
	</c:otherwise>
</c:choose>
</body>
</html>