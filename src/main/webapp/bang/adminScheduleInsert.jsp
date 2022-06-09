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
<link rel="stylesheet" href="css/admin.css">
  <style>
  	label{display:inline-block; width:150px;}
  	.form-control{display:inline-block; width:auto;}
  </style>
</head>
<body>
	<jsp:include page="adminHeader.jsp" />
	<h1>스케줄 추가</h1>
	<form action="scheduleInsert.do" method="post">
		<div class="form-group">
			<label>show 제목</label>
			<select class="form-control" name="show_code">
    			<c:forEach items="${slist}" var="s">
    				<option value="${s.show_code}">${s.show_name}</option>
    			</c:forEach>
    		</select>
		</div>
		<div class="form-group">
			<label>극장이름</label>
			<select class="form-control" id="place_num" name="place_num" onchange="OnChange()">
    			<c:forEach items="${plist}" var="p">
    				<option value="${p.place_num}">${p.place_num}-${p.place_name}</option>
    			</c:forEach>
    		</select>
		</div>
		<div class="form-group">
			<label>상영관 번호</label>
			<select class="form-control" id="therter_num" name="theater_num">
    			<option value="">선택하세요</option>
    			<%-- <c:forEach items="${tlist}" var="t">
    				<option value="${t.theater_num}">${t.theater_num}</option>
    			</c:forEach> --%>
    		</select>
		</div>
		<div class="form-group">
			<label>시작시간</label> 
			<input class="form-control" type="date" name="show_start">
			<!-- <input type="time"> -->
		</div>
		<input class="btn btn-primary" type="submit" value="등록"> 
		<input class="btn btn-secondary" type="reset" value="리셋">
		<input class="btn btn-secondary" type="button" value="돌아가기" id="return">
	</form>
	<script>
		$(function(){
			$("#return").click(function(){
			location.href="schedule.do";
			}); 
		}); 
		/*
		function OnChange(){
			int place_num = document.getElementById("place_num").options[document.getElementById("place_num").selectedIndex].value;
			alert(place_num);
			$.ajax({   
				  type: "GET",  
				  url: "scheduleInsert.do",   
				  data:{"place_num":place_num},
				  success: result
			});
		}*/
	</script>
</body>
</html>