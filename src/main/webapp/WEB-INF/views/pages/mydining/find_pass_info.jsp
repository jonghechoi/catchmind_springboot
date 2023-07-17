<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>CatchMind</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="icon" href="/image/catchcon.png" type="image/png">
        <script src="/js/jquery-3.6.4.min.js"></script>
        <script src="/js/catchmind_hyeonsoo.js"></script>
        <!-- main css -->
        <link rel="stylesheet" href="/css/style.css">
		<link rel="stylesheet" href="/css/jhsStyle.css">
</head>
<script>
	let pass_update = "${pass_update}"
	
	if(pass_update == "no") {
		alert("Previously used passwords cannot be reused.");
	}
</script>
<body>
	<div class="Find">
		<h1>Reset Password</h1>
		<div>
			<p class="find_Pass3">Password</p>
		</div>
		<form name="findPassUpdateForm" action="find_pass_update" method="post">
			<div>
				<input type="password" name="mpass" class="findText" id="updatePass" placeholder="Password">
			</div>
			<div>
				<p class="find_cPass3">Confirm Password</p>
			</div>
			<div>
				<input type="password" name="cmpass" class="findText" id="updatecPass" placeholder="Confirm Password">
				<input type="hidden" name="mid" value="${findPassInfo.mid}">
				<input type="hidden" name="beforemPass" value="${findPassInfo.beforemPass}">
			</div>
				<button type="button" name="findId" class="btnFind1" id="btnResetPassword">Reset Password</button>
		</form>
	</div>
</body>
</html>