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
<title>�������� Ȯ��</title>
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
					<input class="form-control-plaintext" type="text" value="���� ��ȣ" readonly></input>
					<input class="form-control-plaintext" type="text" value="${reservationData.getReservationNum()}" readonly></input><br>
					<input class="form-control-plaintext" type="text" value="ID" readonly />
					<input class="form-control-plaintext" type="text" value="${reservationData.getmID()}" readonly /><br> 
					<input class="form-control-plaintext" type="text" value="���� ��¥" readonly />
					<input class="form-control-plaintext" type="text" value="${reservationData.getReservationDate()}" readonly /><br>
					<input class="form-control-plaintext" type="text" value="������ ��ȣ" readonly />
					<input class="form-control-plaintext" type="text" value="${reservationData.getScheduleNum()}" readonly /><br>
					<input class="form-control-plaintext" type="text" value="�� �ݾ�" readonly />
					<input class="form-control-plaintext" type="text" value="${reservationData.getTotalPrice()}" readonly /><br> 
					<input class="form-control-plaintext" type="text" value="����Ʈ ���  ����" readonly />
					<input class="form-control-plaintext" type="text" name="pointYN" value="0"/><br>
					
					<input class="form-control-plaintext" type="text" value="���ҹ��" readonly />
					<select name="pay">
						<option value="checkCard">üũī��</option>
						<option value="creditCard">�ſ�ī��</option>
						<option value="onlineBank">���ͳݹ�ŷ</option>
					</select> <input class=" btn-primary" type="submit" value="����">
				</div>

			</form>
		</div>
	</div>

</body>
</html>