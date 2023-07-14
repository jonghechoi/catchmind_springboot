<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Catch Mind</title>
	<link rel="stylesheet" href="/css/style.css">
	<link rel="stylesheet" href="/css/style_jonghe.css">
	<script src="/js/jquery-3.6.4.min.js"></script>
	<script src="/js/jonghe.js"></script>
</head>
<body>
	<div id="memberDetailModification">
		<div class="memberInfo">
			<div id="memberDetail" style="display:block">
				<div class="memberInfo">
					<h3 style="border-bottom:2px solid lightgray"> Member Information </h3>
					<div class="memberDetail">
						<div>
							<span>M_ID :  </span>
							<span id="memberId">${member.mid}</span>
						</div>
						<div>
							<span>Name  :  </span>
							<span>${member.mname}</span>
						<div>
							<span>ID :  </span>
							<span>${member.memberId}</span>
						</div>
						</div>
						<div>
							<span>E-mail  :  </span>
							<span>${member.memail}</span>
						</div>
						<div>
							<span>CellPhone  :  </span>
							<span>${member.mphone}</span>
						</div>
					</div>
					<div class="memberModification">
						<form name="memberModificationForm" action="#" method="get">
							<button type="button" id="btnMemberModification">modification</button>
						</form>
					</div>
				</div>
		</div>
	</div>
</body>
</html>

