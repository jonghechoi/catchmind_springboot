<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Catch Minde</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css">
	<link rel="stylesheet" href="resources/vendors/linericon/style.css">
	<link rel="stylesheet" href="resources/vendors/nice-select/css/nice-select.css">
	<link rel="stylesheet" href="resources/css/style.css">
	<link rel="stylesheet" href="resources/css/style_jonghe.css">
	<script src="resources/js/jquery-3.2.1.min.js"></script>
	<script src="resources/js/jonghe.js"></script>
	<link rel="stylesheet" href="resources/css/am-pagination.css">
	<script src="resources/js/am-pagination.js"></script>
	<script>
		function adminReviewDatail(rid) {
			$(document).on("click", "#btnReviewMainDetail_" + rid, function() {
				window.open("admin_review_detail?goMain=false&rid=" + rid, 'Review Detail', 'width=700px,height=900px, scrollbars=yes');
			});		
		}			
	</script>
</head>
<body>
	<section class="review s1">
		<div class="h3">
			<h3> Review </h3>
		</div>
	</section>
	<section class="review s2">
 		<table id="reviewAdmin">
			<tr>
				<th>No</th>
				<th>Name</th>
				<th>Restaurant</th>
				<th>Riview</th>
				<th>Star</th>
				<th>Date</th>
				<th></th>
			</tr>
 			<c:forEach var="ReviewVo" items="${reviewVo}">
				<tr>
					<td>${ReviewVo.rno}</td>
					<td>${ReviewVo.mname}</td> 
					<td>${ReviewVo.sid}</td>
					<td>${ReviewVo.reviewcontent}</td>
					<td>${ReviewVo.reviewstar}</td>
					<td>${ReviewVo.reviewcreatedate}</td>
					<td><button type="button" name="name" id="btnReviewMainDetail_${ReviewVo.rid}" onclick="adminReviewDatail('${ReviewVo.rid}')">Detail</button></td>
				</tr>
			</c:forEach>	
	 	 	<tr>
			</tr>
		</table>
	</section>
</body>
</html>