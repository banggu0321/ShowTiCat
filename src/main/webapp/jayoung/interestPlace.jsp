<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script>
$(function() {
	$("#placeForm").hide();
	$(".myPlaceBtn").on("click", showForm);
	$(".resetBtn").on("click", reset);
	$(".delBtn").on("click", delMyPlace);
})

function showForm() {
	$("#placeForm").show();
}

function reset() {
	$("#placeForm").hide();
}

function delMyPlace() {
	$.ajax({
		url:"../jayoung/deleteMyPlace.do",
		success: function(resData) {
			if(resData >= 1) {
				alert("관심매장이 삭제되었습니다.");
				location.href="../jaeyong/memberMyPage.do";
			}
		}
	})
}

</script>
</head>
<body>
	<c:if test="${member.place_num == 0}">
		등록된 관심매장이 없습니다.	
		<button class="btn btn-primary myPlaceBtn">등록</button>
	</c:if>
	
	<c:if test="${member.place_num != 0}">
		ShowTiCat ${myPlace}
		<button class="btn btn-primary myPlaceBtn">수정</button>
		<button class="btn btn-primary delBtn">삭제</button>
	</c:if>
	<hr>
	
	<form action="../jayoung/interestPlace.do" method="post" id="placeForm">
		<div class="form-group">
		    <label for="sel1">매장 선택</label>
		    <select class="form-control" name="place_num">
		    	<c:forEach items="${placeList}" var="place">
					<option value="${place.place_num}">ShowTiCat ${place.place_name}</option>        
				</c:forEach>
		    </select>
			<input class="btn btn-outline-primary" type="submit" value="등록">
			<input class="btn btn-outline-primary resetBtn" type="reset" value="취소">
		</div>
	</form>


</html>