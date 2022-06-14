<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberUpdate</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="../css/common.css">
<link rel="stylesheet" href="../css/memberMyPage.css">


<script>
$(function() {
	$("#m_pw").on("keyup",checkPW);
	$("#pw2").on("keyup",checkPW);

});

$(function(){
	$("#btnDelete").click(function(){
		var m_id = $(this).attr("del");
		if(confirm(m_id + "삭제?"))
			location.href = "memberDelete.do?m_id="+m_id;
	});
});


function checkPW() {
    var pw1= $("#m_pw").val();
    var pw2= $("#pw2").val();
    
    if(pw1==pw2) {
            $("#pwMsg").html("pass")
        } else {
            $("#pwMsg").html("fail")	        	
        }
    
    }
 
</script>
<style>
p {
	margin: 0;
	font-size: 0.25em;
	color: tomato;
}
</style>
</head>
	<body>
	<jsp:include page="../jayoung/header.jsp"/>
	<form action="memberUpdate.do" method="post">
		<br>
		<label>비밀번호 : </label>
		<input type="password"
			   name="m_pw"
			   id="m_pw" value="${member.m_pw}"><br>
		
		<label>비밀번호 확인 : </label>
		<input type="password"
			   id="pw2"
			   name="m_pw">
		<span  id="pwMsg"></span><br><br>

		<input type="hidden"
			   name="point"
			   value="${member.point}">
		<br>

		<input type="button"
			   class="btn btn-outline-success"
			   del = "${member.m_id}"
			   value="확인"
			   id="btnDelete">
	</form>
</body>
</html>