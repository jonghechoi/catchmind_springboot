<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>   
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" href="image/catchcon.png" type="image/png">
        <title>Catch Mind</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="vendors/linericon/style.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="vendors/bootstrap-datepicker/bootstrap-datepicker3.css">
        <link rel="stylesheet" href="vendors/nice-select/css/nice-select.css">
        <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">
        <!-- main css -->
	    <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/responsive.css">
	    <link rel="stylesheet" href="content/css/searchmain.css"/>
        <link rel="stylesheet" href="css/style_joosung.css">
        <!-- 폰트 --> 
	    <link rel="preconnect" href="https://fonts.googleapis.com">
	    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;300;400;600;700&family=Noto+Sans+KR:wght@100;200;300;400;700;900&display=swap" rel="stylesheet">
	    <!-- filter css -->
	    <link rel="stylesheet" href="assets/libs/remixicon/remixicon.css" />
		<!-- jQuery -->
		<script src="js/popper.js"></script>
		<script src="js/bootstrap.min.js"></script>
	    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
		<script src="js/jquery-3.6.4.min.js"></script>
		<script src="js/searchlist.js"></script>
		<script src="vendors/bootstrap-datepicker/bootstrap-datepicker.js"></script>
		<script src="js/jonghe.js"></script>
		<script>
			$(document).ready(function() {
				if(JSON.parse(localStorage.getItem('check')) === 'kakaoMap') {
					mapMainToSearch();
					localStorage.setItem('check', JSON.stringify('none'));
				}else if(JSON.parse(localStorage.getItem('check')) === 'imageClick') {
					var searchQuery = localStorage.getItem('searchQuery');
					//var searchUrl = localStorage.getItem('searchUrl');
					mainToSearch(searchQuery);
					localStorage.setItem('check', JSON.stringify('none'));
				}else if(JSON.parse(localStorage.getItem('check')) === 'bookNowClick') {
					const bookNowDate = localStorage.getItem('bookNowDate');
					const bookNowLocation = localStorage.getItem('bookNowLocation');
					const bookNowCuisine = localStorage.getItem('bookNowCuisine');
					
					mainBookNowToSearch(bookNowDate, bookNowLocation, bookNowCuisine);
					localStorage.setItem('check', JSON.stringify('none'));
				}
			});
		</script>
    </head>  
    <body>
        <!--================Header Area =================-->
        <header class="header_area">
            <div class="container">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <a class="navbar-brand logo_h" href="/index"><img src="image/catchmind.png" alt=""></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
                        <ul class="nav navbar-nav menu_nav ml-auto">
                            <li class="nav-item"><a class="nav-link" href="/index">Home</a></li>
                            <li class="nav-item active"><a class="nav-link" href="/search">Search</a></li>
                            <li class="nav-item submenu dropdown">
                                <a href="mydining_scheduled" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">MY DINING</a>
                                <ul class="dropdown-menu">
                                    <li class="nav-item"><a class="nav-link" href="mydining_scheduled">Scheduled</a></li>
                                    <li class="nav-item"><a class="nav-link" href="mydining_visited">Visited</a></li>
                                    <li class="nav-item"><a class="nav-link" href="/mydining_cancel_noshow">Cancel / No-Show</a></li>
                                </ul>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="mypage">My Page</a></li>
                            <li class="nav-item"><a class="nav-link" href="notice">Notice</a></li>
                            <c:if test="${sessionScope.sessionVo.roleId =='SHOP' or sessionScope.sessionVo.roleId == 'ADMIN'}">
                            	<li class="nav-item submenu dropdown">
	                                <a href="shop_reservation" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Shop</a>
	                                <ul class="dropdown-menu">
	                                    <li class="nav-item active"><a class="nav-link" href="shop_information?sid=${sessionScope.sessionVo.sid}">Register</a></li>
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
                    <h2 class="page-cover-tittle">Search</h2>
                    <ol class="breadcrumb">
                        <li><a href="index">Home</a></li>
                        <li class="active">Search</li>
                    </ol>
                </div>
            </div>
        </section>
        <!--================Breadcrumb Area =================-->
        
        <!--================ About History Area  =================-->
        <section class="about_history_area section_gap">
            <div class="container1">
		        <div class="weather">
		        	<div class="ta"> 
			        	
						 <center id="inputContainer">
        <select id="cityInput" onchange="GetInfo()" class="cityInput" >
        		<option value="seoul">Seoul</option>
				<option value="incheon">Incheon</option>
				<option value="gyeonggi-do">Gyeonggi</option>
				<option value="jeju">Jeju</option>
				<option value="busan">Busan</option>
         </select>
        <p id="cityName"></p>
    </center>
    <div id = "weatherContainer">
        <div id="iconsContainer">    
            <div class = "icons">
                <p class="weathert" id="day1"></p>
                <div class="image"><img src="image/dots.png" class="imgClass" id="img1"></div>
                <p class="minValues" id="day1Min">Loading..</p>
                <p class="maxValues" id="day1Max">Loading..</p>
            </div>
            <div class = "icons">
                <p class="weathert" id="day2"></p>
                <div class="image"><img src="image/dots.png" class="imgClass" id="img2"></div>
                <p class="minValues" id="day2Min">Loading..</p>
                <p class="maxValues" id="day2Max">Loading..</p>
            </div> 
            <div class = "icons">
                <p class="weathert" id="day3"></p>
                <div class="image"><img src="image/dots.png" class="imgClass" id="img3"></div>
                <p class="minValues" id="day3Min">Loading..</p>
                <p class="maxValues" id="day3Max">Loading..</p>
            </div>
            <div class = "icons">
                <p class="weathert" id="day4"></p>
                <div class="image"><img src="image/dots.png" class="imgClass" id="img4"></div>
                <p class="minValues" id="day4Min">Loading..</p>
                <p class="maxValues" id="day4Max">Loading..</p>
            </div>
            <div class = "icons">
                <p class="weathert" id="day5"></p>
                <div class="image"><img src="image/dots.png" class="imgClass" id="img5"></div>
                <p class="minValues" id="day5Min">Loading..</p>
                <p class="maxValues" id="day5Max">Loading..</p>
            </div>
        </div>
    </div>
		        	 <!-- <div id="ww_4ba0b9170f70e" v='1.3' loc='id' a='{"t":"horizontal","lang":"ko","sl_lpl":1,"ids":[],"font":"Arial","sl_ics":"one","sl_sot":"celsius","cl_bkg":"image","cl_font":"#FFFFFF","cl_cloud":"#FFFFFF","cl_persp":"#81D4FA","cl_sun":"#FFC107","cl_moon":"#FFC107","cl_thund":"#FF5722","el_phw":3}'>Weather Data Source: <a href="https://wetterlang.de/seoul_wetter_30_tage/" id="ww_4ba0b9170f70e_u" target="_blank">30 tage Seoul wetter</a></div><script async 
="https://app1.weatherwidget.org/js/?id=ww_4ba0b9170f70e"></script> -->
		       	 	</div>
<%--		       	 	<div class="calendar">--%>
<%--		       	 		<div class="col-md-99">--%>
<%--                                    <h2>BookYourTable</h2>--%>
<%--                                    </div>--%>
<%--                                <div class="col-md-9">--%>
<%--                                    <div class="booking_table1">--%>
<%--                                            <div class="col-md-4">--%>
<%--                                                <div class="book_tabel_item">--%>
<%--                                                    <div class="form-group">--%>
<%--                                                        <div class="input-group date" id="datepicker">--%>
<%--                                                            <input type="text" class="form-control" placeholder="Date" --%>
<%--																	name="rdate" value="rdate" id="rdate"/>--%>
<%--                                                            <span class="input-group-addon">--%>
<%--                                                                <i class="fa fa-calendar" aria-hidden="true"></i>--%>
<%--                                                            </span>--%>
<%--                                                        </div>--%>
<%--                                                    </div>  --%>
<%--                                                  <div class="input-group">--%>
<%--                                                        <select class="wide">--%>
<%--                                                            <option data-display="Seating Options">Seating Options</option>--%>
<%--                                                            <option value="all">All</option>--%>
<%--                                                            <option value="roofTop">Rooftop</option>--%>
<%--                                                            <option value="terrace">Terrace</option>--%>
<%--                                                            <option value="bar">Bar</option>--%>
<%--                                                            <option value="diningHall">Dining Hall</option>--%>
<%--                                                            <option value="windowSeat">Window Seat</option>--%>
<%--                                                            <option value="privateRoom">Private Room</option>--%>
<%--                                                            <option value="Rental">Rental</option>--%>
<%--                                                        </select>--%>
<%--                                                    </div>--%>
<%--                                                </div>--%>
<%--                                            </div>  --%>
<%--                                            <div class="col-md-4">--%>
<%--                                                <div class="book_tabel_item">--%>
<%--                                                   <div class="input-group reservation-page">--%>
<%--                                                        <select class="wide">--%>
<%--                                                            <option data-display="Party Size">Party Size</option>--%>
<%--                                                            <option value="1">1</option>--%>
<%--                                                            <option value="2">2</option>--%>
<%--                                                            <option value="3">3</option>--%>
<%--                                                            <option value="4">4</option>--%>
<%--                                                            <option value="5">5</option>--%>
<%--                                                            <option value="6">6</option>--%>
<%--                                                            <option value="7">7</option>--%>
<%--                                                            <option value="8">8</option>--%>
<%--                                                            <option value="9">9</option>--%>
<%--                                                            <option value="10">10</option>--%>
<%--                                                        </select>--%>
<%--                                                    </div>--%>
<%--                                                   <div class="input-group">--%>
<%--															<select class="wide" name = "rtime" id="rtime"--%>
<%--																onchange="selectBoxRtime()">--%>
<%--																<option value = "rtime" data-display="Time">Time</option>--%>
<%--															</select>--%>
<%--														</div>--%>
<%--                                                </div>--%>
<%--                                        </div>--%>
<%--                                   </div>--%>
<%--                            </div> --%>
<%--		        	</div>  --%>
		        	   </div>
						      <form id="catch-form" class="form">
                    	<div class="softsearch">
						            <input id="searchBar" required maxlength="10" type="text" placeholder="Location, Cuisine, or Restaurant" spellcheck="false" onkeyup="enterkeySearch(event)">
						        <button type="button" form="catch-form"><i class="fa fa-search"></i></button>
						</div>
						        <div class="catch-inner">
								<div class="rc"><a>Recent</a>
						            <div class="allDelete off">
						                <div class="btn">All Delete ❌</div>
						            </div>
						            <p class="txt"></p>
						            <ul id="catch-list"></ul>
						    	</div>
						</div>
						 </form>
						 <div class="img" style="background-image: url(&quot;https://image.toast.com/aaaaaqx/catchtable/shopinfo/sIeb32Qa4R0s7IQbtR-LKaA/ieb32qa4r0s7iqbtr-lkaa_22121514220787590_thumbMenuImage.jpeg?small220&quot;);"></div>
			          	 <div class="rb">
			           		<!-- <div><div class="saved-restaurant-list-item" style="margin-bottom: 20px; padding-bottom: 20px;"><div class="restaurant-info"><div class="tb"><div class="img" style="background-image: url(&quot;https://image.toast.com/aaaaaqx/catchtable/shopinfo/s21297/21297_2181223293535919_thumbMenuImage.jpg?small220&quot;);"></div></div><div class="detail"><div class="detail-header"><div class="txt"><h4 class="name">Yakitori Soot</h4><p class="excerpt">A comfortable yakitori omakase place<br>*Please call us for the same-day reservations</p></div></div><div class="restaurant-meta"><div class="__d-flex mb-6"><div class="rating"><span class="star">4.8</span>&nbsp;</div><div style="text-align: right; width: 100%;"></div></div><span class="tags">Izakaya • Dongrae, Busan</span><span class="price"> Lunch Not open <br> Dinner  ₩30,000~₩40,000 <br></span></div><div class="timetable-list timetable-list-sm"><a href="#" id="DEFAULT_itemElem_1830" class="timetable-list-item" style="margin-bottom: auto; margin-top: auto; min-width: 70px;"><span class="time">6:30 PM</span></a><a href="#" id="DEFAULT_itemElem_1900" class="timetable-list-item" style="margin-bottom: auto; margin-top: auto; min-width: 70px;"><span class="time">7:00 PM</span></a><a href="#" id="DEFAULT_itemElem_1930" class="timetable-list-item" style="margin-bottom: auto; margin-top: auto; min-width: 70px;"><span class="time">7:30 PM</span></a></div></div></div></div></div>	
							<hr>
							<div id="shopSearchListScroll_1" data-dummy="210"><div class="saved-restaurant-list-item" style="margin-bottom: 20px; padding-bottom: 20px;"><div class="restaurant-info"><div class="tb"><div class="img" style="background-image: url(&quot;https://image.toast.com/aaaaaqx/catchtable/shopinfo/sIeb32Qa4R0s7IQbtR-LKaA/ieb32qa4r0s7iqbtr-lkaa_22121514220787590_thumbMenuImage.jpeg?small220&quot;);"></div></div><div class="detail"><div class="detail-header"><div class="txt"><h4 class="name">SULGYEDO</h4><p class="excerpt">Building the best chicken and an unforgettable experience in Y-Town; There is nowhere like SULGYEDO. </p></div><a class="btn-bookmark">북마크</a></div><div class="restaurant-meta"><div class="__d-flex mb-6"><div class="rating"><span class="star">4.5</span>&nbsp;<span class="count">(69)</span></div><div style="text-align: right; width: 100%;"></div></div><span class="tags">Chicken &amp; Duck • Yeouido</span><span class="price"> Lunch/Dinner ₩10,000~₩30,000 <br></span></div><div class="timetable-list timetable-list-sm"><a href="#" id="DEFAULT_itemElem_1830" class="timetable-list-item" style="margin-bottom: auto; margin-top: auto; min-width: 70px;"><span class="time">6:30 PM</span></a><a href="#" id="DEFAULT_itemElem_1900" class="timetable-list-item" style="margin-bottom: auto; margin-top: auto; min-width: 70px;"><span class="time">7:00 PM</span></a><a href="#" id="DEFAULT_itemElem_1930" class="timetable-list-item" style="margin-bottom: auto; margin-top: auto; min-width: 70px;"><span class="time">7:30 PM</span></a></div></div></div></div></div>
							<hr>
							<div id="shopSearchListScroll_2" data-dummy="221"><div class="saved-restaurant-list-item" style="margin-bottom: 20px; padding-bottom: 20px;"><div class="restaurant-info"><div class="tb"><div class="img" style="background-image: url(&quot;https://image.toast.com/aaaaaqx/catchtable/shopinfo/s21477/21477_2192816334860246_thumbMenuImage.jpg?small220&quot;);"></div></div><div class="detail"><div class="detail-header"><div class="txt"><h4 class="name">Yakitori Tanyo</h4><p class="excerpt">A yakitori omakase place featuring Korean local chicken with a spectacular view of Gwangan Bridge</p></div><a class="btn-bookmark">북마크</a></div><div class="restaurant-meta"><div class="__d-flex mb-6"><div class="rating"><span class="star">4.8</span>&nbsp;<span class="count">(383)</span></div><div style="text-align: right; width: 100%;"></div></div><span class="tags">Yakitori • Gwangalli, Busan</span><span class="price"> Lunch Not open <br> Dinner ￦35,000 <br></span></div><div class="timetable-list timetable-list-sm"><a href="#" id="DEFAULT_itemElem_1700" class="timetable-list-item" style="margin-bottom: auto; margin-top: auto; min-width: 70px;"><span class="time">5:00 PM</span></a><a href="#" id="DEFAULT_itemElem_" class="timetable-list-item disabled" style="margin-bottom: auto; margin-top: auto; min-width: 70px;"><span class="time">&nbsp;</span></a><a href="#" id="DEFAULT_itemElem_2100" class="timetable-list-item" style="margin-bottom: auto; margin-top: auto; min-width: 70px;"><span class="time">9:00 PM</span></a></div></div></div></div></div>
							<hr>
							<div id="shopSearchListScroll_3" data-dummy="222"><div class="saved-restaurant-list-item" style="margin-bottom: 20px; padding-bottom: 20px;"><div class="restaurant-info"><div class="tb"><div class="img" style="background-image: url(&quot;https://image.toast.com/aaaaaqx/catchtable/shopinfo/s20804/20804_2161821401356927_thumbMenuImage.jpg?small220&quot;);"></div></div><div class="detail"><div class="detail-header"><div class="txt"><h4 class="name">Yakitorimook, Sinsa</h4><p class="excerpt">A yakitori place where you can taste all parts of a local chicken</p></div><a class="btn-bookmark">북마크</a></div><div class="restaurant-meta"><div class="__d-flex mb-6"><div class="rating"><span class="star">4.6</span>&nbsp;<span class="count">(779)</span></div><div style="text-align: right; width: 100%;"></div></div><span class="tags">Yakitori • Garosu-gil</span><span class="price"> Lunch Not open <br> Dinner ￦22,000 - ￦35,000 <br></span></div><div class="timetable-list timetable-list-sm"><div class="notable"><p style="font-size: 13px;">Closed day.</p></div></div></div></div></div></div>
							<hr>
							<div id="shopSearchListScroll_1" data-dummy="210"><div class="saved-restaurant-list-item" style="margin-bottom: 20px; padding-bottom: 20px;"><div class="restaurant-info"><div class="tb"><div class="img" style="background-image: url(&quot;https://image.toast.com/aaaaaqx/catchtable/shopinfo/soBe_yC58BHX5nFzOdCBvkg/obe_yc58bhx5nfzodcbvkg_22122915183140452_thumbMenuImage.jpg?small220&quot;);"></div></div><div class="detail"><div class="detail-header"><div class="txt"><h4 class="name">JL Dessert Bar</h4><p class="excerpt">JL Dessert Bar incorporates refined plated desserts, macarons, petit gateaux with array of drinks.</p></div><a class="btn-bookmark">북마크</a></div><div class="restaurant-meta"><div class="__d-flex mb-6"><div class="rating"><span class="star">4.5</span>&nbsp;<span class="count">(575)</span></div><div style="text-align: right; width: 100%;"></div></div><span class="tags">Dessert, Plated Dessert, Macaron • Itaewon, Hannam</span><span class="price"> Lunch/Dinner ₩10,000~₩60,000 <br></span></div><div class="timetable-list timetable-list-sm"><a href="#" id="DEFAULT_itemElem_1845" class="timetable-list-item" style="margin-bottom: auto; margin-top: auto; min-width: 70px;"><span class="time">6:45 PM</span></a><a href="#" id="DEFAULT_itemElem_1900" class="timetable-list-item" style="margin-bottom: auto; margin-top: auto; min-width: 70px;"><span class="time">7:00 PM</span></a><a href="#" id="DEFAULT_itemElem_1915" class="timetable-list-item" style="margin-bottom: auto; margin-top: auto; min-width: 70px;"><span class="time">7:15 PM</span></a></div></div></div></div></div> -->
						</div>
                <div class="row">
                        <div class="about_content ">
                        <div class="top-wrap">
                        <h1 class="top-title">Filter</h1>
                        <button type="reset" class="reset-btn" id="btnReset"><p>Reset</p></button>
                    	</div>
		            <div class="filter-select-box">
		                <div class="container">
		                    <a href="#" class="box" id="p1">
		                        <i class="icon location"></i>
		                        <div class="title">
		                          <div class="z1">
		                            <p class="name">Location</p>
		                           <!--  <span class="value">All</span> -->
									</div>
										<div id="d_p1">
											<option class="d_p1" id="Seoul" value="seoul">Seoul</option>
											<option class="d_p1" id="Incheon" value="incheon">Incheon</option>
											<option class="d_p1" id="Gyeonggi" value="gyeonggi">Gyeonggi</option>
											<option class="d_p1" id="Jeju" value="jeju">Jeju</option>
											<option class="d_p1" id="Busan" value="busan">Busan</option>
									</div>
		                        </div> 
		                    </a>
		                    <a href="#" class="box" id="p2">
		                        <i class="icon cuisine"></i>
		                        <div class="title">
		                        <div class="z1">
		                            <p class="name">Cuisine</p>
		                            <!-- <span class="value">All</span> -->
		                            </div>
		                            	<div id="d_p2">
											<option class="d_p2" id="Korean" value="korean">Korean</option>
							 				<option class="d_p2" id="Japanese" value="japanese">Japanese</option>
											<option class="d_p2" id="Chinese" value="chinese">Chinese</option>
											<option class="d_p2" id="Western" value="western">Western</option>
											<option class="d_p2" id="Dessert" value="dessert">Dessert</option>
									</div>
		                        </div>
		                    </a>
		                    <a href="#" class="box" id="p3">
		                        <i class="icon price"></i>
		                        <div class="title">
		                        <div class="z1">
		                            <p class="name">Price</p>
		                            <!-- <span class="value">All</span> -->
		                            </div>
		                            	<div id="d_p3">
											<option class="d_p3" id="1" value="50">0~50$</option>
											<option class="d_p3" id="2" value="100">50~100$</option>
											<option class="d_p3" id="3" value="150">100~150$</option>
											<option class="d_p3" id="4" value="200">150~200$</option>
											<option class="d_p3" id="5" value="300">200~300$</option>
									</div>
		                        </div>
		                    </a>
		                      <div class="apply-btn-wrap">
			           	    </div>
                    </div>
                </div>
           	 </div>
            </div>
           </div>
        </section>
        <!--================ About History Area  =================-->
        
      
        
        <!--================ start footer Area  =================-->	
         <footer class="footer-area section_gap" style="padding:50px 0 0 0; background:rgb(255, 61, 0)">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3  col-md-6 col-sm-6 footer-widget1" style="padding-right:50px; width:370px">
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
            <%-- <%@ include file="footer.jsp" %> --%>
        </footer>

		<!--================ End footer Area  =================-->
        
        
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="assets/libs/jquery/jquery-1.12.4.the.js"></script>
        <!-- <script src="js/jquery-3.2.1.min.js"></script> -->
        <script src="vendors/owl-carousel/owl.carousel.min.js"></script>
        <script src="js/jquery.ajaxchimp.min.js"></script>
        <script src="vendors/nice-select/js/jquery.nice-select.js"></script>
        <script src="js/mail-script.js"></script>
        <script src="js/stellar.js"></script>
        <script src="vendors/lightbox/simpleLightbox.min.js"></script>
        <script src="js/custom.js"></script>
        <script src="js/slide.js"></script>
        <script src="js/weather.js"></script>
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<script src="vendors/bootstrap-datepicker/bootstrap-datepicker.js"></script>
		<script>
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
				
				$('#datepicker').datepicker({
					format : "yyyy-mm-dd",
					startDate: '0d', 
					endDate: '+1m',
					todayHighlight: true
				}).datepicker("setDate", new Date());
								
			});
		</script>
    </body>
</html>