<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/popup.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>TicKet은 역시 ShowTiCat!!</title>
</head>
<body>
	<div class="header">
		<!-- 헤더 컨텐츠 -->
		<div class="headerContents">
			<div class="contents">
				<!-- 로고 및 사이트 이름 -->
				<h1>
					<!-- 로고 이미지 추가해야댐 -->
					<img src="#" alt="">
					<!-- 사이트 이름 -->
					<span>S h o w T i C a t</span>
				</h1>
				<!-- 회원관련창 -->
				<ul class="member">
					<li>
						<!-- 로그인 이미지 추가해야댐 --> <a href="#"><img src="#" alt=" ">
							<span>로그인</span> </a>
					</li>
					<li>
						<!-- 회원가입 이미지 추가해야댐 --> <a href="#"><img src="#" alt=" ">
							<span>회원가입</span> </a>
					</li>
					<li>
						<!-- 마이페이지 이미지 추가해야댐 --> <a href="#"><img src="#" alt=" ">
							<span>MyShow</span> </a>
					</li>
				</ul>
				<!-- member -->
			</div>
			<!-- contents -->
		</div>
		<!-- headerContents -->

		<div class="nav">
			<div class="contents">
				<ul class="nav_menu">
					<li>
						<h2>
							<a href="#">영화</a>
						</h2>
					</li>
					<li>
						<h2>
							<a href="#">공연</a>
						</h2>
					</li>
					<li>
						<h2>
							<a href="#">극장</a>
						</h2>
					</li>
					<li>
						<h2>
							<a href="#">예매</a>
						</h2>
					</li>
					<li>
						<h2></h2>
					</li>
					<li class="sherch">
						<h2>
							<input> <a href="#">검색</a>
						</h2>
					</li>
				</ul>
			</div>
			<!-- contens -->
		</div>
		<!-- nav -->
	</div>
	<!-- header -->
	<!-- /////////////////////////////////////////////////// -->
	<!-- 틀만 잡았음 -->
	<div class="contaniner container-fluid">
		<div class="contents">
			<div id="slideWrap" class="carousel slide" data-ride="carousel">
				<a class="carousel-control-prev" href="#slideWrap" data-slide="prev">
					<span class="carousel-control-prev-icon"></span>
				</a>
				<div class="carousel-inner">

					<div class="carousel-item active">
						<img src="../images/broker_banner.jpg" alt="" width="100%"
							height="500">
						<!--  width="980" -->
					</div>
					<div class="carousel-item">
						<img src="../images/deathnote_banner.jpg" alt="" width="100%"
							height="500">
						<!--  width="980" -->
					</div>
					<div class="carousel-item">
						<img src="../images/crimecity2_banner.jpg" alt="" width="100%"
							height="500">
						<!--  width="980" -->
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
		</div>
		<!-- contents -->
	</div>
	<!-- contaniner -->
	<!-- /////////////////////////////////////////////////// -->
	<div class="chart">
		<div class="contents">
			<jsp:include page="mainTab.jsp" />
		</div>
		<!-- contents -->
	</div>
	<!-- chart -->
	<jsp:include page="mainPopup.jsp" />
	<div id="topButton" style="cursor: pointer">
		<img src="../images/ticket.png" id="reserveButtonImg">
		<img src="../images/up.jpg" id="topButtonImg">
	</div>
	<!-- <script>
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
	</script> -->
	<footer> </footer>
</body>

</html>