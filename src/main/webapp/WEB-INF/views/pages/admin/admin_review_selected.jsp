<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Catch Minde</title>
	<link rel="stylesheet" href="/css/bootstrap.css">
	<link rel="stylesheet" href="/vendors/linericon/style.css">
	<link rel="stylesheet" href="/vendors/nice-select/css/nice-select.css">
	<link rel="stylesheet" href="/css/style.css">
	<link rel="stylesheet" href="/css/style_jonghe.css">
	<script src="/js/jquery-3.2.1.min.js"></script>
	<script src="/js/jonghe.js"></script>
	<link rel="stylesheet" href="/css/am-pagination.css">
	<script src="/js/am-pagination.js"></script>
	<script>
		function adminReviewDatail(rid) {
			$(document).on("click", "#btnReviewMainDetail_" + rid, function() {
				window.open("/admin_review_detail/false/" + rid, 'Review Detail', 'width=700px,height=900px, scrollbars=yes');
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
 			<c:forEach var="ReviewDto" items="${review}">
				<tr>
					<td>${ReviewDto.rno}</td>
					<td>${ReviewDto.mname}</td>
					<td>${ReviewDto.sid}</td>
					<td>${ReviewDto.reviewcontent}</td>
					<td>${ReviewDto.reviewstar}</td>
					<td>${ReviewDto.reviewcreatedate}</td>
					<td><button type="button" name="name" id="btnReviewMainDetail_${ReviewDto.rid}" onclick="adminReviewDatail('${ReviewDto.rid}')">Detail</button></td>
				</tr>
			</c:forEach>	
	 	 	<tr>
			</tr>
		</table>
	</section>
</body>
</html>