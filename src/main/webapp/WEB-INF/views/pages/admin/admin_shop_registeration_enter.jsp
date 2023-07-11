<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Catch Mind</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="icon" href="/image/catchcon.png" type="image/png">
	<title>Royal Hotel</title>
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="/css/bootstrap.css">
	<link rel="stylesheet" href="/vendors/linericon/style.css">
	<link rel="stylesheet" href="/css/font-awesome.min.css">
	<link rel="stylesheet" href="/vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.css">
	<link rel="stylesheet" href="/vendors/nice-select/css/nice-select.css">
	<link rel="stylesheet" href="/vendors/owl-carousel/owl.carousel.min.css">
	<!-- main css -->
	<link rel="stylesheet" href="/css/style.css">
	<link rel="stylesheet" href="/css/style_jonghe.css">
	<script src="/js/jquery-3.6.4.min.js"></script>
	<script src="/js/jonghe.js"></script>
</head>
<body>
	<section class="s1">
		<div class="h3">
			<h3> Shop Registeration </h3>
		</div>
	</section>
	<section class="s2">
	<div id="shopRegisteration">
		<div class="shopInfo">
			<form name="shopRegisterationForm" action="#" method="post">
				<ul class=shopDetail>
					<li>
						<span>Shop  :  </span>
						<input type="text" name="sname" id="inputShopName" value="">
					</li>
					<li>
						<span>Phone  :  </span>
						<input type="text" name="sphone" id="inputShopPhone" value="">
					</li>
					<li>
						<span>FoodStyle  :  </span>
						<input type="text" name="sfoodstyle" id="inputShopFoodStyle" value="">
					</li>					
					<li>
						<span>Location  :  </span>
						<input type="text" name="slocshort" id="inputShopLocation" value="">
					</li>					
					<li>
						<span>Address  :  </span>
						<input type="text" name="sloc" id="inputShopAddress" value="">
						<input type="hidden" name="slocx" value="">
						<input type="hidden" name="slocy" value="">
					</li>		
					<li>
						<span>Photo  :  </span>
						<input type="text" name="smphoto" id="inputShopPhoto" value="">
					</li>		
					<li>
						<button type="button" id="btnShopRegisteration">Register</button>
					</li>
				</ul>
			</form>
		</div>
	</div>
	</section>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/popper.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/vendors/owl-carousel/owl.carousel.min.js"></script>
    <script src="/js/jquery.ajaxchimp.min.js"></script>
    <script src="/vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.js"></script>
    <script src="/vendors/nice-select/js/jquery.nice-select.js"></script>
    <script src="/js/mail-script.js"></script>
    <script src="/js/stellar.js"></script>
    <script src="/vendors/imagesloaded/imagesloaded.pkgd.min.js"></script>
    <script src="/vendors/isotope/isotope-min.js"></script>
    <script src="/js/stellar.js"></script>
    <script src="/vendors/lightbox/simpleLightbox.min.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fb222ca455cfb2afe3fb2c4341112dbb&libraries=services"></script>
	<script>
	$(document).ready(function() {
	    document.getElementById("inputShopAddress").addEventListener("click", function(){
	        new daum.Postcode({
	            oncomplete: function(data) { //선택시 입력값 세팅
	                document.getElementById("inputShopAddress").value = data.addressEnglish; // 주소 넣기
	                document.querySelector("input[name=smphoto]").focus(); //상세입력 포커싱
	                
	        	    var geocoder = new kakao.maps.services.Geocoder();

	        	    var callback = function(result, status) {
	        	        if (status === kakao.maps.services.Status.OK) {
	        	        	document.querySelector("input[name=slocx]").value = result[0].x;
	        	        	document.querySelector("input[name=slocy]").value = result[0].y;
	        	        	
	        	        	// 요거 써먹자!!!
	        	        	// var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	        	        	// 결과값으로 받은 위치 마커 표시
	        	        	// var marker = new kakao.maps.Marker({
	        	        	//     map: map,
	        	        	//     position: coords
	        	        	// })
	        	        }
	        	    };

	        	    geocoder.addressSearch(data.address, callback);
	            }
	        }).open();
	    });
	    

	})
	</script>
</body>
</html>