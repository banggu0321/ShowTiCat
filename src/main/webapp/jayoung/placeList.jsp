<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
<c:forEach items="${placeList}" var="place" varStatus="s">
	<c:if test="${s.first}">
		| <a href="placeDetail.do?place_num=${place.place_num}">
		ShowTiCat ${place.place_name}</a> |
	</c:if>
	<c:if test="${s.first==false}">
		 <a href="placeDetail.do?place_num=${place.place_num}">
		 ShowTiCat ${place.place_name}</a> |
	</c:if>
</c:forEach>
</body>
</html>