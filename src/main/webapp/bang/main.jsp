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
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script><script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
.contents {
	width: 980px;
	height: 100%;
	margin: 0 auto;
}
/*===========================================================================
common
=============================================================================*/
html,
body {
    height: 100%;
    
}

html,body,h1,ol,ul,li,div,h2 {
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
ul,ol,li{
    list-style: none;
 
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
    background: url(../images/exPoster1) no-repeat center;
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

.movieChart {
    margin: 0 0 20px 0;
}

.posters {
    height: 295px;
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

}

.posterWrap img {
    /* 이미지 임시 표시 */
    outline: 1px solid #708090;

}

.movieImage {
    height: 80%;

    /* 이미지 임시 표시 */
    outline: 1px solid #708090;
}
/*===========================================================================
tabmenu
=============================================================================
/* tabmenu{
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
} */
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
		<!-- Nav tabs -->	
			<ul class="tabmenu nav nav-tabs">
				<li class="nav-item">
					<a class="nav-link active" data-toggle="tab" href="#home">무비차트</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" data-toggle="tab" href="#menu1">상영예정작</a>
				</li>
			</ul>
			<!-- Tab panes -->
  				<div class="tab-content">
  					<div id="home" class="container tab-pane active movieChart">	
						<div class="posters">
							<div class="posterWrap">
								<div class="movieImage"></div>
								<!-- movieImamge -->
								<div class="movieName">
									<strong>영화제목</strong>
								</div><!-- movieName -->
								<img src="#" alt=" "><span>예매율</span>
							</div><!-- posterWrap -->
							<div class="posterWrap">
								<div class="movieImage"></div>
								<!-- movieImamge -->
								<div class="movieName">
									<strong>영화제목</strong>
								</div><!-- movieName -->
								<img src="#" alt=" "><span>예매율</span>
							</div><!-- posterWrap -->
							<div class="posterWrapBar"></div><!-- posterWrapBar -->
							<div class="posterWrap">
								<div class="movieImage"></div>
								<!-- movieImamge -->
								<div class="movieName">
									<strong>공연제목</strong>
								</div>
								<!-- movieName -->
								<img src="#" alt=" "><span>예매율</span>
							</div><!-- posterWrap -->
							<div class="posterWrap">
								<div class="movieImage"></div>
								<!-- movieImamge -->
								<div class="movieName">
									<strong>공연제목</strong>
								</div><!-- movieName -->
								<img src="#" alt=" "><span>예매율</span>
							</div><!-- posterWrap -->
						</div><!-- posters -->
					</div><!-- movieChart -->
					<div id="menu1" class="container tab-pane screen">	
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
									<strong>공연제목2</strong>
								</div>
								<!-- movieName -->
								<img src="#" alt=" "><span>예매율</span>
							</div>
							<!-- posterWrap -->
							<div class="posterWrap">
								<div class="movieImage"></div>
								<!-- movieImamge -->
								<div class="movieName">
									<strong>공연제목2</strong>
								</div>
								<!-- movieName -->
								<img src="#" alt=" "><span>예매율</span>
							</div><!-- posterWrap -->
						</div><!-- posters -->
					</div><!-- screen -->
				</div><!-- tab-content -->
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