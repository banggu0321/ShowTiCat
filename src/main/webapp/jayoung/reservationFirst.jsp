<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RESERVATION</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="../css/common.css">
<link rel="stylesheet" href="css/reservationcss.css">

</head>
<body>
<jsp:include page="header.jsp"/>
<div class="contents">
	<ul class="left showL">
		<li class="reserv">영화</li>
		<c:forEach items="${showList}" var="show">
			<li class="style">
			<a href="userReservation.do?show_code=${show.show_code}&place_num=1020&date=${sysdate}">
				${show.show_name}
			</a>
			<c:if test="${show.opening_date >sysdate}">
				<p class="d_day">${show.opening_date} OPEN</p>
			</c:if>
			</li>
		</c:forEach>
	</ul>
	
	<ul class="left place">
		<li class="reserv">극장</li>
		<c:forEach items="${placeList}" var="place" varStatus="s">
				<li class="style">
				<a href="userReservation.do?show_code=${show_code}&place_num=${place.place_num}&date=${sysdate}">
					ShowTiCat ${place.place_name}
				</a>
				</li>
		</c:forEach>
	 </ul>
	 
	<ul class="left date">
		<li class="reserv">날짜</li>
		<c:forEach items="${dateList}" var="date" varStatus="s">
			<li class="style">
			<a href="userReservation.do?show_code=${show_code}&place_num=${place_num}&date=${date}">
				${date}
			</a>
			</li>
		</c:forEach>
	</ul>
	
	<ul class="left schedule">
		<li class="reserv">시간</li>
		<li class="msg">영화, 극장, 날짜를 선택해주세요.</li>
	</ul>

</div>
</body>
</html>