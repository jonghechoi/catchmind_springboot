<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
	<link rel="stylesheet" href="resources/css/style.css">
	<link rel="stylesheet" href="resources/css/style_jonghe.css">
	<script src="resources/js/jquery-3.6.4.min.js"></script>
	<script>
		$(document).ready(function() {
			const FacilityVo = '${FacilityVo}';
			if('${FacilityVo.parkingdesc}' != null && '${FacilityVo.parkingdesc}'.length != 0) {
				const facilityDesc = document.querySelector('#parkingdesc');
				facilityDesc.value = '${FacilityVo.parkingdesc}'; 
			}
			if('${FacilityVo.valetdesc}' != null && '${FacilityVo.valetdesc}'.length != 0) {
				const facilityDesc = document.querySelector('#valetdesc');
				facilityDesc.value = '${FacilityVo.valetdesc}'; 
			}
			if('${FacilityVo.corkagedesc}' != null && '${FacilityVo.corkagedesc}'.length != 0) {
				const facilityDesc = document.querySelector('#corkagedesc');
				facilityDesc.value = '${FacilityVo.corkagedesc}'; 
			}
			if('${FacilityVo.adultonlydesc}' != null && '${FacilityVo.adultonlydesc}'.length != 0) {
				const facilityDesc = document.querySelector('#adultonlydesc');
				facilityDesc.value = '${FacilityVo.adultonlydesc}'; 
			}
			if('${FacilityVo.sommelierdesc}' != null && '${FacilityVo.sommelierdesc}'.length != 0) {
				const facilityDesc = document.querySelector('#sommelierdesc');
				facilityDesc.value = '${FacilityVo.sommelierdesc}'; 
			}
			if('${FacilityVo.letteringdesc}' != null && '${FacilityVo.letteringdesc}'.length != 0) {
				const facilityDesc = document.querySelector('#letteringdesc');
				facilityDesc.value = '${FacilityVo.letteringdesc}'; 
			}
			if('${FacilityVo.rentalsdesc}' != null && '${FacilityVo.rentalsdesc}'.length != 0) {
				const facilityDesc = document.querySelector('#rentalsdesc');
				facilityDesc.value = '${FacilityVo.rentalsdesc}'; 
			}
		});
	</script>
</head>
<body>
	<div id="shopFacilityDetailUpdate">
		<div class="memberInfo">
			<h3 style="border-bottom:2px solid lightgray"> Facility Detail Information </h3>
			<form name="shopFacilityDetailUpdateForm" action="member_modify_update" method="post">
				<ul class="memberDetail">
					<li>
						<span>Parking  </span>
						<textarea rows="4" cols="50" name="parkingdesc" id="parkingdesc"></textarea>
					</li>
					<li>
						<span>Valet  </span>
						<textarea rows="4" cols="50" name="valetdesc" id="valetdesc"></textarea>
					</li>
					<li>
						<span>Corkage  </span>
						<textarea rows="4" cols="50" name="corkagedesc" id="corkagedesc"></textarea>
					</li>
					<li>
						<span>AdultOnly  </span>
						<textarea rows="4" cols="50" name="adultonlydesc" id="adultonlydesc"></textarea>
					</li>
					<li>
						<span>Sommelier  </span>
						<textarea rows="4" cols="50" name="sommelierdesc" id="sommelierdesc"></textarea>
					</li>
					<li>
						<span>Lettering  </span>
						<textarea rows="4" cols="50" name="letteringdesc" id="letteringdesc" style="margin-left: 124px; width: auto"></textarea>
					</li>
					<li>
						<span>Rentals  </span>
						<textarea rows="4" cols="50" name="rentalsdesc" id="rentalsdesc"></textarea>
					</li>
					<li>
						<button type="button" id="btnShopFacilityDetailUpdate" style="margin-left:396px">Complete</button>
					</li>
				</ul>
			</form>
		</div>
	</div>
	<script src="resources/js/jonghe.js"></script>
</body>
</html>