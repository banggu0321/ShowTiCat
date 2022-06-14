<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
body {
	margin: 0 auto;
	width: 60%;
}
h1 {
	text-align: center;
}
#formMain{
position: relative;
left:10%;
width:70%;
}
input{
text-align: center;
}
</style>
<title>결제정보 확인</title>
</head>
<body>
<h1>결제정보 확인</h1>
<hr>

<div id="formMain" class="container">
<form class="form-inline" action="http://localhost:9090/ShowTiCat/reservationCompletePayYNandRate">
<div id="sub1" class="form-group">
<input class="form-control-plaintext" type="text" value="예약 번호" readonly ></input><input class="form-control-plaintext" type="text" value="${reservationData.getReservationNum()}" readonly></input><br>
<input class="form-control-plaintext" type="text" value="ID" readonly /><input class="form-control-plaintext" type="text" value="${reservationData.getmID()}" readonly/><br>
<input class="form-control-plaintext" type="text" value="예약 날짜" readonly /><input class="form-control-plaintext" type="text" value="${reservationData.getReservationDate()}" readonly/><br>
<input class="form-control-plaintext" type="text" value="스케쥴 번호" readonly /><input class="form-control-plaintext" type="text" value="${reservationData.getScheduleNum()}" readonly/><br>
<input class="form-control-plaintext" type="text" value="총 금액" readonly /><input class="form-control-plaintext" type="text" value="${reservationData.getTotalPrice()}" readonly/><br>
<input class="form-control-plaintext" type="text" value="지불방식" readonly />
<select name="pay">
<option value="checkCard">체크카드</option>
<option value="creditCard">신용카드</option>
<option value="onlineBank">인터넷뱅킹</option>
</select>

<input class=" btn-primary" type="submit" value="지불">
</div>

</form>
</div>

</body>
</html>