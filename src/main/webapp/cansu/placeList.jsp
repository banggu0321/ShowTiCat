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
			<th>place_num</th>
			<th>place_name</th>
			<th>place_loc</th>
			<th>place_phone</th>
		</tr>

		<c:forEach items="${placeList}" var="place">
			<tr>
				<td><a href="http://localhost:9090/ShowTiCat/theaterListByPlaceNumServlet?placeNumber=${place.place_num}">${place.place_num}</a></td>
				<td>${place.place_name}</td>
				<td>${place.place_loc}</td>
				<td>${place.place_phone}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>