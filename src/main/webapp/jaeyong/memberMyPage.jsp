<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title><link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="../css/common.css">
<link rel="stylesheet" href="../css/memberMyPage.css">

</head>
<body>
<jsp:include page="../jayoung/header.jsp"/>

	<div class="fbx">
		<div class=mySide>
			<div class="favorite">
			<a href = "#">관심매장</a>
			</div><!-- favorite -->

			<div class="reservation">
			<a href = "#">예매</a>			
			</div><!-- reservation -->

			<div class="delete">
			<a href = "#">회원탈퇴</a>
			</div><!-- delete -->

		</div><!-- mySide -->
		
		<div class="centerHidden">
		
		</div><!-- centerHidden -->

		<div class="rightHidden">
		</div><!-- rightHidden -->

	</div><!-- fbx -->
</body>

</html>