<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberMyPage</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="../css/common.css">
<link rel="stylesheet" href="../css/memberMyPage.css">

</head>
<body>
	<jsp:include page="../jayoung/header.jsp" />

	<div class="contents">
		<jsp:include page="/jaeyong/mySide.jsp" />
		<div class="helloBox">
		
			<div class="userImage">
			</div><!-- userImage -->
		
			<div class="helloTextBox">
				<h1>${member.m_name}</h1><span>님</span>
				<p></p>
				<p>어서오세요!!!</p>
				<p>안녕하세요???</p>
			</div><!-- helloTextBox -->
		
		</div><!-- helloBox -->
	</div><!-- contents -->
</body>

</html>