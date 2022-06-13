<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공연/영화 관리</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="css/admin.css">
<style type="text/css">
.nav_menu_2 a {
	font-weight: bold;
	color: red;
}
</style>
<script>
	$(function() {
		$(".btnM").click(function() {
			$("#myModal").modal();
		});

		$(".btnUpd").click(function() {
			var show_code = $(this).attr("data-showcode");
			$("#show_code").val(show_code);
			$.ajax({
				url : "showUpdate.do", //어디로
				data : {
					"show_code" : show_code
				}, //가져갈 data{key,value}
				type : "get",
				//datatype : "json",
				success : function(responseData) {
					//alert("서버에 다녀옴 : "+ responseData);
					var show = JSON.parse(responseData);
					//console.dir(show);
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
			if (confirm(show_code + " 삭제?")) {
				$.ajax({
					url : "showDeleteCheck.do",
					data : {
						"show_code" : show_code
					},
					type : "get",
					success : function(responseData) {
						if (responseData == 0) {
							$.ajax({
								url : "showDelete.do",
								data : {
									"show_code" : show_code
								},
								type : "get",
								success : function() {
									alert("[" + show_code + "]" + "삭제되었습니다.");
									location.reload();
								},
								fail : {}
							});
						} else {
							alert("삭제불가");
						}
					},
					fail : function() {
						alert("fail");
					}
				});//location.href = "showDeleteCheck.do?show_code=" + show_code;
			}//location.href = "showDelete.do?show_code=" + show_code;
		});
	});
</script>
</head>
<body>
	<jsp:include page="adminHeader.jsp" />
	<div>
		<div>
			<div id="listTitle">
				<h1>공연/영화 목록</h1>
			</div>
			<div id="listButton">
				<button class="btnAdd btn btn-warning"
					onclick="location.href='showInsert.do'">영화/공연 등록</button>
				<!-- <a href="scheduleInsert.do">스케줄 추가</a> -->
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-auto">
				<table class="table table-responsive">
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
							<td><input type="button" value="수정"
								class="btnUpd btn btn-info" data-toggle="modal"
								data-target="#myModal" data-showcode="${show.show_code}">
								<input type="button" value="삭제" class="btnDel btn btn-dark"
								data-showcode="${show.show_code}"></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
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
				<form class="modalForm modal-body form-group" action="showUpdate.do"
					method="post" enctype="multipart/form-data">
					<label>코드</label><input class="form-control" type="text"
						id="show_code" name="show_code" readonly="readonly"><br>
					<label>제목</label><input class="form-control" type="text"
						id="show_name" name="show_name"><br> <label>감독</label><input
						class="form-control" type="text" id="director" name="director"><br>
					<label>트레일러</label><input class="form-control" type="text"
						id="trailer" name="trailer"><br> <label>개봉일자</label><input
						class="form-control" type="date" id="opening_date"
						name="opening_date"><br> <label>러닝타임</label> <input
						class="form-control" type="number" id="show_time" name="show_time"><br>
					<label>카테고리</label> <select class="form-control" name="category"
						id="category" onchange="OnChange()">
						<option value="영화">영화</option>
						<option value="공연">공연</option>
					</select><br> <label>줄거리</label><input class="form-control" type="text"
						id="summary" name="summary"><br> 
						
				<label>포스터</label> 
				<input class="form-control" type="text" id="poster" name="poster" readonly="readonly">
					<div class="custom-file form-control">
						<input type="file" class="custom-file-input" id="customFile"
							name="file"> <label class="custom-file-label"
							for="customFile">Choose file</label>
					</div>
					<br> <label>가격</label><input class="form-control" type="text"
						id="price" name="price" readonly="readonly"><br>

					<!-- Modal footer -->
					<div class="modal-footer">
						<input class="btn btn-primary" type="submit" value="수정하기">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script>
		function OnChange() {
			var option = document.getElementById("category").options[document
					.getElementById("category").selectedIndex].value;
			//alert(option);
			if (option == "영화") {
				document.getElementById("price").value = 12000;
			} else {
				document.getElementById("price").value = 100000;
			}
		}
		$(".custom-file-input").on(
				"change",
				function() {
					var fileName = $(this).val().split("\\").pop();
					$(this).siblings(".custom-file-label").addClass("selected")
							.html(fileName);
				});
	</script>
</body>
</html>