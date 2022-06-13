<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/main_upticket.css">

<script>
	$(document).ready(function() {

		$(window).scroll(function() {
			// top button controll
			if ($(this).scrollTop() > 500) {
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
	<img src="images/main_ticket.png" id="reserveButtonImg"> 
	<img src="images/main_up.jpg" id="topButtonImg">
</div>