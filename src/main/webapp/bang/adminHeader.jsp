<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="path" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${path}/css/admin.css">

<div class="header">
	<hr>
	<div class="content">
		<div class="nav">
			<div>
				<span>관리자페이지</span>
			</div>
			<ul class="nav_menu">
				<li class="nav_menu_1">
					<span><a href="schedule.do">Schedule</a></span>
				</li>
				<li class="nav_menu_2">
					<span><a href="show.do">Show</a></span>
				</li>
			</ul>
		</div><!-- nav -->
		<!-- 로고 및 사이트 이름 -->
		<div class="logo">
			<a href="${path}"> 
				<img src="${path}/images/222.png" alt="ShowTiCat">
			</a>
		</div><!-- logo -->
	</div>
	<hr>
</div><!-- header -->