<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
</head>

<body>
<c:set var="path" value="${pageContext.request.contextPath}"/>
    <div class="header">
        <!-- 헤더 컨텐츠 -->
        <div class="headerContents">
            <div class="contents">
                <!-- 로고 및 사이트 이름 -->
                <h1>
                    <a href="${path}/jayoung/index.jsp"><img src="${path}/images/Ticat.png" alt="logo">
                    <!-- 사이트 이름 -->
                    <span>S h o w T i C a t</span>
                    </a>
                </h1>
                <!-- 회원관련창 -->
                <c:if test="${member != null}">
	                <ul class="member">
	                    <il>
	                        <a href="${path}/jayoung/logout.do">
	                        	<img src="${path}/images/login.png" alt="logout">
	                            <span>로그아웃</span>
	                        </a>
	                    </il>
	                    <il>
	                        <a href="${path}/jayoung/login.do">
	                        <img src="${path}/images/mypage.png" alt="mypage">
	                            <span>MyPage</span>
	                        </a>
	                    </il>
	                </ul><!-- member -->
				</c:if>	
                <c:if test="${member == null}">
	                <ul class="member">
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
	                    <il>
	                        <a href="${path}/jjjjjjjjyyyyyyyy/memberPage.jsp">
	                        <img src="${path}/images/mypage.png" alt="mypage">
	                            <span>MyPage</span>
	                        </a>
	                    </il>
	                </ul><!-- member -->
				</c:if>	
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
                    	<%-- date 수정필요 --%>
                        <h2><a href="placeDetail.do?place_num=1020&date=2022-06-11">극장</a></h2>
                    </li>
                    <li>
                        <h2><a href="#">예매</a></h2>
                    </li>
                    <li>
                        <h2></h2>
                    </li>
                    <li class="sherch">
                        <h2><input id="search" value="${word}">
                            <a href="${path}/jayoung/result.do?word=${word}">검색</a>
                        </h2>
                    </li>
                </ul>
            </div><!-- contens -->
        </div><!-- nav -->
    </div><!-- header -->
</body>
</html>