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
<title>�������� Ȯ��</title>
</head>
<body>
<h1>�������� Ȯ��</h1>
<hr>

<div id="formMain" class="container">
<form class="form-inline" action="http://localhost:9090/ShowTiCat/reservationCompletePayYNandRate">
<div id="sub1" class="form-group">
<input class="form-control-plaintext" type="text" value="���� ��ȣ" readonly ></input><input class="form-control-plaintext" type="text" value="${reservationData.getReservationNum()}" readonly></input><br>
<input class="form-control-plaintext" type="text" value="ID" readonly /><input class="form-control-plaintext" type="text" value="${reservationData.getmID()}" readonly/><br>
<input class="form-control-plaintext" type="text" value="���� ��¥" readonly /><input class="form-control-plaintext" type="text" value="${reservationData.getReservationDate()}" readonly/><br>
<input class="form-control-plaintext" type="text" value="������ ��ȣ" readonly /><input class="form-control-plaintext" type="text" value="${reservationData.getScheduleNum()}" readonly/><br>
<input class="form-control-plaintext" type="text" value="�� �ݾ�" readonly /><input class="form-control-plaintext" type="text" value="${reservationData.getTotalPrice()}" readonly/><br>
<input class="form-control-plaintext" type="text" value="���ҹ��" readonly />
<select name="pay">
<option value="checkCard">üũī��</option>
<option value="creditCard">�ſ�ī��</option>
<option value="onlineBank">���ͳݹ�ŷ</option>
</select>

<input class=" btn-primary" type="submit" value="����">
</div>

</form>
</div>

</body>
</html>