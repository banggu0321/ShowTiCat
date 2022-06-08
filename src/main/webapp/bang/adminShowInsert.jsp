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
<link rel="stylesheet" href="css/admin.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="adminHeader.jsp" />
	<h1>공연 추가</h1>
	<form action="showInsert.do" method="post">
		<div class="form-group">
			<label>show코드</label> <input type="text" name="show_code" value="AA">
		</div>
		<div class="form-group">
			<label>제목</label> <input type="text" name="show_name" value="">
		</div>
		<div class="form-group">
			<label>감독</label> <input type="text" name=director value="">
		</div>
		<div class="form-group">
			<label>트레일러</label> <input type="text" name="trailer" value=""><!-- 형식지정 -->
		</div>
		<div class="form-group">
			<label>개봉일자</label> <input type="date" name="opening_date" value="">
		</div>
		<div class="form-group">
			<label>러닝타임</label> <input type="number" name="show_time" value="">
		</div>
		<div class="form-group">
			<label>카테고리</label> <input type="text" name="category" value=""><!-- select -->
		</div>
		<div class="form-group">
			<label>줄거리</label> <input type="text" name="summary" value=""><!-- txa -->
		</div>
		<div class="form-group">
			<label>포스터</label> <input type="text" name="poster" value=""><!-- 이미지input -->
		</div>
		<div class="form-group">
			<label>가격</label> <input type="number" name="price" value=""> <!-- 카테고리따라 정해짐/select -->
		</div>
		<input class="btn btn-primary" type="submit" value="등록"> 
		<input class="btn btn-secondary" type="reset" value="리셋">
		<input class="btn btn-secondary" type="button" value="돌아가기" id="return">
	</form>
	<script>
		$(function(){
			$("#return").click(function(){
			location.href="show.do";
			}); 
		}); 
	</script>
</body>
</html>