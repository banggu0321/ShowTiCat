<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.review {
	display: table;
	border-collapse: collapse;
	margin: 20px;
    }
.review li {
	display: inline-table;
	padding: 30px 20px;
	width: 45%;
	line-height: 50px;
	border: 1px solid gray;
}

</style>
</head>
<body>
<c:if test="${empty review}">아직 등록된 리뷰가 없습니다.</c:if>
<ul class="review">
<c:forEach items="${review}" var="rr" varStatus="s">
	<li>
		평점 : ${rr.grade}<br>
		한줄평 : ${rr.content}<br>
		등록일 : ${rr.review_date}
	</li>
	<li>
		평점 : ${rr.grade}<br>
		한줄평 : ${rr.content}<br>
		등록일 : ${rr.review_date}
	</li>
	<li>
		평점 : ${rr.grade}<br>
		한줄평 : ${rr.content}<br>
		등록일 : ${rr.review_date}
	</li>
	<li>
		평점 : ${rr.grade}<br>
		한줄평 : ${rr.content}<br>
		등록일 : ${rr.review_date}
	</li>
	<li>
		평점 : ${rr.grade}<br>
		한줄평 : ${rr.content}<br>
		등록일 : ${rr.review_date}
	</li>
	<li>
		평점 : ${rr.grade}<br>
		한줄평 : ${rr.content}<br>
		등록일 : ${rr.review_date}
	</li>
	<li>
		평점 : ${rr.grade}<br>
		한줄평 : ${rr.content}<br>
		등록일 : ${rr.review_date}
	</li>
	<li>
		평점 : ${rr.grade}<br>
		한줄평 : ${rr.content}<br>
		등록일 : ${rr.review_date}
	</li>
</c:forEach>
</ul>
</body>
</html>