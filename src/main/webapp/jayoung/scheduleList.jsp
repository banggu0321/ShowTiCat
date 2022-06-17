<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script>
$(function() {	
	$(".reservBtn").on("click",reservation);
})

function reservation() {
	var num = $(this).attr("num");
	location.href="reservation.do?schedule_num="+num;
}
</script>

<style>
.reservBtn{
	margin: 0px 8px 5px 8px;
}

</style>
</head>
<body>

<%-- 상영스케줄 --%>
	<c:if test="${empty list}"><p class="nullMsg">해당 일자에 상영중인 영화 & 공연이 없습니다.</p></c:if>
<div id="display">	
	<c:forEach items="${list}" var="value" varStatus="s">
	<c:forEach items="${theaterList}" var="theater" varStatus="v">
	<c:forEach items="${showList}" var="show">
	<c:forEach items="${cntList}" var="cnt">
	<c:if test="${theater.theater_num==value.theater_num&&value.show_code==show.show_code&&cnt.key==value.schedule_num}">
		<%-- 첫번째 --%>
		<c:if test="${s.first}">
			<p>${v.count}관 | ${theater.theater_name} | 총 ${theater.last_seat}석</p>
			<div class="show">
		</c:if>
		
		<%-- 중간 --%>		
		<c:if test="${!s.first}">
			<%-- 제목이 같은경우 --%>
			<c:if test="${list.get(s.index).show_name==list.get(s.index-1).show_name}">
				<%-- 상영관이 다른경우 --%>
				<c:if test="${list.get(s.index).theater_num!=list.get(s.index-1).theater_num}">
					</div>
					<br> <%-- 상영관 구분 --%>
					<p>${v.count}관 | ${theater.theater_name} | 총 ${theater.last_seat}석</p>
					<div class="show">
				</c:if>
			</c:if>
					
			<c:if test="${list.get(s.index).show_name!=list.get(s.index-1).show_name}">
				</div>
				<p>${v.count}관 | ${theater.theater_name} | 총 ${theater.last_seat}석</p>
				<div class="show">
			</c:if>
		</c:if>
		
		<button class="btn btn-outline-primary reservBtn" num="${value.schedule_num}">
			${value.start_time}<br> ${theater.last_seat - cnt.value} 석
		</button>
		
	</c:if>
	</c:forEach>
	</c:forEach>
	</c:forEach>
	</c:forEach>
	</div>
</div>	
</body>
</html>