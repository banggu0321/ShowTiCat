<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${path}/css/main_upticket.css">

<script>
	$(document).ready(function() {

		$(window).scroll(function() {
			// top button controll
			if ($(this).scrollTop() > 50) {
				$('#topButton').fadeIn();
			} else {
				$('#topButton').fadeOut();
			}
		});

		$("#topButtonImg").click(function() {
			$('html, body').animate({
				scrollTop : 0
			}, '300');
		});

	});
</script>

<div id="topButton" style="cursor: pointer">
	<a href="${path}/jayoung/reservationFirst.do"><img src="${path}/images/main_ticket.png" id="reserveButtonImg"></a> 
	<img src="${path}/images/main_up.jpg" id="topButtonImg">
</div>