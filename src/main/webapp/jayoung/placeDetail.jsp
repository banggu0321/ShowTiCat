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
<link rel="stylesheet" href="css/common.css">

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
.show {
	display: inline-block;
	padding-bottom: 15px;
}
.reservBtn, .dateBtn {
	margin-right: 10px;
}
.title {
	font-size: 20px;
}
</style>

<script>
$(function() {
	$(".reservBtn").on("click",reservation);
	$(".dateBtn").on("click",changeDate);

})

function reservation() {
	var num = $(this).attr("num");
	location.href="reservation.do?schedule_num="+num;
}

function changeDate() {
	var date = $(this).attr("date");
	location.href="placeDetail.do?place_num="+${place.place_num} +"&date="+date ;
}
</script>
</head>
<body>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="header.jsp"/>
<div class="contents">
	<%-- 극장목록 --%>
	<c:forEach items="${placeList}" var="place" varStatus="s">
		<c:if test="${s.first}">
			| <a href="placeDetail.do?place_num=${place.place_num}&date=${dateList[0]}">
			ShowTiCat ${place.place_name}</a> |
		</c:if>
		<c:if test="${s.first==false}">
			 <a href="placeDetail.do?place_num=${place.place_num}&date=${dateList[0]}">
			 ShowTiCat ${place.place_name}</a> |
		</c:if>
	</c:forEach>

	
	<%-- 극장정보 --%>
	<img class="left img" src="${path}/images/theater.webp" width="300px" height="400px">
	<div class="left">
		<p class="name">ShowTiCat ${place.place_name}</p>
		<hr>
		<p class="info">위치 : ${place.place_loc}</p>
		<p class="info">문의 : ${place.place_phone}</p>
	</div>
	<hr>
	
	<%-- 날짜선택 --%>
	<c:forEach items="${dateList}" var="date">
		<button class="btn btn-outline-dark dateBtn" date="${date}">${date}</button>
	</c:forEach>
	<hr>
	
	<%-- 상영스케줄 --%>
	<c:if test="${empty list}"><h4>해당 일자에 상영중인 영화 & 공연이 없습니다.</h4></c:if>
	
	<c:forEach items="${list}" var="value" varStatus="s">
	<c:forEach items="${theaterList}" var="theater" varStatus="v">
	<c:forEach items="${showList}" var="show">
	<c:if test="${theater.theater_num==value.theater_num&&value.show_code==show.show_code}">
		<%-- 첫번째 --%>
		<c:if test="${s.first}">
			<div>
				<a href="showDetail.do?show_code=${show.show_code}" class="title">${value.show_name}</a>
				<span> ${show.category} | ${show.show_time}분 | ${show.opening_date} OPEN</span>
			</div>
			<p>${v.count}관 | ${theater.theater_name} | 총 ${theater.last_seat}석</p>
			<div class="show">
				<button class="btn btn-outline-primary reservBtn" num="${value.schedule_num}">
					${value.show_start}<br>${value.start_time}<br>좌석 : /${theater.last_seat}
				</button>
		</c:if>
		
		<%-- 중간 --%>		
		<c:if test="${!s.first}">
			<%-- 제목이 같은경우 --%>
			<c:if test="${list.get(s.index).show_name==list.get(s.index-1).show_name}">
				<%-- 상영관이 같은경우 --%>
				<c:if test="${list.get(s.index).theater_num==list.get(s.index-1).theater_num}">
					<button class="btn btn-outline-primary reservBtn" num="${value.schedule_num}">
						${value.show_start}<br>${value.start_time}<br>좌석 : /${theater.last_seat}
					</button>
				</c:if>
	
				<c:if test="${list.get(s.index).theater_num!=list.get(s.index-1).theater_num}">
					</div>
					<br> <%-- 상영관 구분 --%>
					<p>${v.count}관 | ${theater.theater_name} | 총 ${theater.last_seat}석</p>
					<div class="show">
					<button class="btn btn-outline-primary reservBtn" num="${value.schedule_num}">
						${value.show_start}<br>${value.start_time}<br>좌석 : /${theater.last_seat}
					</button>
				</c:if>
			</c:if>
					
			<c:if test="${list.get(s.index).show_name!=list.get(s.index-1).show_name}">
				</div>
				<hr> <%-- 영화/공연 구분 --%>
				<div>
					<a href="showDetail.do?show_code=${show.show_code}" class="title">${value.show_name}</a>
					<span> ${show.category} | ${show.show_time}분 | ${show.opening_date} OPEN</span>
				</div>
				<p>${v.count}관 | ${theater.theater_name} | 총 ${theater.last_seat}석</p>
				<div class="show">
				<button class="btn btn-outline-primary reservBtn" num="${value.schedule_num}">
					${value.show_start}<br>${value.start_time}<br>좌석 : /${theater.last_seat}
				</button>
			</c:if>
		</c:if>
	</c:if>
	</c:forEach>
	</c:forEach>
	</c:forEach>
	</div>
</div>
</body>
</html>