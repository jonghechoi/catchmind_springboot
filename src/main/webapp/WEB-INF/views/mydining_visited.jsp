<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" href="resources/image/catchcon.png" type="image/png">
        <title>Catch Mind</title>
        <!-- Bootstrap CSS -->
        <script src="resources/js/jquery-3.6.4.min.js"></script>
        <script src="resources/js/catchmind_hyeonsoo.js"></script>
        <script src="resources/js/am-pagination.js"></script>
        <script src="resources/js/paging_visited.js"></script>
        <link rel="stylesheet" href="resources/css/bootstrap.css">
        <link rel="stylesheet" href="resources/vendors/linericon/style.css">
        <link rel="stylesheet" href="resources/css/font-awesome.min.css">
        <link rel="stylesheet" href="resources/vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.css">
        <link rel="stylesheet" href="resources/vendors/nice-select/css/nice-select.css">
        <link rel="stylesheet" href="resources/vendors/owl-carousel/owl.carousel.min.css">
        <!-- main css -->
        <link rel="stylesheet" href="resources/css/am-pagination.css">
        <link rel="stylesheet" href="resources/css/style.css">
		<link rel="stylesheet" href="resources/css/jhsStyle.css">
        <link rel="stylesheet" href="resources/css/responsive.css">
        
        
        <script>
        	let review_write = "${reviewWrite}"
        	if(review_write === "ok") {
        		alert("Complete the review");
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
                            <li class="nav-item submenu dropdown active">
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
	                                <a href="shop_reservation.do" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Shop</a>
	                                <ul class="dropdown-menu">
	                                    <li class="nav-item active"><a class="nav-link" href="shop_information.do?sid=${sessionScope.sessionVo.sid}">Register</a></li>
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
                    <h2 class="page-cover-tittle">My Dining</h2>
                    <ol class="breadcrumb">
                        <li class="active">Visited</li>
                        <li><a href="mydining_scheduled.do">Scheduled</a></li> <!-- 링크로 넘어갈때 mid 가져가야함  -->
                    </ol>
                </div>
            </div>
        </section>
        <!--================Breadcrumb Area =================-->
        
        <!--================ Accomodation Area  =================-->
        <section class="accomodation_area section_gap">
            <div class="container">
                <div class="section_title text-center">
                    <h2 class="title_color">Visit completed</h2>
                    <p>Thank you for using it. Please write a review</p>
                </div>
                <p id="pooo"></p>
                <%-- <div class="row mb_30">
                <c:forEach var="scheduledVo" items="${visitedList}">
                    <div class="col-lg-3 col-sm-6">
                        <div class="accomodation_item text-center">
                            <div class="hotel_img">
                                <img src="${scheduledVo.smphoto}" width="262px"; height="272px"; alt="">
                                <c:choose>
                                	 <c:when test="${scheduledVo.reviewYN == 'N'}">
	                               		 <a href="write_review.do?sid=${scheduledVo.sid}&mid=${scheduledVo.mid}&rid=${scheduledVo.rid}" class="btn theme_btn button_hover">Write Review</a>
                                	 </c:when>
                                	  <c:when test="${scheduledVo.reviewYN == 'Y'}">
	                               		 <a href="mypage_review.do?${scheduledVo.sid}&mid=${scheduledVo.mid}" class="btn theme_btn button_hover" style="padding: 5px 1px;">My Review Check</a>
                                	  </c:when>
                                </c:choose>
                            </div>
                            <img src="resources/image/jhs_img/1000_F_412408259_m13MpFAxpttIh3jxxsRl3rbsbS5SjnVL.jpg" width="20px"; height="20px"; >
                            <a href="#"><h4 class="sec_h4">${scheduledVo.sname }</h4></a>
                            <h5>${scheduledVo.rdate }<br> ${scheduledVo.rtime } - ${scheduledVo.guestNumber } People <br><small>${scheduledVo.slocShort}</small></h5>
                        </div>
                    </div>
                </c:forEach>
                </div> --%>
            </div>
        </section>
        <!--================ Accomodation Area  =================-->
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
        
        
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <!-- <script src="resources/js/jquery-3.2.1.min.js"></script> -->
        <script src="resources/js/popper.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="resources/vendors/owl-carousel/owl.carousel.min.js"></script>
        <script src="resources/js/jquery.ajaxchimp.min.js"></script>
        <script src="resources/vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.js"></script>
        <script src="resources/vendors/nice-select/js/jquery.nice-select.js"></script>
        <script src="resources/js/mail-script.js"></script>
        <script src="resources/js/stellar.js"></script>
        <script src="resources/vendors/lightbox/simpleLightbox.min.js"></script>
        <script src="resources/js/custom.js"></script>
    </body>
</html>