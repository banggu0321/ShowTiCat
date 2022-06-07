<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Show TiCat</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="common.css">

<script>
$(function() {
	$("#showList").on("click",showList);
	$("#scheduleList").on("click",scheduleList);
})

function showList() {
	location.href="showList.do";
}

function scheduleList() {
	location.href="placeDetail.do?place_num=1000";
}

</script>
</head>
<body>
<h1 class="left">Show TiCat</h1>
<jsp:include page="header.jsp"/>
<hr>
<button class="btn btn-primary" id="showList">영화/공연 목록보기</button>
<button class="btn btn-primary" id="scheduleList">극장별로 조회</button>

</body>
</html>