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
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCHyjHLk2rWmOixhpK-ZR3jSDYRpZm-pjI&callback=initMap"></script>
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
.show {
	display: inline-block;
}
.reservBtn {
	margin-right: 10px;
}
</style>

<script>
$(function() {
	$(".reservBtn").on("click",reservation);

function initMap() {
    // 오스트레일리아 울룰루 산의 위도, 경도 정보
    var uluru = {lat: -25.344, lng: 131.036};
    // 구글 지도 객체를 생성하고, 위치는 uluru로 맞춘다.
    var map = new google.maps.Map(
        document.getElementById('googleMap'), {zoom: 15, center: uluru});
    // Uluru 산에 마커를 위치시키는 ㅗ드
    var marker = new google.maps.Marker({position: uluru, map: map});
}

window.initMap = initMap;
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
<div id="googleMap" style="width: 500px%;height: 250px;"></div>
<p class="info">문의 : ${place.place_phone}</p>
</div>
<hr>
<c:forEach items="${list}" var="value" varStatus="s">
	<%-- 첫번째 --%>
	<c:if test="${s.first}">
			<h4>${value.show_name}</h4>
			<p>${value.theater_num}관</p>
		<div class="show">
			<button class="btn btn-outline-primary reservBtn">
				${value.show_name}<br>${value.show_start}<br>${value.start_time}
			</button>
		
	</c:if>
	<%-- 중간 --%>		
	<c:if test="${!s.first}">
		<%-- 제목이 같은경우 --%>
		<c:if test="${list.get(s.index).show_name==list.get(s.index-1).show_name}">
			<%-- 상영관이 같은경우 --%>
			<c:if test="${list.get(s.index).theater_num==list.get(s.index-1).theater_num}">
				<button class="btn btn-outline-primary reservBtn">
					${value.show_name}<br>${value.show_start}<br>${value.start_time}
				</button>
			</c:if>

			<c:if test="${list.get(s.index).theater_num!=list.get(s.index-1).theater_num}">
				</div>
				<br> <%-- 상영관 구분 --%>
				<p>${value.theater_num}관</p>
				<div class="show">
				<button class="btn btn-outline-primary reservBtn">
					${value.show_name}<br>${value.show_start}<br>${value.start_time}
				</button>
			</c:if>
		</c:if>
				
		<c:if test="${list.get(s.index).show_name!=list.get(s.index-1).show_name}">
			</div> 
			<hr> <%-- 영화/공연 구분 --%>
			<h4>${value.show_name}</h4>
			<p>${value.theater_num}관</p>
			<div class="show">
			<button class="btn btn-outline-primary reservBtn">
				${value.show_name}<br>${value.show_start}<br>${value.start_time}
			</button>
		</c:if>
	</c:if>
</c:forEach>
</div>
<hr>
</body>
</html>



