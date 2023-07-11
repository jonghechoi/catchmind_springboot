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
		<script>
		let find_fail = "${find_fail}"
		
		if(find_fail === "no") {
			alert("Member information does not exist.");
		}
		</script>
</head>
<body>
	<div class="Find">
		<h1>Find ID</h1>
		<form name="findIdForm" action="find_id_proc.do" method="post">
			<div>
				<input type="text" name="mname" class="findText" id="findName" placeholder="Name">
			</div>
			<div>
				<div>
					<p class="find_email">Email</p>
				</div>
				<input type="text" name="memail1" class="email22" id="email1"> @
				<input type="text" name="memail2" class="email22" id="email2">
			</div>
			<div class="findText">
				<div>
					<p class="find_phoneNum">PhoneNumber</p>
				</div>
				<select name="mphone1" id="phone1">
					<option value="default">Choice</option>
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="017">017</option>
				</select>
				- <input type="text" name="mphone2" id="phone2" maxlength="4">
				- <input type="text" name="mphone3" id="phone3" maxlength="4">
			</div>
			<button type="button" name="findId" class="btnFind1" id="btnFindId">Find ID</button>
		</form>
	</div>
</body>
</html>