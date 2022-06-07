<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>FIND PASSWORD</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="common.css">

</head>
<body>
<h1>FIND PASSWORD</h1> 
<hr>
<form action="findPW.do" method="post">
<div class="form-group">
	<label>ID :</label>
	<input class="form-control" type="text" name="m_id">
</div>

<div class="form-group">
	<label>이름 :</label>
	<input class="form-control" type="text" name="m_name">
</div>

<div class="form-group">
	<label>휴대전화 :</label>
	<input class="form-control" type="text" name="phone" placeholder="하이픈(-)제외 11자리 입력" pattern="[01]{3}[0-9]{8}">
</div>

<input class="btn btn-success" type="submit" value="비밀번호 찾기">
</form>
</body>
</html>