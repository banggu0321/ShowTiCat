<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
  <!-- 네이버 로그인 버튼 노출 영역 -->
  <div id="naver_id_login"></div>
  <!-- //네이버 로그인 버튼 노출 영역 -->
  
  <form action="loginTest" method="post" id="myfrm">
  <input type="hidden" name="email" id="email">
  <input type="hidden" name="nickname" id="nickname">
  <input type="hidden" name="age" id="age">
  </form>
  
  <script type="text/javascript">
  	var naver_id_login = new naver_id_login("TLA9FoepHy9mR_zRu3wf", 
  							"http://localhost:9090/ShowTiCat/jayoung/loginTest.jsp");
  	var state = naver_id_login.getUniqState();
  	naver_id_login.setButton("white", 2,40);
  	naver_id_login.setDomain("http://localhost:9090/ShowTiCat");
  	naver_id_login.setState(state);
  	naver_id_login.setPopup();
  	naver_id_login.init_naver_id_login();
  </script>
</body>
</html>