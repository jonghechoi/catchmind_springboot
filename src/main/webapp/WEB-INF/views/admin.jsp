<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<link rel="stylesheet" href="/css/style_jonghe.css">
	<link rel="stylesheet" href="/css/responsive.css">
    <!--================수정사항 스크립트, 스타일 ================-->
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/jonghe.js"></script>
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
        				<!--================ 변경하는 부분 =================-->                
                            <li class="nav-item"><a class="nav-link" href="/">Home</a></li>
                            <li class="nav-item"><a class="nav-link" href="search.do">Search</a></li>
                            <li class="nav-item submenu dropdown">
                                <a href="mydining_scheduled" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">MY DINING</a>
                                <ul class="dropdown-menu">
                                    <li class="nav-item active"><a class="nav-link" href="mydining_scheduled">Scheduled</a></li>
                                    <li class="nav-item"><a class="nav-link" href="mydining_visited">Visited</a></li>
                                </ul>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="mypage.do">My Page</a></li>
                            <li class="nav-item"><a class="nav-link" href="notice.do">Notice</a></li>
                            <%--<c:if test="${sessionScope.sessionVo.roleId =='SHOP' or sessionScope.sessionVo.roleId == 'ADMIN'}">--%>
	                            <li class="nav-item submenu dropdown">
	                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Shop</a>
	                                <ul class="dropdown-menu">
                                        <li class="nav-item active"><a class="nav-link" href="/shop_information">Register</a></li>
                                        <li class="nav-item"><a class="nav-link" href="/shop_reservation">Reservation</a></li>
	                                </ul>
	                            </li>                     
                            <%--</c:if>
                            <c:if test="${sessionScope.sessionVo.roleId == 'ADMIN'}">--%>
                            	<li class="nav-item active"><a class="nav-link" href="/admin">Admin</a></li>
                        	<%--</c:if>--%>
                        <!--================ 변경하는 부분 =================-->
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
                    <h2 class="page-cover-tittle">Administrator Page</h2>
                    <ol class="breadcrumb">
                        <li>Do best!!</li>
                        <!-- <li class="active"></li> -->
                    </ol>
                </div>
            </div>
        </section>
        <!--================Breadcrumb Area =================-->
        <!--================Contact Area =================-->
        <section class="contact_area section_gap">
           	<div class="container div1">
           		<div class="nav_bar">
					<ul class="nav_bar">
					  <li><a class="active" id="li_Home">Home</a></li>
					  <li><a class="" id="li_MemberAdmin">Member</a></li>
					  <li><a class="" id="li_ShopInfoAdmin">Shop List</a></li>
					  <li><a class="" id="li_ReservAdmin">Shop Registeration</a></li>
					  <li><a class="" id="li_ReviewAdmin">Review</a></li>
					  <li><a class="" id="li_NotiAdmin">Notice</a></li>
					</ul>
           		</div>
 	           	<div class="member">
 	           		<iframe src="/admin_member_list" id="memberIframe"
				    	scrolling="no" width="100%" height="400px" frameborder=0 style="display:none"></iframe>
	           	</div>
	           	<div class="shopInformation">
	           		<iframe src="/admin_shop_information" id="shopInformationIframe"
				    	scrolling="no" width="100%" height="400px" frameborder=0 style="display:none"></iframe>
	           	</div>
	           	<div class="reservation">
	           		<iframe src="/admin_shop_registeration_check" id="reserveIframe"
				    	scrolling="no" width="100%" height="400px" frameborder=0 style="display:none"></iframe>
	           	</div>	           	
	           	<div class="review">
	           		<iframe src="/admin_review" id="reviewIframe"
				    	scrolling="yes" width="100%" height="400px" frameborder=0 style="display:none"></iframe>
	           	</div>
	           	<div class="notice">
	           		<iframe src="/admin_notice_list" id="noticeIframe"
				    	scrolling="no" width="100%" height="400px" frameborder=0 style="display:none"></iframe>
	           	</div> 
           	</div>
           	<!--================ 수정사항 ================-->
        </section>
        <!--================Contact Area =================-->
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
                            <h6 class="footer_title">Contact</h6>
                            <p style="color:white">We will always put your advice first. If you have any questions, please feel free to leave them.</p>	
                            <p style="color:white">02-123-1234</p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-6 footer-widget3"  style="width:300px">
                        <div class="single-footer-widget instafeed">
                            <h6 class="footer_title">InstaFeed</h6>
                            <ul class="list_style instafeed d-flex flex-wrap">
                                <li><img src="/image/instagram/Image-01.jpg" alt=""></li>
                                <li><img src="/image/instagram/Image-02.jpg" alt=""></li>
                                <li><img src="/image/instagram/Image-03.jpg" alt=""></li>
                                <li><img src="/image/instagram/Image-04.jpg" alt=""></li>
                                <li><img src="/image/instagram/Image-05.jpg" alt=""></li>
                                <li><img src="/image/instagram/Image-06.jpg" alt=""></li>
                                <li><img src="/image/instagram/Image-07.jpg" alt=""></li>
                                <li><img src="/image/instagram/Image-08.jpg" alt=""></li>
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
       <!--================Contact Success and Error message Area =================-->
        <div id="success" class="modal modal-message fade" role="dialog">
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
        <!-- Modals error -->
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
        </div>
        <!--================End Contact Success and Error message Area =================-->
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
	</body>
</html>