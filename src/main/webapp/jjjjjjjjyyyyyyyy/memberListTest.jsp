<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberListTest</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<style>
table, td {
border: 1px solid black;
border-collapse: collapse;
padding: 10px;
}
.color1 { background-color: pink;}
.color2 { background-color: beige;}
</style>
</head>
<body>
<h1>MemeberList</h1>

<h3>
	application정보 얻기 : ${myname }
	request: ${myaddress }
</h3>

<br><br>

<table>
<tr>
<td>아이디</td>
<td>비밀번호</td>
<td>이름</td>
<td>이메일</td>
<td>핸드폰</td>
<td>생일</td>
<td>성별</td>
<td>가입일자</td>
<td>포인트</td>
<td>관심장소</td>
</tr>
전체건수: ${MemberSize} <br>
방법2: <c:set var="listSize" value="${MemberDatas.size()}"></c:set>

${memberSize}
<c:forEach items="${memberDatas}" var="member" varStatus="rowStatus">
<tr class="${rowStatus.count%2==0?'color1':'color2'}">
<td>${rowStatus.count}...${memberSize-rowStatus.index}</td>
<td><a href="memberDetail.do?memberid=${member.m_id}">${member.m_id }</a></td>
<td>${member.m_id }</td>
<td>${member.m_pw }</td>
<td>${member.m_name }</td>
<td>${member.email }</td>
<td>${member.phone }</td>
<td>${member.birth }</td>
<td>${member.gender }</td>
<td>${member.m_date }</td>
<td>${member.place_num }</td>
<td><button class="btnDel" data-bno="${member.m_id}">삭제하기</button></td>
</tr>
</c:forEach>
</table>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
$(function(){
	$(".btnDel").click(function(){
		var bno = $(this).attr("data-m_id");
		if(confirm(m_id + "삭제?"))
			location.href = "memberDelete.do?m_id="+m_id;
	});
});
</script>
</body>
</html>