<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


bbb
<c:forEach items="${totalList }" var="img">
	<div class="movieImage">
		<input class="pImage" type="image" src=" ../images/${img.poster }"
			style="width: 100px; height: 100px;">
			 
	</div>
	<!-- movieImamge -->
	
	<div class="movieName">
	   <strong>${img.show_name }</strong>
	</div>
	<div class="movieImage">
		<input class="pImage" type="image" src=" ../images/${img.poster }"
			style="width: 100px; height: 100px;">
			 
	</div>
	<!-- movieImamge -->
	
	<div class="movieName">
	   <strong>${img.show_name }</strong>
	</div>
<!-- movieName -->

</c:forEach>

