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
	<script>
		$(document).ready(function() {
		  // 다른 페이지의 URL
/* 		  let url = "member.do";

		  $.get(url, function(data) {
     	    // 다른 페이지의 HTML에서 원하는 요소 가져오기
     	    let spanObjArr = $(data).find(".memberDetail div span:last-child");
     	    $(spanObjArr).each(function(idx, element) {
     	    	let input = ".memberDetail li:nth-child(" + (idx+1) + ") input";
     	    	$(input).val($(element).text());
     	    });
		    // 가져온 값을 현재 페이지의 input 요소에 할당
		  });	 */		
		});
	</script>
</head>
<body>
	<div id="memberDetailModification">
		<div class="memberInfo">
			<h3 style="border-bottom:2px solid lightgray"> Member Information </h3>
			<form name="memberDetailModificationForm" action="member_modify_update.do" method="post">
				<ul class="memberDetail">
					<li>
						<span>M_ID  :  </span>
						<input type="text" name="mid" id="inputName" value="${memberVo.mid}">
					</li>
					<li>
						<span>Name  :  </span>
						<input type="text" name="mname" id="inputName" value="${memberVo.mname}">
					</li>
					<li>
						<span>ID :  </span>
						<input type="text" name="memberId" id="inputId" value="${memberVo.memberId}">
					</li>
					<li>
						<span>E-mail  :  </span>
						<input type="text" name="memail" id="inputEmail" value="${memberVo.memail}">
					</li>
					<li>
						<span>CellPhone  :  </span>
						<input type="text" name="mphone" id="inputPhone" value="${memberVo.mphone}">
					</li>
					<li>
						<button type="button" id="btnMemberModificationUpdate">modification</button>
					</li>
				</ul>
			</form>
		</div>
	</div>
</body>
</html>