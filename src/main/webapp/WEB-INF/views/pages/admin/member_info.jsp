<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Catch Mind</title>
	<link rel="stylesheet" href="resources/css/style.css">
	<link rel="stylesheet" href="resources/css/style_jonghe.css">
	<script src="resources/js/jquery-3.6.4.min.js"></script>
	<script src="resources/js/jonghe.js"></script>
	<script>
		$(document).ready(function() {
			
/* 		  $("#btnMemberModification").click(function() {
	   		const popup = window.open('member_modify.do', 'Member Modification', 'width=700px,height=700px,scrollbars=yes');
		  }); */
		  
		  // 다른 페이지의 URL
		  /* let url = "member.do";
		  $.get(url, function(data) {
     	    // 다른 페이지의 HTML에서 원하는 요소 가져오기
     	    let spanObjArr = $(data).find(".memberDetail div span:last-child");
     	    $(spanObjArr).each(function(idx, element) {
     	    	let input = ".memberDetail li:nth-child(" + (idx+1) + ") input";
     	    	$(input).val($(element).text());
     	    });
		    // 가져온 값을 현재 페이지의 input 요소에 할당
		  }) ;*/			
		});
	</script>
</head>
<body>
	<div id="memberDetailModification">
		<div class="memberInfo">
<!-- 			<h3 style="border-bottom:2px solid lightgray"> Member Information </h3> -->
			<div id="memberDetail" style="display:block">
				<div class="memberInfo">
					<h3 style="border-bottom:2px solid lightgray"> Member Information </h3>
					<!-- <div class="reserveDetail"> -->
					<div class="memberDetail">
						<div>
							<span>M_ID :  </span>
							<span id="memberId">${memberVo.mid}</span>
						</div>
						<div>
							<span>Name  :  </span>
							<span>${memberVo.mname}</span>
						<div>
							<span>ID :  </span>
							<span>${memberVo.memberId}</span>
						</div>
						</div>
						<div>
							<span>E-mail  :  </span>
							<span>${memberVo.memail}</span>
						</div>
						<div>
							<span>CellPhone  :  </span>
							<span>${memberVo.mphone}</span>
						</div>
					</div>
					<div class="memberModification">
						<form name="memberModificationForm" action="#" method="get">
							<button type="button" id="btnMemberModification">modification</button>
						</form>
					</div>
				</div>
			<!-- </div> -->
		</div>
	</div>
</body>
</html>

