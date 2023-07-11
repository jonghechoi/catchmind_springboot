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
<body>
	<div class="Find">
	<h1>Find ID</h1>
	<div>
		<h3>${findMember.mname} ID information</h3><br>
	</div>
	<div>
		${findMember.memberId}<br>
	</div>
		<button type="button" name="findId" class="btnFind1" id="btnFindPass1">Find Password</button>
	</div>
</body>
</html>