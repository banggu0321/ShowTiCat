<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>TicKet은 역시 ShowTiCat!!</title>

<link rel="stylesheet" href="css/index.css">
</head>

<body>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="header.jsp"/>
    <!-- /////////////////////////////////////////////////// -->
    <!-- 틀만 잡았음 -->
    <div class="contaniner">
        <div class="contents">
            <div class="banner">

            </div><!-- banner -->
        </div><!-- contents -->
    </div><!-- contaniner -->
    <!-- /////////////////////////////////////////////////// -->
    <div class="chart">
        <div class="contents">
            <!--  -->
            <div class="movieChart">
                <h2><a href="#">무비차트</a></h2>
            </div><!-- movieChart -->
            <div class="posters">
                <div class="posterWrap">
                    <div class="movieImage">
                    </div><!-- movieImamge -->
                    <div class="movieName">
                        <strong>영화제목</strong>
                    </div><!-- movieName -->
                    <img src="#" alt=" "><span>예매율</span>
                </div><!-- posterWrap -->

                <div class="posterWrap">
                    <div class="movieImage">
                    </div><!-- movieImamge -->
                    <div class="movieName">
                        <strong>영화제목</strong>
                    </div><!-- movieName -->
                    <img src="#" alt=" "><span>예매율</span>
                </div><!-- posterWrap -->

                <div class="posterWrap">
                    <div class="movieImage">
                    </div><!-- movieImamge -->
                    <div class="movieName">
                        <strong>영화제목</strong>
                    </div><!-- movieName -->
                    <img src="#" alt=" "><span>예매율</span>
                </div><!-- posterWrap -->

                <div class="posterWrap">
                    <div class="movieImage">
                    </div><!-- movieImamge -->
                    <div class="movieName">
                        <strong>영화제목</strong>
                    </div><!-- movieName -->
                    <img src="#" alt=" "><span>예매율</span>
                </div><!-- posterWrap -->

                <div class="posterWrap">
                    <div class="movieImage">
                    </div><!-- movieImamge -->
                    <div class="movieName">
                        <strong>영화제목</strong>
                    </div><!-- movieName -->
                    <img src="#" alt=" "><span>예매율</span>
                </div><!-- posterWrap -->

            </div><!-- posters -->


        </div><!-- contents -->
    </div><!-- chart -->

    <footer>

    </footer>
</body>

</html>