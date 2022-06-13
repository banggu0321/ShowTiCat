<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스케줄 추가</title>
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
<link rel="stylesheet" href="css/admin.css">
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
				<h1>공연 추가</h1>
			</div>
		</div>

		<h1>스케줄 추가</h1>
		<form action="scheduleInsert.do" method="post">
			<div class="form-group">
				<label>show 제목</label> <select class="form-control" name="show_code">
					<c:forEach items="${slist}" var="s">
						<option value="${s.show_code}">${s.show_name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label>극장이름</label> <select class="form-control" id="place_num"
					name="place_num" onchange="OnChange()">
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
				<label>시작시간</label> <input class="form-control"
					type="datetime-local" name="show_start">
				<!-- <input type="time"> -->
			</div>
			<input class="btn btn-primary" type="submit" value="등록"> <input
				class="btn btn-secondary" type="reset" value="리셋"> <input
				class="btn btn-secondary" type="button" value="돌아가기" id="return">
		</form>
	</div>
	<script>
		$(function() {
			$("#return").click(function() {
				location.href = "schedule.do";
			});

			/* $(".placeN").click(function() {
				var place_num = $(".placeN").val();
				alert(place_num);
			}); */
		});
		function OnChange() {
			var place_num = $("#place_num").val();
			//alert(place_num);
			$.ajax({
				type : "GET",
				url : "scheduleInsertTheater.do",
				data : {
					"place_num" : place_num
				},
				success : function(responseData) {
					//alert("서버에 다녀옴 : "+ responseData);
					$("#theater").html(responseData);
				}
			});
		}
		/* $.ajax({
		$("#show_code").val(show_code);
		$.ajax({
		url:"scheduleTheater.do",
		type:"get",
		data:{"place_num":show_code},
		success:function(responseData){
			//alert("서버에 다녀옴 : "+ responseData);
			$("#theater").html(responseData);
		}
		});
		}); 
		 */
	</script>
</body>
</html>