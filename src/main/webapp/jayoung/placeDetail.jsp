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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="../css/common.css">

<style>
a {
	color:black;
}
a:hover {
	text-decoration: none;
}
.placeList{
	line-height: 30px;
}
.name {
	padding-top: 20px;
	font-size: 25px;
	font-weight: bold;
}
.img {
	padding: 20px;
}
.show {
	display: inline-block;
	padding-bottom: 15px;
}
.title {
	font-size: 25px;
}
.nullMsg {
	text-align: center;
}
.reservBtn, .dateBtn, .place {
	margin: 0px 10px;	
}
.dateBtn {
	font-size: 18px;
}
</style>

<script>
$(function() {	
	$(".reservBtn").on("click",reservation);
	$(".dateBtn").on("click",changeDate);
	$(".myBtn").on("click",myPlace);
})

function reservation() {
	var num = $(this).attr("num");
	location.href="reservation.do?schedule_num="+num;
}

function changeDate() {
	var date = $(this).attr("date");
	location.href="placeDetail.do?place_num="+${place.place_num} +"&date="+date ;
}

function myPlace() {
	var place_num = $(this).attr("num");
	$.ajax({
		url:"myPlace.do",
		data:{"place_num":place_num},
		success: function(resData) {
			if(resData>=1) {
				alert("관심매장으로 등록되었습니다.");
				location.reload();
			}else {
				alert("로그인 후 등록가능합니다.");
				location.href = "login.do";
			}
		}
	})
}
</script>
</head>
<body>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="header.jsp"/>
<div class="contents">
	<%-- 극장목록 --%>
	<div class="placeList">
	<c:forEach items="${placeList}" var="place" varStatus="s">
		 <a href="placeDetail.do?place_num=${place.place_num}&date=${sysdate}" class="place">
			ShowTiCat ${place.place_name}
		</a> |
	</c:forEach> </div>
	<hr>
	
	<%-- 극장정보 --%>
	<img class="left img" src="${path}/images/theater.webp" width="225px" height="300px">
	<div class="left">
		<p class="name">ShowTiCat ${place.place_name}
		<c:if test="${place.place_num != member.place_num}">
			<button class="btn btn-outline-primary btn-sm myBtn" num="${place.place_num}">
				관심매장으로 등록
			</button>
		</c:if>
		<c:if test="${place.place_num == member.place_num}">
			<button class="btn btn-primary btn-sm">
				관심매장
			</button>
		</c:if>
		</p>
		<hr>
		<p class="info">위치 : ${place.place_loc}</p>
		<p class="info">문의 : ${place.place_phone}</p>
	</div>
	<hr>
	
	<%-- 날짜선택 --%>
	<c:forEach items="${dateList}" var="date">
		<button class="btn btn-light dateBtn" date="${date}">${date}</button>
	</c:forEach>
	<hr>
<jsp:include page="displaySchedule.jsp"/>
</div>
<jsp:include page="../bang/mainUpTicket.jsp"/>
</body>
</html>