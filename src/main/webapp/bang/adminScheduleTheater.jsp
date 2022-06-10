<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<select class="form-control" id="therter_num" name="theater_num">
	<option value="A1">A1</option>

	<c:forEach items="${tlist}" var="t">
		<option value="${t.theater_num}">${t.theater_num}</option>
	</c:forEach>
</select>