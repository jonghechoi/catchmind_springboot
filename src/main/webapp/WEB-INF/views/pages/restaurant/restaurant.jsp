<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<link rel="stylesheet" href="/css/responsive.css">
		<link rel="stylesheet" href="/css/style_dayoung.css">
		<!-- <script src="js/jquery-3.2.1.min.js"></script> -->
		<script src="/js/popper.js"></script>
		<script src="/js/bootstrap.min.js"></script>
		<script src="/js/jquery-3.6.4.min.js"></script>
		<script src="/vendors/bootstrap-datepicker/bootstrap-datepicker.js"></script>
		<script src="/js/catchmind_dayoung.js"></script>
		<script src="https://www.jqueryscript.net/demo/Mobile-friendly-Custom-Scrollbar-Plugin-With-jQuery-NiceScroll/js/jquery.nicescroll.min.js"></script>
		<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
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
                            <li class="nav-item active"><a class="nav-link" href="/">Home</a></li>
                            <li class="nav-item"><a class="nav-link" href="/search">Search</a></li>
                            <li class="nav-item submenu dropdown">
                                <a href="mydining_scheduled" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">MY DINING</a>
                                <ul class="dropdown-menu">
									<li class="nav-item active"><a class="nav-link" href="/mydining_scheduled">Scheduled</a></li>
									<li class="nav-item"><a class="nav-link" href="/mydining_visited">Visited</a></li>
									<li class="nav-item"><a class="nav-link" href="/mydining_cancel_noshow">Cancel / No-Show</a></li>
                                </ul>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="/mypage">My Page</a></li>
                            <li class="nav-item"><a class="nav-link" href="/notice">Notice</a></li>
                            <c:if test="${sessionScope.sessionDto.roleId =='SHOP' or sessionScope.sessionDto.roleId == 'ADMIN'}">
	                            <li class="nav-item submenu dropdown">
	                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Shop</a>
									<ul class="dropdown-menu">
										<li class="nav-item active"><a class="nav-link" href="/shop_information/${sessionScope.sessionVo.sid}">Register</a></li>
										<li class="nav-item"><a class="nav-link" href="/shop_reservation/${sessionScope.sessionVo.sid}">Reservation</a></li>
									</ul>
	                            </li>
                            </c:if>
                            <c:if test="${sessionScope.sessionDto.roleId == 'ADMIN'}">
                            	<li class="nav-item"><a class="nav-link" href="/admin">Admin</a></li>
                        	</c:if>
                        </ul>
                    </div>
                </nav>
            </div>
        </header>
		<!--================Header Area =================-->

		<!--================Breadcrumb Area =================-->
		<section class="breadcrumb_area">
			<div class="overlay bg-parallax" data-stellar-ratio="0.8"
				data-stellar-vertical-offset="0" data-background=""
				style="background: url('/upload/${shopPhotoDto.sphoto1}') no-repeat scroll center 0/cover"></div>
			<div class="container">
				<div class="page-cover text-center">
					<h2 class="page-cover-tittle">${shopDto.sname}</h2>
					<!--<ol class="breadcrumb">
	                        <li><a href="index.html">Home</a></li>
	                        <li class="active">About</li>
	                    </ol>-->
				</div>
			</div>
		</section>
		<!--================Breadcrumb Area =================-->

		<!--================ About History Area  =================-->
		<section class="about_history_area section_gap">
			<div class="container">
				<div class="row">
					<!--  Start restaurant page mini info -->
					<div class="col-md-4 d_flex align-items-center">
						<div class="about_content ">
							<h2 class="title title_color">${shopDto.sname}</h2>
							<p>${shopDto.sintro}</p>
							<span>${shopDto.slocshort}</span>
							<div class="restaurant-meta mb-30">
								<div class="rating">
									<span class="star">${starAvg}</span> <span class="count">(${totalReviewCount})</span>
								</div>
								<div class="price" style="font-size: 12px;">
									<span class="lunch" style="margin-right: 10px;">${shopDto.lunchString}</span>
									<span class="dinner" style="margin-right: 10px;">${shopDto.dinnerString}</span>
									<a href="#" class="btn-more"></a>
								</div>
							</div>
							<nav class="res_menu">
								<div class="res_menu_left">
									<a href="#"> <i class="res_menu_save">저장</i></a>
									<a id="kakao-share-btn" href="javascript:;" onclick="shareKakao()">
	                           			<img src="/image/dayoung_img/share.png" alt="카카오 공유하기"
	                           				style="float: right;">
	                           		</a>
								</div>
								<div class="res_menu_right">
									<a href="#" class="button_hover theme_btn_two">Reserve</a>
								</div>
							</nav>
						</div>
					</div>
					<!--  End restaurant page mini info -->

					<!-- Start restaurant page mini photo-->
					<div class="col-md-8">
						<section class="testimonial_area section_gap">
							<div class="container">
								<div class="testimonial_slider owl-carousel">
									<div class="media testimonial_item">
										 <img src="/upload/${shopPhotoDto.sphoto2}" alt="img" width=480px
											  height=333px>
									</div>
									<div class="media testimonial_item">
										<img src= "/upload/${shopPhotoDto.sphoto3}" alt="img" width=480px height=333px>
									</div>
									<div class="media testimonial_item">
										<img src= "/upload/${shopPhotoDto.sphoto4}" alt="img" width=480px height=333px>
									</div>
									<div class="media testimonial_item">
										<img src= "/upload/${shopPhotoDto.sphoto5}" alt="img" width=480px height=333px>
									</div>
								</div>
							</div>
						</section>
					</div>
					<!-- End restaurant page mini photo-->
				</div>
			</div>
		</section>
		<hr class="seperator">
		<!--================ About History Area  =================-->

		<!--================ Facilities Area  =================-->
		<section class="facilities_area section_gap">
			<div class="overlay bg-parallax" data-stellar-ratio="0.8"
				data-stellar-vertical-offset="0" data-background=""></div>
			<div class="container">

				<!-- Start Notices from restaurant -->
				<c:if test="${not empty ptitleNotNullList}"> <!-- if 조건 선언 -->
				<div class="section_title text-center">
					<h2 class="title_w">Notices from Restaurant</h2>
					<div class="res_notice">
						<div class="res_notice_block">
							<div class="res_notice_icon">
								<div class="img"></div>
							</div>
							<div class="res_notice_desc">
								<p>${ptitleNotNullList.get(0).pcontents}</p>
							</div>
						</div>
						<c:if test = "${ptitleNotNullList.size() > 1}">
							<c:forEach var="rsPolicyDto" begin="1" end="${ptitleNotNullList.size() - 1}" step="1"
									   items="${ptitleNotNullList}">
								<div class="res_notice_block">
									<div class="res_notice_icon2">
										<div class="img2"></div>
									</div>
									<div class="res_notice_desc">
										<p>${rsPolicyDto.pcontents}</p>
									</div>
								</div>
							</c:forEach>
						</c:if>
					</div>
				</div>
				<hr class="seperator">
				</c:if>
				<!-- End Notices from restaurant -->

				<div class="facilities_icon">
					<div class="section-body pt-20">
						<div class="restaurant-features mb-20">
							<c:if test="${facilityDto.parking eq 1}">
								<span class="feature-item">
									<img src="https://dau2wmhjxkxtx.cloudfront.net/web-static/static_webapp_v2/img/icons-mood/ic_parking.svg" class="icon">
									<span class="label">Parking</span>
								</span>
							</c:if>
							<c:if test="${facilityDto.valet eq 1}">
								<span class="feature-item">
									<img src="https://dau2wmhjxkxtx.cloudfront.net/web-static/static_webapp_v2/img/icons-mood/ic_valet_parking.svg" class="icon">
									<span class="label">Valet</span>
								</span>
							</c:if>
							<c:if test="${facilityDto.corkage eq 1}">
								<span class="feature-item">
									<img src="https://dau2wmhjxkxtx.cloudfront.net/web-static/static_webapp_v2/img/icons-mood/ic_corkage.svg" class="icon">
									<span class="label">Corkage</span>
								</span>
							</c:if>
							<c:if test="${facilityDto.adultonly eq 1}">
								<span class="feature-item">
									<img src="https://dau2wmhjxkxtx.cloudfront.net/web-static/static_webapp_v2/img/icons-mood/ic_no_kids.svg" class="icon">
									<span class="label">Adult-Only</span>
								</span>
							</c:if>
							<c:if test="${facilityDto.sommelier eq 1}">
								<span class="feature-item">
									<img src="https://dau2wmhjxkxtx.cloudfront.net/web-static/static_webapp_v2/img/icons-mood/ic_sommelier.svg" class="icon">
									<span class="label">Sommelier</span>
								</span>
							</c:if>
							<c:if test="${facilityDto.lettering eq 1}">
								<span class="feature-item">
									<img src="https://catchtable.co.kr/web-static/static_webapp_v2/img/icons-mood/ic_lettering.svg" class="icon">
									<span class="label">Lettering</span>
								</span>
							</c:if>
							<c:if test="${facilityDto.rentals eq 1}">
								<span class="feature-item">
									<img src="https://catchtable.co.kr/web-static/static_webapp_v2/img/icons-mood/ic_rent.svg" class="icon">
									<span class="label">Rentals</span>
								</span>
							</c:if>
						</div>
					</div>
				</div>
				<hr class="seperator2">


				<div class="__notes ml--20 mr--20 open">
					<c:if test="${not empty facilityDto.parkingdesc}">
						<div class="__notes-item">
							<a class="__toggle">Parking</a>
							<div class="__note">
								<p>${facilityDto.parkingdesc}</p>
							</div>
						</div>
					</c:if>
					<c:if test="${not empty facilityDto.valetdesc}">
						<div class="__notes-item">
							<a class="__toggle">Valet</a>
							<div class="__note">
								<p>${facilityDto.valetdesc}</p>
							</div>
						</div>
					</c:if>
					<c:if test="${not empty facilityDto.corkagedesc}">
						<div class="__notes-item">
							<a class="__toggle">Corkage</a>
							<div class="__note">
								<p>${facilityDto.corkagedesc}</p>
							</div>
						</div>
					</c:if>
					<c:if test="${not empty facilityDto.adultonlydesc}">
						<div class="__notes-item">
							<a class="__toggle">Adult-Only</a>
							<div class="__note">
								<p>${facilityDto.adultonlydesc}</p>
							</div>
						</div>
					</c:if>
					<c:if test="${not empty facilityDto.sommelierdesc}">
						<div class="__notes-item">
							<a class="__toggle">Sommelier</a>
							<div class="__note">
								<p>${facilityDto.sommelierdesc}</p>
							</div>
						</div>
					</c:if>
					<c:if test="${not empty facilityDto.letteringdesc}">
						<div class="__notes-item">
							<a class="__toggle">Lettering</a>
							<div class="__note">
								<p>${facilityDto.letteringdesc}</p>
							</div>
						</div>
					</c:if>
					<c:if test="${not empty facilityDto.rentalsdesc}">
						<div class="__notes-item">
							<a class="__toggle">Rentals</a>
							<div class="__note">
								<p>${facilityDto.rentalsdesc}</p>
							</div>
						</div>
					</c:if>
				</div>
				<hr class="seperator">
			</div>
		</section>
		<!--================ Facilities Area  =================-->

		<!--================ Testimonial Area  =================-->
		<section class="testimonial_area section_gap">
			<div class="container">
				<!-- Start restaurant page menu-->
				<section class="section pt-30 pb-30">
					<div class="container gutter-sm">
						<div class="section-header">
							<h2 class="title_color">Menu</h2>
							<!-- <div class="utils">
								<a class="btn-all">More</a>
							</div> -->
						</div>
						<div class="section-body">
							<div class="menupan mb-20">
								<ul>
									<li><a href="#" class="tb">
											<div class="name">
												<h4>${shopDto.sname} LUNCH</h4>
											</div>
											<div class="price">${shopDto.lunchString}</div>
									</a></li>
									<li><a href="#" class="tb">
											<div class="name">
												<h4>${shopDto.sname} DINNER</h4>
											</div>
											<div class="price">${shopDto.dinnerString}</div>
									</a></li>
								</ul>
							</div>
						</div>
					</div>
				</section>
				<hr class="seperator">
				<!-- End restaurant page menu-->

				<!-- Start restuarant page reservation-->
				<section>
					<form name="reservationForm" action="/reservation_proc" method="post">
						<div class="hotel_booking_area position">
							<div class="container">
								<div class="hotel_booking_table">
									<div class="col-md-3">
										<h2>
											Book<br/> Your<br/> Table
										</h2>
									</div>
									<input type="hidden" id="sid" name="sid" value="${shopDto.sid}">
									<%-- <input type="hidden" id="smealfee" name="smealfee" value="${shopVo.smealfee}">
									<input type="hidden" id="sdeposit" name="sdeposit" value="${shopVo.sdeposit}"> --%>
									<div class="col-md-9">
										<div class="booking_table">
											<div class="row">
												<div class="col-md-4">
													<div class="book_tabel_item">
														<div class="form-group">
															<div class="input-group date" id="datepicker">
																<input type="text" class="form-control" placeholder="Date"
																	name="rdate" value="rdate" id="rdate"/>
																<span class="input-group-addon">
																	<i class="fa fa-calendar" aria-hidden="true"></i>
																</span>
															</div>
														</div>
														<div class="input-group">
															<select class="wide" name = "rtabletype" id="rtabletype" onchange="selectBoxRtabletype()">
																<option name = "rtabletype" value = "default" data-display="Seating Options">Seating Option</option>
															</select>
														</div>
													</div>
												</div>
												<div class="col-md-4">
													<div class="book_tabel_item">
														<div class="input-group reservation-page">
															<select class="wide" name ="guestnumber" id="guestnumber"
																onchange="selectBoxGuestnumber()">
																<option data-display="Party Size" value="default">Party Size</option>
															</select>
														</div>
														<div class="input-group">
															<select class="wide" name = "rtime" id="rtime"
																onchange="selectBoxRtime()">
																<option value = "default" data-display="Time">Time</option>
															</select>
														</div>
													</div>
												</div>
												<div class="col-md-4">
													<div class="book_tabel_item">
														<button type="button" class="theme_btn_two button_hover"
															style="margin-top: 35px;" id="btnReservation">Book Now</button>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</form>
				</section>
				<hr class="seperator">
				<!-- End restuarant page reservation-->

				<!-- Start restaurant page photo-->
				<section class="section pt-30 pb-30">
					<div class="container gutter-sm" style="margin:50px 0px;">
						<div class="section-header">
							<h2 class="title_color">
								Photos <span class="count">${totalReviewPhotoCount}</span>
							</h2>
							<!-- <div class="utils">
								<a class="btn-all">More</a>
							</div> -->
						</div>
						<div class="section-body">
							<div class="photo-grid-list">
								<c:forEach var="reviewDto" items="${reviewList}">
									<div class="photo-grid-list-item">
										<a class="tb">
											<div class="img">
												<img src="/upload/${reviewDto.reviewphoto}?small200"
													style="position: absolute; top: 0px; left: 0px; width: 100%; height: 100%;">
											</div>
										</a>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</section>
				<hr class="seperator">
				<!-- End restaurant page photo-->

				<!-- Start restaurant page recommended reviews-->
				<section class="section pt-30 pb-30">
					<div class="container gutter-sm">
						<div class="section-header mb-25">
							<h2 class="title_color">Recommended Reviews</h2>
							<!-- <div class="utils">
								<a class="btn-all">More</a>
							</div> -->
						</div>
						<div class="section-body">
							<div class="section-body">
								<div class="rating-summary mb-30">
									<div class="rating">
										<img src="/image/dayoung_img/star.svg.png">
											<span class="star">${starAvg}</span>
											<span class="count">(${totalReviewCount})</span>
									</div>
								</div>
								<div class="v-scroll">
									<div class="v-scroll-inner">
										<div class="review-post-list">
											<c:forEach var="reviewDto" items="${reviewList}">
												<a class="review-post-list-item">
													<div class="tb">
														<div class="img"
															style="background-image:
																	url('/upload/${reviewDto.reviewphoto}');"></div>
													</div>
													<div class="detail">
														<div class="post-meta">
															<div class="profile-pic">
																<div class="img"
																	style="background-image: url('https://catchtable.co.kr/web-static/static_webapp_v2/img/noimg/profile_default_v2.png');"></div>
															</div>
															<div class="profile">
																<h4 class="name username">
																	<span class="txt">${reviewDto.mname}</span>
																</h4>
																<span class="date">${reviewDto.reviewcreatedate}</span>
															</div>
															<div class="rating">
																<span class="star">${reviewDto.reviewstar}</span>
															</div>
														</div>
														<div class="comment-area">
															<p class="excerpt">
																${reviewDto.reviewcontent}
															</p>
														</div>
													</div>
												</a>
											</c:forEach>
											<!-- <div class="showall">
												<a href="#" class="arrow"> <span>More</span>
												</a>
											</div> -->
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>
				<hr class="seperator">
				<!-- End restaurant page recommended reviews-->

				<!-- Start restaurant page Location -->
				<section class="section">
					<div class="container gutter-sm">
						<div class="section-header">
							<h2 class="title_color">Location</h2>
						</div>
						<div id="map" style="width:500px; height:400px;"></div>
						<div class="section-body">
							<div class="location-map">
								<div class="addr" style="padding: 0px 20px;">
									<br>
									<p>${shopDto.sloc}</p>
									<a href="#" class="btn-copy" style="padding-top: 4px;">Copy</a>
								</div>
							</div>
						</div>
					</div>
				</section>
				<hr class="seperator2">
				<!-- End restaurant page Location -->

				<!-- Start restaurant page Detailed Information -->
				<section class="section">
					<div class="container gutter-sm pb-20">
						<div class="section-header">
							<h2 class="title_color">Detailed Information</h2>
						</div>
						<div class="section-body">
							<div class="desc-blocks" style="word-break: break-word;">
								<div class="desc-block">
									<dl>
										<dt>Phone Number</dt>
										<dd>${shopDto.sphone}</dd>
									</dl>
									<!-- <div class="action">
										<a class="btn-call"><span>Call</span></a>
									</div> -->
								</div>
								<div class="desc-block">
									<dl>
										<dt>About Us</dt>
										<dd>${shopDto.sintro}</dd>
									</dl>
								</div>
								<div class="desc-block">
									<dl>
										<dt>Closing Day</dt>
										<dd>${shopDto.sclosingdate}</dd>
									</dl>
								</div>
								<div class="desc-block">
									<dl>
										<dt>Business Hours</dt>
										<dd>
											${shopDto.sopeninghour} ~ ${shopDto.sclosinghour}
											<!-- <br>
											Break time 15:30~18:00
											<br>
											Last order 13:30 &amp; 20:00 -->
										</dd>
									</dl>
								</div>
								<div class="desc-block">
									<dl>
										<dt>Notes</dt>
										<dd>
											<c:forEach var="rsPolicyDto" items="${rsPolicyList}">
												*${rsPolicyDto.pcontents}<br>
											</c:forEach>
										</dd>
									</dl>
								</div>
							</div>
						</div>
					</div>
				</section>
				<hr class="seperator2">
				<!-- End restaurant page Detailed Information -->

			</div>
		</section>
		<hr class="seperator">
		<!--================ Testimonial Area  =================-->

		<!--================ start footer Area  =================-->
		<footer class="footer-area section_gap"
			style="padding: 50px 0 0 0; background: rgb(255, 61, 0)">
			<div class="container">
				<div class="row">
					<div class="col-lg-3  col-md-6 col-sm-6 footer-widget1"
						style="padding-right: 50px; width:370px;">
						<div class="single-footer-widget single-footer-widget-left">
							<h6 class="footer_title">About Agency</h6>
							<p style="color: white">
								WAD Corp. <br> Address: A-605, 660, Daewangpangyo-ro,
								Bundang-gu, Seongnam-si, Gyeonggi-do, Republic of Korea <br>
								Business registration number: 614-88-00597 <br> Online
								marketing business report number: 2017-Seongnam Bundang-0933 <br>
								Personal information responsible: service@catchtable.co.kr <br>
								Terms of Service | Privacy policy | Terms of Location Service
							</p>
						</div>
					</div>
					<div class="col-lg-3 col-md-6 col-sm-6 footer-widget2"
						style="width: 300px">
						<div class="single-footer-widget">
							<h6 class="footer_title">Newsletter</h6>
							<p style="color: white">For business professionals caught
								between high OEM price and mediocre print and graphic output,</p>
							<div id="mc_embed_signup">
								<form target="_blank"
									action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
									method="get" class="subscribe_form relative">
									<div class="input-group d-flex flex-row">
										<input name="EMAIL" placeholder="Email Address"
											onfocus="this.placeholder = ''"
											onblur="this.placeholder = 'Email Address '" required=""
											type="email">
										<button class="btn sub-btn">
											<span class="lnr lnr-location"></span>
										</button>
									</div>
									<div class="mt-10 info"></div>
								</form>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-6 col-sm-6 footer-widget3"
						style="width: 300px">
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
				<div
					class="row footer-bottom d-flex justify-content-between align-items-center">
					<p class="col-lg-8 col-sm-12 footer-text m-0">
				</div>
			</div>
		</footer>
		<!--================ End footer Area  =================-->

		<!-- Optional JavaScript -->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="/vendors/owl-carousel/owl.carousel.min.js"></script>
		<script src="/js/jquery.ajaxchimp.min.js"></script>
		<script src="/vendors/nice-select/js/jquery.nice-select.js"></script>
		<script src="/js/mail-script.js"></script>
		<script src="/js/stellar.js"></script>
		<script src="/vendors/lightbox/simpleLightbox.min.js"></script>
		<script src="/js/custom.js"></script>
		<script>
			var dayoff = "${shopDto.sclosingdate}";
			$(document).ready(function(){
				var dayoffnum = -1;
				var weekday = new Array(7);
				weekday[0] = "SUNDAY";
				weekday[1] = "MONDAY";
				weekday[2] = "TUESDAY";
				weekday[3] = "WEDNESDAY";
				weekday[4] = "THURSDAY";
				weekday[5] = "FREIDAY";
				weekday[6] = "SATURDAY";
				for(var i = 0; i < 7; i++){
					if(weekday[i] === dayoff){
						dayoffnum = i;
						break;
					}
				}

				$('#datepicker').datepicker({
					format : "yyyy-mm-dd",
					startDate: '0d',
					endDate: '+1m',
					todayHighlight: true,
					daysOfWeekDisabled: [dayoffnum] // 월요일(1) 비활성화
				}).datepicker("setDate", new Date());

			});
		</script>

		<!-- Kako Map -->
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fb222ca455cfb2afe3fb2c4341112dbb"></script>
        <script>
	        var container = document.getElementById('map');
	        var options = {
	            center: new kakao.maps.LatLng(33.450701, 126.570667),
	            level: 3
	        	};
	        var map = new kakao.maps.Map(container, options);
        </script>
	</body>
</html>