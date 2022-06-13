<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="../css/common.css">

<script>
$(function() {
	$("#placeForm").hide();
	$(".myPlaceBtn").on("click", myPlace);
	$(".delBtn").on("click", delMyPlace);
})

function myPlace() {
	$("#placeForm").show();
}

function delMyPlace() {
	$.ajax({
		url:"deleteMyPlace.do",
		success: function(resData) {
			if(resData >= 1) {
				alert("관심매장이 삭제되었습니다.");
				location.reload();
			}
		}
	})
}

</script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="contents">
	<c:if test="${member.place_num == 0}">
		등록된 관심매장이 없습니다.	
		<button class="btn btn-primary myPlaceBtn">등록</button>
	</c:if>
	
	<c:if test="${member.place_num != 0}">
		내 관심매장 : ShowTiCat ${myPlace}
		<button class="btn btn-primary myPlaceBtn">수정</button>
		<button class="btn btn-primary delBtn">삭제</button>
	</c:if>
	<hr>
	
	<form action="interestPlace.do" method="post" id="placeForm">
		<div class="form-group">
		    <label for="sel1">매장 선택</label>
		    <select class="form-control" name="place_num">
		    	<c:forEach items="${placeList}" var="place">
					<option value="${place.place_num}">ShowTiCat ${place.place_name}</option>        
				</c:forEach>
		    </select>
			<input class="btn btn-outline-primary" type="submit" value="등록">
		</div>
	</form>

	
	<jsp:include page="myReview.jsp"/>
</div>
</body>
</html>