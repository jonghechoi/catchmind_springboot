<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Catch Mind</title>
	<link rel="stylesheet" href="../css/style_jonghe.css">
	<script src="http://localhost:9000/royal-master/jquery-3.6.4.min.js"></script>
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
					<td>09/05/2023 Notice</td>
				</tr>
				<tr>
					<th>Content</th>
					<td>The entire system will be inspected as of May 2023. Please keep in mind.
					</td>
				</tr>
				<tr>
					<th>Hits</th>
					<td>1000</td>
				</tr>
				<tr>
					<th>Reporting<br>Date</th>
					<td>2023-04-18</td>
				</tr>
				<tr>
					<td colspan="2">
						<a href="http://localhost:9000/royal-master/Admin/notice_update.jsp">
							<button type="button">Revise</button></a>
						<a href="http://localhost:9000/royal-master/Admin/notice_delete.jsp">
							<button type="button">Remove</button></a> 
						<button type="button" class="toList">List</button>
					</td>
				</tr>
			</table>
		</section>
	</div>
</body>
</html>