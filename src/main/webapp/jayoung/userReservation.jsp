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

<style>
#reservation{
	color: red;
}
.reserv {
	text-align: center;
	font-size: 18px;
	font-weight: bold;
	padding: 5px 0px;
	margin-bottom: 15px;
	border-bottom: 1px solid #ddd;
}
.style{
	border-bottom: 1px solid #ddd;
	padding: 10px 0px;
}
.left{
	padding:0px 0px 0px 10px;
}
.place {
	width: 24%;
}
.showL {
	width: 29%;
}
.schedule {
	width: 35%;
}
.date{
	width: 12%;
	text-align: center;
}
.checkStyle {
	padding: 10px 0px;
	margin: 0px;
	background-color: #007bff;
	border-radius: 0.25rem;
}
.checkStyle a {
	font-weight: bold;
	color: white;
}
.checkStyle a:hover {
	color: white;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="contents">
	<ul class="left showL">
		<li class="reserv">영화</li>
		<c:forEach items="${showList}" var="show">
			<c:if test="${show_code==show.show_code}">
			<li class="checkStyle">
			<a href="userReservation.do?show_code=${show.show_code}&place_num=1020&date=${sysdate}">
				${show.show_name}
			</a>
			</li>
			</c:if>
			<c:if test="${show_code!=show.show_code}">
			<li class="style">
			<a href="userReservation.do?show_code=${show.show_code}&place_num=1020&date=${sysdate}">
				${show.show_name}
			</a>
			</li>
			</c:if>
		</c:forEach>
	</ul>
	
	<ul class="left place">
		<li class="reserv">극장</li>
		<c:forEach items="${placeList}" var="place" varStatus="s">
			<c:if test="${place_num==place.place_num}">
			<li class="checkStyle">
				<a href="userReservation.do?show_code=${show_code}&place_num=${place.place_num}&date=${sysdate}">
					ShowTiCat ${place.place_name}
				</a>
			</li>
			</c:if>
			<c:if test="${place_num!=place.place_num}">
				<li class="style">
				<a href="userReservation.do?show_code=${show_code}&place_num=${place.place_num}&date=${sysdate}">
					ShowTiCat ${place.place_name}
				</a>
				</li>
			</c:if>
		</c:forEach>
	 </ul>
	 
	<ul class="left date">
		<li class="reserv">날짜</li>
		<c:forEach items="${dateList}" var="date" varStatus="s">
			<c:if test="${show_start==date}">
			<li class="checkStyle">
			<a href="userReservation.do?show_code=${show_code}&place_num=${place_num}&date=${date}">
				${date}
			</a>
			</li>
			</c:if>
			<c:if test="${show_start!=date}">
			<li class="style">
			<a href="userReservation.do?show_code=${show_code}&place_num=${place_num}&date=${date}">
				${date}
			</a>
			</li>
			</c:if>
		</c:forEach>
	</ul>
	
	<ul class="left schedule">
		<li class="reserv">시간</li>
		<jsp:include page="scheduleList.jsp"/>
	</ul>

</div>
</body>
</html>