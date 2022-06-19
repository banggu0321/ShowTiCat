<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="EUC-KR">
<style>
form, th, td{
text-align:center;
}

#mainDIV{
	position: absolute;
	top: 35%;
	
	display: inline-block;
	width: 60%;
	
	position: absolute;
	left: 20%;
}
</style>
<title>예약 조회 하기</title>
</head>
<body>

	<div id="headerInclude">
		<jsp:include page="/jayoung/header.jsp" />
	</div>

	<div id="mainDIV" class="container">
		<table class="table table-bordered table-hover">
			<tr class="info">
				<th>예약 번호</th>
				<th>예약 날짜</th>
				<th>지불방식</th>
				<th>총 비용</th>
			</tr>

			<c:forEach items="${reservationList}" var="reserve">
				<tr>
					<td>${reserve.reservationNum}</td>
					<td>${reserve.reservationDate}</td>
					<td>${reserve.payment}</td>
					<td>${reserve.totalPrice}</td>
				</tr>
			</c:forEach>
		</table>
		
		<form action="http://localhost:9090/ShowTiCat/reservationShowDetailCancel">
		<input class="btn btn-primary" type="submit" value="돌아가기">
		</form>
	</div>

</body>
</html>