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
	$("#aList").on("click",aList);
	$("#mList").on("click",mList);
	$("#sList").on("click",sList);
	$("#scheduleList").on("click",scheduleList);
})

function aList() {
	location.href="showAllList.do";
}

function mList() {
	location.href="showList.do?category=영화";
}

function sList() {
	location.href="showList.do?category=공연";
}

function scheduleList() {
	location.href="placeDetail.do?place_num=1020";
}

</script>
</head>
<body>
<jsp:include page="header.jsp"/>

<button class="btn btn-primary" id="aList">영화/공연 목록보기</button>
<button class="btn btn-primary" id="mList" hidden="hidden">영화 목록보기</button>
<button class="btn btn-primary" id="sList" hidden="hidden">공연 목록보기</button>
<button class="btn btn-primary" id="scheduleList">극장별로 조회</button>
</body>
</html>