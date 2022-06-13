<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/main_tab.css">
<script>
		$(function() {//tchart active하면
			//alert("load 후");
			if($(".tchart").hasClass("active")){
				$.ajax({
					url:"bang/tab1.do",
					type:"get",
					success:function(responseData){
						//alert("서버에 다녀옴 : "+ responseData);
						$("#home > .movieChart > .posters").html(responseData);
					}
				});
			}else{}
			
			$(".tscreen").click(function() {
				$.ajax({
					url:"bang/tab2.do",
					type:"get",
					success:function(responseData){
						//alert("서버에 다녀옴 : "+ responseData);
						$("#menu1 > .movieChart > .posters").html(responseData);
					}
				});
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
	      <a class="nav-link tchart active" data-toggle="tab" href="#home">무비차트</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link tscreen" data-toggle="tab" href="#menu1">상영예정작</a>
	    </li>
	  </ul>
	  
	  <!-- Tab panes -->
	  <div class="tab-content">
	    <div id="home" class="container tab-pane active"><br>
			<div class="movieChart">	
				<div class="posters">
				    <div class="posterWrap">
						<div class="movieImage"">
							<input class="pImage" type="image" src="bang/main_images/notReady.jpg">
						</div>
						<!-- movieImamge -->
						<div class="movieName">
							<strong>준비중</strong>
						</div><!-- movieName -->
					</div><!-- posterWrap -->
					<div class="posterWrap">
						<div class="movieImage"">
							<input class="pImage" type="image" src="bang/main_images/notReady.jpg">
						</div>
						<!-- movieImamge -->
						<div class="movieName">
							<strong>준비중</strong>
						</div><!-- movieName -->
					</div><!-- posterWrap -->
					<div class="posterWrapBar"></div><!-- posterWrapBar -->
					<div class="posterWrap">
						<div class="movieImage"">
							<input class="pImage" type="image" src="bang/main_images/notReady.jpg">
						</div>
						<!-- movieImamge -->
						<div class="movieName">
							<strong>준비중</strong>
						</div><!-- movieName -->
					</div><!-- posterWrap -->
					<div class="posterWrap">
						<div class="movieImage"">
							<input class="pImage" type="image" src="bang/main_images/notReady.jpg">
						</div>
						<!-- movieImamge -->
						<div class="movieName">
							<strong>준비중</strong>
						</div><!-- movieName -->
					</div><!-- posterWrap -->
				</div><!-- posters -->
			</div><!-- movieChart -->
	    </div>
	    <div id="menu1" class="container tab-pane"><br>
	    	<div class="movieChart">	
				<div class="posters">
					<div class="posterWrap">
						<div class="movieImage"">
							<input class="pImage" type="image" src="bang/main_images/notReady.jpg">
						</div>
						<!-- movieImamge -->
						<div class="movieName">
							<strong>준비중</strong>
						</div><!-- movieName -->
					</div><!-- posterWrap -->
					<div class="posterWrap">
						<div class="movieImage"">
							<input class="pImage" type="image" src="bang/main_images/notReady.jpg">
						</div>
						<!-- movieImamge -->
						<div class="movieName">
							<strong>준비중</strong>
						</div><!-- movieName -->
					</div><!-- posterWrap -->
					<div class="posterWrapBar"></div><!-- posterWrapBar -->
					<div class="posterWrap">
						<div class="movieImage"">
							<input class="pImage" type="image" src="bang/main_images/notReady.jpg">
						</div>
						<!-- movieImamge -->
						<div class="movieName">
							<strong>준비중</strong>
						</div><!-- movieName -->
					</div><!-- posterWrap -->
					<div class="posterWrap">
						<div class="movieImage"">
							<input class="pImage" type="image" src="bang/main_images/notReady.jpg">
						</div>
						<!-- movieImamge -->
						<div class="movieName">
							<strong>준비중</strong>
						</div><!-- movieName -->
					</div><!-- posterWrap -->
				</div><!-- posters -->
			</div><!-- screen -->
	    </div>
	  </div>
	</div>
</body>
</html>