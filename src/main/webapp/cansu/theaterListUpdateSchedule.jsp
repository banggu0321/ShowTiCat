<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>update schedule table</h1>
	<table>
		<tr>
			<th>theater_num</th>
			<th>place_num</th>
			<th>show start</th>
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

</body>
</html>