<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <script src="resources/js/jquery-3.6.4.min.js"></script>
        <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
        <script src="resources/js/catchmind_hyeonsoo.js"></script>
        <link rel="icon" href="resources/image/catchcon.png" type="image/png">
        <!-- <link rel="icon" href="image/favicon.png" type="image/png"> -->
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
		<link rel="stylesheet" href="resources/css/jhsStyle.css">
        <link rel="stylesheet" href="resources/css/responsive.css">
        <script>
        	let join_complete = "${SignUp_Complete}"
        	let login_failed = "${login_fail}"
        	let pass_update = "${pass_update}"
        	
        	if(join_complete === 'ok') {
        		alert("Sign Up Complete");
        		window.close();
        	}
        	
        	if(login_failed === "no") {
        		alert("Please check your ID or password");
        	}
        	
        	if(pass_update == "ok") {
        		alert("Password reset complete");
        		window.close();
        	}
        </script>
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
                             <!--================ Menu =================-->                
                            <li class="nav-item"><a class="nav-link" href="index.do">Home</a></li> 
                            <li class="nav-item"><a class="nav-link" href="search.do">Search</a></li>
                            <li class="nav-item submenu dropdown">
                                <a href="mydining_scheduled.do" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">MY DINING</a>
                                <ul class="dropdown-menu">
                                    <li class="nav-item"><a class="nav-link" href="mydining_scheduled.do">Scheduled</a></li>
                                    <li class="nav-item"><a class="nav-link" href="mydining_visited.do">Visited</a></li>
                                </ul>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="mypage.do">My Page</a></li>
                            <li class="nav-item"><a class="nav-link" href="notice.do">Notice</a></li>
                            <c:if test="${sessionScope.sessionVo.roleId =='SHOP' or sessionScope.sessionVo.roleId == 'ADMIN'}">
                            	<li class="nav-item submenu dropdown">
	                                <a href="shop_reservation.do" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Shop</a>
	                                <ul class="dropdown-menu">
	                                    <li class="nav-item"><a class="nav-link" href="shop_information.do?sid=${sessionScope.sessionVo.sid}">Register</a></li>
	                                    <!-- <li class="nav-item active" id="shop_information">Register</li> -->
	                                    <li class="nav-item"><a class="nav-link" href="shop_reservation.do?sid=${sessionScope.sessionVo.sid}">Reservation</a></li>
	                                </ul>
	                            </li>
                            </c:if>
                            <c:if test="${sessionScope.sessionVo.roleId == 'ADMIN'}">
                            	<li class="nav-item"><a class="nav-link" href="admin.do">Admin</a></li>
                            </c:if>
                        <!--================ Menu =================-->
                        </ul>
                    </div> 
                </nav>
            </div>
        </header>
        <!--================Header Area =================-->
        
        <!--================Breadcrumb Area =================-->
        <section class="breadcrumb_area">
            <div class="overlay bg-parallax" data-stellar-ratio="0.8" data-stellar-vertical-offset="0" data-background="" style="background: url('https://d3h1lg3ksw6i6b.cloudfront.net/media/image/2017/07/04/138dc94f354c4a64bf6881d686981508_KMJ.jpg') no-repeat scroll center 0 / cover"></div>
            <div class="container">
                <div class="page-cover text-center">
                    <h2 class="page-cover-tittle">Login</h2>
                    <!-- <ol class="breadcrumb">
                        <li><a href="index.html">Home</a></li>
                        <li class="active">Contact Us</li>
                    </ol> -->
                </div>
            </div>
        </section>
        <!--================Breadcrumb Area =================-->
        
        <!--================Contact Area =================-->
        <section class="contact_area section_gap">
        <div class="div222">
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        </div>
                    </div>
                    <div class="col-md-9">
                         <form name="loginForm" action="login_proc.do" method="post">
                           <ul class="loginUl">
								<li>
									<!-- <label>ID(Email)</label> -->
									<input type="text" name="memberId" id="id" placeholder="ID">
								</li>
								<li>
									<!-- <label>PassWord</label> -->
									<input type="password" name="mpass" id="pass" placeholder="Password">
									<!-- <input type="hidden" name="roleId" value="USER"> -->
								</li>
								<li>
									<span><a href="#" id="btnSignUp">Sign Up</a></span>
									<span><a href="#" id="btnFindID">Find ID</a></span>
									<span><a href="#" id="btnFindPass">Find Password</a></span>
								</li>
								<li>
									<button type="button" class="btn_style" id="btnLogin">Sign In</button>
								</li>
						 	</ul>
                        </form>
                        <!-- <form name="kakaoLoginForm" action="kakao_login_proc.do" method="post"> -->
						 	<div class="dkakao">
								<button class="__kakao" onclick="kakaoLogin();">
									<img src="https://d1il53drs2cmia.cloudfront.net/resources/img/login/kakao_button.svg" alt="" style="background: url(&quot;data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7&quot;) center center no-repeat transparent;">
									<!-- <a href="javascript:void(0)"> -->
									<span class="kakaoSpan"> Sign In With Kakao</span>
									<!-- </a> -->
								</button>
						 	</div>
                        <!-- </form> -->
                    </div>
                </div>
            </div>
            <div class="div111">
            </div>
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
                        <div class="login_type_ao">
                        	<a href="login_role.do" class="login_type_style">Admin / Shop</a>
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
        <script src="resources/js/kakaologin_hyeonsoo.js"></script>
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
    </body>
</html>