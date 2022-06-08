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
	<h1>place list</h1>
	<hr>
	<table>
		<tr>
			<th>theater_num</th>
			<th>theater_type</th>
			<th>LAST_SEAT</th>
			<th>PLACE_NUM</th>
		</tr>

		<c:forEach items="${theaterByNumber}" var="theater">
			<tr>
				<td><a href="cansu/scheduleResult.jsp?theaterNum=${theater.theater_num}&placeNum=${theater.place_num}">${theater.theater_num}</a></td>
				<td>${theater.theater_type}</td>
				<td>${theater.last_seat}</td>
				<td>${theater.place_num}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>