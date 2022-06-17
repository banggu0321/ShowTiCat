<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REVIEW</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="../css/common.css">

<script>
$(function() {
	$(".updateBtn").on("click", updateReview);
	$(".delBtn").on("click", deleteReview);
})

function deleteReview() {
	var review_num = $(this).attr("num");
	
	if(confirm("리뷰를 정말 삭제하시겠습니까?")) {
		$.ajax({
			url:"deleteReview.do",
			data:{"review_num":review_num},
			success: function(resData) {
				if(resData >= 2) {
					alert("리뷰가 삭제되었습니다.");
					location.href="myReview.do";
				}
			}
		})
	}
}

function updateReview() {
	var review_num = $(this).attr("num");
	location.href="updateReview.do?review_num="+review_num;
}

</script>

<style type="text/css">
.table {
	table-layout: fixed;

}
.n, .b, .d, .t {
	text-align: center;
}
.n {
	width: 6%;
	text-align: center;
}
.b {
	width: 10%;
}
.c {
	width: 45%;
	text-align: center;
}
.d {
	width: 11%;
}
.t {
	width: 12%;
	overflow:hidden;
	white-space : nowrap;
	text-overflow: ellipsis;
}
.myReview a {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="contents">
<jsp:include page="../jaeyong/mySide.jsp"/>

<div class="centerHidden">
	<h3>MY REVIEW</h3>
	<c:if test="${empty myReview}">등록한 리뷰가 없습니다.</c:if>
	
	<c:if test="${!empty myReview}">
	<table class="table">
		<thead id="thead">
			<tr>
				<th class="n">번호</th>
				<th class="t">제목</th>
				<th class="n">평점</th>
				<th class="c">한줄평</th>
				<th class="d">작성일</th>
				<th class="b"></th>
				<th class="b"></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${myReview}" var="review">
			<tr>
				<td class="n">${review.review_num}</td>
				<td class="t">${review.show_name}</td>
				<td class="n">${review.grade}</td>
				<td>${review.content}</td>
				<td class="d">${review.review_date}</td>
				<td class="b">
					<button class="btn btn-info btn-sm updateBtn" num="${review.review_num}">
						리뷰수정
					</button>
				</td>
				<td class="b">
					<button class="btn btn-outline-info btn-sm delBtn" num="${review.review_num}">
						리뷰삭제
					</button>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</c:if>
</div><!-- centerHidden -->

<div class="rightHidden">
</div><!-- rightHidden -->

</div>
<jsp:include page="../bang/mainUpTicket.jsp" />
</body>
</html>