<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <link rel="stylesheet" href="css/main_tab.css">
<script>
		$(function() {
			$.ajax({
				url:"screenMovie.do",
				type:"get",
				success:function(responseData){
					alert("서버에 다녀옴 : "+ responseData);
					var show = responseData.screenmovielist;
					console.dir(show);
				}
			});
		});
</script>
</head>
<body>
	<div class="container mt-3">
	  <br>
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
	    <div id="home" class="container tab-pane active"><br>
			<div class="movieChart">	
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
	    </div>
	    <div id="menu1" class="container tab-pane"><br>
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
	    </div>
	  </div>
	</div>
</body>
</html>