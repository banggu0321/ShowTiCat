<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>pay info sample</h1>
<hr>

<form action="http://localhost:9090/ShowTiCat/reservationCompleteFromShowList">
<select name="pay">
<option value="checkCard">check card</option>
<option value="crediCard">credit card</option>
<option value="onlineBank">online bank</option>
</select>
<input type="submit"/>
</form>

</body>
</html>