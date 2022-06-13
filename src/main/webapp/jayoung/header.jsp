<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/header.css">
<script>
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
<c:set var="path" value="${pageContext.request.contextPath}"/>
    <div class="header">
        <!-- 헤더 컨텐츠 -->
        <div class="headerContents">
            <div class="contents">
                <!-- 로고 및 사이트 이름 -->
                <h1>
                    <a href="${path}">
	                    <img src="${path}/images/222.png" alt="ShowTiCat">
	                    <!-- 사이트 이름 -->
                    </a>
                </h1>
                <!-- 회원관련창 -->
	            <ul class="member">
		            <li></li>
                <c:if test="${member != null}">
	                    <il>
	                        <a href="${path}/jayoung/logout.do">
	                        	<img src="${path}/images/login.png" alt="logout">
	                            <span>로그아웃</span>
	                        </a>
	                    </il>
	                    <il>
	                        <a href="${path}/jaeyong/memberPage.jsp">
	                        <img src="${path}/images/mypage.png" alt="mypage">
	                            <span>MyPage</span>
	                        </a>
	                    </il>
				</c:if>	
                <c:if test="${member == null}">
	                    <il>
	                        <a href="${path}/jayoung/login.do">
	                        	<img src="${path}/images/login.png" alt="login">
	                            <span>로그인</span>
	                        </a>
	                    </il>
	                    <il>
	                        <a href="${path}/jayoung/insert.do">
	                        <img src="${path}/images/register.png" alt="register">
	                            <span>회원가입</span>
	                        </a>
	                    </il>
				</c:if>	
	            </ul><!-- member -->
            </div><!-- contents -->
        </div><!-- headerContents -->
        
        <div class="nav">
            <div class="contents">
                <ul class="nav_menu">
                    <li>
                        <h2><a href="${path}/jayoung/showList.do?category=영화">영화</a></h2>
                    </li>
                    <li>
                        <h2><a href="${path}/jayoung/showList.do?category=공연">공연</a></h2>
                    </li>
                    <li>
                        <h2><a href="${path}/jayoung/placeDetail.do?place_num=1020&date=${sysdate}">극장</a></h2>
                    </li>
                    <li>
                        <h2><a href="#">예매</a></h2>
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
            </div><!-- contens -->
        </div><!-- nav -->
    </div><!-- header -->

</body>
</html>