<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예매확인</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="../css/common.css">
<script>
	$(function() {
		//상세모달 .DetailBtn
		$(".DetailBtn").click(function() {
			var reservation_num = $(this).attr("data-reservationnum");
			$(".reservation_num").val(reservation_num);
			$(".seatBtn").attr("data-modalreservation", reservation_num);
			$.ajax({
				url : "../mypage/confirmdetail.do", //어디로
				data : {
					"reservation_num" : reservation_num
				}, //가져갈 data{key,value}
				type : "get",
				//datatype : "json",
				success : function(responseData) {
					//alert("서버에 다녀옴 : "+ responseData);
					var detail = JSON.parse(responseData);
					//console.dir(show);
					$(".place_name").val(detail["place_name"]);
					$(".theater_num").val(detail["theater_num"]);
					$(".theater_type").val(detail["theater_type"]);
					$(".price").val(detail["price"]);
					$(".payment").val(detail["payment"]);
					$(".total_price").val(detail["total_price"]);
				}
			}); //location.href = "showUpdate.do?show_code=" + show_code;
		});
		//자리확인 모달
		$(".seatBtn").click(function() {
			var reservation_num = $(this).attr("data-modalreservation");
			//alert(reservation_num);
			$("#reservation_num").val(reservation_num);
			$.ajax({
				url : "../mypage/confirmSeat.do", //어디로
				data : {
					"reservation_num" : reservation_num
				}, //가져갈 data{key,value}
				type : "get",
				//datatype : "json",
				success : function(responseData) {
					$("#here").html(responseData);

				}
			}); //location.href = "showUpdate.do?show_code=" + show_code;

		});

		//삭제
		$(".DelBtn").click(function() {
			var category = $(this).attr("data-category");
			var reservation_num = $(this).attr(
					"data-reservationnum");
			//alert(category);
			//alert(reservation_num);
			if (confirm(reservation_num + "번 예매를 취소하시겠습니까?")) {
				if (category == "공연") {
					$.ajax({
						url : "../mypage/confirmDeleteShowCheck.do",
						data : {"reservation_num" : reservation_num},
						type : "get",
						success : function(responseData) {
							if (responseData >= 1) {
								$.ajax({
									url : "../mypage/confirmDelete.do",
									data : {"reservation_num" : reservation_num},
									type : "get",
									success : function(message) {
										//alert(message);
										if (message >= 1) {
											alert("["+ reservation_num+ "]"+ "삭제되었습니다.");
											location.reload();
										} else {
											alert("이미 취소된 좌석입니다.");
											location.reload();
										}
									},
									fail : {}
								});
							} else {alert("공연취소는 하루전까지만 가능합니다.");}
						}
					});
				} else{
					$.ajax({
						url : "../mypage/confirmDeleteMovieCheck.do",
						data : {"reservation_num" : reservation_num},
						type : "get",
						success : function(responseData) {
							if (responseData >= 1) {
								$.ajax({
									url : "../mypage/confirmDelete.do",
									data : {"reservation_num" : reservation_num},
									type : "get",
									success : function(message) {
										//alert(message)
										if (message >= 1) {
											alert("["+ reservation_num+ "]"+ "삭제되었습니다.");
											location.reload();
										} else {
											alert("이미 취소된 좌석입니다.");
											location.reload();
											}
									},
									fail : {}
								});
							} else {alert("영화취소는 30분전까지만 가능합니다.");}
						}
					});
				}
			}
		});
	});
</script>
<style>
.reservation a {
	font-weight: bold;
	color:red;
}

</style>

</head>
<body>
	<!-- header -->
	<jsp:include page="../jayoung/header.jsp" />
	<div class="contents">
		<jsp:include page="../jaeyong/mySide.jsp"/>
			<div>
				<div id="listTitle">
					<h2>MY RESERVATION</h2>
				</div>
				<div>
					<p>- 예매 취소의 경우 영화는 상영시간 기준 30분 전 까지, 공연은 하루 전 까지만 가능합니다. </p>
					<p>- 리뷰는 관람일 다음날 부터 작성 가능합니다. </p>
				</div>
				<!-- 취소목록 -->
			</div>
			<div class="row justify-content-center">
				<div class="col-auto">
					<table class="table table-responsive">
						<tr>
							<td>예매번호</td>
							<td>예매일자</td>
							<td>show제목</td>
							<td>관람일</td>
							<td>시작시간</td>
							<td>카테고리</td>
							<td>상태</td>
							<td>상세보기</td>
							<td>리뷰</td>
							<td></td>
						</tr>
						<c:forEach items="${resevationlist}" var="resevation">
							<!-- var : DTO -->
						<tr>
							<td>${resevation.reservation_num}</td>
							<td>${resevation.reservation_date }</td>
							<td>${resevation.show_name }</td>
							<td>${resevation.show_start_date }</td>
							<td>${resevation.show_start_time }</td>
							<td>${resevation.category }</td>
							<c:choose>
								<c:when test="${resevation.pay_yn eq '예매완료'}">
									<td style="color: red;">${resevation.pay_yn}</td>
								</c:when>
								<c:when test="${resevation.pay_yn eq '관람완료'}">
									<td style="color: blue;">${resevation.pay_yn}</td>
								</c:when>
								<c:when test="${resevation.pay_yn eq '예매취소'}">
									<td style="">${resevation.pay_yn}</td>
								</c:when>
							</c:choose>
								<!-- onclick, data-showcode, data-mid -->
							<td>
								<c:if test="${!empty resevation.detail}">
									<c:choose>
										<c:when test="${resevation.pay_yn eq '예매취소'}">
											<button class="DetailBtn btn btn-light"
												data-reservationnum="${resevation.reservation_num}"
												data-toggle="modal" data-target="#myModalCancel">상세</button>
										</c:when>
										<c:otherwise>
											<button class="DetailBtn btn btn-secondary"
												data-reservationnum="${resevation.reservation_num}"
												data-toggle="modal" data-target="#myModal">상세</button>
										</c:otherwise>
									</c:choose>
								</c:if>
							</td>
							<td>
								<c:if test="${!empty resevation.review}">
									<button class="reviewBtn btn btn-info"
										onclick="location.href='../jayoung/insertReview.do?reservation_num=${resevation.reservation_num}'"
										data-showcode="${resevation.reservation_num}"
										data-mid="${resevation.m_id}">리뷰</button>
								</c:if>
							</td>
							<td>
								<c:if test="${!empty resevation.cancel_yn}">
									<button class="DelBtn btn btn-dark"
										data-reservationnum="${resevation.reservation_num}"
										data-category="${resevation.category}">삭제</button>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	
		<!-- The Modal  -->
		<div class="modal" id="myModal" style="display: none; z-index: 1050;">
			<div class="modal-dialog">
				<div class="modal-content">
	
					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">예매 상세 내역</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
	
					<!-- Modal body -->
					<form class="modalForm modal-body form-group">
						<label>예매번호</label> <input class="form-control reservation_num"
							type="text" readonly="readonly"><br> <label>극장</label>
						<input class="form-control place_name" type="text"
							readonly="readonly"><br> <label>상영관</label> <input
							class="form-control theater_num" type="text" 
							readonly="readonly"><br> <label>type</label> <input
							class="form-control theater_type" type="text" 
							readonly="readonly"><br> <label>가격</label> <input
							class="form-control price" type="text" readonly="readonly"><br>
						<label>결제방법</label> <input class="form-control payment" type="text"
							readonly="readonly"><br> <label>결제금액</label>
						<input class="form-control total_price" type="text"
							readonly="readonly"><br> <label>자리확인</label> <input
							class="seatBtn btn-primary" type="button" data-toggle="modal"
							data-target="#myModal2" data-modalreservation="" value="확인"><br>
						<!-- Modal footer -->
						<div class="modal-footer">
							<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- The Modal (Cancel) -->
		<div class="modal" id="myModalCancel"
			style="display: none; z-index: 1050;">
			<div class="modal-dialog">
				<div class="modal-content">
	
					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">취소 내역</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
	
					<!-- Modal body -->
					<form class="modalForm modal-body form-group">
						<label>예매번호</label> <input class="form-control reservation_num"
							type="text" readonly="readonly"><br> <label>극장</label>
						<input class="form-control place_name" type="text"
							readonly="readonly"><br> <label>상영관</label> <input
							class="form-control theater_num" type="text"
							readonly="readonly"><br> <label>type</label> <input
							class="form-control theater_type" type="text"
							readonly="readonly"><br> <label>가격</label> <input
							class="form-control price" type="text" readonly="readonly"><br>
						<label>결제방법</label> <input class="form-control payment" type="text"
							readonly="readonly"><br> <label>결제금액</label>
						<input class="form-control total_price" type="text"
							readonly="readonly"><br>
						<!-- Modal footer -->
						<div class="modal-footer">
							<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- The Modal(Seat) -->
		<div class="modal" id="myModal2" style="display: none; z-index: 1060;">
			<div class="modal-dialog">
				<div class="modal-content">
	
					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">자리확인</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
	
					<div id="here"></div>
				</div>
			</div>
		</div>
		<%-- <jsp:include page="mainUpTicket.jsp" /> --%>
</body>
</html>