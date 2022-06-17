<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="path" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${path}/bang/css/popup.css">	

<form name="notice_form">
	<div id="divpop1" class="divpop">
		<img alt="" src="${path}/bang/main_images/QR_22739206_.png">
		<div class="button_area">
			<input type='checkbox' name='chkbox' id='todaycloseyn' value='Y'>
			오늘하루 이 창을 열지 않음 
			<a href='#' onclick="javascript:closeWin(1);"><B>[닫기]</B></a>
		</div>
	</div>
</form>