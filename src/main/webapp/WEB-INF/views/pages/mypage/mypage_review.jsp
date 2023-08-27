<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" href="image/catchcon.png" type="image/png">
    <title>CatchMind</title>
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
        $(document).ready(function(){
            $()
        });
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
                    <li class="nav-item"><a class="nav-link" href="/index">HOME</a></li>
                    <li class="nav-item"><a class="nav-link" href="/search">SEARCH</a></li>
                    <li class="nav-item submenu dropdown">
                        <a href="mydining_scheduled" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">MYDINING</a>
                        <ul class="dropdown-menu">
                            <li class="nav-item active"><a class="nav-link" href="/mydining_scheduled">Scheduled</a></li>
                            <li class="nav-item"><a class="nav-link" href="/mydining_visited">Visited</a></li>
                            <li class="nav-item"><a class="nav-link" href="/mydining_cancel_noshow">Cancel / No-Show</a></li>
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
            <h2 class="page-cover-tittle">My Review</h2>
            <ol class="breadcrumb">
                <li>My PAGE</li>
                <li class="active">My Review</li>
            </ol>
        </div>
    </div>
</section>
<!--================Breadcrumb Area =================-->

<!--================ Accomodation Area  =================-->
<section class="accomodation_area section_gap">
    <div class="container">
        <div class="section_title text-center">
            <h2 class="title_color">My Review</h2>
        </div>
        <div class="row mb_30">
            <c:forEach var="reviewVo" items="${reviewList}">
                <div class="col-lg-3 col-sm-6">
                    <div class="accomodation_item text-center">
                        <div class="hotel_img">
                            <img src="http://localhost:9000/upload/${reviewVo.reviewsphoto }" width="262px" height="272px" alt="">
                        </div>
                        <a href="#"><h4 class="sec_h4">${reviewVo.sname}</h4></a>

                        <span class="__date">${reviewVo.reviewcreatedate}</span><span class="star">${reviewVo.reviewstar }</span>
                        <h5>${reviewVo.reviewcontent}
                            <small></small></h5>
<%--                        <a href="/write_review/${reviewVo.rid}">Edit Review</a>--%>

                    </div>
                </div>
            </c:forEach>
            <%--                    <c:if test="${sessionScope.sessionVo.roleId =='mypage_review' or sessionScope.sessionVo.roleId == 'mydining_visited'}">--%>
            <%--                    <li class="nav-item submenu dropdown">--%>
            <%--                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">mypage_review</a>--%>
            <%--                        <ul class="dropdown-menu">--%>
            <%--                            <li class="nav-item active"><a class="nav-link" href="shop_information.do?sid=${sessionScope.sessionVo.sid}">mypage_review</a></li>--%>
            <%--                            <li class="nav-item"><a class="nav-link" href="shop_reservation.do?sid=${sessionScope.sessionVo.sid}">mypage_review</a></li>--%>
            <%--                        </ul>--%>
            <%--                    </li>--%>
            <%--                </c:if>--%>

            <!-- <div class="col-lg-3 col-sm-6">
                <div class="accomodation_item text-center">
                    <div class="hotel_img"><a href="#" ="btn-bookmark active"></a>
                        <img src="resources/image/catch/230507151506597(1).jpeg" width="262px"; height="272px"; alt="">
                    </div>
                    <a href="#"><h4 class="sec_h4">L'Amant Secret</h4></a>
                    <span class="__date">Apr 21, 2022</span>    <span class="star">★ 4.8</span>
                    <h5>guided me to a private room, were kind and responsive from, and I enjoyed the meal<br>
                    <small></small></h5>
                </div>
            </div>
            <div class="col-lg-3 col-sm-6">
                <div class="accomodation_item text-center">
                    <div class="hotel_img"><a href="#" ="btn-bookmark active"></a>
                        <img src="resources/image/catch/2357191245568_rv.jpg" width="262px"; height="272px"; alt="">
                    </div>
                    <a href="#"><h4 class="sec_h4">Soul Dining</h4></a>
                    <span class="__date">Nov 02, 2022</span>    <span class="star">★ 4.5</span>
                    <h5>Each dish was filled with sincerity and it was delicious<br> The salad was the best<br>
                    <small></small></h5>
                </div>
            </div>
             <div class="col-lg-3 col-sm-6">
                <div class="accomodation_item text-center">
                    <div class="hotel_img"><a href="#" ="btn-bookmark active"></a>
                        <img src="resources/image/catch/8r8kcx3xrkmc7pfi7lezba_2341518181244717.jpg" width="262px"; height="272px"; alt="">
                    </div>
                    <a href="#"><h4 class="sec_h4">Low and Slow</h4></a>
                    <span class="__date">Sep 30, 2022</span>    <span class="star">★ 5.0</span>
                    <h5>There's a reason why they're booked up so fast I was happy<br> to eat meat full of juice.<br>
                    <small></small></h5>
                </div>
            </div>
            <div class="col-lg-3 col-sm-6">
                <div class="accomodation_item text-center">
                    <div class="hotel_img"><a href="#" ="btn-bookmark active"></a>
                        <img src="resources/image/catch/rsvnvk29u-g1xal0gqzppg_22111523302100765.jpg" width="262px"; height="272px"; alt="">
                    </div>
                    <a href="#"><h4 class="sec_h4">HERMANA</h4></a>
                    <span class="__date">Sep 24, 2022</span>    <span class="star">★ 4.9</span>
                    <h5>The atmosphere was amazing, the view was amazing, and the food was the best<br>
                    <small></small></h5>
                </div>
            </div>
            <div class="col-lg-3 col-sm-6">
                <div class="accomodation_item text-center">
                    <div class="hotel_img"><a href="#" ="btn-bookmark active"></a>
                        <img src="resources/image/catch/230417233948722(0).jpeg" width="262px"; height="272px"; alt="">
                    </div>
                    <a href="#"><h4 class="sec_h4">Gortz (Görtz)</h4></a>
                    <span class="__date">Jan 01, 2023</span>    <span class="star">★ 4.7</span>
                    <h5>The food was delicious and the meal while looking at the Han River at night was really cool<br>
                    <small></small></h5>
                </div>
            </div>
            <div class="col-lg-3 col-sm-6">
                <div class="accomodation_item text-center">
                    <div class="hotel_img"><a href="#" ="btn-bookmark active"></a>
                        <img src="resources/image/catch/230509200719537(0).jpeg" width="262px"; height="272px"; alt="">
                    </div>
                    <a href="#"><h4 class="sec_h4">Flower Blossom on the Rice</h4></a>
                    <span class="__date">May 10, 2023</span>    <span class="star">★ 5.0</span>
                    <h5>The best Korean restaurant with pretty food.<br> Thank you for the delicious food!<br>
                    <small></small></h5>
                </div>
            </div>
            <div class="col-lg-3 col-sm-6">
                <div class="accomodation_item text-center">
                    <div class="hotel_img"><a href="#"="btn-bookmark active"></a>
                        <img src="resources/image/catch/23225170303149_rv.jpg" width="262px"; height="272px"; alt="">
                    </div>
                    <a href="#"><h4 class="sec_h4">On 6.5</h4></a>
                    <span class="__date">May 04, 2023</span>    <span class="star">★ 4.9</span>
                    <h5>came here at the recommendation of a friend. I am very satisfied with the taste<br>
                    <small></small></h5>
                </div>
            </div> -->
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
<script src="/js/custom.js"></script>
</body>
</html>