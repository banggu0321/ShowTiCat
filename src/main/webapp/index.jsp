<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Show TiCat</title>
<c:set var="path" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="${path}/bang/css/popup.css">

<script type="text/javascript">
	//쿠키설정    
	function setCookie(name, value, expiredays) {
		var todayDate = new Date();
		todayDate.setDate(todayDate.getDate() + expiredays);
		document.cookie = name + '=' + escape(value) + '; path=/; expires='
				+ todayDate.toGMTString() + ';'
	}

	//쿠키 불러오기
	function getCookie(name) {
		var obj = name + "=";
		var x = 0;
		while (x <= document.cookie.length) {
			var y = (x + obj.length);
			if (document.cookie.substring(x, y) == obj) {
				if ((endOfCookie = document.cookie.indexOf(";", y)) == -1)
					endOfCookie = document.cookie.length;
				return unescape(document.cookie.substring(y, endOfCookie));
			}
			x = document.cookie.indexOf(" ", x) + 1;

			if (x == 0)
				break;
		}
		return "";
	}

	//닫기 버튼 클릭시
	function closeWin(key) {
		if ($("#todaycloseyn").prop("checked")) {
			setCookie('divpop' + key, 'Y', 1);
		}
		$("#divpop" + key + "").hide();
	}

	$(function() {
		if (getCookie("divpop1") == "Y") {
			$("#divpop1").hide();
		} else {
			$("#divpop1").show();
		}
	});
	function deleteCookie() {
		document.cookie = "divpop1=" + "N" + ";path=/; expires=-1";
	}
	
	$(function() {
		$.ajax({
			url:"getSysdate.do",
			success: function(resData) {
				}
		});

	})
</script>
</head>

<body>
	<jsp:include page="jayoung/header.jsp"/>

	<!-- /////////////////////////////////////////////////// -->
	<!-- 틀만 잡았음 -->
	<div class="contaniner container-fluid">
		<div id="banner_contents" class="contents">
			<div id="slideWrap" class="carousel slide" data-ride="carousel">
				<a class="carousel-control-prev" href="#slideWrap" data-slide="prev">
					<span class="carousel-control-prev-icon"></span>
				</a>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<a href='jayoung/showDetail.do?show_code=AA7'>
						<img src="${path}/images/broker_banner.jpg" alt="" width="100%" height="500"></a>
						<!--  width="980" -->
					</div>
					<div class="carousel-item">
						<a href='jayoung/showDetail.do?show_code=AA10'>
						<img src="${path}/images/deathnote_banner.jpg" alt="" width="100%" height="500"></a>
						<!--  width="980" -->
					</div>
					<div class="carousel-item">
						<a href='jayoung/showDetail.do?show_code=AA6'> 
						<img src="${path}/images/crimecity2_banner.jpg" alt="" width="100%" height="500"></a>
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
			<jsp:include page="bang/mainTab.jsp" />
		</div>
		<!-- contents -->
	</div>
	<!-- chart -->
	<%-- <jsp:include page="mainPopup.jsp" /> --%>
	<form name="notice_form" id="popupform">
		<div id="divpop1" class="divpop">
			<img alt="" src="${path}/bang/main_images/QR_22739206_.png">
			<div class="button_area">
				<input type='checkbox' name='chkbox' id='todaycloseyn' value='Y'>
				오늘 하루 이 창을 열지 않음 
				<a href='#' onclick="javascript:closeWin(1);"><B>[닫기]</B></a>
			</div>
		</div>
	</form>
	<jsp:include page="bang/mainUpTicket.jsp" />
	<footer>
	</footer>
</body>
</html>