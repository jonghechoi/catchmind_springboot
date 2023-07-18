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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
        <script src="/js/catchmind_hyeonsoo.js"></script>
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
    </head>
    <body>
        <!--================Header Area =================-->
        <header class="header_area">
            <div class="container">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <a class="navbar-brand logo_h" href="/index"><img src="/image/catchmind.png" alt=""></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
                        <ul class="nav navbar-nav menu_nav ml-auto">
                           <!--================ Menu =================-->                
                            <li class="nav-item"><a class="nav-link" href="/index">Home</a></li>
                            <li class="nav-item"><a class="nav-link" href="/search">Search</a></li>
                            <li class="nav-item submenu dropdown active">
                                <a href="/mydining_scheduled" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">MY DINING</a>
                                <ul class="dropdown-menu">
                                    <li class="nav-item"><a class="nav-link" href="/mydining_scheduled">Scheduled</a></li>
                                    <li class="nav-item"><a class="nav-link" href="/mydining_visited">Visited</a></li>
                                </ul>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="/mypage">My Page</a></li>
                            <li class="nav-item"><a class="nav-link" href="/notice">Notice</a></li>
                            <c:if test="${sessionScope.sessionVo.roleId =='SHOP' or sessionScope.sessionVo.roleId == 'ADMIN'}">
                            	<li class="nav-item submenu dropdown">
	                                <a href="/shop_reservation" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Shop</a>
	                                <ul class="dropdown-menu">
                                        <li class="nav-item active"><a class="nav-link" href="/shop_information">Register</a></li>
                                        <li class="nav-item"><a class="nav-link" href="/shop_reservation">Reservation</a></li>
	                                </ul>
	                            </li>
                            </c:if>
                            <c:if test="${sessionScope.sessionVo.roleId == 'ADMIN'}">
                            	<li class="nav-item"><a class="nav-link" href="/admin">Admin</a></li>
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
                    <h2 class="page-cover-tittle">Write Review</h2>
                    <ol class="breadcrumb">
                        <li><a href="/mydining_visited">Visited</a></li>
                        <li class="active">Write Review</li>
                    </ol>
                </div>
            </div>
        </section>
        <!--================Breadcrumb Area =================-->
        
        <!--================ About History Area  =================-->
        <section class="about_history_area section_gap">
      		<form name="writeReviewForm" action="/write_review" method="post" enctype="multipart/form-data">
	            <div class="container">
	                <div class="row">
	                    <div class="col-md-6 d_flex align-items-center">
	                        <div class="about_content ">
	                            <p class="title title_color"></p>
                            	<div class="d1photo">
                            	<input type="hidden" name="mid" value="${reviewVo.mid}">
								<input type="hidden" name="sid" value="${reviewVo.sid}">
								<input type="hidden" name="rid" value="${reviewVo.rid}">
									<h3 class="photo">Photo Upload</h3>
									<span class="upload">Please upload photos related to the restaurant.</span>
									<input type="file" name="reviewfile1" class="btn_fileUpload" id="fileInput">
									<img id="previewImage" src="#" alt="Preview">
								</div>
								<p class="writeReview">Write a review ♥</p>
		                        <textarea class="col-auto form-control" type="text" name="reviewcontent" id="reviewcontent"
								  placeholder="Please write a warm review to help restaurants and users"></textarea>
	                        </div>
	                    </div>
	                   	<div class="col-md-6">
		                    	<fieldset class="field_star" id="tasteFieldset">
									<span class="text-bold">맛</span>
									<input type="radio" name="tasteStar" value="5" id="tasteStar1"><label
										for="tasteStar1" class="review_label">★</label>
									<input type="radio" name="tasteStar" value="4" id="tasteStar2"><label
										for="tasteStar2" class="review_label">★</label>
									<input type="radio" name="tasteStar" value="3" id="tasteStar3"><label
										for="tasteStar3" class="review_label">★</label>
									<input type="radio" name="tasteStar" value="2" id="tasteStar4"><label
										for="tasteStar4" class="review_label">★</label>
									<input type="radio" name="tasteStar" value="1" id="tasteStar5"><label
										for="tasteStar5" class="review_label">★</label>
								</fieldset>
								<fieldset class="field_star" id="moodFieldset">
									<span class="text-bold">분위기</span>
									<input type="radio" name="moodStar" value="5" id="moodStar1"><label
										for="moodStar1" class="review_label">★</label>
									<input type="radio" name="moodStar" value="4" id="moodStar2"><label
										for="moodStar2" class="review_label">★</label>
									<input type="radio" name="moodStar" value="3" id="moodStar3"><label
										for="moodStar3" class="review_label">★</label>
									<input type="radio" name="moodStar" value="2" id="moodStar4"><label
										for="moodStar4" class="review_label">★</label>
									<input type="radio" name="moodStar" value="1" id="moodStar5"><label
										for="moodStar5" class="review_label">★</label>
								</fieldset>
								<fieldset class="field_star" id="serviceFieldset">
									<span class="text-bold">서비스</span>
									<input type="radio" name="serviceStar" value="5" id="serviceStar1"><label
										for="serviceStar1" class="review_label">★</label>
									<input type="radio" name="serviceStar" value="4" id="serviceStar2"><label
										for="serviceStar2" class="review_label">★</label>
									<input type="radio" name="serviceStar" value="3" id="serviceStar3"><label
										for="serviceStar3" class="review_label">★</label>
									<input type="radio" name="serviceStar" value="2" id="serviceStar4"><label
										for="serviceStar4" class="review_label">★</label>
									<input type="radio" name="serviceStar" value="1" id="serviceStar5"><label
										for="serviceStar5" class="review_label">★</label>
								</fieldset>
								<p class="reviewPolicy">CatchTable Review Policy ></p>
			                    <p>Contents related to the use of the restaurant,<br> including false and exaggerated contents,<br> unauthorized theft of works, infringement<br> of portrait rights and privacy,<br> and slander may be deleted</p>
			                    <button type="button" class="btnReview" id="review_registe">Registering</button>
	                   		</div>
		                </div>
		            </div>
            	</form>
        </section>
        <!--================ About History Area  =================-->
        
        <!--  teststst-->
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