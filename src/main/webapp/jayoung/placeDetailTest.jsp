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
.nullMsg {
	text-align: center;
}
</style>

<script>
$(function() {
	location.href="#${sysdate}";
	$(".reservBtn").on("click",reservation);
	$(".dateBtn").on("click",changeDate);

})

function reservation() {
	var num = $(this).attr("num");
	location.href="reservation.do?schedule_num="+num;
}

function changeDate() {
	var date = $(this).attr("date");
	location.href="placeDetail.do?place_num="+${place.place_num} +"&date="+date;
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
	
	<div class="container">
	<!-- Nav pills -->
	<ul class="nav nav-pills" role="tablist">
	<c:forEach items="${dateList}" var="date" varStatus="vvv">
		<c:if test="${vvv.first}">
	    	<li class="nav-item">
		    	<a class="nav-link active" data-toggle="pill" href="#${date}">${date}</a>
	    	</li>
	    </c:if>
	    <c:if test="${!vvv.first}">
	    	<li class="nav-item">
	    		<a class="nav-link" data-toggle="pill" href="#${date}">${date}</a>
	    	</li>
		</c:if>
	</c:forEach>
	</ul>
	
	
	<!-- Tab panes -->
	<c:forEach items="${dateList}" var="date" varStatus="vvv">
		<div class="tab-content">
			<c:if test="${vvv.first}">
				<div id="${date}" class="container tab-pane active"><br>
					${date}
					<%-- <jsp:include page="scheduleDisplay.jsp"/> --%>
				</div>
				</c:if>
				 <c:if test="${!vvv.first}">
				<div id="${date}" class="container tab-pane fade"><br>
					${date}
					<%-- <jsp:include page="scheduleDisplay.jsp"/> --%>
				</div>
			</c:if>
		</div>
	</c:forEach>
</div>
</div>
</body>
</html>