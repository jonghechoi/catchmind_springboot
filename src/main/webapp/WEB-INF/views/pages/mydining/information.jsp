<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" href="/image/catchcon.png" type="image/png">
        <script src="/js/jquery-3.6.4.min.js"></script>
        <script src="/js/catchmind_hyeonsoo.js"></script>
        <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
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
		<link rel="stylesheet" href="/css/jhsStyle.css">
        <link rel="stylesheet" href="/css/responsive.css">
        
        <script>
        	let information_bookmark = "${information_bookmark}";
        	
        	if(information_bookmark == "delete") {
        		alert("Delete Favorite Restaurant Registration");
        		
        	}else if(information_bookmark == "insert") {
        		alert("Favorite Restaurant Registration Completed");
        	}
        </script>
        
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
                           <!--================ Menu =================-->                
                            <li class="nav-item"><a class="nav-link" href="index">Home</a></li>
                            <li class="nav-item"><a class="nav-link" href="search.do">Search</a></li>
                            <li class="nav-item submenu dropdown active">
                                <a href="/mydining_scheduled" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">MY DINING</a>
                                <ul class="dropdown-menu">
                                    <li class="nav-item"><a class="nav-link" href="/mydining_scheduled">Scheduled</a></li>
                                    <li class="nav-item"><a class="nav-link" href="/mydining_visited">Visited</a></li>
                                </ul>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="mypage">My Page</a></li>
                            <li class="nav-item"><a class="nav-link" href="notice">Notice</a></li>
                            <c:if test="${sessionScope.sessionVo.roleId =='SHOP' or sessionScope.sessionVo.roleId == 'ADMIN'}">
                            	<li class="nav-item submenu dropdown">
	                                <a href="shop_reservation" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Shop</a>
	                                <ul class="dropdown-menu">
                                        <li class="nav-item active"><a class="nav-link" href="/shop_information">Register</a></li>
                                        <li class="nav-item"><a class="nav-link" href="/shop_reservation">Reservation</a></li>
	                                </ul>
	                            </li>
                            </c:if>
                            <c:if test="${sessionScope.sessionVo.roleId == 'ADMIN'}">
                            	<li class="nav-item"><a class="nav-link" href="admin">Admin</a></li>
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
                    <h2 class="page-cover-tittle">${scheduledVo.sname}</h2>
                    <ol class="breadcrumb">
                        <li><a href="/mydining_scheduled">Schedule</a></li>
                        <li class="active">Information</li>
                    </ol>
                </div>
            </div>
        </section>
        <!--================Breadcrumb Area =================-->

        <!--================ About History Area  =================-->
        <section class="about_history_area section_gap">
            <div class="container">
                <div class="row">
                    <!--  Start restaurant page mini info -->
                    <div class="col-md-6 d_flex align-items-center">
                        <div class="about_content ">
                        <c:choose>
	                        <c:when test="${scheduledVo.fcheck == 'Y'}">
	                        	<a href="/information_bookmark/${scheduledVo.sid}/${scheduledVo.rid}" class="btn_sh" id="btn_bookmark"><img src="/image/jhs_img/free-icon-bookmark-6924811.png"></a>
    	                    </c:when>
    	                    <c:otherwise>
	                        	<a href="/information_bookmark/${scheduledVo.sid}/${scheduledVo.rid}" class="btn_sh" id="btn_bookmark"><img src="/image/jhs_img/free-icon-bookmarks-4218997.png"></a>
    	                    </c:otherwise>
                        </c:choose>
                        	<a class="kakao-share-btn" id="kakao-share-btn" href="javascript:;" onclick="shareKakao()"><img src="/image/jhs_img/free-icon-share-3989188.png" alt="카카오 공유하기"></a>
                            <h2 class="title title_color">${scheduledVo.sname}</h2>
                            <p>${scheduledVo.sintro}</p>
                            <span>${scheduledVo.slocShort}</span>
                            <div class="restaurant-meta mb-30">
                                <div class="__more-info1">
	                                <dl style="font-size: 15px;">
	                                    <dt>Booker</dt>
	                                    <dd>${scheduledVo.mname}</dd>
	                                </dl>
	                                <dl style="font-size: 15px;">
	                                    <dt>Phone Number</dt>
	                                    <dd>${scheduledVo.mphone}</dd>
	                                </dl>
	                            </div>
                            </div>
                        </div>
                    </div>
                    <!--  End restaurant page mini info -->

                    <!-- Start restaurant page mini photo-->
                    <div class="col-md-6">
                        <section class="testimonial_area section_gap">
                            <div class="container">
                            	<img src = "${scheduledVo.smphoto}" alt="img" width=280px height=280px>
                            </div>
                        </section>
                    </div>
                    <!-- End restaurant page mini photo-->
                    <div class="col-md-6">
                    	<div class="schedule_d">
                        	<p class="sc_p">Schedule</p>
                        	<div>
                        		<span><img src="/image/jhs_img/free-icon-calendar-8895471.png" class="schedule_img" ></span>
                        		<span><img src="/image/jhs_img/free-icon-clock-88291.png" class="schedule_img" ></span>
                        		<span><img src="/image/jhs_img/free-icon-user-3856336.png" class="schedule_img" id="img_sch" ></span>
                        	</div>
	                        	<span class="schedule_day1">${scheduledVo.rdate}</span>
	                        	<span class="schedule_day1">${scheduledVo.rtime}</span>
	                        	<span class="schedule_day1">${scheduledVo.guestNumber} person(s)</span>
                        </div>
                	</div>
	                <div class="col-md-6">
	                    <div class="__checkout-reserv-info">
	                        <div class="__summary">
	                            <div class="__more-info">
	                                <div class="section-header">
                            <h2 class="title_colorlo">Location</h2>
                        </div>
                        <div class="section-body">
                            <div class="location-map">
                                <div class="addr" style="padding: 0px 20px;">
                                    <p id="locationText">${scheduledVo.sloc}</p>
                                    <a href="#" class="btn-copy" style="padding-top: 4px;">Copy</a>
                                </div>
                            </div>
                        </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
                </div>
            </div>
            <hr class = "seperator2">
        </section>
        <!--================ About History Area  =================-->


                <!-- End restaurant page recommended reviews-->
                <!-- Start restaurant page Location -->
                <section class="section">
                    <div class="container gutter-sm">
                        <div class="section-header">
                            <h2 class="title_w1">Select Menu</h2>
                    <div class = "res_notice" style="height: 320px;">
                        <div class="boxed-dl-list mb-20"
                             style = "border-radius: 10px;
                                      border: solid 1px #e8e8e8;
                                      padding: 13px 20px 5px 20px;
                                      margin-bottom: 20px!important;
                                      display: inline-block;
                                      width: 45%;">
                            <p class="notice mt-15 mb-20" style = "background:
                        url(data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIxMyIgaGVpZ2h0PSIxMyIgdmlld0JveD0iMCAwIDEzIDEzIj4KICAgIDxnIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPGNpcmNsZSBjeD0iNi41IiBjeT0iNi41IiByPSI2LjUiIGZpbGw9IiNGRjNEMDAiLz4KICAgICAgICA8cGF0aCBmaWxsPSIjRkZGIiBmaWxsLXJ1bGU9Im5vbnplcm8iIGQ9Ik02LjY5NCAzLjc0Yy4yMjQgMCAuNDEyLS4wNzQuNTY0LS4yMjIuMTUyLS4xNDguMjI4LS4zMy4yMjgtLjU0NiAwLS4yMDgtLjA3Ni0uMzg2LS4yMjgtLjUzNC0uMTUyLS4xNDgtLjM0LS4yMjItLjU2NC0uMjIyLS4yMjQgMC0uNDEyLjA3NC0uNTY0LjIyMi0uMTUyLjE0OC0uMjI4LjMyNi0uMjI4LjUzNCAwIC4yMTYuMDc2LjM5OC4yMjguNTQ2LjE1Mi4xNDguMzQuMjIyLjU2NC4yMjJ6bTAgNy4yNzJjLjE2IDAgLjI5OC0uMDQuNDE0LS4xMi4xMTYtLjA4LjE3NC0uMjA0LjE3NC0uMzcyVjUuMDg0YzAtLjE2OC0uMDU4LS4yOTItLjE3NC0uMzcyLS4xMTYtLjA4LS4yNTQtLjEyLS40MTQtLjEyLS4xNTIgMC0uMjg4LjA0LS40MDguMTItLjEyLjA4LS4xOC4yMDQtLjE4LjM3MnY1LjQzNmMwIC4xNjguMDYuMjkyLjE4LjM3Mi4xMi4wOC4yNTYuMTIuNDA4LjEyeiIvPgogICAgPC9nPgo8L3N2Zz4K) 1px 0.1em no-repeat; text-align: left; padding: 0px 0px 0px 20px;">A deposit will be charged according to the number of party.</p>
                            <dl class="mb-10" style="margin-bottom: 10px!important;">
                                <dt style="text-align: left">Deposit per person</dt>
                                <dd style="text-align: right">${scheduledVo.sdeposit}</dd>
                            </dl>
                            <dl class="">
                                <dt style="text-align: left">x Person(s)</dt>
                                <dd style="text-align: right">${scheduledVo.guestNumber}</dd>
                            </dl>
                            <hr class="hairline mt-20 mb-20"
                                style="margin-top: 20px!important;
                                       margin-bottom: 20px!important;
                                       margin: 0 -20px;">
                            <dl class="dl-lg">
                                <dt style="text-align: left">Total Amount</dt>
                                <dd style="text-align: right; color: rgb(255, 61, 0);">${scheduledVo.totalMount}</dd>
                            </dl>
                        </div>
                    </div>
                </div>
                        </div>
                    </div>
                </section>
                <hr class = "seperator2">
                <!-- End restaurant page Location -->

                <!-- Start restaurant page Detailed Information -->
                <section class="sectionDetail">
                    <div class="container gutter-sm pb-20">
                        <div class="section-header">
                            <h2 class="title_color">Detailed Information</h2>
                        </div>
                        <div class="section-body">
                            <div class="desc-blocks" style="word-break: break-word;">
                                <div class="desc-block">
                                    <dl>
                                        <dt>Phone Number</dt>
                                        <dd>${scheduledVo.sphone}</dd>
                                    </dl>
                                    <div class="action">
                                        <a class="btn-call"><span>Call</span></a>
                                    </div>
                                </div>
                                <div class="desc-block">
                                    <dl>
                                        <dt>About Us</dt>
                                        <dd>Increasingly assertive and self-assured, the evolution of Zero Complex
                                            is founded on Chef Lee Chung-hu’s philosophy that balance and harmony
                                            hold the key to great food. The outcome of his approach to cooking is
                                            authentic and creative dishes, served in a near-sterile space that
                                            provides the blank canvas for Chef Lee’s inventions. Lee grows many of
                                            his own herbs and vegetables in the greenhouse in front of the restaurant
                                            building. The French sommelier’s natural wine pairings round out the
                                            flavors and textures, bringing the meal full circle.</dd>
                                    </dl>
                                </div>
                                <div class="desc-block">
                                    <dl>
                                        <dt>Business Hours</dt>
                                        <dd>Open Time  >  ${scheduledVo.sopeningHour}<br>Close Time  >  ${scheduledVo.sclosingHour}</dd>
                                    </dl>
                                </div>
                                <div class="desc-block">
                                    <dl>
                                        <dt>Closing Day</dt>
                                        <dd>${scheduledVo.sclosingDate}</dd>
                                    </dl>
                                </div>
                                <div class="desc-block">
                                    <dl>
                                        <dt>Notes</dt>
                                        <dd>*You can change or cancel your reservation by phone or email.<br>
                                            *Full refund of the deposit is possible only if you cancel or change
                                            (number of people, date) 3 days before the reservation date.<br>
                                            *Reservation will be refunded upon visit (no deduction from meal amount)<br>
                                            *Please request in advance or contact us in advance for any allergies
                                            or matters. Please understand that it is difficult to respond effectivelywhen
                                            we are notified on the spot.<br>*For reservations for more than 5 people,
                                            please call us (02-532-0876).</dd>
                                    </dl>
                                </div>
                                <div class="d_cancel">
                                	<button type="button" class="btn_cancel" value="${scheduledVo.rid}">Reservation Cancel</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <!-- End restaurant page Detailed Information -->
                <!--  -->
            </div>
        </section>
        <!--================ Testimonial Area  =================-->
        
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
        
        
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="/js/kakao_share.js"></script>
        <script src="/js/jquery-3.2.1.min.js"></script>
        <script src="/js/popper.js"></script>
        <script src="/js/bootstrap.min.js"></script>
        <script src="/vendors/owl-carousel/owl.carousel.min.js"></script>
        <script src="/js/jquery.ajaxchimp.min.js"></script>
        <script src="/vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.js"></script>
        <script src="/vendors/nice-select/js/jquery.nice-select.js"></script>
        <script src="/js/mail-script.js"></script>
        <script src="/js/stellar.js"></script>
        <script src="/vendors/lightbox/simpleLightbox.min.js"></script>
        <script src="/js/custom.js"></script>
    </body>
</html>