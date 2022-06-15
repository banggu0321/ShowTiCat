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
tr, td {
	text-align: center;
}
#main {
	position: absolute;
	top: 35%;
	
	display: inline-block;
	width: 60%;
	
	position: absolute;
	left: 20%;
}

#sub1, #sub2 {
	float: left;
	margin: 15px;
}

#title {
	font-size: xx-large;
	width: 290px;
}

#aTheater {
	text-decoration: none;
	color: blue;
}
</style>

<title>������ �󼼺���</title>
</head>

<body id="bodyM">
	<div id="headerInclude">
		<jsp:include page="/cansu/header.jsp" />
	</div>

	<div id="main">
		<div id="sub1">
			<img alt="${show.showName}"
				src="${pageContext.request.contextPath}/images/${show.poster}"
				width="300px" height="400px">
			<p id="title">${show.showName}</p>
			<hr>
			<p>���� : ${show.director}</p>
			<p>�󿵽ð� : ${show.showTime}��</p>
			<form
				action="http://localhost:9090/ShowTiCat/reservationShowDetailCancel">
				<input class="btn btn-primary btn-lg" type="submit" name="reSet"
					value="���� ���">
			</form>
		</div>

		<div id="sub2">
			<table class="table table-bordered table-hover">
				<tr>
					<th>�����ȣ</th>
					<th>��� ��ȣ</th>
					<th>�󿵱Ⱓ</th>
				</tr>

				<c:forEach items="${ScheduleList}" var="scheduleAttr">
					<tr>
						<td><a id="aTheater"
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