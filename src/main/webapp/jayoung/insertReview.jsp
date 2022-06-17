<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>REVIEW</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="../css/common.css">

<style>
#name {
	width:500px;
}
#content {
	width: 460px;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="contents">
<jsp:include page="../jaeyong/mySide.jsp"/>
<h2>NEW REVIEW</h2>
<hr>
	<form action="insertReview.do" method="post">
		<div class="form-group">
			<label id="name">SHOW NAME : ${show.show_name}</label>
			<input type="hidden" name="show_code" value="${show.show_code}">
		</div>

		<input class="form-control" type="hidden" name="m_id" value="${member.m_id}">
		
		<div class="form-group">
			<label>CONTENT </label>
			<textarea class="form-control" rows="2" id="content" name="content"></textarea>
		</div>
		
		<div class="form-group">
			<label>GRADE </label>
			<label class="form-check-inline">
				<input class="form-check-input" type="radio" name="grade" value="good" checked="checked">좋았어요!
			</label>
			<label class="form-check-inline">
				<input class="form-check-input" type="radio" name="grade" value="soso">그냥그랬어요..
			</label>
			<label class="form-check-inline">
				<input class="form-check-input" type="radio" name="grade" value="bad">별로였어요ㅠㅠ
			</label>
		</div>
		<br>
		<input type="submit" class="btn btn-success" value="등록" id="submitBtn">
		<input type="reset" class="btn btn-secondary" value="초기화">
	</form>
</div>
<jsp:include page="../bang/mainUpTicket.jsp" />
</body>
</html>