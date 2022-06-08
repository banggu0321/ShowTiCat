<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="css/admin.css">
</head>
<body>
    <jsp:include page="adminHeader.jsp"/>
    <div>
    	<h1>LOGIN</h1>
    	<form>
    		<div class="form-group">
    			<label>ID</label>
    			<input class="form-control" type="text" name="id" value="admin">
    		</div>
    		<div class="form-group">
    			<label>PW</label>
    			<input class="form-control" type="text" name="pw" value="1234">
    		</div>
    		<input class="btn btn-success" type="submit" value="로그인">
    	</form>
    </div>
</body>
</html>