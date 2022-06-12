<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<c:if test="${empty list}"><h5 class="nullMsg">해당 일자에 상영중인 영화 & 공연이 없습니다.</h5></c:if>
	
				<c:forEach items="${list}" var="value" varStatus="s">
				<c:forEach items="${theaterList}" var="theater" varStatus="v">
				<c:forEach items="${showList}" var="show">
				<c:if test="${theater.theater_num==value.theater_num&&value.show_code==show.show_code}">
					<%-- 첫번째 --%>
					<c:if test="${s.first}">
						<div>
							<a href="showDetail.do?show_code=${show.show_code}" class="title">${value.show_name}</a>
							<span> ${show.category} | ${show.show_time}분 | ${show.opening_date} OPEN</span>
						</div>
						<p>${v.count}관 | ${theater.theater_name} | 총 ${theater.last_seat}석</p>
						<div class="show">
							<button class="btn btn-outline-primary reservBtn" num="${value.schedule_num}">
								${value.start_time}<br>좌석 : /${theater.last_seat}
							</button>
					</c:if>
					
					<%-- 중간 --%>		
					<c:if test="${!s.first}">
						<%-- 제목이 같은경우 --%>
						<c:if test="${list.get(s.index).show_name==list.get(s.index-1).show_name}">
							<%-- 상영관이 같은경우 --%>
							<c:if test="${list.get(s.index).theater_num==list.get(s.index-1).theater_num}">
								<button class="btn btn-outline-primary reservBtn" num="${value.schedule_num}">
									${value.start_time}<br>좌석 : /${theater.last_seat}
								</button>
							</c:if>
				
							<c:if test="${list.get(s.index).theater_num!=list.get(s.index-1).theater_num}">
								</div>
								<br> <%-- 상영관 구분 --%>
								<p>${v.count}관 | ${theater.theater_name} | 총 ${theater.last_seat}석</p>
								<div class="show">
								<button class="btn btn-outline-primary reservBtn" num="${value.schedule_num}">
									${value.start_time}<br>좌석 : /${theater.last_seat}
								</button>
							</c:if>
						</c:if>
								
						<c:if test="${list.get(s.index).show_name!=list.get(s.index-1).show_name}">
							</div>
							<hr> <%-- 영화/공연 구분 --%>
							<div>
								<a href="showDetail.do?show_code=${show.show_code}" class="title">${value.show_name}</a>
								<span> ${show.category} | ${show.show_time}분 | ${show.opening_date} OPEN</span>
							</div>
							<p>${v.count}관 | ${theater.theater_name} | 총 ${theater.last_seat}석</p>
							<div class="show">
							<button class="btn btn-outline-primary reservBtn" num="${value.schedule_num}">
								${value.start_time}<br>좌석 : /${theater.last_seat}
							</button>
						</c:if>
					</c:if>
				</c:if>
				</c:forEach>
				</c:forEach>
				</c:forEach>
				</div>
</body>
</html>