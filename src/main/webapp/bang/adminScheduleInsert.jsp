<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>스케줄 추가</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  
 <style>
	label {
		display: inline-block;
		width: 150px;
	}
	.nav_menu_1 a {
		font-weight: bold;
		color: red;
	}
 </style>
</head>
<body>
	<jsp:include page="adminHeader.jsp" />
	<div>
		<div>
			<div id="listTitle">
				<h1>스케줄 추가</h1>
			</div>
		</div>
		<form action="scheduleInsert.do" method="post" id="insertscheduleform">
			<div class="form-group">
				<label>show 제목</label> 
				<select class="form-control" id="show_code" name="show_code" onchange="OnChangeShow()">
					<c:forEach items="${slist}" var="s">
						<option value="${s.show_code}">${s.show_name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label>극장 이름</label> 
				<select class="form-control" id="place_num" name="place_num" onchange="OnChangePlace()">
					<c:forEach items="${plist}" var="p">
						<option class="placeN" value="${p.place_num}">${p.place_num}-${p.place_name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<div>
					<label>상영관 번호</label>
				</div>
				<div id="theater">
					<select class="form-control" id="therter_num" name="theater_num">
						<option value="">선택하세요</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<div>
					<label>시작시간</label> 
				</div>
				<div id="startdate">
					<input class="form-control" id="opening_date" type="datetime-local" name="show_start">
				</div>
			</div>
			<input class="btn btn-primary" type="submit" value="등록"> 
			<input class="btn btn-secondary" type="reset" value="리셋"> 
			<input class="btn btn-secondary" type="button" value="돌아가기" id="return">
		</form>
	</div>
	<script>
		//return버튼
		$(function() {
			$("#return").click(function() {
				location.href = "schedule.do";
			});
		});
		//극장에 따라 상영관 번호 바꾸기
		function OnChangePlace() {
			var place_num = $("#place_num").val();
			$.ajax({
				type : "GET",
				url : "scheduleInsertTheater.do",
				data : {"place_num" : place_num},
				success : function(responseData) {
					$("#theater").html(responseData);
				}
			});
		}
		//영화/공연에 따라 개봉일을 최솟값으로 제한
		//datetime-local의 형식 : yyyy-MM-ddTHH:mm:ss
		function OnChangeShow() {
			var show_code = $("#show_code").val();
			$.ajax({
				type : "GET",
				url : "scheduleInsertDate.do",
				data : {"show_code" : show_code},
				success : function(responseData) {
					var show = JSON.parse(responseData);
					var opening_date = show["opening_date"];
					$("#opening_date").val(opening_date+"T00:00"); 
					$("#opening_date").attr("min", opening_date+"T00:00"); 
				}
			});
		}
	</script>
</body>
</html>