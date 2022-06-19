<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="path" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${path}/css/common.css">

<meta charset="EUC-KR">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
#formMain {
	position: relative;
	left: 10%;
	width: 70%;
}

input {
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
</style>
<title>결제정보 확인</title>
</head>
<body>
	<div id="headerInclude">
		<jsp:include page="../jayoung/header.jsp" />
	</div>

	<div id="main">
		<div id="formMain" class="container">
			<form class="form-inline"
				action="http://localhost:9090/ShowTiCat/reservationCompletePayYNandRate">
				<div id="sub1" class="form-group">
					<input class="form-control-plaintext" type="text" value="예약 번호" readonly></input>
					<input class="form-control-plaintext" type="text" value="${reservationData.getReservationNum()}" readonly></input><br>
					<input class="form-control-plaintext" type="text" value="ID" readonly />
					<input class="form-control-plaintext" type="text" value="${reservationData.getmID()}" readonly /><br> 
					<input class="form-control-plaintext" type="text" value="예약 날짜" readonly />
					<input class="form-control-plaintext" type="text" value="${reservationData.getReservationDate()}" readonly /><br>
					<input class="form-control-plaintext" type="text" value="스케쥴 번호" readonly />
					<input class="form-control-plaintext" type="text" value="${reservationData.getScheduleNum()}" readonly /><br>
					<input class="form-control-plaintext" type="text" value="총 금액" readonly />
					<input class="form-control-plaintext" type="text" value="${reservationData.getTotalPrice()}" readonly /><br> 
					<input class="form-control-plaintext" type="text" value="포인트 사용  여부" readonly />
					<input class="form-control-plaintext" type="text" name="pointYN" value="0"/><br>
					
					<input class="form-control-plaintext" type="text" value="지불방식" readonly />
					<select name="pay">
						<option value="checkCard">체크카드</option>
						<option value="creditCard">신용카드</option>
						<option value="onlineBank">인터넷뱅킹</option>
					</select> <input class=" btn-primary" type="submit" value="지불">
				</div>

			</form>
		</div>
	</div>

</body>
</html>