<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>Find ID</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <script src="http://localhost:9000/catch_royal/js/jquery-3.6.4.min.js"></script>
        <script src="http://localhost:9000/catch_royal/js/catch.js"></script>
        <link rel="icon" href="image/favicon.png" type="image/png">
        <!-- main css -->
        <link rel="stylesheet"; href="http://localhost:9000/catch_royal/css/style.css">
		<link rel="stylesheet"; href="http://localhost:9000/catch_royal/css/jhsStyle.css">
</head>
<body>
	<div class="Find">
		<h1>Find ID</h1>
		<form name="findForm" action="#" method="get">
			<div>
				<input type="text" name="name" class="findText" placeholder="Name">
			</div>
			<div class="fintText">
				<input type="text" name="phone" class="findText" placeholder="Phone Number(with out -)">
				<br>
				<button type="button" class="btnRequest">Request</button>
			</div>
			<div>
				<input type="text" name="request" class="findText" placeholder="Request Number">
			</div>
			<button type="button" name="findId" class="btnFind">Find ID</button>
		</form>
	</div>
</body>
</html>