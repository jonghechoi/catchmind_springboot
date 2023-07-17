<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.google.gson.JsonObject" %>
<%@ page import="com.google.gson.Gson" %>    
<%
//    String reviewJson = (String) request.getAttribute("reviewJson");
//    JsonObject reviewObj = new Gson().fromJson(reviewJson, JsonObject.class);
//    String rid = reviewObj.get("rid").toString();
//
//    Boolean goMain = (Boolean)request.getAttribute("goMain");
%>
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
			document.getElementById("inputRno").value = "${reviewJson.rno}";
			document.getElementById("inputreviewid").value = "${reviewJson.reviewid}";
			document.getElementById("inputmid").value = "${reviewJson.mid}";
			document.getElementById("inputmemberName").value = "${reviewJson.mname}";
			document.getElementById("inputsid").value = "${reviewJson.sid}";
			document.getElementById("inputReviewcontent").value =  "${reviewJson.reviewcontent}";
			document.getElementById("inputReviewcreatedate").value = "${reviewJson.reviewcreatedate}";
			document.getElementById("inputReviewmodifydate").value = "${reviewJson.reviewmodifydate}";
			document.getElementById("inputReviewstar").value = "${reviewJson.reviewstar}";
			document.getElementById("shopPhoto").src = "/upload/" + "${reviewJson.reviewphoto}";

			var reviewRidStr = "${reviewJson.rid}";
			var reviewRid = "${reviewJson.rid}";
			
			if(${goMain}) {
				var btnUpdateId = 'btnReviewMainUpdate_' + reviewRid;
				btnReviewMainUpdate.setAttribute("id", btnUpdateId);
				
				document.getElementById(btnUpdateId).addEventListener("click", function() {
					$.ajax({
						url: "/admin_review_detail_data/" + reviewRidStr,
						success: function(result) {
							if(result == 1) {
								alert("Success Upload to Main.")
								window.open("/admin_review_selected", 'Review For Main', 'width=905px,height=800px, scrollbars=yes');
							}else {
								alert("Fail Upload to Main.")
							}
						}
					})
				});
			}else {
				var btnDeleteId = 'btnReviewMainDelete_' + reviewRid;
				btnReviewMainDelete.setAttribute("id", btnDeleteId);
				
				document.getElementById(btnDeleteId).addEventListener("click", function() {
					$.ajax({
						url: "/admin_review_detail_delete_data/" + reviewRidStr,
						success: function(result) {
							if(result == 1) {
								alert("Success Review Delete From Main");
								window.open("/admin_review_selected", 'Review For Main', 'width=905px,height=800px, scrollbars=yes');
							}else {
								alert("Fail to Delete Review From Main");
								window.open("/admin_review_selected", 'Review For Main', 'width=905px,height=800px, scrollbars=yes');
							}
						}
					})
				});
			}
		});
	</script>
</head>
<body>
	<div id="memberDetailModification">
		<div class="memberInfo">
			<h3 style="border-bottom:2px solid lightgray"> Review Detail </h3>
			<form name="memberDetailModificationForm" action="member_modify_update" method="post">
				<ul class="memberDetail">
					<li>
						<span>No  :  </span>
						<input type="text" name="rno" id="inputRno" value="" disabled>
					</li>
 					<li>
						<span>ReviewID  :  </span>
						<input type="text" name="reviewid" id="inputreviewid" value="" disabled>
					</li>
					<li>
						<span>MID :  </span>
						<input type="text" name="mid" id="inputmid" value="" disabled>
					</li>
					<li>
						<span>MName :  </span>
						<input type="text" name="memberName" id="inputmemberName" value="" disabled>
					</li>
					<li>
						<span>Shop  :  </span>
						<input type="text" name="sid" id="inputsid" value="" disabled>
					</li>
					<li>
						<span>Review  :  </span>
						<textarea rows="10" cols="29" name="sintro" id="inputReviewcontent" disabled></textarea>
					</li>
					<li>
						<span>Date  :  </span>
						<input type="text" name="reviewcreatedate" id="inputReviewcreatedate" value="" disabled>
					</li>
					<li>
						<span>MDate  :  </span>
						<input type="text" name="reviewmodifydate" id="inputReviewmodifydate" value="" disabled>
					</li>
					<li>
						<span>Star  :  </span>
						<input type="text" name="reviewstar" id="inputReviewstar" value="" disabled>
					</li>
					<li>
						<span>Photo  :  </span>
						<img src="" id="shopPhoto" style="width:219px; height:219px;">
					</li>
					<li>
					<c:choose>
						<c:when test="${goMain}">
							<button type="button" id="btnReviewMainUpdate">Go Main!</button>
						</c:when>
						<c:otherwise>
							<button type="button" id="btnReviewMainDelete">Delete From Main!</button>
						</c:otherwise>
					</c:choose>
					</li>
				</ul>
			</form>
		</div>
	</div>
</body>
</html>