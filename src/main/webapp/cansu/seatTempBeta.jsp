<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<c:set var="path" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${path}/css/common.css">

<meta charset="EUC-KR">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
input[type="checkbox"] {
	width: 25px;
	height: 25px;
	margin: 15px;
}

input[type="checkbox"]:checked {
	appearance: none;
	background-color: #1E90FF;
	color: #1E90FF;
}

#sub1 {
	height: 400px;
	background-color: #B0C4DE;
	border: 1px solid black;
}

#screen {
	background-color: #F8F8F8;
	text-align: center;
	color: #1E90FF;
}

#sub2 {
	position: relative;
	top: 10%;
	left: 30%;
	width: 40%;
	text-align: center;
}

#sub3 {
	position: relative;
	top: 20%;
	left: 45%;
	width: 10%;
}

#main {
	position: absolute;
	top: 35%;
	display: inline-block;
	width: 60%;
	position: absolute;
	left: 20%;
}
</style>
<title>좌석 선택</title>
<body>
	<div id="headerInclude">
		<jsp:include page="../jayoung/header.jsp" />
	</div>
	<form action="http://localhost:9090/ShowTiCat/seatSampleServletBeta">
		<div id="main">
			<div id='sub1'>

				<div id='screen'>
					<p>SCREEN</p>
				</div>

				<div id='sub2'>
					<table>
						<tr>
							<td>
							<c:set var="loopEnd" value="1" /> 
							<c:set var="otherBool" value="0" /> 
							
							<c:if test="${empty seatList}">
								<input type="checkbox" name="p1" value="1">
							</c:if>
							<c:forEach items="${seatList}" var="selectedSeat">
									<c:if test="${loopEnd eq 1}">
										<c:choose>
											<c:when test="${selectedSeat eq 1 }">
												<input type="checkbox" name="p1" value="1" disabled>
												<c:set var="loopEnd" value="0" />
											</c:when>
											<c:otherwise> 
												<c:set var="otherBool" value="${otherBool+1 }" />
												<c:if test="${otherBool eq fn:length(seatList)}">
													<input type="checkbox" name="p1" value="1">
												</c:if>
											</c:otherwise>

										</c:choose>
									</c:if>
							</c:forEach>
							</td>
							
									<td>
							<c:set var="loopEnd" value="1" />
							<c:set var="otherBool" value="0" /> 
							<c:if test="${empty seatList}">
								<input type="checkbox" name="p2" value="2">
							</c:if>
							<c:forEach items="${seatList}" var="selectedSeat">
									<c:if test="${loopEnd eq 1}">
										<c:choose>
											<c:when test="${selectedSeat eq 2 }">
												<input type="checkbox" name="p2" value="2" disabled>
												<c:set var="loopEnd" value="0" />
											</c:when>
											<c:otherwise>
												<c:set var="otherBool" value="${otherBool+1 }" />
												<c:if test="${otherBool eq fn:length(seatList)}">
													<input type="checkbox" name="p2" value="2">
												</c:if>
											</c:otherwise>
										</c:choose>
									</c:if>
							</c:forEach>
							</td>

							<td>
							<c:set var="loopEnd" value="1" /> 
							<c:set var="otherBool" value="0" /> 
							<c:if test="${empty seatList}">
								<input type="checkbox" name="p3" value="3">
							</c:if>
							<c:forEach items="${seatList}" var="selectedSeat">
									<c:if test="${loopEnd eq 1}">
										<c:choose>
											<c:when test="${selectedSeat eq 3 }">
												<input type="checkbox" name="p3" value="3" disabled>
												<c:set var="loopEnd" value="0" />
											</c:when>
											<c:otherwise>
												<c:set var="otherBool" value="${otherBool+1 }" />
												<c:if test="${otherBool eq fn:length(seatList)}">
													<input type="checkbox" name="p3" value="3">
												</c:if>
											</c:otherwise>
										</c:choose>
									</c:if>
							</c:forEach>
							</td>

							<td>
							<c:set var="loopEnd" value="1" /> 
							<c:set var="otherBool" value="0" /> 
							<c:if test="${empty seatList}">
								<input type="checkbox" name="p4" value="4">
							</c:if>
							<c:forEach items="${seatList}" var="selectedSeat">
									<c:if test="${loopEnd eq 1}">
										<c:choose>
											<c:when test="${selectedSeat eq 4 }">
												<input type="checkbox" name="p4" value="4" disabled>
												<c:set var="loopEnd" value="0" />
											</c:when>
											<c:otherwise>
												<c:set var="otherBool" value="${otherBool+1 }" />
												<c:if test="${otherBool eq fn:length(seatList)}">
													<input type="checkbox" name="p4" value="4">
												</c:if>
											</c:otherwise>
										</c:choose>
									</c:if>
							</c:forEach>
							</td>

							<td>
							<c:set var="loopEnd" value="1" /> 
							<c:set var="otherBool" value="0" /> 
							<c:if test="${empty seatList}">
								<input type="checkbox" name="p5" value="5">
							</c:if>
							<c:forEach items="${seatList}" var="selectedSeat">
									<c:if test="${loopEnd eq 1}">
										<c:choose>
											<c:when test="${selectedSeat eq 5 }">
												<input type="checkbox" name="p5" value="5" disabled>
												<c:set var="loopEnd" value="0" />
											</c:when>
											<c:otherwise>
												<c:set var="otherBool" value="${otherBool+1 }" />
												<c:if test="${otherBool eq fn:length(seatList)}">
													<input type="checkbox" name="p5" value="5">
												</c:if>
											</c:otherwise>
										</c:choose>
									</c:if>
							</c:forEach>
							</td>
							
						</tr>

						<tr>
							<td>
							<c:set var="loopEnd" value="1" />
							<c:set var="otherBool" value="0" /> 
							<c:if test="${empty seatList}">
								<input type="checkbox" name="p6" value="6">
							</c:if>
							<c:forEach items="${seatList}" var="selectedSeat">
									<c:if test="${loopEnd eq 1}">
										<c:choose>
											<c:when test="${selectedSeat eq 6 }">
												<input type="checkbox" name="p6" value="6" disabled>
												<c:set var="loopEnd" value="0" />
											</c:when>
											<c:otherwise>
												<c:set var="otherBool" value="${otherBool+1 }" />
												<c:if test="${otherBool eq fn:length(seatList)}">
													<input type="checkbox" name="p6" value="6">
												</c:if>
											</c:otherwise>
										</c:choose>
									</c:if>
							</c:forEach>
							</td>

							<td>
							<c:set var="loopEnd" value="1" /> 
							<c:set var="otherBool" value="0" /> 
							<c:if test="${empty seatList}">
								<input type="checkbox" name="p7" value="7">
							</c:if>
							<c:forEach items="${seatList}" var="selectedSeat">
									<c:if test="${loopEnd eq 1}">
										<c:choose>
											<c:when test="${selectedSeat eq 7 }">
												<input type="checkbox" name="p7" value="7" disabled>
												<c:set var="loopEnd" value="0" />
											</c:when>
											<c:otherwise>
												<c:set var="otherBool" value="${otherBool+1 }" />
												<c:if test="${otherBool eq fn:length(seatList)}">
													<input type="checkbox" name="p7" value="7">
												</c:if>
											</c:otherwise>
										</c:choose>
									</c:if>
							</c:forEach>
							</td>

							<td>
							<c:set var="loopEnd" value="1" /> 
							<c:set var="otherBool" value="0" /> 
							<c:if test="${empty seatList}">
								<input type="checkbox" name="p8" value="8">
							</c:if>
							<c:forEach items="${seatList}" var="selectedSeat">
									<c:if test="${loopEnd eq 1}">
										<c:choose>
											<c:when test="${selectedSeat eq 8 }">
												<input type="checkbox" name="p8" value="8" disabled>
												<c:set var="loopEnd" value="0" />
											</c:when>
											<c:otherwise>
												<c:set var="otherBool" value="${otherBool+1 }" />
												<c:if test="${otherBool eq fn:length(seatList)}">
													<input type="checkbox" name="p8" value="8">
												</c:if>
											</c:otherwise>
										</c:choose>
									</c:if>
							</c:forEach>
							</td>

							<td>
							<c:set var="loopEnd" value="1" /> 
							<c:set var="otherBool" value="0" /> 
							<c:if test="${empty seatList}">
								<input type="checkbox" name="p9" value="9">
							</c:if>
							<c:forEach items="${seatList}" var="selectedSeat">
									<c:if test="${loopEnd eq 1}">
										<c:choose>
											<c:when test="${selectedSeat eq 9 }">
												<input type="checkbox" name="p9" value="9" disabled>
												<c:set var="loopEnd" value="0" />
											</c:when>
											<c:otherwise>
												<c:set var="otherBool" value="${otherBool+1 }" />
												<c:if test="${otherBool eq fn:length(seatList)}">
													<input type="checkbox" name="p9" value="9">
												</c:if>
											</c:otherwise>
										</c:choose>
									</c:if>
							</c:forEach>
							</td>

							<td>
							<c:set var="loopEnd" value="1" /> 
							<c:set var="otherBool" value="0" /> 
							<c:if test="${empty seatList}">
								<input type="checkbox" name="p10" value="10">
							</c:if>
							<c:forEach items="${seatList}" var="selectedSeat">
									<c:if test="${loopEnd eq 1}">
										<c:choose>
											<c:when test="${selectedSeat eq 10 }">
												<input type="checkbox" name="p10" value="10" disabled>
												<c:set var="loopEnd" value="0" />
											</c:when>
											<c:otherwise>
												<c:set var="otherBool" value="${otherBool+1 }" />
												<c:if test="${otherBool eq fn:length(seatList)}">
													<input type="checkbox" name="p10" value="10">
												</c:if>
											</c:otherwise>
										</c:choose>
									</c:if>
							</c:forEach>
							</td>
						</tr>

						<tr>
							<td>
							<c:set var="loopEnd" value="1" /> 
							<c:set var="otherBool" value="0" /> 
							<c:if test="${empty seatList}">
								<input type="checkbox" name="p11" value="11">
							</c:if>
							<c:forEach items="${seatList}" var="selectedSeat">
									<c:if test="${loopEnd eq 1}">
										<c:choose>
											<c:when test="${selectedSeat eq 11 }">
												<input type="checkbox" name="p11" value="11" disabled>
												<c:set var="loopEnd" value="0" />
											</c:when>
											<c:otherwise>
												<c:set var="otherBool" value="${otherBool+1 }" />
												<c:if test="${otherBool eq fn:length(seatList)}">
													<input type="checkbox" name="p11" value="11">
												</c:if>
											</c:otherwise>
										</c:choose>
									</c:if>
							</c:forEach>
							</td>

							<td>
							<c:set var="loopEnd" value="1" />
							<c:set var="otherBool" value="0" /> 
							<c:if test="${empty seatList}">
								<input type="checkbox" name="p12" value="12">
							</c:if>
							<c:forEach items="${seatList}" var="selectedSeat">
									<c:if test="${loopEnd eq 1}">
										<c:choose>
											<c:when test="${selectedSeat eq 12 }">
												<input type="checkbox" name="p12" value="12" disabled>
												<c:set var="loopEnd" value="0" />
											</c:when>
											<c:otherwise>
												<c:set var="otherBool" value="${otherBool+1 }" />
												<c:if test="${otherBool eq fn:length(seatList)}">
													<input type="checkbox" name="p12" value="12">
												</c:if>
											</c:otherwise>
										</c:choose>
									</c:if>
							</c:forEach>
							</td>

							<td>
							<c:set var="loopEnd" value="1" /> 
							<c:set var="otherBool" value="0" /> 
							<c:if test="${empty seatList}">
								<input type="checkbox" name="p13" value="13">
							</c:if>
							<c:forEach items="${seatList}" var="selectedSeat">
									<c:if test="${loopEnd eq 1}">
										<c:choose>
											<c:when test="${selectedSeat eq 13 }">
												<input type="checkbox" name="p13" value="13" disabled>
												<c:set var="loopEnd" value="0" />
											</c:when>
											<c:otherwise>
												<c:set var="otherBool" value="${otherBool+1 }" />
												<c:if test="${otherBool eq fn:length(seatList)}">
													<input type="checkbox" name="p13" value="13">
												</c:if>
											</c:otherwise>
										</c:choose>
									</c:if>
							</c:forEach>
							</td>

							<td>
							<c:set var="loopEnd" value="1" /> 
							<c:set var="otherBool" value="0" /> 
							<c:if test="${empty seatList}">
								<input type="checkbox" name="p14" value="14">
							</c:if>							
							<c:forEach items="${seatList}" var="selectedSeat">
									<c:if test="${loopEnd eq 1}">
										<c:choose>
											<c:when test="${selectedSeat eq 14 }">
												<input type="checkbox" name="p14" value="14" disabled>
												<c:set var="loopEnd" value="0" />
											</c:when>
											<c:otherwise>
												<c:set var="otherBool" value="${otherBool+1 }" />
												<c:if test="${otherBool eq fn:length(seatList)}">
													<input type="checkbox" name="p14" value="14">
												</c:if>
											</c:otherwise>
										</c:choose>
									</c:if>
							</c:forEach>
							</td>

							<td>
							<c:set var="loopEnd" value="1" /> 
							<c:set var="otherBool" value="0" /> 
							<c:if test="${empty seatList}">
								<input type="checkbox" name="p15" value="15">
							</c:if>
							<c:forEach items="${seatList}" var="selectedSeat">
									<c:if test="${loopEnd eq 1}">
										<c:choose>
											<c:when test="${selectedSeat eq 15 }">
												<input type="checkbox" name="p15" value="15" disabled>
												<c:set var="loopEnd" value="0" />
											</c:when>
											<c:otherwise>
												<c:set var="otherBool" value="${otherBool+1 }" />
												<c:if test="${otherBool eq fn:length(seatList)}">
													<input type="checkbox" name="p15" value="15">
												</c:if>
											</c:otherwise>
										</c:choose>
									</c:if>
							</c:forEach>
							</td>
						</tr>

						<tr>
							<td>
							<c:set var="loopEnd" value="1" /> 
							<c:set var="otherBool" value="0" /> 
							<c:if test="${empty seatList}">
								<input type="checkbox" name="p16" value="16">
							</c:if>
							<c:forEach items="${seatList}" var="selectedSeat">
									<c:if test="${loopEnd eq 1}">
										<c:choose>
											<c:when test="${selectedSeat eq 16 }">
												<input type="checkbox" name="p16" value="16" disabled>
												<c:set var="loopEnd" value="0" />
											</c:when>
											<c:otherwise>
												<c:set var="otherBool" value="${otherBool+1 }" />
												<c:if test="${otherBool eq fn:length(seatList)}">
													<input type="checkbox" name="p16" value="16">
												</c:if>
											</c:otherwise>
										</c:choose>
									</c:if>
							</c:forEach>
							</td>

							<td>
							<c:set var="loopEnd" value="1" /> 
							<c:set var="otherBool" value="0" /> 
							<c:if test="${empty seatList}">
								<input type="checkbox" name="p17" value="17">
							</c:if>
							<c:forEach items="${seatList}" var="selectedSeat">
									<c:if test="${loopEnd eq 1}">
										<c:choose>
											<c:when test="${selectedSeat eq 17 }">
												<input type="checkbox" name="p17" value="17" disabled>
												<c:set var="loopEnd" value="0" />
											</c:when>
											<c:otherwise>
												<c:set var="otherBool" value="${otherBool+1 }" />
												<c:if test="${otherBool eq fn:length(seatList)}">
													<input type="checkbox" name="p17" value="17">
												</c:if>
											</c:otherwise>
										</c:choose>
									</c:if>
							</c:forEach>
							</td>

							<td>
							<c:set var="loopEnd" value="1" /> 
							<c:set var="otherBool" value="0" /> 
							<c:if test="${empty seatList}">
								<input type="checkbox" name="p18" value="18">
							</c:if>
							<c:forEach items="${seatList}" var="selectedSeat">
									<c:if test="${loopEnd eq 1}">
										<c:choose>
											<c:when test="${selectedSeat eq 18 }">
												<input type="checkbox" name="p18" value="18" disabled>
												<c:set var="loopEnd" value="0" />
											</c:when>
											<c:otherwise>
												<c:set var="otherBool" value="${otherBool+1 }" />
												<c:if test="${otherBool eq fn:length(seatList)}">
													<input type="checkbox" name="p18" value="18">
												</c:if>
											</c:otherwise>
										</c:choose>
									</c:if>
							</c:forEach>
							</td>

							<td>
							<c:set var="loopEnd" value="1" /> 
							<c:set var="otherBool" value="0" /> 
							<c:if test="${empty seatList}">
								<input type="checkbox" name="p19" value="19">
							</c:if>
							<c:forEach items="${seatList}" var="selectedSeat">
									<c:if test="${loopEnd eq 1}">
										<c:choose>
											<c:when test="${selectedSeat eq 19 }">
												<input type="checkbox" name="p19" value="19" disabled>
												<c:set var="loopEnd" value="0" />
											</c:when>
											<c:otherwise>
												<c:set var="otherBool" value="${otherBool+1 }" />
												<c:if test="${otherBool eq fn:length(seatList)}">
													<input type="checkbox" name="p19" value="19">
												</c:if>
											</c:otherwise>
										</c:choose>
									</c:if>
							</c:forEach>
							</td>

							<td>
							<c:set var="loopEnd" value="1" /> 
							<c:set var="otherBool" value="0" /> 
							<c:if test="${empty seatList}">
								<input type="checkbox" name="p20" value="20">
							</c:if>
							<c:forEach items="${seatList}" var="selectedSeat">
									<c:if test="${loopEnd eq 1}">
										<c:choose>
											<c:when test="${selectedSeat eq 20 }">
												<input type="checkbox" name="p20" value="20" disabled>
												<c:set var="loopEnd" value="0" />
											</c:when>
											<c:otherwise>
												<c:set var="otherBool" value="${otherBool+1 }" />
												<c:if test="${otherBool eq fn:length(seatList)}">
													<input type="checkbox" name="p20" value="20">
												</c:if>
											</c:otherwise>
										</c:choose>
									</c:if>
							</c:forEach>
							</td>
						</tr>
					</table>
				</div>

				<div id='sub3'>
					<input type="submit" class="btn btn-primary">
				</div>
			</div>
		</div>

	</form>

</body>
</html>