<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<style>
body {
	margin: 0 auto;
	width: 60%;
}

div {
	display: inline-block;
}

h1 {
	text-align: center;
}

tr, td{
	text-align: center;
}

a{
text-decoration: none;
}

#sub1, #sub2 {
	float: left;
	margin: 25px;
}

#title{
font-size: xx-large;
width: 290px;
}


</style>

<title>스케쥴 상세보기</title>
</head>
<body>
	<h1>스케쥴 상세보기</h1>
	<div id="main">
		<div id="sub1">
			<img alt="${show.showName}" src="${pageContext.request.contextPath}/images/${show.poster}" width="300px" height="400px">
			<p id="title">${show.showName}</p>
			<hr>
			<p>감독 : ${show.director}</p>
			<p>상영시간 : ${show.showTime}분</p>
			<form action="">
			<input type="button" name="reSet" value="예매 취소">
			</form>
		</div>

		<div id="sub2">
			<table class="table table-bordered table-hover">
				<tr>
					<th>극장번호</th>
					<th>장소 번호</th>
					<th>상영기간</th>
				</tr>

				<c:forEach items="${ScheduleList}" var="scheduleAttr">
					<tr>
						<td><a
							href="http://localhost:9090/ShowTiCat/reservationFromShowLTBeta?theaterNum=${scheduleAttr.theaterNum}&placeNum=${scheduleAttr.placeNum}&showStart=${scheduleAttr.showStart}">
								${scheduleAttr.theaterNum}</a></td>
						<td>${scheduleAttr.placeNum}</td>
						<td>${scheduleAttr.showStart}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>

</body>
</html>