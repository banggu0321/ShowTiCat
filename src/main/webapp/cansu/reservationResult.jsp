<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>reservation data confirm</h1>
<hr>

<form action="http://localhost:9090/ShowTiCat/reservationCompletePayYNandRate">
<input type="text" value="reservation number" disabled ><input type="text" value=${reservationData.getReservationNum()}><br>
<input type="text" value="my ID" disabled ><input type="text" value=${reservationData.getmID()} readonly><br>
<input type="text" value="reservation date" disabled ><input type="text" value=${reservationData.getReservationDate()}><br>
<input type="text" value="schedule number" disabled ><input type="text" value=${reservationData.getScheduleNum()}><br>
<input type="text" value="payment" disabled ><input type="text" value=${reservationData.getPayment()}><br>
<input type="text" value="total price" disabled ><input type="text" value=${reservationData.getTotalPrice()}><br>
<input type="text" value="pay YES or NOT" disabled ><input type="text" value=${reservationData.getPayYN()}><br>
<input type="submit" value="지불">
</form>

</body>
</html>