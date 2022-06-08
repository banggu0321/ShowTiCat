<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공연/영화 관리</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="css/admin.css">
	<script>
		$(function() {
			$(".btnM").click(function(){
				$("#myModal").modal();
			});
			
			$(".btnUpd").click(function() {
				var show_code = $(this).attr("data-showcode");
				$("#show_code").val(show_code);
				$.ajax({
					url:"showUpdate.do",	//어디로
					data:{"show_code":show_code},	//가져갈 data{key,value}
					type:"get",
					success:function(responseData){
						alert("서버에 다녀옴 : "+ responseData);
						var show = JSON.parse(responseData);
						  $("#show_name").val(show["show_name"]);
						  $("#director").val(show["director"]);
						  $("#trailer").val(show["trailer"]);
						  $("#opening_date").val(show["opening_date"]);
						  $("#show_time").val(show["show_time"]);
						  $("#category").val(show["category"]);
						  $("#summary").val(show["summary"]);
						  $("#poster").val(show["poster"]);
						  $("#price").val(show["price"]);
					}
				}); //location.href = "showUpdate.do?show_code=" + show_code;
			});
			
			$(".btnDel").click(function() {
				var show_code = $(this).attr("data-showcode");
				if(confirm(show_code + " 삭제?")){
					$.ajax({
						url:"showDeleteCheck.do",
						data:{"show_code": show_code},
						type:"get",
						success: function(responseData){
							if(responseData==0){
								$("#message").html("삭제가능");
							}else{
								$("#message").html("삭제불가");
							}
						},
						fail:function(){
							$("#message").html("fail");
						});
					});//location.href = "showDeleteCheck.do?show_code=" + show_code;
				}//location.href = "showDelete.do?show_code=" + show_code;
			});
		});
	</script>
</head>
<body>
	<jsp:include page="adminHeader.jsp" />
	<div>
		<h1>공연/영화 목록</h1>
		<a href="showInsert.do">영화/공연 등록</a> <br>
		<span id="message">!!!!</span>
		<br>
		<table>
			<tr>
				<td>코드</td>
				<td>제목</td>
				<td>개봉일자</td>
				<td>러닝시간</td>
				<td>카테고리</td>
				<td></td>
			</tr>
			<c:forEach items="${showlist}" var="show">
				<!-- var : DTO -->
				<tr>
					<td>${show.show_code}</td>
					<td>${show.show_name }</td>
					<td>${show.opening_date }</td>
					<td>${show.show_time }</td>
					<td>${show.category }</td>
					<td>
						<input type="button" value="모달" class="btnM btn btn-info" 
							 data-showcode="${show.show_code}">
						<input type="button" value="수정" class="btnUpd btn btn-info" 
							data-toggle="modal" data-target="#myModal" data-showcode="${show.show_code}">
						<input type="button" value="삭제" class="btnDel btn btn-dark" 
							 data-showcode="${show.show_code}">
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
<!-- The Modal -->
  <div class="modal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">공연수정</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <form class="modal-body form-group" action="showUpdate.do" method="post">
          <label>코드</label><input class="form-control" type="text" id="show_code" readonly="readonly"><br>
          <label>제목</label><input class="form-control" type="text" id="show_name"><br>
          <label>감독</label><input class="form-control" type="text" id="director"><br>
          <label>트레일러</label><input class="form-control" type="text" id="trailer"><br>
          <label>개봉일자</label><input class="form-control" type="date" id="opening_date"><br>
          <label>러닝타임</label><input class="form-control" type="number" id="show_time"><br>
          <label>카테고리</label><input class="form-control" type="text" id="category"><br>
          <label>줄거리</label><input class="form-control" type="text" id="summary"><br>
          <label>포스터</label><input class="form-control" type="text" id="poster"><br>
          <label>가격</label><input class="form-control" type="text" id="price" readonly="readonly"><br>
        </form>
        
        <!-- Modal footer -->
        <form class="modal-footer">
          <input  class="btn btn-primary" type="submit" value="수정하기">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </form>
      </div>
    </div>
  </div>
</body>
</html>