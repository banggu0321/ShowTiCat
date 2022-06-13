<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/main_tab.css">
</head>
<body>
	<div id="slideWrap" class="carousel slide" data-ride="carousel">
		<a class="carousel-control-prev" href="#slideWrap" data-slide="prev">
			<span class="carousel-control-prev-icon"></span>
		</a>
		<div class="carousel-inner">

			<div class="carousel-item active">
				<img src="../images/broker_banner.jpg" alt="" width="1100"
					height="500">
			</div>
			<div class="carousel-item">
				<img src="../images/deathnote_banner.jpg" alt="" width="1100"
					height="500">
			</div>
			<div class="carousel-item">
				<img src="../images/crimecity2_banner.jpg" alt="" width="1100"
					height="500">
			</div>

		</div>
		<a class="carousel-control-next" href="#slideWrap" data-slide="next">
			<span class="carousel-control-next-icon"></span>
		</a>
		<ul class="carousel-indicators">
			<li data-target="#slideWrap" data-slide-to="0" class="active"></li>
			<li data-target="#slideWrap" data-slide-to="1"></li>
			<li data-target="#slideWrap" data-slide-to="2"></li>
		</ul>
	</div>
</body>
</html>