<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Catch Mind</title>
	<link rel="stylesheet" href="/css/style_jonghe.css">
	<script src="/js/jquery-3.6.4.min.js"></script>
	<script src="/js/jonghe.js"></script>
</head>
<body>
	<div class="content">
		<section class="notice_update">
			<h1 class="title">Notice</h1>
			<form name="adminNoticeModificationForm" action="/admin_notice_update_proc" method="post">
				<input type="hidden" name="nid" id="titleInputHidden" value="${notice.nid}">
				<table>
					<tr>
						<th>Title</th>
						<td>
							<input type="text" name="ntitle" id="titleInput" value="${notice.ntitle}">
						</td>
					</tr>
					<tr>
						<th>Content</th>
						<td>
							<textarea name="ncontents" id="contentTA">${notice.ncontents}</textarea>
						</td>
					</tr>					
					<tr>
						<td colspan="2">
							<button type="button" id="btnNoticeModificationUpdate">Complete</button>
							<button type="button" class="toPrev">Prev</button>
							<button type="button" class="toList">List</button>
						</td>				
					</tr>
				</table>
			</form>
		</section>
	</div>
</body>
</html>