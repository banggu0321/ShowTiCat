<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>SHOW DETAIL</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="css/common.css">

<script>
$(function() {
	$("#reservBtn").on("click", reservation);
	$("#close").on("click", stop);
})

function reservation() {
	location.href="reservation.do?show_code=${show.show_code}";
}

function stop() {
	
}
</script>

<style>
.left {
	float: left;
}
.poster {
	padding: 20px;
}
.title {
	padding-top: 20px;
	font-size: 50px;
	font-weight: bold;
}
.info {
	font-size: 20px;
}
.deBtn {
	font-size: 20px;
	margin-right: 20px;
}
pre {
	font-size: 15px;
}
a:hover {
	text-decoration: none;
}
.url {
	color: black;
}
.modal-body {
	margin: 0 auto;
}
</style>

</head>
<body>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="header.jsp"/>
<h4>SHOW DETAIL</h4>
<hr>
<img class="left poster" alt="${show.show_name}" src="${path}/images/${show.poster}" width="300px" height="400px">
<div class="left">
	<p class="title">${show.show_name}</p>
	<hr>
	<p class="info">감독 : ${show.director}</p>
	<p class="info">배우 : 
		<c:forEach items="${castList}" var="cast" varStatus="s">
			<c:if test="${s.last==false&&cast.cast_url!=null}">
				<a href="${cast.cast_url}" class="url" target="_blank">${cast.cast_name}</a>,
			</c:if>
			<c:if test="${s.last&&cast.cast_url!=null}">
				<a href="${cast.cast_url}" class="url" target="_blank">${cast.cast_name}</a>
			</c:if>
			<c:if test="${s.last==false&&cast.cast_url==null}">${cast.cast_name},</c:if>
			<c:if test="${s.last&&cast.cast_url==null}">${cast.cast_name}</c:if>
		</c:forEach>
	</p>
	<p class="info">상영시간 : ${show.show_time}분</p>
	<p class="info">개봉일 : ${show.opening_date}</p>
	<button class="btn btn-outline-primary deBtn" data-toggle="modal" data-target="#myModal">예고편보기</button>
	<button class="btn btn-primary deBtn" id="reservBtn">예매하기</button>

</div>
<hr>
<h3>줄거리</h3>
<pre>${show.summary}</pre>
<hr>
<h3>예매자 통계</h3>
<c:import url="showChart.jsp"></c:import>
<%-- <img class="left poster" alt="${show.show_name}" src="${path}/images/${show.show_chart}" width="300px" height="400px"> --%>

<!-- The Modal -->
<div class="modal" id="myModal">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
    
      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">TRAILER</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>
      
      <!-- Modal body -->
      <div class="modal-body">
        <iframe width="650" height="366" src="https://www.youtube.com/embed/${show.trailer}?autoplay=1&mute=1" 
        	title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
      </div>
        
      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal" id="close">Close</button>
      </div>
        
    </div>
  </div>
</div>

</body>
</html>