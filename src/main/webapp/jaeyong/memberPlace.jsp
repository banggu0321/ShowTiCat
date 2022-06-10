<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MemberPlace</title>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
</script>
</head>
<body>
	<h1>MemberPlace</h1>
	<form action="/jaeyong/memberPlace.do" method="post">
		<label>관심매장 : </label>
		<c:if>${member.Place}</c:if>
		<input type = "submit" value ="수정하기" >
	</form>

</body>
</html>