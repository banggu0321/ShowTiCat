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
	<h1>reservation list table</h1>
	<hr>

	<table>
		<tr>
			<th>reservation number</th>
			<th>reservation date</th>
			<th>payment</th>
			<th>total price</th>
		</tr>
					
		<c:forEach  items="${reservationList}" var="reserve">
		<tr>
				<td>${reserve.reservationNum}</td>
				<td>${reserve.reservationDate}</td>
				<td>${reserve.payment}</td>
				<td>${reserve.totalPrice}</td>
		</tr>
		</c:forEach>
		

	</table>

</body>
</html>