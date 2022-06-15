<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>
.header {
	height: 113px;
	border-bottom: 1px solid #ddd;
}

.headerContents h1 {
	width: 274px;
	height: 57px;
}

.headerContents {
	height: 113px;
	border-bottom: 1px solid #ddd;
	margin-bottom: 50px;
	width: 100%;
	height: 113px;
	margin: 0 0 50px;
}

.headerContents .contents {
	height: 113px;
	border-bottom: 1px solid #ddd;
	margin-bottom: 50px;
	width: 100%;
	height: 113px;
	padding: 30px 25px 25px 5px;
	display: flex;
	justify-content: space-between;
}

.header h1 img {
	width: 240px;
	height: 100%;
}

.header h1 span {
	width: 274px;
	height: 57px;
	margin-top: 10px;
	font-size: 20px;
	font-weight: bold;
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
	width: 120px;
	height: 100%;
	list-style: none;
}

.member a {
	height: 57px;
	display: flex;
	flex-direction: column;
	font-size: 13px;
	font-weight: bold;
	text-decoration: none;
	color: black;
}
.member a:hover {
	color: black;
	text-decoration: none;
}
.member img {
	height: 100%;
}

.member #m_info {
	font-weight: bold;
	margin-top: 10px;
}

.nav {
	margin: -70px 0px;
	height: 75px;
	padding: 20px;
	border-bottom: 1px solid #ddd;
}

.nav a {
	font-size: 16px;
	font-weight: bold;
	color: black;
	text-decoration: none;
}

.nav a:hover {
	font-size: 18px;
	font-weight: bold;
	color: black;
	text-decoration: none;
}
.nav li {
	width: 100%;
	height: 40px;
	list-style: none;
	
}
.nav_menu {
	width: 1000px;
	display: inline-flex;
}

.nav_menu .search form {
	margin-top: 8px;
	display: inline-flex;
}

.nav_menu .search .btn {
	margin-left: 5px;
	font-weight: bold;
}
</style>
</head>

<body>
	<c:set var="path" value="${pageContext.request.contextPath}" />
	<div class="header">
		<!-- 헤더 컨텐츠 -->
		<div class="headerContents">
			<div class="contents">

				<!-- 로고 및 사이트 이름 -->
				<h1>
					<a href="${path}"> <img src="${path}/images/222.png"
						alt="ShowTiCat"> <!-- 사이트 이름 -->
					</a>
				</h1>

				<!-- 회원관련창 -->
				<ul class="member">
					<c:if test="${member != null}">
						<li><a href="${path}/jayoung/logout.do"> <img
								src="${path}/images/login.png" alt="logout"> <span>로그아웃</span></a></li>
						<li><a href="${path}/jaeyong/memberPage.jsp"> <img
								src="${path}/images/mypage.png" alt="mypage"> <span>MyPage</span>
						</a></li>
						<li id="m_info"><span><br> ${member.m_name}님<br>
								${member.point}점 </span></li>
					</c:if>

					<c:if test="${member == null}">
						<li><a href="${path}/jayoung/login.do"> <img
								src="${path}/images/login.png" alt="login"> <span>로그인</span>
						</a></li>
						<li><a href="${path}/jayoung/insert.do"> <img
								src="${path}/images/register.png" alt="register"> <span>회원가입</span>
						</a></li>
						<li><a href="${path}/jaeyong/memberPage.jsp"> <img
								src="${path}/images/mypage.png" alt="mypage"> <span>MyPage</span>
						</a></li>
					</c:if>

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
							<a href="${path}/jayoung/showList.do?category=영화">영화</a>
						</h2>
					</li>
					<li>
						<h2>
							<a href="${path}/jayoung/showList.do?category=공연">공연</a>
						</h2>
					</li>
					<li>
						<h2>
							<a
								href="${path}/jayoung/placeDetail.do?place_num=1020&date=${sysdate}">극장</a>
						</h2>
					</li>
					<li>
						<h2>
							<a href="#">예매</a>
						</h2>
					</li>
					<li></li>
					<li></li>
					<li class="search">
						<form action="${path}/jayoung/result.do" id="formH">
							<input type="text" name="word" id="searchH" value="${word}">
							<input class="btn btn-light btn-sm" type="submit" value="검색">
						</form>
					</li>
				</ul>
			</div>
			<!-- contens -->
		</div>
		<!-- nav -->
	</div>
	<!-- header -->
</body>
</html>