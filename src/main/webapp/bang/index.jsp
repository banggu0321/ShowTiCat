<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style>
	.contents {
    width: 980px;
    height: 100%;
    margin: 0 auto;
}

/*===========================================================================
common
=============================================================================*/
html,
body {
    height: 100%;
    
}

html,body,h1,ol,ul,li,div,h2 {
    margin: 0;
    padding: 0;
}

/* body * {
    outline: 3px dotted tomato;
} */

a {
    color: black;
    text-decoration: none;
    
}
ul,ol,li{
    list-style: none;
 
}

/*===========================================================================
header
=============================================================================*/
.header {
    margin-bottom: 50px;
    height: 113px;
    border-bottom: 1px solid #ddd;
}

.headerContents {
    width: 100%;
    height: 113px;
    margin: 0 0 50px;
}

.headerContents h1 {
    width: 274px;
    height: 57px;
}

.headerContents .contents {
    padding: 30px 5px 25px 5px;
    display: flex;
    justify-content: space-between;
}

.header h1 img {
    width: 117px;
    height: 100%;

    /* 이미지 임시 표시 */
    outline: 1px solid #708090;
}

.header h1 span {
    font-size: 18.5px;
}


.member {
    width: 400px;
    height: 57px;
    padding-left: 0;
    display: flex;
    align-items: center;
    text-align: center;
    justify-content: space-evenly;
}

.member li {
    width: 36px;
    height: 100%;
}

.member a {
    height: 57px;
    display: flex;
    flex-direction: column;
    font-size: 13px;
}

.member img {
    height: 100%;

    /* 이미지 임시 표시 */
    outline: 1px solid #708090;
}

/*===========================================================================
nav
=============================================================================*/
.nav {
    margin: -50px;
    /* height: 40px;
    padding: 5px; */
}

.nav a {
    font-size: 16px;
}

/* .nav li {
    width: 100%;
    height: 40px;
} */

.nav_menu {
    width: 980px;
    display: inline-flex;
}

.nav_menu .sherch {
    display: flex;
}

.nav_menu input {
    width: 65%;
}

/*===========================================================================
container
=============================================================================*/
.contaniner {
    width: 100%;
    height: 500px;
    position: relative;
    background-color: #000;

}

.banner {
    width: 100%;
    height: 100%;
    background: url(../images/exPoster1) no-repeat center;
    background-size: 50% 50%;

}

/*===========================================================================
chart
=============================================================================*/
.chart {
    width: 100%;
    height: fit-content;
}

.chart .contents {
    height: 50%;
    padding: 50px 30px 60px;

}

	</style>
    <title>TicKet은 역시 ShowTiCat!!</title>
</head>

<body>
    <div class="header">
        <!-- 헤더 컨텐츠 -->
        <div class="headerContents">
            <div class="contents">
                <!-- 로고 및 사이트 이름 -->
                <h1>
                    <!-- 로고 이미지 추가해야댐 -->
                    <img src="#" alt="">
                    <!-- 사이트 이름 -->
                    <span>S h o w T i C a t</span>
                </h1>
                <!-- 회원관련창 -->
                <ul class="member">
                    <il>
                        <!-- 로그인 이미지 추가해야댐 -->
                        <a href="#"><img src="#" alt=" ">
                            <span>로그인</span>
                        </a>
                    </il>
                    <il>
                        <!-- 회원가입 이미지 추가해야댐 -->
                        <a href="#"><img src="#" alt=" ">
                            <span>회원가입</span>
                        </a>
                    </il>
                    <il>
                        <!-- 마이페이지 이미지 추가해야댐 -->
                        <a href="#"><img src="#" alt=" ">
                            <span>MyShow</span>
                        </a>
                    </il>
                </ul><!-- member -->
            </div><!-- contents -->
        </div><!-- headerContents -->

        <div class="nav">
            <div class="contents">
                <ul class="nav_menu">
                    <li>
                        <h2><a href="#">영화</a></h2>
                    </li>
                    <li>
                        <h2><a href="#">공연</a></h2>
                    </li>
                    <li>
                        <h2><a href="#">극장</a></h2>
                    </li>
                    <li>
                        <h2><a href="#">예매</a></h2>
                    </li>
                    <li>
                        <h2></h2>
                    </li>
                    <li class="sherch">
                        <h2><input>
                            <a href="#">검색</a>
                        </h2>
                    </li>
                </ul>
            </div><!-- contens -->
        </div><!-- nav -->
    </div><!-- header -->
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
        	<jsp:include page="mainTab.jsp"/>
        </div><!-- contents -->
    </div><!-- chart -->

    <footer>

    </footer>
</body>

</html>