<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<c:forEach items="${showList1 }" var="img" varStatus="status">
	<div class="posterWrap">
		<div class="movieImage" data-poster="${img.show_code }">
			<a href="jayoung/showDetail.do?show_code=${img.show_code }">
				<input class="pImage" type="image" src="${path}/images/${img.poster }">
			</a>
		</div>
		<!-- movieImamge -->
		<div class="movieName">
			<strong>${img.show_name }</strong>
		</div><!-- movieName -->
	</div><!-- posterWrap -->
</c:forEach>
<div class="posterWrapBar"></div><!-- posterWrapBar -->
<c:forEach items="${showList2 }" var="img" varStatus="status">
	<div class="posterWrap">
		<div class="movieImage" data-poster="${img.show_code }">
			<a href="jayoung/showDetail.do?show_code=${img.show_code}">
				<input class="pImage" type="image" src="${path}/images/${img.poster}">
			</a>
		</div>
		<!-- movieImamge -->
		<div class="movieName">
			<strong>${img.show_name }</strong>
		</div><!-- movieName -->
	</div><!-- posterWrap -->
</c:forEach>