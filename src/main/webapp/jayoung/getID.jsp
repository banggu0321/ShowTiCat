<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>FIND ID</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="common.css">

<script>
$(function() {
	$("#findPW").on("click", findPW);
})

function findPW() {
	location.href="findPW.do";
}
</script>

</head>
<body>
<jsp:include page="header.jsp"/>
<h4>FIND ID</h4>
<hr>
<h5>아이디는 ${m_id} 입니다.</h5>
<button id="findPW" class="btn btn-outline-success">비밀번호 찾기</button>
</body>
</html>