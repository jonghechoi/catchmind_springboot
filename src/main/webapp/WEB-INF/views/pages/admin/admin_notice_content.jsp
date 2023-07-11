<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Catch Mind</title>
	<link rel="stylesheet" href="resources/css/style_jonghe.css">
	<script src="resources/js/jquery-3.6.4.min.js"></script>
	<script>
		$(document).ready(function() {
			$(".toList").click(function() {
			    window.history.back();
			});
		});
	</script>
</head>
<body>
	<div class="content">
		<section class="notice_content1">
			<h1 class="title">Notice</h1>
			<table class="notice_content2">
				<tr>
					<th>Title</th>
					<td>${noticeDto.ntitle}</td>
				</tr>
				<tr>
					<th>Content</th>
					<td>${noticeDto.ncontents}
					</td>
				</tr>
				<tr>
					<th>Hits</th>
					<td>${noticeDto.nhits}</td>
				</tr>
				<tr>
					<th>Reporting<br>Date</th>
					<td>${noticeDto.ncreatedate}</td>
				</tr>
				<tr>
					<td colspan="2">
						<a href="notice_update.do?nid=${noticeDto.nid}">
							<button type="button">Revise</button></a>
						<a href="notice_delete.do?nid=${noticeDto.nid}">
							<button type="button">Remove</button></a> 
						<button type="button" class="toList">List</button>
					</td>
				</tr>
			</table>
		</section>
	</div>
</body>
</html>