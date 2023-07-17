<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" href="/image/catchcon.png" type="image/png">
		<title>Catch Mind</title>
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="/css/bootstrap.css">
		<link rel="stylesheet" href="/vendors/linericon/style.css">
		<link rel="stylesheet" href="/css/font-awesome.min.css">
		<link rel="stylesheet" href="/vendors/bootstrap-datepicker/bootstrap-datepicker3.css">
		<link rel="stylesheet" href="/vendors/nice-select/css/nice-select.css">
		<link rel="stylesheet" href="/vendors/owl-carousel/owl.carousel.min.css">
		<!-- main css -->
		<link rel="stylesheet" href="/css/style.css">
		<link rel="stylesheet" href="/css/style_dayoung.css">
		<link rel="stylesheet" href="/css/responsive.css">
		<!-- <script src="js/jquery-3.2.1.min.js"></script> -->	
		<script src="/js/popper.js"></script>
		<script src="/js/bootstrap.min.js"></script>
		<script src="/js/jquery-3.6.4.min.js"></script>
		<script src="/vendors/bootstrap-datepicker/bootstrap-datepicker.js"></script>
		<script src="https://www.jqueryscript.net/demo/Mobile-friendly-Custom-Scrollbar-Plugin-With-jQuery-NiceScroll/js/jquery.nicescroll.min.js"></script>
    	<!-- <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script> -->
    	<!-- iamport.payment.js -->
	    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
	    <script src="/js/catchmind_dayoung.js"></script>
    </head>
    <body>
        <!--================Header Area =================-->
        <header class="header_area">
            <div class="container">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <a class="navbar-brand logo_h" href="index"><img src="/image/catchmind.png" alt=""></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
                        <ul class="nav navbar-nav menu_nav ml-auto">
                            <li class="nav-item active"><a class="nav-link" href="index">Home</a></li>
                            <li class="nav-item"><a class="nav-link" href="search">Search</a></li>
                            <li class="nav-item submenu dropdown">
                                <a href="mydining_scheduled" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">MY DINING</a>
                                <ul class="dropdown-menu">
                                    <li class="nav-item active"><a class="nav-link" href="mydining_scheduled">Scheduled</a></li>
                                    <li class="nav-item"><a class="nav-link" href="mydining_visited">Visited</a></li>
                                </ul>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="mypage">My Page</a></li>
                            <li class="nav-item"><a class="nav-link" href="notice">Notice</a></li>
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
                            	<li class="nav-item"><a class="nav-link" href="admin">Admin</a></li>
                        	</c:if>
                        </ul>
                    </div> 
                </nav>
            </div>
        </header>
        <!--================Header Area =================-->
        
        <!--================Breadcrumb Area =================-->
        <section class="breadcrumb_area">
            <div class="overlay bg-parallax" data-stellar-ratio="0.8" data-stellar-vertical-offset="0" data-background="" style="background: url('resources/image/dayoung_img/reservation_confirm_bg.jpeg') no-repeat scroll center 0 / cover"></div>
            <div class="container">
                <div class="page-cover text-center">
                    <h2 class="page-cover-tittle">Reservation</h2>
                    <!--<ol class="breadcrumb">
                        <li><a href="index.html">Home</a></li>
                        <li class="active">About</li>
                    </ol>-->
                </div>
            </div>
        </section>
        <!--================Breadcrumb Area =================-->
        
        <!--================ Reservation Confirm Area  =================-->
        <section class="facilities_area section_gap">
	        <!-- Start form -->
	        <form name="bookingForm" action="booking_without_payment.do" method="post">
				<input type="hidden" id="sid" name="sid" value="${bookingDto.sid}">
				<input type="hidden" id="rdate" name="rdate" value="${bookingDto.rdate}">
				<input type="hidden" id="rtabletype" name="rtabletype" value="${bookingDto.rtabletype}">
				<input type="hidden" id="rtime" name="rtime" value="${bookingDto.rtime}">
				<input type="hidden" id="guestnumber" name="guestnumber" value="${bookingDto.guestnumber}">
	            <div class="overlay bg-parallax" data-stellar-ratio="0.8" data-stellar-vertical-offset="0" data-background="">  
	            </div>
	            <div class="container">
	                <!-- Start select menu -->
	                <div class="section_title text-center">
	                    <br><br><br><br>
	                    <h2 class="title_w" style="font-size: 50px;">${shopDto.sname}</h2>
	                </div>
	                <hr class = "seperator">
	                <!-- End select menu -->
	
	                <!-- Start notes -->
	                <c:if test="${not empty rsPolicyList}">
	                <div class="section_title text-center">
	                    <h2 class="title_w" style="margin-top: 70px;">Notes</h2>
	                    <div class="drawer-box-body fixed-height enable-scroll" style="padding: 20px; text-align: left;">
	                    	<c:forEach var="rsPolicyVo" items="${rsPolicyList}">
	                    		<label class="label-checkbox mb-15" style = "display: block">
		                            <input type="checkbox" id="notes" name="notes" class="form-checkbox" style="min-width: 20px;">
		                            <span class="label strong font-14" style="word-break: break-all;">
										${rsPolicyVo.pcontents}
		                            </span>
		                        </label>
							</c:forEach>
	                        <div class="well mt-30" style="margin-bottom: 100px;">&nbsp;</div>
	                    </div>
	                </div>
	                <hr class = "seperator">
	                </c:if>
	                <!-- End notes -->
	
	                <!-- Start reservation information -->
	                <div class="section_title text-center">
	                    <h2 class="title_w" style="margin-top: 70px;">Reservation Information</h2>
	                </div>
	                <div class="section-body">
	                    <div class="__checkout-reserv-info">
	                        <div class="__summary">
	                            <div class="__more-info">
	                                <dl style="font-size: 15px;">
	                                    <dt>Schedule</dt>
	                                    <dd>${bookingDto.rdate} · ${bookingDto.rtime} · ${bookingDto.guestnumber}
                                                                Person(s)</dd>
	                                </dl>
	                                <dl style="font-size: 15px;">
	                                    <dt>Booker</dt>
	                                    <dd>${sessionVo.memberId} (${sessionVo.kemail})</dd>
	                                </dl>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                <hr class = "seperator2">
	                <!-- End reservation information -->
	
	                <!-- Start Special request & phone number -->
	                <div class="section_title text-center">
	                    <h2 class="title_w" style="margin-top: 70px;">Special Request</h2>
	                </div>
	                <div class="section-body mb-30">
	                    <div class="__select-textarea">
	                        <textarea class="form-input __active"
	                        		  name="rrequest"
	                                  placeholder="     If you have any request to restaurant, please write here."
	                                  rows="4"
	                                  style="width: 80%;"></textarea>
	                    </div>
	                </div>
	                <div class="section_title text-center">
	                    <h2 class="title_w" style="margin-top: 70px;">Phone Number</h2>
	                </div>
	                <div class="section-body">
	                    <input type="text"
	                    	   name="contact"
	                           class="form-input __active"
	                           placeholder="     Please write down your email address / phone number"
	                           style="width: 80%;">
	                    <p class="color-gray mt-5">If you leave your phone number which will be used while visit Korea,
	                                               the restaurant can contact you quickly when they have any inquiry.
	                    </p>
	                </div>
	                <hr class = "seperator">
	                <!-- End Special request & phone number -->
	

	                <!-- Start payment btn -->
	                <div class="sticky-bottom-btns" style="position: fixed;
	                                                       bottom: 0;
	                                                       z-index: 99;
	                                                       width: auto;
	                                                       max-width: 480px;
	                                                       left: 50%;
	                                                       transform: translateX(-50%);
	                                                       padding: 20px;
	                                                       box-sizing: border-box;
	                                                       width: 100vw;
	                                                       /*background: rgba(255,255,255,.7);*/
	                                                       -webkit-backdrop-filter: blur(2px);
	                                                       backdrop-filter: blur(2px);
	                                                       display: flex;">
	                    <button type="submit" 
	                    		id="requestBooking"
	                    		class="btn btn-lg btn-red full-width ebold"
	                            style="display: block;
			                            width: 100%;
			                            flex: 1;
			                            margin-right: 10px;
			                            margin-bottom: 50px;
			                            font-weight: 700;
			                            background: #ff3d00;
			                            color: #fff;
			                            line-height: 46px;
			                            text-align: center;
			                            font-size: 14px;
			                            font-weight: 500;
			                            padding: 0 20px;
			                            position: relative;
			                            /* border: 1px solid white; */
			                            box-shadow: 3px 3px 3px 3px tomato;
			                            border-radius: 6px;">
	                        Book table 
	                    </button>
	                </div>
	            </div>
	        </form>
	        <!-- End form -->
        </section>
        <!--================ Reservation Confirm Area  =================-->


		<!--================ start footer Area  =================-->
        <footer class="footer-area section_gap" style="padding:50px 0 0 0; background:rgb(255, 61, 0)">
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
                                <li><img src="image/instagram/Image-01.jpg" alt=""></li>
                                <li><img src="image/instagram/Image-02.jpg" alt=""></li>
                                <li><img src="image/instagram/Image-03.jpg" alt=""></li>
                                <li><img src="image/instagram/Image-04.jpg" alt=""></li>
                                <li><img src="image/instagram/Image-05.jpg" alt=""></li>
                                <li><img src="image/instagram/Image-06.jpg" alt=""></li>
                                <li><img src="image/instagram/Image-07.jpg" alt=""></li>
                                <li><img src="image/instagram/Image-08.jpg" alt=""></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="border_line"></div>
                <div class="row footer-bottom d-flex justify-content-between align-items-center">
                    <p class="col-lg-8 col-sm-12 footer-text m-0">
                </div>
            </div>
        </footer>
        <!--================ End footer Area  =================-->
        
        
        
        
        
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="vendors/owl-carousel/owl.carousel.min.js"></script>
        <script src="js/jquery.ajaxchimp.min.js"></script>
        <script src="vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.js"></script>
        <script src="vendors/nice-select/js/jquery.nice-select.js"></script>
        <script src="js/mail-script.js"></script>
        <script src="js/stellar.js"></script>
        <script src="vendors/lightbox/simpleLightbox.min.js"></script>
        <script src="js/custom.js"></script>
    </body>
</html>