<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
body {
	margin: 0 auto;
	width: 60%;
}
h1 {
	text-align: center;
}
input[type="checkbox"]{
width: 25px;
height: 25px;
margin: 15px;
}
input[type="checkbox"]:checked{
appearance: none;
background-color: #1E90FF; 
color:#1E90FF;
}
#sub1{
height: 400px;
background-color: #B0C4DE;
border: 1px solid black;
}
#screen{
background-color: #F8F8F8;
text-align: center;
color: #1E90FF;
}
#sub2{
position: relative;
top: 10%;
left:30%;
width:40%;
text-align:center;
}
#sub3{
position: relative;
top:20%;
left: 45%;
width:10%;
}
</style>
<title>좌석 선택</title>
</head>
<body>
<h1>좌석 선택</h1>

<form action="http://localhost:9090/ShowTiCat/seatSampleServlet">
<div id='sub1'>
<div id='screen'>
<p>SCREEN</p>
</div>

<div id='sub2'>
<table>
<tr>
<td><input type="checkbox" name="p1" value="1"></td>
<td><input type="checkbox" name="p2" value="2"></td>
<td><input type="checkbox" name="p3" value="3"></td>
<td><input type="checkbox" name="p4" value="4"></td>
<td><input type="checkbox" name="p5" value="5"></td>
</tr>

<tr>
<td><input type="checkbox" name="p6" value="6"></td>
<td><input type="checkbox" name="p7" value="7"></td>
<td><input type="checkbox" name="p8" value="8"></td>
<td><input type="checkbox" name="p9" value="9"></td>
<td><input type="checkbox" name="p10" value="10"></td>
</tr>

<tr>
<td><input type="checkbox" name="p11" value="11"></td>
<td><input type="checkbox" name="p12" value="12"></td>
<td><input type="checkbox" name="p13" value="13"></td>
<td><input type="checkbox" name="p14" value="14"></td>
<td><input type="checkbox" name="p15" value="15"></td>
</tr>

<tr>
<td><input type="checkbox" name="p16" value="16"></td>
<td><input type="checkbox" name="p17" value="17"></td>
<td><input type="checkbox" name="p18" value="18"></td>
<td><input type="checkbox" name="p19" value="19"></td>
<td><input type="checkbox" name="p20" value="20"></td>
</tr>
</table>
</div>

<div id='sub3'>
<input type="submit" class="btn btn-primary" >
</div>


</div>
</form>

</body>
</html>