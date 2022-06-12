<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
	<script type="text/javascript">
	//쿠키설정    
	function setCookie(name, value, expiredays) {
		var todayDate = new Date();
		todayDate.setDate(todayDate.getDate() + expiredays);
		document.cookie = name + '=' + escape(value) + '; path=/; expires='
				+ todayDate.toGMTString() + ';'
	}

	//쿠키 불러오기
	function getCookie(name) {
		var obj = name + "=";
		var x = 0;
		while (x <= document.cookie.length) {
			var y = (x + obj.length);
			if (document.cookie.substring(x, y) == obj) {
				if ((endOfCookie = document.cookie.indexOf(";", y)) == -1)
					endOfCookie = document.cookie.length;
				return unescape(document.cookie.substring(y, endOfCookie));
			}
			x = document.cookie.indexOf(" ", x) + 1;

			if (x == 0)
				break;
		}
		return "";
	}

	//닫기 버튼 클릭시
	function closeWin(key) {
		if ($("#todaycloseyn").prop("checked")) {
			setCookie('divpop' + key, 'Y', 1);
		}
		$("#divpop" + key + "").hide();
	}

	
</script>
</head>
<body>
	<form>
		<input type=button value="쿠키삭제" onClick="deleteCookie()">
	</form>
</body>
</html>