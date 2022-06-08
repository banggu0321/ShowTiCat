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
</head>
<body>
	<jsp:include page="adminHeader.jsp" />
	<h1>스케줄 추가</h1>
	<form action="scheduleInsert.do" method="post">
		<div class="form-group">
			<label>show 제목</label> <input type="text" name="show_code" value="AA9">
			<%-- <section>
    				<c:forEach items="${schedulelist}">
    				</c:forEach>
    			</section> --%>
		</div>
		<div class="form-group">
			<label>극장이름</label> <input type="number" name="place_num" value="1000">
			<%-- <section>
    				<c:forEach items="">
    				</c:forEach>
    			</section> --%>
		</div>
		<div class="form-group">
			<label>상영관 번호</label> <input type="text" name="theater_num" value="A1">
			<%-- <section>
    				<c:forEach items="">
    				</c:forEach>
    			</section> --%>
		</div>
		<div class="form-group">
			<label>시작시간</label> <input type="date" name="show_start">
			<!-- <input type="time"> -->
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