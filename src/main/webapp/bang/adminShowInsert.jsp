<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>공연 추가</title>
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
	.form-control {
		display: inline-block;
		width: 50%;
	}
	.nav_menu_2 a {
		font-weight: bold;
		color: red;
	}
	.custom-file-label {
		width: 100%;
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
		<form action="showInsert.do" id="insertshowform" method="post"
			enctype="multipart/form-data">
			<div class="form-group">
				<label>show코드</label> 
				<input class="form-control" type="text"name="show_code" value="BB">
			</div>
			<div class="form-group">
				<label>제목</label> 
				<input class="form-control" type="text" name="show_name" value="">
			</div>
			<div class="form-group">
				<label>감독</label> 
				<input class="form-control" type="text" name=director value="">
			</div>
			<div class="form-group">
				<label>트레일러</label> 
				<input class="form-control" type="text" name="trailer" value="">
				<!-- 형식지정 -->
			</div>
			<div class="form-group">
				<label>개봉일자</label> 
				<input class="form-control" type="date" name="opening_date" value="">
			</div>
			<div class="form-group">
				<label>러닝타임</label> 
				<input class="form-control" type="number" name="show_time" value="">
			</div>
			<div class="form-group">
				<label>카테고리</label> 
				<select class="form-control" name="category" id="category" onchange="OnChange()">
					<option value="영화">영화</option>
					<option value="공연">공연</option>
				</select>
			</div>
			<div class="form-group">
				<label>줄거리</label>
				<textarea class="form-control" name="summary"></textarea>
			</div>
			<div class="form-group">
				<label>포스터</label>
				<div class="custom-file form-control">
					<input type="file" class="custom-file-input" id="customFile" name="file"> 
					<label class="custom-file-label" for="customFile">Choose file</label>
				</div>
			</div>
			<div class="form-group">
				<label>가격</label> <input class="form-control" type="number"
					name="price" readonly="readonly" id="price" value="12000">
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
				location.href = "show.do";
			});
		});
		//category에 따라 가격 정해짐
		function OnChange() {
			var option = document.getElementById("category").
							options[document.getElementById("category").selectedIndex].value;
			if (option == "영화") {
				document.getElementById("price").value = 12000;
			} else {
				document.getElementById("price").value = 150000;
			}
		}
		//파일 업로더 label
		$(".custom-file-input").on("change",function() {
			var fileName = $(this).val().split("\\").pop();
			$(this).siblings(".custom-file-label").addClass("selected").html(fileName);
		});
	</script>
</body>
</html>