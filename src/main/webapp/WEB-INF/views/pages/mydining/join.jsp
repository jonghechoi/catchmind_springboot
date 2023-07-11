<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CatchMind</title>
<link rel="icon" href="/image/catchcon.png" type="image/png">
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/jhsStyle.css">
<script src="/js/jquery-3.6.4.min.js"></script>
<script src="/js/catchmind_hyeonsoo.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<div class="content">
		<section class="join">
			<h1 class="title" style="margin-left:40px">Sign Up</h1>
			<form name="joinForm" action="join_proc.do" method="post">
				<!-- <div class="joinTypeCheck">
                     <input type="radio" name="joinType" value="user"><span>User</span>
					 <input type="radio" name="joinType" value="owner"><span>Owner</span>
                </div> -->
				<ul>
					<li>
						<label>ID</label>
						<input type="text" name="memberId" 
							placeholder="Please enter at least 6 English characters and numbers" class="input1"
							id="id1">
						<button type="button" class="btn_style2" id="btnIdCheck">Check</button>
						<span id="idCheck_msg1"></span>
						<span id="idCheck_msg"></span>
					</li>
					<li>
						<label>Password</label>
						<input type="password" name="mpass" class="input1" id="pass1" placeholder="8–15 English characters + numbers + special characters">
						<span id="pass_check"></span>
					</li>
					<li>
						<label>Password Check</label>
						<input type="password" name="cpass" class="input1" id="cpass" placeholder="Please enter the same password">
						<span id="cmsg"></span>
					</li>
					<li>
						<label>Name</label>
						<input type="text" name="mname" class="input1" id="name">
					</li>
					<li>
						<label>Email</label>
						<input type="text" name="memail1" class="email" id="email1"> @
						<input type="text" name="memail2" class="email" id="email2">
						<select id="email3">
							<option value="default">Choice</option>
							<option value="naver.com">Naver</option>
							<option value="gmail.com">Google</option>
							<option value="daum.net">Daum</option>
							<option value="self">Self</option>
						</select>
					</li>
					<li>
						<label>Phone</label>
						<input type="radio" name="tel" value="SKT"><span>SKT</span>
						<input type="radio" name="tel" value="LG"><span>LG</span>
						<input type="radio" name="tel" value="KT"><span>KT</span>
						<select name="mphone1" id="phone1">
							<option value="default">Choice</option>
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="017">017</option>
						</select>
						- <input type="text" name="mphone2" id="phone2" maxlength="4">
						- <input type="text" name="mphone3" id="phone3" maxlength="4">
					</li>
					<li>
					<button type="button" class="btn_style" id="btnJoin">Sign Up</button>
					<button type="reset" class="btn_style">Reset</button>
					</li>
				</ul>
			</form>
		</section>
	</div>

</body>
</html>