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
	<link rel="icon" href="resources/image/catchcon.png" type="image/png">
	<title>Catch Mind</title>
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="resources/css/bootstrap.css">
	<link rel="stylesheet" href="resources/vendors/linericon/style.css">
	<link rel="stylesheet" href="resources/css/font-awesome.min.css">
	<link rel="stylesheet" href="resources/vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.css">
	<link rel="stylesheet" href="resources/vendors/nice-select/css/nice-select.css">
	<link rel="stylesheet" href="resources/vendors/owl-carousel/owl.carousel.min.css">
	<!-- main css -->
	<link rel="stylesheet" href="resources/css/style.css">
	<link rel="stylesheet" href="resources/css/responsive.css">
	<link rel="stylesheet" href="resources/css/style_jonghe.css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="resources/js/jquery-3.6.4.min.js"></script>
	<script src="resources/js/jonghe.js"></script>
	<script>
	   $(function() {
	       //input占쏙옙 datepicker占쏙옙 占쏙옙占쏙옙
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
	       
	       //占십기값占쏙옙 占쏙옙占쏙옙 占쏙옙짜占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占� 占쌌니댐옙.
	       $("#datepicker1").datepicker('setDate', 'today'); //(-1D:占싹뤄옙占쏙옙, -1M:占싼댐옙占쏙옙, -1Y:占싹놂옙占쏙옙), (+1D:占싹뤄옙占쏙옙, -1M:占싼댐옙占쏙옙, -1Y:占싹놂옙占쏙옙)            
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
	       
	       //占십기값占쏙옙 占쏙옙占쏙옙 占쏙옙짜占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占� 占쌌니댐옙.
	       $("#datepicker2").datepicker('setDate', 'today'); //(-1D:占싹뤄옙占쏙옙, -1M:占싼댐옙占쏙옙, -1Y:占싹놂옙占쏙옙), (+1D:占싹뤄옙占쏙옙, -1M:占싼댐옙占쏙옙, -1Y:占싹놂옙占쏙옙)            
	   });
	</script>
      <!--================占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙크占쏙옙트, 占쏙옙타占쏙옙 ================-->
</head>
	<body>
        <!--================Header Area =================-->
        <header class="header_area">
            <div class="container">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <a class="navbar-brand logo_h" href="index.do"><img src="resources/image/catchmind.png" alt=""></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
                        <ul class="nav navbar-nav menu_nav ml-auto">
        				<!--================ 占쏙옙占쏙옙占싹댐옙 占싸븝옙 =================-->                
                            <li class="nav-item active"><a class="nav-link" href="index.do">Home</a></li> 
                            <li class="nav-item"><a class="nav-link" href="search.do">Search</a></li>
                            <li class="nav-item submenu dropdown">
                                <a href="mydining_scheduled.do" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">MY DINING</a>
                                <ul class="dropdown-menu">
                                    <li class="nav-item active"><a class="nav-link" href="mydining_scheduled.do">Scheduled</a></li>
                                    <li class="nav-item"><a class="nav-link" href="mydining_visited.do">Visited</a></li>
                                </ul>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="mypage.do">My Page</a></li>
                            <li class="nav-item"><a class="nav-link" href="notice.do">Notice</a></li>
                            <c:if test="${sessionScope.sessionVo.roleId =='SHOP' or sessionScope.sessionVo.roleId == 'ADMIN'}">
	                            <li class="nav-item submenu dropdown">
	                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Shop</a>
	                                <ul class="dropdown-menu">
	                                    <li class="nav-item active"><a class="nav-link" href="shop_information.do?sid=${sessionScope.sessionVo.sid}">Register</a></li>
	                                    <li class="nav-item"><a class="nav-link" href="shop_reservation.do?sid=${sessionScope.sessionVo.sid}">Reservation</a></li>
	                                </ul>
	                            </li>
                            </c:if>     
                            <c:if test="${sessionScope.sessionVo.roleId == 'ADMIN'}">                
                            	<li class="nav-item"><a class="nav-link" href="admin.do">Admin</a></li>
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
<!--          <footer class="footer-area section_gap" style="padding:50px 0 0 0; background:rgb(255, 61, 0)">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3  col-md-6 col-sm-6 footer-widget1" style="padding-right:50px width:370px">
                        <div class="single-footer-widget single-footer-widget-left">
                            <h6 class="footer_title">About Agency</h6>
                            <p style="color:white">WAD Corp.
                            <br>
							Address: A-605, 660, Daewangpangyo-ro, Bundang-gu, Seongnam-si, Gyeonggi-do, Republic of Korea
							<br>
							Business registration number: 614-88-00597
							<br>
							Online marketing business report number: 2017-Seongnam Bundang-0933
							<br>
							Personal information responsible: service@catchtable.co.kr
							<br>
							Terms of Service | Privacy policy | Terms of Location Service </p>
                        </div>
                    </div>						
                    <div class="col-lg-3 col-md-6 col-sm-6 footer-widget2" style="width:300px">
                        <div class="single-footer-widget">
                            <h6 class="footer_title">Newsletter</h6>
                            <p style="color:white">For business professionals caught between high OEM price and mediocre print and graphic output, </p>		
                            <div id="mc_embed_signup">
                                <form target="_blank" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01" method="get" class="subscribe_form relative">
                                    <div class="input-group d-flex flex-row">
                                        <input name="EMAIL" placeholder="Email Address" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Email Address '" required="" type="email">
                                        <button class="btn sub-btn"><span class="lnr lnr-location"></span></button>		
                                    </div>									
                                    <div class="mt-10 info"></div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-6 footer-widget3"  style="width:300px">
                        <div class="single-footer-widget instafeed">
                            <h6 class="footer_title">InstaFeed</h6>
                            <ul class="list_style instafeed d-flex flex-wrap">
                                <li><img src="resources/image/instagram/Image-01.jpg" alt=""></li>
                                <li><img src="resources/image/instagram/Image-02.jpg" alt=""></li>
                                <li><img src="resources/image/instagram/Image-03.jpg" alt=""></li>
                                <li><img src="resources/image/instagram/Image-04.jpg" alt=""></li>
                                <li><img src="resources/image/instagram/Image-05.jpg" alt=""></li>
                                <li><img src="resources/image/instagram/Image-06.jpg" alt=""></li>
                                <li><img src="resources/image/instagram/Image-07.jpg" alt=""></li>
                                <li><img src="resources/image/instagram/Image-08.jpg" alt=""></li>
                            </ul>
                        </div>
                    </div>						
                </div>
                <div class="border_line"></div>
                <div class="row footer-bottom d-flex justify-content-between align-items-center">
                    <p class="col-lg-8 col-sm-12 footer-text m-0">
                </div>
            </div>
        </footer> -->
		<!--================ End footer Area  =================-->
       <!--================Contact Success and Error message Area =================-->
<!--         <div id="success" class="modal modal-message fade" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <i class="fa fa-close"></i>
                        </button>
                        <h2>Thank you</h2>
                        <p>Your message is successfully sent...</p>
                    </div>
                </div>
            </div>
        </div>
        Modals error
        <div id="error" class="modal modal-message fade" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <i class="fa fa-close"></i>
                        </button>
                        <h2>Sorry !</h2>
                        <p> Something went wrong </p>
                    </div>
                </div>
            </div>
        </div> -->
        <!--================End Contact Success and Error message Area =================-->
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
        <!-- 占쌨뤄옙 占쏙옙占쏙옙占쏙옙占� 占쌀쏙옙 -->
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	</body>
</html>