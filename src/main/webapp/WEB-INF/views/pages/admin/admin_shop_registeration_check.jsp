<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Catch Mind</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="icon" href="resources/image/catchcon.png" type="image/png">
	<title>Royal Hotel</title>
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="resources/css/bootstrap.css">
	<link rel="stylesheet" href="resources/vendors/linericon/style.css">
	<link rel="stylesheet" href="resources/css/font-awesome.min.css">
	<link rel="stylesheet" href="resources/vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.css">
	<link rel="stylesheet" href="resources/vendors/nice-select/css/nice-select.css">
	<link rel="stylesheet" href="resources/vendors/owl-carousel/owl.carousel.min.css">
	<!-- main css -->
	<link rel="stylesheet" href="resources/css/style.css">
	<!-- <link rel="stylesheet" href="resources/css/responsive.css"> -->
	<!-- <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css"> -->
	<link rel="stylesheet" href="resources/css/style_jonghe.css">
	<!-- <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> -->
	<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
	<script src="resources/js/jquery-3.6.4.min.js"></script>
<!-- 	<script>
	   $(function() {
	       //input을 datepicker로 선언
	       $("#datepicker1,#datepicker2").datepicker({
	           dateFormat: 'yy-mm-dd' //달력 날짜 형태
	           ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
	           ,showMonthAfterYear:true // 월- 년 순서가아닌 년도 - 월 순서
	           ,changeYear: true //option값 년 선택 가능
	           ,changeMonth: true //option값  월 선택 가능                
	           ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
	           ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
	           ,buttonImageOnly: true //버튼 이미지만 깔끔하게 보이게함
	           ,buttonText: "선택" //버튼 호버 텍스트              
	           ,yearSuffix: "년" //달력의 년도 부분 뒤 텍스트
	           ,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 텍스트
	           ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip
	           ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 텍스트
	           ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 Tooltip
	           ,minDate: "-5Y" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
	           ,maxDate: "+5y" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)  
	       });                    
	       
	       //초기값을 오늘 날짜로 설정해줘야 합니다.
	       $("#datepicker1,#datepicker2").datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)            
	   });
	</script> -->
	<script>
		$(document).ready(function() {
			$("#shopRegisterButton").click(function() {
				
			});
		});
	</script>
	<style>
		button#shopRegisterButton {
			display: block;
			margin: auto;
			margin-top: 50px;
			border: none;
			border-radius: 15px;
			width: 500px;
			height: 50px;
			font-size: 15pt;
		}
		button#shopRegisterButton:hover {
			cursor: pointer;
		}
	</style>
</head>
<body>
	<section class="s1">
		<div class="h3">
			<h3> Shop Registeration </h3>
		</div>
	</section>
	<section class="s2">
		<button type="button" id="shopRegisterButton" onclick="location.href='admin_shop_registeration_enter'">Do you want to register a shop?</button>
	</section>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="resources/js/jquery-3.2.1.min.js"></script>
    <script src="resources/js/popper.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/vendors/owl-carousel/owl.carousel.min.js"></script>
    <script src="resources/js/jquery.ajaxchimp.min.js"></script>
    <script src="resources/vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.js"></script>
    <script src="resources/vendors/nice-select/js/jquery.nice-select.js"></script>
    <script src="resources/js/mail-script.js"></script>
    <script src="resources/js/stellar.js"></script>
    <script src="resources/vendors/imagesloaded/imagesloaded.pkgd.min.js"></script>
    <script src="resources/vendors/isotope/isotope-min.js"></script>
    <script src="resources/js/stellar.js"></script>
    <script src="resources/vendors/lightbox/simpleLightbox.min.js"></script>
    <!--gmaps Js-->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
    <script src="resources/js/gmaps.min.js"></script>
    <!-- contact js -->
    <script src="resources/js/jquery.form.js"></script>
    <script src="resources/js/jquery.validate.min.js"></script>
    <script src="resources/js/contact.js"></script>
    <script src="resources/js/custom.js"></script>
	<!-- 달력 사용위한 소스 -->
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</body>
</html>