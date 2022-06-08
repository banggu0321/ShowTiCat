<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Place Detail</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="common.css">

<style>
a {
	color:black;
}
a:hover {
	text-decoration: none;
}
.name {
	padding-top: 20px;
	font-size: 30px;
	font-weight: bold;
}
.info {
	font-size: 15px;
}
.img {
	padding: 20px;
}

</style>

<script>
$(function() {
	$(".reservBtn").on("click",reservation);
})

function reservation() {
	var num = $(this).attr("num");
	location.href="reservation.do?schedule_num="+num;
}
</script>
</head>
<body>
<jsp:include page="header.jsp"/>
<h4>Schedule List</h4>
<hr>
<jsp:include page="placeList.jsp"/>
<hr>
<img class="left img" src="../images/theater.webp" width="300px" height="400px">
<div class="left">
<p class="name">${place.place_name}</p>
<hr>
<p class="info">위치 : ${place.place_loc}</p>
<p class="info">문의 : ${place.place_phone}</p>
</div>
<hr>
<c:forEach items="${theaterList}" var="theater" varStatus="v">
	<c:forEach items="${showList}" var="show">
		<c:forEach items="${list}" var="value" varStatus="s">
			<c:if test="${value.show_code==show.show_code && value.theater_num==theater.theater_num}">
			<p>${show.show_name}</p>
			<p>${v.count}관</p>
			<button class="btn btn-outline-primary">${value.show_name}<br>${value.start_time}</button>
			</c:if>
		</c:forEach>
	</c:forEach>
</c:forEach>


	<hr>

</body>
</html>