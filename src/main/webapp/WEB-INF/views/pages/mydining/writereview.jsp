<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" href="image/favicon.png" type="image/png">
        <title>CatchMind</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="vendors/linericon/style.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.css">
        <link rel="stylesheet" href="vendors/nice-select/css/nice-select.css">
        <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">
        <!-- main css -->
        <link rel="stylesheet" href="http://localhost:9000/catchmind/css/style.css">
		<link rel="stylesheet" href="http://localhost:9000/catchmind/css/jhsStyle.css">
        <link rel="stylesheet" href="css/responsive.css">
    </head>
    <body>
        <!--================Header Area =================-->
        <header class="header_area">
            <div class="container">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <a class="navbar-brand logo_h" href="index"><img src="resources/image/catchmind.png" alt=""></a>
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
                                    <li class="nav-item"><a class="nav-link" href="/mydining_cancel_noshow">Cancel / No-Show</a></li>
                                </ul>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="mypage">My Page</a></li>
                            <li class="nav-item"><a class="nav-link" href="notice">Notice</a></li>
                            <c:if test="${sessionScope.sessionVo.roleId =='SHOP' or sessionScope.sessionVo.roleId == 'ADMIN'}">
	                            <li class="nav-item submenu dropdown">
	                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Shop</a>
	                                <ul class="dropdown-menu">
	                                    <li class="nav-item active"><a class="nav-link" href="shop_information?sid=${sessionScope.sessionVo.sid}">Register</a></li>
	                                    <li class="nav-item"><a class="nav-link" href="shop_reservation?sid=${sessionScope.sessionVo.sid}">Reservation</a></li>
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
            <div class="overlay bg-parallax" data-stellar-ratio="0.8" data-stellar-vertical-offset="0" data-background=""></div>
            <div class="container">
                <div class="page-cover text-center">
                    <h2 class="page-cover-tittle">Write Review</h2>
                    <ol class="breadcrumb">
                        <li><a href="mydining_visited">Visited</a></li>
                        <li class="active">Write Review</li>
                    </ol>
                </div>
            </div>
        </section>
        <!--================Breadcrumb Area =================-->
        
        <!--================ About History Area  =================-->
        <section class="about_history_area section_gap">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 d_flex align-items-center">
                        <div class="about_content ">
                            <p class="title title_color">
                            	<div class="d1photo">
									<h3 class="photo">Photo Upload</h3>
									<span class="upload">Please upload photos related to the restaurant.</span>
									<a href="#"><img src="http://localhost:9000/catchmind/image/jhs_img/dot506.PNG" width="120px"; height="110px";></a>
									<a href="#"><img src="http://localhost:9000/catchmind/image/jhs_img/free-icon-add-button-8138351.png" width="120px"; height="110px";></a>
								</div>
								<p class="writeReview">Write a review ♥</p>
		                        <textarea class="col-auto form-control" type="text" id="reviewContents"
								  placeholder="Please write a warm review to help restaurants and users"></textarea>
                        </div>
                    </div>
                   	<div class="col-md-6">
                   		<form class="mb-6" name="myform" id="myform" method="post">
	                    	<fieldset>
								<%--@declare id="rate1"--%><%--@declare id="rate2"--%><%--@declare id="rate3"--%><%--@declare id="rate4"--%><%--@declare id="rate5"--%>
                                    <span class="text-bold">Flavor</span>
								<input type="radio" name="tasteStar" value="5" id="tasteStar1"><label
									for="rate1">★</label>
								<input type="radio" name="tasteStar" value="4" id="tasteStar2"><label
									for="rate2">★</label>
								<input type="radio" name="tasteStar" value="3" id="tasteStar3"><label
									for="rate3">★</label>
								<input type="radio" name="tasteStar" value="2" id="tasteStar4"><label
									for="rate4">★</label>
								<input type="radio" name="tasteStar" value="1" id="tasteStar5"><label
									for="rate5">★</label>
							</fieldset>
							<fieldset>
								<span class="text-bold">Atmosphere</span>
								<input type="radio" name="moodStar" value="5" id="moodStar1"><label
									for="rate1">★</label>
								<input type="radio" name="moodStar" value="4" id="moodStar2"><label
									for="rate2">★</label>
								<input type="radio" name="moodStar" value="3" id="moodStar3"><label
									for="rate3">★</label>
								<input type="radio" name="moodStar" value="2" id="moodStar4"><label
									for="rate4">★</label>
								<input type="radio" name="moodStar" value="1" id="moodStar5"><label
									for="rate5">★</label>
							</fieldset>
							<fieldset>
								<span class="text-bold">Service</span>
								<input type="radio" name="serviceStar" value="5" id="serviceStar1"><label
									for="rate1">★</label>
								<input type="radio" name="serviceStar" value="4" id="serviceStar2"><label
									for="rate2">★</label>
								<input type="radio" name="serviceStar" value="3" id="serviceStar3"><label
									for="rate3">★</label>
								<input type="radio" name="serviceStar" value="2" id="serviceStar4"><label
									for="rate4">★</label>
								<input type="radio" name="serviceStar" value="1" id="serviceStar5"><label
									for="rate5">★</label>
							</fieldset>
							<p class="reviewPolicy">CatchTable Review Policy ></p>
		                    <p>Contents related to the use of the restaurant,<br> including false and exaggerated contents,<br> unauthorized theft of works, infringement<br> of portrait rights and privacy,<br> and slander may be deleted</p>
		                    <button type="button" class="btnReview">Registering</button>
						</form>
                   </div>
                </div>
            </div>
        </section>
        <!--================ About History Area  =================-->
        
        
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