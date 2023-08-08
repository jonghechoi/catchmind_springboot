<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="icon" href="/image/catchcon.png" type="image/png">
	<title>Catch Mind</title>
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="/css/bootstrap.css">
	<link rel="stylesheet" href="/vendors/linericon/style.css">
	<link rel="stylesheet" href="/css/font-awesome.min.css">
	<link rel="stylesheet" href="/vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.css">
	<link rel="stylesheet" href="/vendors/nice-select/css/nice-select.css">
	<link rel="stylesheet" href="/vendors/owl-carousel/owl.carousel.min.css">
	<!-- main css -->
	<link rel="stylesheet" href="/css/style.css">
	<link rel="stylesheet" href="/css/responsive.css">
	<link rel="stylesheet" href="/css/style_jonghe.css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="/js/jquery-3.6.4.min.js"></script>
	<script src="/js/jonghe.js"></script>
	<script>
	   $(function() {
	       $("#datepicker1").datepicker({
	           dateFormat: 'yy-mm-dd' 
		           ,showOtherMonths: true 
		           ,showMonthAfterYear:true 
		           ,changeYear: true 
		           ,changeMonth: true                 
		           ,showOn: "both"   
		           ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif"
		           ,buttonImageOnly: true 
		           ,buttonText: "Choose"               
			           ,yearSuffix: " Year" 
		           ,monthNamesShort: ['January','February','March','April', 'May', 'June','July','August','September','October','November','December'] 
		           ,monthNames: ['January','February','March','April', 'May', 'June','July','August','September','October','November','December'] 
		           ,dayNamesMin: ['Sun','Mon','Tue','Wen','Thu','Fri','Sat'] 
		           ,dayNames: ['Sun','Mon','Tue','Wen','Thu','Fri','Sat'] 
		           ,minDate: "-5Y" 
		           ,maxDate: "+5y"   
	       	   ,onSelect: function(startDate) {
	       		   $("#startDate").val(startDate);
	       	   }
	       });                    
	       
	       $("#datepicker1").datepicker('setDate', 'today');
	   });
	   $(function() {
	       $("#datepicker2").datepicker({
	           dateFormat: 'yy-mm-dd' 
	           ,showOtherMonths: true 
	           ,showMonthAfterYear:true 
	           ,changeYear: true 
	           ,changeMonth: true                 
	           ,showOn: "both"   
	           ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif"
	           ,buttonImageOnly: true 
	           ,buttonText: "Choose"               
	           ,yearSuffix: " Year" 
	           ,monthNamesShort: ['January','February','March','April', 'May', 'June','July','August','September','October','November','December'] 
	           ,monthNames: ['January','February','March','April', 'May', 'June','July','August','September','October','November','December'] 
	           ,dayNamesMin: ['Sun','Mon','Tue','Wen','Thu','Fri','Sat'] 
	           ,dayNames: ['Sun','Mon','Tue','Wen','Thu','Fri','Sat'] 
	           ,minDate: "-5Y" 
	           ,maxDate: "+5y"   
	       	   ,onSelect: function(endDate) {
	       		   $("#endDate").val(endDate);
	       		   reservationListing();
	       	   }
	       });                    
	       
	       $("#datepicker2").datepicker('setDate', 'today');
	   });
	</script>
</head>
	<body>
        <!--================Header Area =================-->
        <header class="header_area">
            <div class="container">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <a class="navbar-brand logo_h" href="/"><img src="/image/catchmind.png" alt=""></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
                        <ul class="nav navbar-nav menu_nav ml-auto">
        				<!--================ 占쏙옙占쏙옙占싹댐옙 占싸븝옙 =================-->                
                            <li class="nav-item active"><a class="nav-link" href="/index">Home</a></li>
                            <li class="nav-item"><a class="nav-link" href="/search">Search</a></li>
                            <li class="nav-item submenu dropdown">
                                <a href="/mydining_scheduled" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">MY DINING</a>
                                <ul class="dropdown-menu">
                                    <li class="nav-item active"><a class="nav-link" href="/mydining_scheduled">Scheduled</a></li>
                                    <li class="nav-item"><a class="nav-link" href="/mydining_visited">Visited</a></li>
                                    <li class="nav-item"><a class="nav-link" href="/mydining_cancel_noshow">Cancel / No-Show</a></li>
                                </ul>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="/mypage">My Page</a></li>
                            <li class="nav-item"><a class="nav-link" href="/notice">Notice</a></li>
                            <c:if test="${sessionScope.sessionVo.roleId =='SHOP' or sessionScope.sessionVo.roleId == 'ADMIN'}">
	                            <li class="nav-item submenu dropdown">
	                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Shop</a>
	                                <ul class="dropdown-menu">
                                        <li class="nav-item active"><a class="nav-link" href="/shop_information">Register</a></li>
                                        <li class="nav-item"><a class="nav-link" href="/shop_reservation">Reservation</a></li>
	                                </ul>
	                            </li>
                            </c:if>     
                            <c:if test="${sessionScope.sessionVo.roleId == 'ADMIN'}">                
                            	<li class="nav-item"><a class="nav-link" href="/admin">Admin</a></li>
                        	</c:if>
                        <!--================ 占쏙옙占쏙옙占싹댐옙 占싸븝옙 =================-->
                        </ul>
                    </div> 
                </nav>
            </div>
        </header>
        <!--================Header Area =================-->
        <!--================Breadcrumb Area =================-->
        <section class="breadcrumb_area">
            <div class="overlay bg-parallax" data-stellar-ratio="0.8" data-stellar-vertical-offset="0" data-background=""></div>
            <div class="container">
                <div class="page-cover text-center">
                    <h2 class="page-cover-tittle">Reservation Status</h2>
                    <ol class="breadcrumb">
                        <li>Check Your Restaurant's Reservation Status</li>
                        <!-- <li class="active"></li> -->
                    </ol>
                </div>
            </div>
        </section>
        <!--================Breadcrumb Area =================-->
        <!--================Reservation Check Area =================-->
		<!-- <section id="s1"> -->
		<div class="container div1 shop-reservation">
			<section class="s1">
				<div class="h3">
					<h3> Restaurant Reservation </h3>
					<input type="hidden" id="shopReservationSid" value="${shopVo.sid}">
				</div>
			</section>
			<!-- <section id="s2"> -->
			<section class="s2">
				<div id="reserveList">
					<div class="restaurantList">
						<div class="restaurantInfo" style="padding-left:60px">
							<span>${shopVo.sname}</span>
							<span>${shopVo.slocshort}</span>
						</div>
						<div class='input-group date reservation'>
							<div>
						        <input type="text" id="datepicker1">
						        <input type="text" id="startDate">
							</div>
							<div>
						        <input type="text" id="datepicker2">
						        <input type="text" id="endDate">
							</div>
						</div>
					</div>
				</div>
				<div id="reserveDetail">
<!-- 					<div>
						<div class="reserveDetail">
							<div>
								<span>Date  :  </span>
								<span>2023/05/07</span>
							</div>
							<div>
								<span>Time  :  </span>
								<span>16:50</span>
							</div>
							<div>
								<span>Name  :  </span>
								<span>korea</span>
							</div>
							<div>
								<span>ID</span>
								<span>sosinnmi</span>

							</div>
							<div>
								<span>CellPhone</span>
								<span>010-1234-1234</span>
							</div>
						</div>
						<div class="confirm">
							<form name="confirmForm" action="#" method="get">
								<button type="button" class="btnConfirm">confirm</button>
								<button type="button" class="btnCancel">cancel</button>
							</form>
						</div>
					</div>
					<hr> -->
				</div>
			</section>
		</div>
        <!--================Reservation Check Area =================-->
        <!--================ start footer Area  =================-->
        <footer class="footer-area section_gap" style="padding:50px 0 0 0; background:rgb(255, 61, 0)">
            <%@ include file="../../footer.jsp" %>
        </footer>
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
        <!--gmaps Js-->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
        <script src="/js/gmaps.min.js"></script>
        <!-- contact js -->
        <script src="/js/jquery.form.js"></script>
        <script src="/js/jquery.validate.min.js"></script>
        <script src="/js/contact.js"></script>
        <script src="/js/custom.js"></script>
        <!-- 占쌨뤄옙 占쏙옙占쏙옙占쏙옙占� 占쌀쏙옙 -->
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	</body>
</html>