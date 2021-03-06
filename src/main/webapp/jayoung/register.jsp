<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>JOIN ShowTiCat</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="../css/common.css">

<script>
$(function() {
	$("#joinForm").on("submit",isChecked);
	$("#check").hide();
	
	$("#m_id").on("keyup",checkID);
	$("#m_pw").on("keyup",checkPW);
	$("#pw2").on("keyup",checkPW);
	$("#phone").on("keyup",checkPhone);
	$("#select").on("change",selectChange);
	$("#resetBtn").on("click",reset);
	$("#sendSMS").on("click",sendSMS);
	$("#checkNum").on("click",checkNum);
	
    var now = new Date();
    var year = now.getFullYear();
    var mon = (now.getMonth() + 1) > 9 ? ''+(now.getMonth() + 1) : '0'+(now.getMonth() + 1); 
    var day = (now.getDate()) > 9 ? ''+(now.getDate()) : '0'+(now.getDate());           
                 
    for(var i = 1900 ; i <= year ; i++) {
        $('#year').append('<option value="'+i+'">' + i + '</option>');    
    }
          
    for(var i=1; i <= 12; i++) {
        var mm = i > 9 ? i : "0"+i ;            
        $('#month').append('<option value="'+mm+'">' + mm + '</option>');    
    }
    
    for(var i=1; i <= 31; i++) {
        var dd = i > 9 ? i : "0"+i ;            
        $('#day').append('<option value="'+dd+'">' + dd+ '</option>');    
    }
    
    $("#year  > option[value="+year+"]").attr("selected", "true");        
    $("#month  > option[value="+mon+"]").attr("selected", "true");    
    $("#day  > option[value="+day+"]").attr("selected", "true");  
});

function checkPW() {
	var pw1 = $("#m_pw").val().trim();
	var pw2 = $("#pw2").val().trim();
	
	if(pw1==null||pw1==''){
		$("#pwMsg").html("PW??? ?????????????????????.");
	}else if(pw1 != pw2) {
		$("#pwMsg").html("??????????????? ???????????????.");
	} else {
		$("#pwMsg").html("??????????????? PW?????????.");
	}
}

function checkID() {
	var m_id = $("#m_id").val().trim();
	if(m_id==""||m_id==null) {
		$("#idMsg").html("ID??? ?????????????????????.");
		return;
	}
	$.ajax({
		url:"idCheck.do",
		data:{"m_id":m_id},
		success: function(resData) {
			if(resData==0) {
				$("#idMsg").html("??????????????? ID?????????.");
			}else {
				$("#idMsg").html("?????? ???????????? ID?????????.");	
			}
		},
		fail: function() {}
	});
}

function checkPhone() {
	var phone = $("#phone").val().trim();
	if(phone.length < 11) {
		$("#phoneMsg").html("???????????? ?????????????????????.");
		return;
	}
	$.ajax({
		url:"phoneCheck.do",
		data:{"phone":phone},
		success: function(resData) {
			if(resData==0) {
				$("#phoneMsg").html("??????????????? ??????????????????.");
			}else {
				$("#phoneMsg").html("??????????????? ??????????????????.");	
			}
		},
		fail: function() {}
	});
}

function isChecked() {
	var idMsg = $("#idMsg").html().trim();
	var pwMsg = $("#pwMsg").html().trim();

	var name = $("#m_name").val();
	var email = $("#email1").val();
	var phoneMsg = $("#phoneMsg").html();
	var msg = $("#msg").html();
	
	if(idMsg != "??????????????? ID?????????.") {
		$("#m_id").focus();
		return false;
	}else if(pwMsg != "??????????????? PW?????????.") {
		$("#m_pw").focus();
		return false;
	}else if(name==null||name==''){
		$("#m_name").focus();
		return false;
	}else if(email==null||email==''){
		$("#email").focus();
		return false;
	}else if(phoneMsg != "??????????????? ??????????????????."){
		$("#phone").focus();
		return false;
	}else if(msg != "????????????"){
		return false;
	}
}

function selectChange() {
	 if ($('#select').val() == 'directly') {
        $('#email2').attr("readonly", false);
        $('#email2').val("");
        $('#email2').focus();
    } else {
        $('#email2').val($('#select').val());
        $('#email2').attr("readonly",true);
    }
}

var code="";
function sendSMS() {
	var phone = $("#phone").val();
	var phoneMsg = $("#phoneMsg").html();
	if(phoneMsg != "??????????????? ??????????????????."){
		alert("????????? ???????????? ??????????????????.");
		$("#phone").focus();
		return;
	}

	$("#check").show();
	$.ajax({
		url:"sendSMS.do",
		data:{"phone":phone},
		success:function(data) {
			alert("??????????????? ?????????????????????.");
			$("#phone").attr("readonly",true);
			code = data;
		}
	})
}

function checkNum() {
	var input = $("#random").val();
	if(input == code) {
		$("#msg").html("????????????");
	}else {
		$("#msg").html("????????????");
	}
}

function reset() {
	$("#idMsg").empty();
	$("#pwMsg").empty();
	$("#msg").empty();
	$("#check").hide();
	$("#phone").attr("readonly",false);
	$("#phoneMsg").empty();
}
</script>

</head>

<body>
<jsp:include page="header.jsp"/>
<div class="contents">
	<form action="insert.do" method="post" id="joinForm">
	<div class="form-group">
		<label>ID </label>
		<input class="form-control" type="text" name="m_id" id="m_id">
		<span id="idMsg"></span>
	</div>
	
	<div class="form-group">
		<label>PASSWORD </label>
		<input class="form-control" type="text" name="m_pw" id="m_pw">
	</div>
	
	<div class="form-group">
		<label>PASSWORD CHECK</label>
		<input class="form-control" type="text" id="pw2" placeholder="???????????? ??????">
		<span id="pwMsg"></span>
	</div>
	
	<div class="form-group">
		<label>NAME </label>
		<input class="form-control" type="text" name="m_name" id="m_name">
	</div>
	
	<div class="form-group">
		<label>EMAIL </label>
		<input class="form-control" type="text" name="email1" id="email1" placeholder="?????????">
		<span>@</span>
		<input class="form-control" name="email2" id="email2" readonly="readonly">
		<select class="form-control" id="select">
			<option value="" disabled selected>E-Mail ??????</option>
			<option>naver.com</option>
			<option>gmail.com</option>
			<option>nate.com</option>
			<option>hanmail.net</option>
			<option value="directly">?????? ????????????</option>
		</select>
	</div>
	
	<div class="form-group">
		<label>PHONE </label>
		<input class="form-control" type="text" name="phone" id="phone" placeholder="?????????(-)?????? 11?????? ??????" pattern="[01]{2}[01679]{1}[0-9]{7,8}">
		<input class="btn btn-outline-danger" type="button" id="sendSMS" value="??????????????????">
		<span id="phoneMsg"></span>
	</div>
	
	<div id="check" class="form-group">
		<label>???????????? </label>
		<input class="form-control" type="text" name="random" id="random" placeholder="???????????? ??????" >
		<input class="btn btn-outline-danger" type="button" id="checkNum" value="????????????">
		<span id="msg"></span>
	</div>
	
	<div class="form-group">
		<label>BIRTHDAY </label>
		<select class="form-control" id="year" name="year"></select><span class="birth">??? </span>
		<select class="form-control" id="month" name="month"></select><span class="birth">??? </span>
		<select class="form-control" id="day" name="day"></select><span class="birth">??? </span>
	</div>
	
	<div class="form-group form-check-inline">
		<label>GENDER </label>
		<label class="form-check-inline">
			<input class="form-check-input" type="radio" name="gender" value="M" checked="checked">???
		</label>
		<label class="form-check-inline">
			<input class="form-check-input" type="radio" name="gender" value="W">???
		</label>
	</div>
	<br>
	<input type="submit" class="btn btn-success" value="????????????" id="submitBtn">
	<input type="reset" class="btn btn-secondary" value="?????????" id="resetBtn">
	</form>
</div>
<jsp:include page="../bang/mainUpTicket.jsp"/>
</body>
</html>