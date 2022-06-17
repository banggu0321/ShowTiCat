<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스케줄 관리</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="css/admin.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style type="text/css">
.nav_menu_1 a{
	font-weight : bold;
	color: red;
}
</style>
</head>
<body>
	<jsp:include page="adminHeader.jsp" />
	<div>
		<div>
			<div id="listTitle">
				<h1>스케줄 목록</h1>
			</div>
			<div id="listButton">
				<button class="btnAdd btn btn-warning" onclick="location.href='scheduleInsert.do'">스케줄 추가</button>
				<!-- <a href="scheduleInsert.do">스케줄 추가</a> -->
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-auto">
				<table class="table table-responsive">
					<tr>
						<td>스케줄넘버</td>
						<td>show제목</td>
						<td>극장이름</td>
						<td>상영관번호</td>
						<td>관람일</td>
						<td>시작시간</td>
						<td>좌석 수</td>
						<td></td>
					</tr>
					<c:forEach items="${schedulelist}" var="schedule">
						<!-- var : DTO -->
						<tr>
							<td>${schedule.schedule_num}</td>
							<td>${schedule.show_name }</td>
							<td>${schedule.place_name }</td>
							<td>${schedule.theater_num }</td>
							<td>${schedule.show_start_date }</td>
							<td>${schedule.show_start_time }</td>
							<td>${schedule.last_seat }</td>
							<td><button class="btnDel btn btn-dark"
									data-schedulenum="${schedule.schedule_num}">삭제</button></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<script>
		$(function() {
			$(".btnDel").on("click",function() {
				var schedule_num = $(this).attr("data-schedulenum");
				if (confirm("[" + schedule_num + "] 삭제?")) {
					$.ajax({
						url : "scheduleDeleteCheck.do",
						data : {
							"schedule_num" : schedule_num
						},
						type : "get",
						success : function(responseData) {
							if (responseData == 0) {
								$.ajax({
									url : "scheduleDelete.do",
									data : {
										"schedule_num" : schedule_num
									},
									type : "get",
									success : function() {
										alert("[" + schedule_num + "]" + "삭제되었습니다.");
										location.reload();
									},
									fail : {}
								});
							} else {
								alert("삭제불가[예매기록있음]");
							}
						},
						fail : function() {
							alert("fail");
						}
					});//location.href = "showDeleteCheck.do?show_code=" + show_code;
				}//location.href = "showDelete.do?show_code=" + show_code;
			});
			
		});
	</script>
</body>
</html>