<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>Find Pass</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
       <script src="/js/jquery-3.6.4.min.js"></script>
        <script src="/js/catchmind_hyeonsoo.js"></script>
        <!-- main css -->
        <link rel="stylesheet" href="/css/style.css">
		<link rel="stylesheet" href="/css/jhsStyle.css">
		<script>
		let find_fail = "${find_fail}"
			
		if(find_fail === "no") {
			alert("Member information does not exist.");
		}
		</script>
</head>
<body>
	<div class="Find">
		<h1>Find Password</h1>
		<form name="findPassForm" action="find_pass" method="post">
			<div>
				<input type="text" name="memberId" class="findText" id="textId" placeholder="ID">
			</div>
			<div>
				<div>
					<p class="find_email">Email</p>
				</div>
				<input type="text" name="memail1" class="email22" id="email1"> @
				<input type="text" name="memail2" class="email22" id="email2">
			</div>
				<button type="button" class="btnRequest" id="btnRequest">Request</button>
			<div>
				<input type="text" name="request" class="findText" id="find_request" placeholder="Request Number">
			<div>
				<span id="mail-check-warn"></span>
			</div>
			</div>
			<button type="button" name="findPass" class="btnFind1" id="btnFindPass_p">FindPassword</button>
		</form>
	</div>
</body>
</html>