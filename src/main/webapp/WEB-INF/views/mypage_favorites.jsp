<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" href="image/favicon.png" type="image/png">
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
<script>
	function bookmark(fid){
		location.href = "bookmark_delete_proc?fid="+fid+"&mid=${mid}";
		
	}
</script>	
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
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
                           <li class="nav-item"><a class="nav-link" href="index">HOME</a></li>
                            <li class="nav-item"><a class="nav-link" href="search">SEARCH</a></li>
                             <li class="nav-item submenu dropdown">
                                <a href="mydining_scheduled" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">MYDINING</a>
                                <ul class="dropdown-menu">
                                    <li class="nav-item active"><a class="nav-link" href="mydining_scheduled">Scheduled</a></li>
                                    <li class="nav-item"><a class="nav-link" href="mydining_visited">Visited</a></li>
                                </ul>
                            </li> 
                            <li class="nav-item"><a class="nav-link active" href="mypage">My Page</a></li>
                            <li class="nav-item"><a class="nav-link" href="notice">Notice</a></li>
                            <c:if test="${sessionScope.sessionVo.roleId =='SHOP' or sessionScope.sessionVo.roleId == 'ADMIN'}">
	                            <li class="nav-item submenu dropdown">
	                                <a href="shop_reservation" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Shop</a>
	                                <ul class="dropdown-menu">
	                                    <li class="nav-item"><a class="nav-link" href="shop_information?sid=${sessionScope.sessionVo.sid}">Register</a></li>
	                                    <!-- <li class="nav-item active" id="shop_information">Register</li> -->
	                                    <li class="nav-item"><a class="nav-link" href="shop_reservation?sid=S${sessionScope.sessionVo.sid}">Reservation</a></li>
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
                    <h2 class="page-cover-tittle">My Favorites</h2>
                    <ol class="breadcrumb">
                        <li>My PAGE</li>
                        <li class="active">My Favorites</li>
                    </ol>
                </div>
            </div>
        </section>
        <!--================Breadcrumb Area =================-->
        
		        <head>
		  <meta charset="UTF-8">
		  <title>카카오 공유하기</title>
		</head>
		<body>
		  <!-- 카카오 공유하기 버튼 -->

		  <!-- 카카오 SDK 스크립트 -->
		  <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
		  <script>
		    // 카카오 JavaScript 키 설정
		    Kakao.init('adacb7319ef90251f888ca7acb9c479d');
		
		    // 카카오 공유하기 함수
		    function shareKakao() {
		      Kakao.Link.sendDefault({
		        objectType: 'feed',	
		        content: {
		          title: '',
		          description: 'ZERO COMPLEX',
		          imageUrl: 'https://image.toast.com/aaaaaqx/catchtable/shopinfo/s716/716_19112817413723085.jpg',
		          link: {
		            webUrl: 'https://www.catchtable.net/shop/zerocomplex',
		            mobileWebUrl: '모바일 웹사이트 URL'
		          }
		        }
		      });
		    }
		    function shareKakao() {
			      Kakao.Link.sendDefault({
			        objectType: 'feed',	
			        content: {
			          title: '',
			          description: 'On6.5',
			          imageUrl: 'https://image.toast.com/aaaaaqx/catchtable/shopinfo/s47jHT01fp_nCI0cT-mo03Q/47jht01fp_nci0ct-mo03q_2210422223601797.png',
			          link: {
			            webUrl: 'https://www.catchtable.net/shop/on65',
			            mobileWebUrl: '모바일 웹사이트 URL'
			          }
			        }
			      });
			    }
		    function shareKakao() {
			      Kakao.Link.sendDefault({
			        objectType: 'feed',	
			        content: {
			          title: '',
			          description: 'JL Dessert Bar',
			          imageUrl: 'https://image.toast.com/aaaaaqx/catchtable/shopinfo/soBe_yC58BHX5nFzOdCBvkg/obe_yc58bhx5nfzodcbvkg_22122915183140452.jpg',
			          link: {
			            webUrl: 'https://www.catchtable.net/shop/jldessertbar',
			            mobileWebUrl: '모바일 웹사이트 URL'
			          }
			        }
			      });
			    }
		  </script>
		</body>
        
        <!--================ Accomodation Area  =================-->
        
        <section class="accomodation_area section_gap">
        <!-- <p style="text-align:right""min-width:-150px"><img src="http://localhost:9000/test1/royal-master/image/catch/free-icon-kakao-talk-3669973 (1).png"> -->
            <div class="container">
                <div class="section_title text-center">
                    <h2 class="title_color">Favorites</h2>
                </div>
                <div class="row mb_30">
                    <c:forEach var="favoritesVo" items="${favoritesList}">
                    <div class="col-lg-3 col-sm-6">
                        <div class="accomodation_item text-center">
                            <div class="hotel_img sang">
                           <button type="button" id = "bookmark" onclick = "bookmark('${favoritesVo.fid}')" class="btnMark"><img src="resources/image/catch/free-icon-bookmark-4436444.png"></button>
                           <a id="kakao-share-btn" href="javascript:;" onclick="shareKakao()"><img src="/image/catch/free-icon-kakao-talk-3669973 (1).png" alt="카카오 공유하기" style="float: right;"></a>
                            <img src="${favoritesVo.smphoto}" width="262px"; height="272px"; alt="">
                            </div>
                            <a href="#"><h4 class="sec_h4">${favoritesVo.sname}</h4></a>
                            <div>
                            <h5>${favoritesVo.fmemo}</h5>
                            </div>
                            <span>Lunch ${favoritesVo.lunch}</span><br>
                            <span>Dinner ${favoritesVo.dinner}</span>
                            
                            
                        </div>
                    </div>
					<!-- 북마크 모달 -->
					<!--<div class="modal fade" id="bookmarkModal" tabindex="-1" role="dialog" aria-labelledby="bookmarkModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-body">
					        Remove from 'Favorites'.
					      </div>
					    </div>
					  </div>
					</div>-->
				</c:forEach>
					<script>
				    /* // 모달 자동 닫힘을 위한 함수
				    function hideModal() {
				        $('#bookmarkModal').modal('hide');  // 모달을 숨깁니다.
				    }
				    // 모달 자동 닫힘 타이머 설정 (2초 후에 모달이 자동으로 닫힙니다)
				    setTimeout(hideModal, 2000); */
					</script>
					

<!--                    <div class="col-lg-3 col-sm-6">
                        <div class="accomodation_item text-center">
                            <div class="hotel_img sang">
                            <button type="button" class="btnMark" data-toggle="modal" data-target="#bookmarkModal"><img src="resources/image/catch/free-icon-bookmark-4436444.png"></button>
                            <a id="kakao-share-btn" href="javascript:;" onclick="shareKakao()"><img src="resources/image/catch/free-icon-kakao-talk-3669973 (1).png" alt="카카오 공유하기" style="float: right;"></a>
                                <img src="resources/image/catch/22126_21102813524536236.jpg" width="262px"; height="272px"; alt="">
                            </div>
                            <a href="#"><h4 class="sec_h4">Haejindwi</h4></a>
                            <h5>Korean omakase along with traditional spirits<br>
                            <small>Korean • Mangwon</small></h5>
                            <span class="lunch" style="margin-right: 10px;"> 40,000~45,000</span>
                        </div>
                    </div>
					<div class="modal fade" id="bookmarkModal" tabindex="-1" role="dialog" aria-labelledby="bookmarkModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-body">
					        Remove from 'Favorites'.
					      </div>
					    </div>
					  </div>
					</div>
					<script>
				    // 모달 자동 닫힘을 위한 함수
				    function hideModal() {
				        $('#bookmarkModal').modal('hide');  // 모달을 숨깁니다.
				    }
				    // 모달 자동 닫힘 타이머 설정 (2초 후에 모달이 자동으로 닫힙니다)
				    setTimeout(hideModal, 2000);
					</script>
					
                    <div class="col-lg-3 col-sm-6">
                        <div class="accomodation_item text-center">
                            <div class="hotel_img sang">
                            <button type="button" class="btnMark" data-toggle="modal" data-target="#bookmarkModal"><img src="resources/image/catch/free-icon-bookmark-4436444.png"></button>
                            <a id="kakao-share-btn" href="javascript:;" onclick="shareKakao()"><img src="resources/image/catch/free-icon-kakao-talk-3669973 (1).png" alt="카카오 공유하기" style="float: right;"></a>
                                <img src="resources/image/catch/18828_2012715032683492.jpeg" width="262px"; height="272px"; alt="">
                            </div>
                            <a href="#"><h4 class="sec_h4">Sushi Mito</h4></a>
                            <h5>cozy Ginza style sushi place by the Chef Yoon Sang-hum<br>
                            <small>Sushi Omakase • Eulji-ro</small></h5>
                            <span class="lunch" style="margin-right: 10px;"> 70,000~130,000</span>
                        </div>
                    </div>
					<div class="modal fade" id="bookmarkModal" tabindex="-1" role="dialog" aria-labelledby="bookmarkModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-body">
					        Remove from 'Favorites'.
					      </div>
					    </div>
					  </div>
					</div>
					<script>
				    // 모달 자동 닫힘을 위한 함수
				    function hideModal() {
				        $('#bookmarkModal').modal('hide');  // 모달을 숨깁니다.
				    }
				    // 모달 자동 닫힘 타이머 설정 (2초 후에 모달이 자동으로 닫힙니다)
				    setTimeout(hideModal, 2000);
					</script>
					
                     <div class="col-lg-3 col-sm-6">
                        <div class="accomodation_item text-center">
                            <div class="hotel_img sang">
                            <button type="button" class="btnMark" data-toggle="modal" data-target="#bookmarkModal"><img src="resources/image/catch/free-icon-bookmark-4436444.png"></button>
                            <a id="kakao-share-btn" href="javascript:;" onclick="shareKakao()"><img src="resources/image/catch/free-icon-kakao-talk-3669973 (1).png" alt="카카오 공유하기" style="float: right;"></a>
                                <img src="resources/image/catch/18529_2211917184585475.png" width="262px"; height="272px"; alt="">
                            </div>
                            <a href="#"><h4 class="sec_h4">Yookiljeom</h4></a>
                            <h5>Online reservation for pork omakase (minimum 4 people)<br>
                            <small>Gangnam-gu • Grilled Pork</small></h5>
                            <span class="lunch" style="margin-right: 10px;"> 10,000~90,000</span>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="accomodation_item text-center">
                            <div class="hotel_img sang">
                            <button type="button" class="btnMark" data-toggle="modal" data-target="#bookmarkModal"><img src="resources/image/catch/free-icon-bookmark-4436444.png"></button>
                            <a id="kakao-share-btn" href="javascript:;" onclick="shareKakao()"><img src="resources/image/catch/free-icon-kakao-talk-3669973 (1).png" alt="카카오 공유하기" style="float: right;"></a>
                                <img src="resources/image/catch/gmhehc80605orfu_cvzqaa_235412024474168.jpeg" width="262px"; height="272px"; alt="">
                            </div>
                            <a href="#"><h4 class="sec_h4">TITOLO</h4></a>
                            <h5>Chef Totti's<br>
                             Italian Wine Bar<br>
                            <small>Italian • Cheongdam</small></h5>
                            <span class="lunch" style="margin-right: 10px;"> 10,000~50,000</span>
                        </div>
                    </div>
					<div class="modal fade" id="bookmarkModal" tabindex="-1" role="dialog" aria-labelledby="bookmarkModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-body">
					        Remove from 'Favorites'.
					      </div>
					    </div>
					  </div>
					</div>
					<script>
				    // 모달 자동 닫힘을 위한 함수
				    function hideModal() {
				        $('#bookmarkModal').modal('hide');  // 모달을 숨깁니다.
				    }
				
				    // 모달 자동 닫힘 타이머 설정 (2초 후에 모달이 자동으로 닫힙니다)
				    setTimeout(hideModal, 2000);
					</script>
					
                    <div class="col-lg-3 col-sm-6">
                        <div class="accomodation_item text-center">
                            <div class="hotel_img sang">
                            <button type="button" class="btnMark" data-toggle="modal" data-target="#bookmarkModal"><img src="resources/image/catch/free-icon-bookmark-4436444.png"></button>
                            <a id="kakao-share-btn" href="javascript:;" onclick="shareKakao()"><img src="resources/image/catch/free-icon-kakao-talk-3669973 (1).png" alt="카카오 공유하기" style="float: right;"></a>
                                <img src="resources/image/catch/24557_2251212334272173.jpeg" width="262px"; height="272px"; alt="">
                            </div>
                            <a href="#"><h4 class="sec_h4">Tous Tous, Seonyu</h4></a>
                            <h5> brunch cafe that pursues healthy ingredients<br>
                            <small>Brunch • Seonyudo</small></h5>
                            <span class="lunch" style="margin-right: 10px;"> 20,000~40,000</span>
                        </div>
                    </div>
					<div class="modal fade" id="bookmarkModal" tabindex="-1" role="dialog" aria-labelledby="bookmarkModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-body">
					        Remove from 'Favorites'.
					      </div>
					    </div>
					  </div>
					</div>
					<script>
				    // 모달 자동 닫힘을 위한 함수
				    function hideModal() {
				        $('#bookmarkModal').modal('hide');  // 모달을 숨깁니다.
				    }
				
				    // 모달 자동 닫힘 타이머 설정 (2초 후에 모달이 자동으로 닫힙니다)
				    setTimeout(hideModal, 2000);
					</script>
					
                    <div class="col-lg-3 col-sm-6">
                        <div class="accomodation_item text-center">
                            <div class="hotel_img sang">
                            <button type="button" class="btnMark" data-toggle="modal" data-target="#bookmarkModal"><img src="resources/image/catch/free-icon-bookmark-4436444.png"></button>
                            <a id="kakao-share-btn" href="javascript:;" onclick="shareKakao()"><img src="resources/image/catch/free-icon-kakao-talk-3669973 (1).png" alt="카카오 공유하기" style="float: right;"></a>
                                <img src="resources/image/catch/18733_216916310301066.png" width="262px"; height="272px"; alt="">
                            </div>
                            <a href="#"><h4 class="sec_h4">Sushi Sangnam</h4></a>
                            <h5>private sushi place without a signboard<br>
                            <small>Sushi Omakase • Hannam</small></h5>
                            <span class="lunch" style="margin-right: 10px;"> 130,000~230,000</span>
                        </div>
                    </div>
					<div class="modal fade" id="bookmarkModal" tabindex="-1" role="dialog" aria-labelledby="bookmarkModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-body">
					        Remove from 'Favorites'.
					      </div>
					    </div>
					  </div>
					</div>
					<script>
				    // 모달 자동 닫힘을 위한 함수
				    function hideModal() {
				        $('#bookmarkModal').modal('hide');  // 모달을 숨깁니다.
				    }
				
				    // 모달 자동 닫힘 타이머 설정 (2초 후에 모달이 자동으로 닫힙니다)
				    setTimeout(hideModal, 2000);
					</script>
					
                    <div class="col-lg-3 col-sm-6">
                        <div class="accomodation_item text-center">
                            <div class="hotel_img sang">
                            <button type="button" class="btnMark" data-toggle="modal" data-target="#bookmarkModal"><img src="resources/image/catch/free-icon-bookmark-4436444.png"></button>
                            <a id="kakao-share-btn" href="javascript:;" onclick="shareKakao()"><img src="resources/image/catch/free-icon-kakao-talk-3669973 (1).png" alt="카카오 공유하기" style="float: right;"></a>
                                <img src="resources/image/catch/24345_225222244064978.jpg" width="262px"; height="272px"; alt="">
                            </div>
                            <a href="#"><h4 class="sec_h4">HANWOOMOOL</h4></a>
                            <h5>Korean beef course restaurant located in Quinon-gil, Itaewon.<br>
                            <small>Course DISH • Itaewon</small></h5>
                        <span class="lunch" style="margin-right: 10px;"> 30,000~40,000</span>
                        </div>
                    </div>
					<div class="modal fade" id="bookmarkModal" tabindex="-1" role="dialog" aria-labelledby="bookmarkModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-body">
					        Remove from 'Favorites'.
					      </div>
					    </div>
					  </div>
					</div>
					<script>
				    // 모달 자동 닫힘을 위한 함수
				    function hideModal() {
				        $('#bookmarkModal').modal('hide');  // 모달을 숨깁니다.
				    }
				
				    // 모달 자동 닫힘 타이머 설정 (2초 후에 모달이 자동으로 닫힙니다)
				    setTimeout(hideModal, 2000);
				 </script>
-->				 
				
                </div>
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
        <script src="js/custom.js"></script>
    </body>
</html>