<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
.contents {
	width: 980px;
	height: 100%;
	margin: 0 auto;
}

/*===========================================================================
common
=============================================================================*/
html, body {
	height: 100%;
}

html, body, h1, ol, ul, li, div, h2 {
	margin: 0;
	padding: 0;
}

/* body * {
    outline: 3px dotted tomato;
} */
a {
	color: black;
	text-decoration: none;
}

ul, ol, li {
	list-style: none;
}

/*===========================================================================
header
=============================================================================*/
.header {
	margin-bottom: 50px;
	height: 113px;
	border-bottom: 1px solid #ddd;
}

.headerContents {
	width: 100%;
	height: 113px;
	margin: 0 0 50px;
}

.headerContents h1 {
	width: 274px;
	height: 57px;
}

.headerContents .contents {
	padding: 30px 5px 25px 5px;
	display: flex;
	justify-content: space-between;
}

.header h1 img {
	width: 117px;
	height: 100%;
	/* 이미지 임시 표시 */
	outline: 1px solid #708090;
}

.header h1 span {
	font-size: 18.5px;
}

.member {
	width: 400px;
	height: 57px;
	padding-left: 0;
	display: flex;
	align-items: center;
	text-align: center;
	justify-content: space-evenly;
}

.member li {
	width: 36px;
	height: 100%;
}

.member a {
	height: 57px;
	display: flex;
	flex-direction: column;
	font-size: 13px;
}

.member img {
	height: 100%;
	/* 이미지 임시 표시 */
	outline: 1px solid #708090;
}

/*===========================================================================
nav
=============================================================================*/
.nav {
	margin: -50px;
	height: 40px;
	padding: 5px;
}

.nav a {
	font-size: 16px;
}

.nav li {
	width: 100%;
	height: 40px;
}

.nav_menu {
	width: 980px;
	display: inline-flex;
}

.nav_menu .sherch {
	display: flex;
}

.nav_menu input {
	width: 65%;
}

/*===========================================================================
container
=============================================================================*/
.contaniner {
	width: 100%;
	height: 500px;
	position: relative;
	background-color: #000;
}

.banner {
	width: 100%;
	height: 100%;
	background: url(/* ../images/exPoster1 */) no-repeat center;
	background-size: 50% 50%;
}

/*===========================================================================
chart
=============================================================================*/
.chart {
	width: 100%;
	height: fit-content;
}

.chart .contents {
	height: 50%;
	padding: 50px 30px 60px;
}

.chart a {
	font-size: 26px;
}

.movieChart .screen {
	margin: 0 0 20px 0;
}

.movieName {
	text-align: center;
}

.posters {
	height: 295px;
	width: 1000px;
	display: flex;
	justify-content: space-around;
}

.posters :nth-child(2) {
	margin: 0 32px;
}

.posters :nth-child(4) {
	margin: 0 32px;
}

.posterWrap {
	width: 20%;
	float: left;
}

.posterWrap img {
	/* 이미지 임시 표시 */
	outline: 1px solid #708090;
}

.posterWrapBar {
	border-left: 3px solid #aaa;
	height: 250px;
}

.movieImage {
	height: 235px;
	width: 200px;
	/* 이미지 임시 표시 */
	outline: 1px solid #708090;
}
/*===========================================================================
tabmenu
=============================================================================*/
tabmenu{
	float:left;
}
.tabmenu>li{
	float:left;
}
.tabmenu li a{
	float:left;
	display:block; 
	text-align:center; 
	background-color:#cccccc; 
	border:1px solid #dddddd;
	border-bottom:none;
}
.tabmenu li.active a{ 
  	background-color:#ffffff; 
}
/* .tabmenu li>div{
	position:absolute;
	left:5px;
	height:0;
	overflow:hidden;
} */
.tabmenu li.active >div{
	border:1px solid #dddddd;
	z-index:1;
}
</style>
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
					<li> <!-- 로그인 이미지 추가해야댐 --> <a href="#"><img src="#"
						alt=" "> <span>로그인</span> </a> </li>
					<li> <!-- 회원가입 이미지 추가해야댐 --> <a href="#"><img src="#"
						alt=" "> <span>회원가입</span> </a> </li>
					<li> <!-- 마이페이지 이미지 추가해야댐 --> <a href="#"><img src="#"
						alt=" "> <span>MyShow</span> </a> </li>
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
	<div class="contaniner">
		<div class="contents">
			<div class="banner"></div>
			<!-- banner -->
		</div>
		<!-- contents -->
	</div>
	<!-- contaniner -->
	<!-- /////////////////////////////////////////////////// -->
	<div class="chart">
		<div class="contents">
			<ul class="tabmenu">
				<li class="active"><a href="#">무비차트</a>
				 	<div class="movieChart">
						<div class="posters">
							<div class="posterWrap">
								<div class="movieImage"></div>
								<!-- movieImamge -->
								<div class="movieName">
									<strong>영화제목</strong>
								</div>
								<!-- movieName -->
								<img src="#" alt=" "><span>예매율</span>
							</div>
							<!-- posterWrap -->
							<div class="posterWrap">
								<div class="movieImage"></div>
								<!-- movieImamge -->
								<div class="movieName">
									<strong>영화제목</strong>
								</div>
								<!-- movieName -->
								<img src="#" alt=" "><span>예매율</span>
							</div>
							<!-- posterWrap -->
							<div class="posterWrapBar"></div>
							<!-- posterWrapBar -->
							<div class="posterWrap">
								<div class="movieImage"></div>
								<!-- movieImamge -->
								<div class="movieName">
									<strong>공연제목</strong>
								</div>
								<!-- movieName -->
								<img src="#" alt=" "><span>예매율</span>
							</div>
							<!-- posterWrap -->
							<div class="posterWrap">
								<div class="movieImage"></div>
								<!-- movieImamge -->
								<div class="movieName">
									<strong>공연제목</strong>
								</div>
								<!-- movieName -->
								<img src="#" alt=" "><span>예매율</span>
							</div><!-- posterWrap -->
						</div><!-- posters -->
					</div><!-- movieChart -->
				</li>
				<!-- movieChart -->
				<li><a href="#">상영예정작</a>
					<div class="screen">
						<div class="posters">
							<div class="posterWrap">
								<div class="movieImage"></div>
								<!-- movieImamge -->
								<div class="movieName">
									<strong>영화제목</strong>
								</div>
								<!-- movieName -->
								<img src="#" alt=" "><span>예매율</span>
							</div>
							<!-- posterWrap -->
							<div class="posterWrap">
								<div class="movieImage"></div>
								<!-- movieImamge -->
								<div class="movieName">
									<strong>영화제목</strong>
								</div>
								<!-- movieName -->
								<img src="#" alt=" "><span>예매율</span>
							</div>
							<!-- posterWrap -->
							<div class="posterWrapBar"></div>
							<!-- posterWrapBar -->
							<div class="posterWrap">
								<div class="movieImage"></div>
								<!-- movieImamge -->
								<div class="movieName">
									<strong>공연제목</strong>
								</div>
								<!-- movieName -->
								<img src="#" alt=" "><span>예매율</span>
							</div>
							<!-- posterWrap -->
							<div class="posterWrap">
								<div class="movieImage"></div>
								<!-- movieImamge -->
								<div class="movieName">
									<strong>공연제목</strong>
								</div>
								<!-- movieName -->
								<img src="#" alt=" "><span>예매율</span>
							</div><!-- posterWrap -->
						</div><!-- posters -->
					</div><!-- screen -->
				</li>
			</ul><!-- tabmenu -->
		</div><!-- contents -->
	</div><!-- chart -->

	<footer> </footer>
	<script>
			$(".tabmenu > li > a").click(
					function() {
						$(this).parent().addClass("active").siblings()
								.removeClass("active");
						return false;
			});
	</script>
</body>

</html>