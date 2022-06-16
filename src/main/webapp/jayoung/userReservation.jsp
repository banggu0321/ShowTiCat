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
	background-color: gray;
	color: white;
	font-size: 18px;
	padding: 5px 0px;
	margin-bottom: 15px;
}

.left{
	padding:0px 0px 0px 10px;
}
.place {
	width: 22%;
}
.showL {
	width: 28%;
}
.schedule {
	width: 35%;
}
.date{
	width: 15%;
	text-align: center;
}
.checkStyle {
	padding: 10px 0px;
	margin: 0px;
	background-color: gray;
}
.checkStyle a {
	font-weight: bold;
	color: white;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="contents">
	<p>영화, 극장, 날짜를 선택해주세요.</p>
	
	<div class="left showL">
		<div class="reserv">영화</div>
		<c:forEach items="${showList}" var="show">
			<c:if test="${show_code==show.show_code}">
			<div class="checkStyle">
			<a href="userReservation.do?show_code=${show.show_code}&place_num=1020&date=${sysdate}">
				${show.show_name}
			</a>
			</div>
			</c:if>
			<c:if test="${show_code!=show.show_code}">
			<a href="userReservation.do?show_code=${show.show_code}&place_num=1020&date=${sysdate}">
				${show.show_name}
			</a>
			</c:if>
			<hr>
		</c:forEach>
	</div>
	
	<div class="left place">
		<div class="reserv">극장</div>
		<c:forEach items="${placeList}" var="place" varStatus="s">
			<c:if test="${place_num==place.place_num}">
			<div class="checkStyle">
				<a href="userReservation.do?show_code=${show_code}&place_num=${place.place_num}&date=${sysdate}">
					ShowTiCat ${place.place_name}
				</a>
			</div>
			</c:if>
			<c:if test="${place_num!=place.place_num}">
				<a href="userReservation.do?show_code=${show_code}&place_num=${place.place_num}&date=${sysdate}">
					ShowTiCat ${place.place_name}
				</a>
			</c:if>
			<hr>
		</c:forEach>
	 </div>
	 
	<div class="left date">
		<div class="reserv">날짜</div>
		<c:forEach items="${dateList}" var="date" varStatus="s">
			<c:if test="${show_start==date}">
			<div class="checkStyle">
			<a href="userReservation.do?show_code=${show_code}&place_num=${place_num}&date=${date}">
				${date}
			</a></div>
			</c:if>
			<c:if test="${show_start!=date}">
			<a href="userReservation.do?show_code=${show_code}&place_num=${place_num}&date=${date}">
				${date}
			</a>
			</c:if>
			<hr>
		</c:forEach>
	</div>
	
	<div class="left schedule">
		<div class="reserv">시간</div>
		<jsp:include page="scheduleList.jsp"/>
	</div>

</div>
</body>
</html>