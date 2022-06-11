<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<select class="form-control" id="therter_num" name="theater_num">
	<c:forEach items="${tlist}" var="t">
		<option value="${t.theater_num}">${t.theater_num}</option>
	</c:forEach>
</select>