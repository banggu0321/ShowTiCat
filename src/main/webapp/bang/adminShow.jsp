<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공연/영화 관리</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="css/admin.css">

</head>
<body>
    <jsp:include page="adminHeader.jsp"/>
    <div>
    	<h1>공연/영화 목록</h1>
			<a href="showInsert.do">영화/공연 등록</a>
			<br><br>
		<table>
			<tr>
				<td>코드</td>
				<td>제목</td>
				<td>개봉일자</td>
				<td>러닝시간</td>
				<td>카테고리</td>
				<td></td>
			</tr>
			<c:forEach items="${showlist}" var="show"> <!-- var : DTO -->
				<tr>
					<td>${show.show_code}</td>
					<td>${show.show_name }</td>
					<td>${show.opening_date }</td>
					<td>${show.show_time }</td>
					<td>${show.category }</td>
					<td><button class="btnDell btn btn-dark" data-deptid="${dept.department_id}">삭제</button></td>
				</tr>
			</c:forEach>
		</table>
    </div>
</body>
</html>