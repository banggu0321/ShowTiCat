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
		<div id="cont">
		<div class="helloBox">
		
			<div class="userImage">
			</div><!-- userImage -->
			
			<div class="helloText">			
				<div class="helloTextBox1">
					<h1>${member.m_name}</h1><span>님 </span><span> (ID:${member.m_id})</span>
					<p></p>
				</div><!-- helloTextBox1 -->
				
				<div class="helloTextBox2">	
					<p>Welcome!! 어서오세요!!</p>
					<p>즐거운 하루 되세요!!</p>
				</div><!-- helloTextBox2 -->
				
			</div><!-- helloText -->
		</div><!-- helloBox -->
		
		<div class="myInfo">

			<div class="myPlace">
				<h2>M Y P L A C E</h2>
				<span><jsp:include page="../jayoung/interestPlace.jsp"/></span>
			</div><!-- myPlace -->                
			         			
			<div class="myPoint">
				<h2>M Y P O I N T</h2>
				<span>${member.point}</span>
			</div><!-- myPoint -->		

		</div><!-- myInfo -->
		</div><!-- cont -->
	</div><!-- contents -->
</body>

</html>