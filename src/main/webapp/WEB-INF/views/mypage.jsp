<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" href="/image/favicon.png" type="image/png">
        <title>Catch Mind</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="/css/bootstrap.css">
        <link rel="stylesheet" href="/vendors/linericon/style.css">
        <link rel="stylesheet" href="/css/font-awesome.min.css">
        <link rel="stylesheet" href="/vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.css">
        <link rel="stylesheet" href="/vendors/nice-select/css/nice-select.css">
        <link rel="stylesheet" href="/vendors/owl-carousel/owl.carousel.min.css">
        <link rel="stylesheet" href="/vendors/lightbox/simpleLightbox.css">
        <!-- main css -->
        <link rel="stylesheet" href="/css/style.css">
       	<link rel="stylesheet" href="/css/lsm.css">
        <link rel="stylesheet" href="/css/responsive.css">
    </head>
	<script>
			let logout_result = "${logout_result }";
			
			if(logout_result == 'ok'){
				alert("로그아웃 되었습니다.");
			}
		
	</script>
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
                            <li class="nav-item"><a class="nav-link" href="/index">HOME</a></li>
                            <li class="nav-item"><a class="nav-link" href="/search">SEARCH</a></li>
                             <li class="nav-item submenu dropdown">
                                <a href="mydining_scheduled" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">MYDINING</a>
                                <ul class="dropdown-menu">
                                    <li class="nav-item active"><a class="nav-link" href="mydining_scheduled">Scheduled</a></li>
                                    <li class="nav-item"><a class="nav-link" href="mydining_visited">Visited</a></li>
                                </ul>
                            </li> 
                            <li class="nav-item"><a class="nav-link active" href="/mypage">My Page</a></li>
                            <li class="nav-item"><a class="nav-link" href="/notice">Notice</a></li>
                            <c:if test="${sessionScope.sessionVo.roleId =='SHOP' or sessionScope.sessionVo.roleId == 'ADMIN'}">
	                            <li class="nav-item submenu dropdown">
	                                <a href="shop_reservation" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Shop</a>
	                                <ul class="dropdown-menu">
	                                    <li class="nav-item"><a class="nav-link" href="shop_information?sid=${sessionScope.sessionVo.sid}">Register</a></li>
	                                    <!-- <li class="nav-item active" id="shop_information">Register</li> -->
	                                    <li class="nav-item"><a class="nav-link" href="shop_reservation?sid=${sessionScope.sessionVo.sid}">Reservation</a></li>
	                                </ul>
	                            </li>
                            </c:if>     
                            <c:if test="${sessionScope.sessionVo.roleId == 'ADMIN'}">                
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
            <div class="overlay bg-parallax" data-stellar-ratio="0.8" data-stellar-vertical-offset="0" data-background=""></div>
            <div class="container">
                <div class="page-cover text-center">
                    <h2 class="page-cover-tittle">MY PAGE</h2>
                    <ol class="breadcrumb">
                        <li><a href="index">Home</a></li>
                        <li class="active">MY PAGE</li>
                    </ol>
                </div>
            </div>
        </section>
        <!--================Breadcrumb Area =================-->
 		<section class="mypage">
			<div class="accomodation_item text-center">
			<div>
				
			<h4 class="name username">${memberList.mname}</h4>
			<p id="introduce_p" class="expand"> Catch Mind <br></p>
			<body>
			    <!-- <button class="btn btn-edit-profile">Edit Profile</button> -->
			    <button class="btn btn-favorites">Favorites</button>
			    <button class="btn btn-my-review">My Review</button>
			    <br>
			    <br>
			    <br>
			    <a href="logout"><button class="btn btn-sign-out">Sign out</button></a>
			    <script>
			        // Edit Profile 버튼 클릭 시 동작
			       /*  document.querySelector('.btn-edit-profile').addEventListener('click', function() {
			            // 페이지 이동을 위한 URL 설정
			            var editProfileURL = 'mypage_editprofile';
			            // 페이지 이동
			            window.location.href = editProfileURL;
			        }); */
			
			        // Favorites 버튼 클릭 시 동작
			        document.querySelector('.btn-favorites').addEventListener('click', function() {

			            // 페이지 이동을 위한 URL 설정
			            //var favoritesURL = 'mypage_favorites/';
			            // 페이지 이동
			            var loggedInUser = getLoggedInUser();
			            var mid = loggedInUser.mid;
			            var favoritesURL = 'mypage_favorites/' + mid + '/';
			            window.location.href = favoritesURL;
			        });
			         function getLoggedInUser() {
			        	return {
			        		mid: "${sessionScope.sessionVo.mid}"
			        };
			        }
			
			        // My Review 버튼 클릭 시 동작
			        document.querySelector('.btn-my-review').addEventListener('click', function() {
			            // 페이지 이동을 위한 URL 설정
			            //var myReviewURL = 'mypage_review?mid=MID';
			            // 페이지 이동
			            window.location.href = myReviewURL;
			        	var loggedInUser = getLoggedInUser();
			            var mid = loggedInUser.mid;
			        	//var reviewId = 'REVIEW_0001';
			        	var myReviewURL = 'mypage_review/' + mid  + '/';
			        	//alert(myReviewURL);
			        	window.location.href = myReviewURL;
			        });
			        function getLoggedInUser() {
			        
			            return {
			                mid: "${sessionScope.sessionVo.mid}"
			            };
			        }
			        function getReviewData() {
			            return {
			                reviewId: 'REVIEW_0003'
			            };
			        } 
			        
			        
			    </script>
			</body>	
						</div>
						</div>
					</section>
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
        <script src="/vendors/imagesloaded/imagesloaded.pkgd.min.js"></script>
        <script src="/vendors/isotope/isotope-min.js"></script>
        <script src="/js/stellar.js"></script>
        <script src="/vendors/lightbox/simpleLightbox.min.js"></script>
        <script src="/js/custom.js"></script>
    </body>
</html>