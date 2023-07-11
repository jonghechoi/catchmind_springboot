<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>ICatch Mind</title>
	<link rel="stylesheet" href="/css/style_jonghe.css">
	<script src="/js/jquery-3.6.4.min.js"></script>
	<script>
		$(document).ready(function() {
			$(".toList").click(function() {
			  window.history.back();
			});
			
			$("#btnNoticeWrite").click(function() {
				var data = $("form[name=writeForm]").serialize() ;
				$.ajax({
					url: "notice_upload",
					method: "POST",
					data: data,
		            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		            dataType: "text",					
					success: function(response) {
		                if (response == 1) {
		                    alert("Notice Upload Success");
		                    window.history.back();
		                } else {
		                    alert("Notice Upload Fail");
		                }						
					}
				})
			});
		});
	</script>
</head>
<body>
	<div class="content">
		<section class="notice_write">
			<h1 class="title">Notice</h1>
			<form name="writeForm" action="#"  method="get">
				<table border=1>
					<tr>
						<th>Title</th>
						<td>
							<input type="text" name="ntitle">
						</td>
					</tr>
					<tr>
						<th>Content</th>
						<td>
							<textarea rows="5" cols="30" name="ncontents"></textarea>
						</td>
					</tr>					
					<tr>
						<td colspan="2">
							<button type="button" id="btnNoticeWrite">Complete</button>
							<button type="reset">Reset</button>
							<button type="button" class="toList">List</button>
						</td>				
					</tr>
				</table>
			</form>
		</section>
	</div>
</body>
</html>