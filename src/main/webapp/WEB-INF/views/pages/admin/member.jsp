<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Catch Mind</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="icon" href="../image/favicon.png" type="image/png">
	<title>CatchMind</title>
	<link rel="stylesheet" href="/css/style.css">
	<link rel="stylesheet" href="/css/style_jonghe.css">
	<!-- <link rel="stylesheet" href="/css/responsive.css"> -->
	<link rel="stylesheet" href="/css/am-pagination.css">
	<script src="/js/jquery-3.6.4.min.js"></script>
	<script src="/js/am-pagination.js"></script>
	<script src="/js/paging_member.js"></script>
</head>
<body>
	<!-- <div id="memberDetail" style="display:none">
	</div> -->
	<div id="memberList" style="display:block">
		<section class="board">
			<h1 class="title member">Member</h1>	
<%-- 			<table id="memberAdmin">
				<tr>
					<th>No</th>
					<th>M_ID</th>
					<th>Name</th>
					<th>ID</th>
					<th>E-mail</th>
					<th>Phone</th>
					<!-- <th>Recent Reservation</th> -->
					<!-- <th>Detail Info</th> -->
					<th></th>
				</tr>
				<c:forEach var="memberVo" items="${list}">
 				<tr>
					<td>${memberVo.rno}</td>
					<td>${memberVo.mid}</td> 
					<td>${memberVo.mname}</td>
					<td>${memberVo.memberid}</td>
					<td>${memberVo.memail}</td>
					<td>${memberVo.mphone}</td>
					<td><button type="button" name="name" id="btnMemberDetail${memberVo.rno}"><a href="member_info.do?mid=${memberVo.mid}">Detail</a></button></td>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="8"><<&nbsp&nbsp&nbsp1&nbsp&nbsp2&nbsp&nbsp3&nbsp&nbsp4&nbsp&nbsp5&nbsp&nbsp&nbsp>></td>
				</tr>
			</table> --%>
		</section>
	</div>
</body>
</html>