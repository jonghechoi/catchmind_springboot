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
        <title>Catch Mind</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="/css/bootstrap.css">
        <link rel="stylesheet" href="/vendors/linericon/style.css">
        <link rel="stylesheet" href="/css/font-awesome.min.css">
        <link rel="stylesheet" href="/vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.css">
        <link rel="stylesheet" href="/vendors/bootstrap-datepicker/bootstrap-datepicker3.css">
        <link rel="stylesheet" href="/vendors/nice-select/css/nice-select.css">
        <link rel="stylesheet" href="/vendors/owl-carousel/owl.carousel.min.css">
        <!-- main css -->
        <link rel="stylesheet" href="/css/style.css">
        <link rel="stylesheet" href="/css/style_jonghe.css">
        <link rel="stylesheet" href="/css/responsive.css">
        <script src="/js/jquery-3.2.1.min.js"></script>
        <script src="/vendors/bootstrap-datepicker/bootstrap-datepicker.js"></script>

        
        <script>
			let login_complete = "${login_complete}"
			let loginRole_complete = "${loginRole_complete}"
			let kakaoLogin = "${kakoLogin_complete}"
			let logout = "${logout_result}"
        	
        	if(login_complete == "ok") {
        		alert("Sign In Complete");
        	}
			
	    	if(loginRole_complete == "ok") {
	    		alert("Sign In Complete");
	    	}
	    	
	    	if(kakaoLogin == "ok") {
	    		alert("Sign In Kakao Complete");
	    	}
	    	
	    	if(logout == "ok") {
	    		alert("Logout Complete");
	    	}
        </script>
        
        <!-- script -->
     	<script>
	     	$(document).ready(function() {
				$('#datepicker').datepicker({
					format : "yyyy-mm-dd",
					startDate: '0d', 
					endDate: '+1m',
					todayHighlight: true,
					//daysOfWeekDisabled: [dayoffnum] // 월요일(1) 비활성화
				}).datepicker("setDate", new Date());
	     		
	            updateData();       
		        setInterval(() => {updateData();}, 600000);
	     	});
	    	function updateData() {
	    		$.ajax({
	    			url: "/index_review",
	    			success: function(dataList) {
	    				$(".testimonial_slider.owl-carousel").empty();
	    				
	    				//var jdata = JSON.parse(dataList);
	    				var output = "";
	    				
	    				for(obj of dataList) {
	    			        output += "<div class='media testimonial_item' style='display: flex; align-items: center;'>";
	    			        
	    			        output += "<div style='float: left; padding:0px 70px 0px 40px; border-right:2px solid lightgray'>"; 
	    			        output += "<img style='margin-right:0px;width:100px; height:100px; text-align:center' class='rounded-circle' src='http://localhost:9000/catchmind/resources/upload/" + obj.reviewphoto + "' alt=''>";
	    			        output += "<div class='media-body' style='text-align:center'>";
	    			        output += "<a href='#'><h4 class='sec_h4'>" + obj.mname + "</h4></a>";
	    			        output += "<div class='star' style='text-align:center'>";
	    			        
	    			        for(i=0; i<obj.reviewstar; i++) { 
	    			        	output += "<a href='#'><i class='fa fa-star'></i></a>"; 
	    			        };
	    			        output += "</div>";
	    			        output += "</div>";
	    			        output += "</div>";

	    			        
	    			        output += "<div style='float: left; padding-left:70px;'>";
	    			        output += "<p>" + obj.reviewcontent + "</p>";
	    			        output += "</div>";
	    			        
	    			        output += "</div>";

	    				};
	    				
	    				$(".testimonial_slider.owl-carousel").append(output);
	    			} //success
	    		}) //ajax
	    	} //function
    	</script>
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
                                <a href="/mydining_scheduled" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">MY DINING</a>
                                <ul class="dropdown-menu">
                                    <li class="nav-item active"><a class="nav-link" href="/mydining_scheduled">Scheduled</a></li>
                                    <li class="nav-item"><a class="nav-link" href="/mydining_visited">Visited</a></li>
                                </ul>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="/mypage">My Page</a></li>
                            <li class="nav-item"><a class="nav-link" href="/notice">Notice</a></li>
                            <%--<c:if test="${sessionScope.sessionVo.roleId =='SHOP' or sessionScope.sessionVo.roleId == 'ADMIN'}">--%>
	                            <li class="nav-item submenu dropdown">
	                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Shop</a>
	                                <ul class="dropdown-menu">
	                                    <%--<li class="nav-item active"><a class="nav-link" href="/shop_information.do?sid=${sessionScope.sessionVo.sid}">Register</a></li>
	                                    <li class="nav-item"><a class="nav-link" href="/shop_reservation.do?sid=${sessionScope.sessionVo.sid}">Reservation</a></li>--%>
                                        <li class="nav-item active"><a class="nav-link" href="/shop_information/S_0003">Register</a></li>
                                        <li class="nav-item"><a class="nav-link" href="/shop_reservation/S_0003">Reservation</a></li>
	                                </ul>
	                            </li>
                            <%--</c:if>--%>
                            <%--<c:if test="${sessionScope.sessionVo.roleId == 'ADMIN'}">--%>
                            	<li class="nav-item"><a class="nav-link" href="/admin">Admin</a></li>
                        	<%--</c:if>--%>
                        </ul>
                    </div> 
                </nav>
            </div>
        </header>
        <!--================Header Area =================-->
        <!--================Banner Area =================-->
        <section class="banner_area">
            <div class="booking_table d_flex align-items-center">
            	<div class="overlay bg-parallax" data-stellar-ratio="0.9" data-stellar-vertical-offset="0" data-background=""></div>
				<div class="container">
					<div class="banner_content text-center">
						<h6>Away from monotonous life</h6>
						<h2>Catch Your Mind</h2>
						<p><!--If you are looking at blank cassettes on the web, you may be very confused at the<br> difference in price. You may see some for as low as $.17 each.--></p>
						<a href="search.do" class="btn theme_btn button_hover">Get Started</a>
					</div>
				</div>
            </div>
             <div class="hotel_booking_area position">
                <div class="container">
                    <div class="hotel_booking_table">
                        <div class="col-md-3">
                            <h2>Enjoy<br>Your Meal</h2>
                        </div>
                        <div class="col-md-9">
                            <div class="boking_table">
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="book_tabel_item">
                                            <div class="form-group">
                                                <!-- <div class='input-group date' id='datetimepicker11'> -->
                                                <div class='input-group date' id='datepicker'>
                                                    <input type='text' id="bookNowDate" class="form-control" placeholder="Reservation date"/>
                                                    <span class="input-group-addon">
                                                        <i class="fa fa-calendar" aria-hidden="true"></i>
                                                    </span>
                                                </div>
                                            </div>
                                            <div class="input-group">
                                                <select class="wide" id="bookNowLocation">
                                                    <option data-display="Location">Location</option>
                                                    <option value="seoul">Seoul</option>
                                                    <option value="incheon">Incheon</option>
                                                    <option value="jeju">Jeju</option>
                                                    <option value="busan">Busan</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="book_tabel_item">
                                            <div class="input-group">
                                                <select class="wide" id="bookNowCuisine">
                                                    <option data-display="Cuisine">Cuisine</option>
                                                    <option value="korean">Korean</option>
                                                    <option value="japanese">Japanese</option>
                                                    <option value="chinese">Chinese</option>
                                                    <option value="western">Western</option>
                                                </select>
                                            </div>
                                            <!-- <div class="input-group">
                                                <select class="wide">
                                                    <option data-display="Price">Browse by Price</option>
                                                    <option value="30000">Under �?30,000</option>
                                                    <option value="50000">�?30,000 ~ �?50,000</option>
                                                    <option value="100000">�?50,000 ~ �?100,000</option>
                                                    <option value="200000">�?100,000 & Above</option>
                                                </select>
                                            </div> -->
                                        </div>
                                    </div>
                                    <div class="col-md-4" style="padding-top: 50px;" >
                                        <div class="book_tabel_item">
                                            <a class="book_now_btn button_hover" href="#">Book Now</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================Banner Area =================-->
        <!--================ Accomodation Area  =================-->
        <section class="accomodation_area section_gap">
            <div class="container">
                <div class="section_title text-center">
                    <h2 class="title_color" style='margin-top:80px'>Where would you like to eat?</h2>
                    <p>The best restaurants proven by experts are waiting for you. </p>
                </div>
                <div class="row mb_30">
                    <div class="col-lg-3 col-sm-6">
                        <div class="accomodation_item text-center">
                            <div class="hotel_img">
                                <!--<img src="image/room1.jpg" alt="">-->
                                <img class="AccomodationImg" src="https://image.toast.com/aaaaaqx/catchtable/shopinfo/sz7PepEw6dYzPacOpI-IvAQ/z7pepew6dyzpacopi-ivaq_2362011453534440.jpeg" alt="">
                                <a href="restaurant.do?sid=S_0001" class="btn theme_btn button_hover">BOOK NOW</a>
                            </div>
                            <a href="#"><h4 class="sec_h4">ZERO COMPLEX</h4></a>
                            <!--<h5>$250<small>/night</small></h5>-->
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="accomodation_item text-center">
                            <div class="hotel_img">
                                <!--<img src="image/room2.jpg" alt="">-->
                                <img class="AccomodationImg" src="https://image.toast.com/aaaaaqx/catchtable/shopinfo/s47jHT01fp_nCI0cT-mo03Q/47jht01fp_nci0ct-mo03q_2210422223601797_thumbMenuImage.png" alt="">
                                <a href="restaurant.do?sid=S_0002" class="btn theme_btn button_hover">BOOK NOW</a>
                            </div>
                            <a href="#"><h4 class="sec_h4">On 6.5</h4></a>
                            <!--<h5>$200<small>/night</small></h5>-->
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="accomodation_item text-center">
                            <div class="hotel_img">
                                <!--<img src="image/room3.jpg" alt="">-->
                                <img class="AccomodationImg" src="https://image.toast.com/aaaaaqx/catchtable/shopinfo/soBe_yC58BHX5nFzOdCBvkg/obe_yc58bhx5nfzodcbvkg_22122915183140452_thumbMenuImage.jpg" alt="">
                                <a href="restaurant.do?sid=S_0003" class="btn theme_btn button_hover">BOOK NOW</a>
                            </div>
                            <a href="#"><h4 class="sec_h4">JL Dessert Bar</h4></a>
                            <!--<h5>$750<small>/night</small></h5>-->
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="accomodation_item text-center">
                            <div class="hotel_img">
                                <!--<img src="image/room4.jpg" alt="">-->
                                <img class="AccomodationImg" src="https://image.toast.com/aaaaaqx/catchtable/shopinfo/swwlaIVPUq12IBc-Lgyxvjw/wwlaivpuq12ibc-lgyxvjw_233514275232871_thumbMenuImage.jpeg" alt="">
                                <a href="restaurant.do?sid=S_0004" class="btn theme_btn button_hover">BOOK NOW</a>
                            </div>
                            <a href="#"><h4 class="sec_h4">GIGAS</h4></a>
                            <!--<h5>$200<small>/night</small></h5>-->
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================ Accomodation Area  =================-->      
        <!--================ About History Area  =================-->
        <section class="about_history_area section_gap">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 d_flex align-items-center">
                        <div class="about_content ">
                            <h2 class="title_index title_color">Browse<br>by Cuisine</h2>
                            <p>The best food is not far away. Enjoy the best food around you. Catchmind will only show you selected restaurants so that you can have the best meal.</p>
                            <a href="search.do" class="button_hover theme_btn_two">Find Food you want</a>
                        </div>
                    </div>
                	<div class="col-md-6">
					  <div class="row">
					    <div class="col-6">
					      <div class="cuisine-list">
					        <div>
					          <a><img class="cuisine-image" src="https://d21sjc85fy47a6.cloudfront.net/aaaaaqx/md/_0006_korean_food.jpg" alt="KOREAN"></a>	      
					        </div>
					        <h4 class="sec_h4 cuisine">Korean</h4>
					      </div>
					    </div>
					    <div class="col-6">
					      <div class="cuisine-list">
					        <div>
					          <a><img class="cuisine-image" src="https://d21sjc85fy47a6.cloudfront.net/aaaaaqx/md/_0010_sushi_omakase.jpg" alt="JAPANESE"></a>
					        </div>
					        <h4 class="sec_h4 cuisine">Japanese</h4>	                        
					      </div>
					    </div>
					  </div>
					  <div class="row">
					    <div class="col-6">
					      <div class="cuisine-list">
					        <div>
					          <a><img class="cuisine-image" src="https://d21sjc85fy47a6.cloudfront.net/aaaaaqx/md/0706_chinese_food.jpg?small200" alt="CHINESE"></a>
					        </div>
					        <h4 class="sec_h4 cuisine">Chinese</h4>	                        
					      </div>
					    </div>
					    <div class="col-6">
					      <div class="cuisine-list">
					        <div>
					          <a><img class="cuisine-image" src="https://d21sjc85fy47a6.cloudfront.net/aaaaaqx/md/_0007_steak.jpg" alt="WESTERN"></a>
					        </div>
					        <h4 class="sec_h4 cuisine">Western</h4>	                        
					      </div>
					    </div>
					  </div>
					</div>
                </div>
            </div>
        </section>
        <!--================ About History Area  =================-->
        <!--================ Testimonial Area  =================-->
        <section class="testimonial_area section_gap">
            <div class="container">
                <div class="section_title text-center">
                    <h2 class="title_color">Review</h2>
                    <p>Share your satisfactory experience with Catch Mind with others</p>
                </div>
                <div class="testimonial_slider owl-carousel">
                </div>
            </div>
        </section>
        <!--================ Testimonial Area  =================-->
        <!--================ Latest Blog Area  =================-->
        <section class="latest_blog_area section_gap">
            <div class="container">
                <div class="section_title text-center">
                    <h2 class="title_color">Search with map</h2> <h2 id="clickLatlng"></h2>
                    <p>Enjoy the best dinner anytime, anywhere on the map, wherever you want </p>
                </div>
                <div class="row mb_30">
                    <div id="map" style="width:600px; height:400px;"></div>
                    <div class="col-lg-4 map-4">
					  <div class="row" style="margin-bottom:30px">
					    <div class="details">
					      <h4 class="sec_h4">Choose the area you want on the map</h4>
					    </div>
					  </div>
					  <div class="row">
					    <div class="col-md-6">
					      <div class="cuisine-list">
					        <div>
					          <img class="resources/cuisine-image place-image" src="https://d21sjc85fy47a6.cloudfront.net/aaaaaqx/md/0706apgujeong.jpg" alt="SEOUL">             
					        </div>
					        <h4 class="sec_h4">Seoul</h4>
					      </div>
					    </div>
					    <div class="col-md-6">
					      <div class="cuisine-list">
					        <div>
					          <img class="resources/cuisine-image place-image" src="https://d21sjc85fy47a6.cloudfront.net/aaaaaqx/md/0706itaewon.jpg" alt="JEJU">
					        </div>
					        <h4 class="sec_h4">Jeju</h4>                        
					      </div>
					    </div>
					  </div>
					  <div class="row">
					    <div class="col-md-6">
					      <div class="cuisine-list">
					        <div>
					          <img class="resources/cuisine-image place-image" src="https://d21sjc85fy47a6.cloudfront.net/aaaaaqx/md_2022/2022_07_ENver/sinsa-4.png" alt="BUSAN">
					        </div>
					        <h4 class="sec_h4">Busan</h4>                        
					      </div>
					    </div>
					    <div class="col-md-6">
					      <div class="cuisine-list">
					        <div>
					          <img class="resources/cuisine-image place-image" src="https://d21sjc85fy47a6.cloudfront.net/aaaaaqx/md_2022/2022_07_ENver/seocho-4.png" alt="INCHEON">
					        </div>
					        <h4 class="sec_h4">Incheon</h4>                        
					      </div>
					    </div>
					  </div>
					</div>
                </div>
            </div>
        </section>
        <!--================ Recent Area  =================-->
        <!--================ start footer Area  =================-->	
        <footer class="footer-area section_gap" style="padding:50px 0 0 0; background:rgb(255, 61, 0)">
            <%@ include file="footer.jsp" %>
        </footer>
		<!--================ End footer Area  =================-->		
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="/js/bootstrap.min.js"></script>
        <script src="/vendors/owl-carousel/owl.carousel.min.js"></script>
        <script src="/js/jquery.ajaxchimp.min.js"></script>
        <script src="/js/mail-script.js"></script>
        <script src="/vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.js"></script>
        <script src="/vendors/nice-select/js/jquery.nice-select.js"></script>
        <script src="/js/mail-script.js"></script>
        <script src="/js/stellar.js"></script>
        <script src="/vendors/lightbox/simpleLightbox.min.js"></script>
        <script src="/js/custom.js"></script>
        <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fb222ca455cfb2afe3fb2c4341112dbb"></script>
	    <!-- Kako Map -->
       	<script src="/js/jonghe.js"></script>
	    
		<script>
 			var container = document.getElementById('map');
			var options = {
				center: new kakao.maps.LatLng(37.5517047604094, 127.020792640827),
				level: 3
			};
	
			var map = new kakao.maps.Map(container, options);

			// 지도를 클릭한 위치에 표출할 마커입니다
			var marker = new kakao.maps.Marker({ 
			    // 지도 중심좌표에 마커를 생성합니다 
			    position: map.getCenter() 
			}); 
			// 지도에 마커를 표시합니다
			marker.setMap(map);

			// 지도에 클릭 이벤트를 등록합니다
			// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
			kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
			    
			    // 클릭한 위도, 경도 정보를 가져옵니다 
			    var latlng = mouseEvent.latLng; 
			    
			    // 마커 위치를 클릭한 위치로 옮깁니다
			    marker.setPosition(latlng);
			    var check = 'kakaoMap';
			    localStorage.setItem('check', JSON.stringify(check));
			    
			    localStorage.setItem('lat', JSON.stringify(latlng.getLat()));
			    localStorage.setItem('lng', JSON.stringify(latlng.getLng()));
			    window.location.href = "search.do";
			});
			
			
			$(".cuisine-image").click(function() {
				var cuisine = $(this).attr('alt');
				var searchUrl = "search.do?searchQuery=" + encodeURIComponent(cuisine);
				var searchQuery = getParameterByName("searchQuery", searchUrl);
				
			    var check = 'imageClick';
			    localStorage.setItem('check', JSON.stringify(check));

			    localStorage.setItem('searchQuery', JSON.stringify(searchQuery).replace(/["']/g, ''));
			    localStorage.setItem('searchUrl', JSON.stringify(searchUrl));
				
				window.location.href = "search.do";
				//mainToSearch(searchQuery);
			});
			
			$(".place-image").click(function() {
				var place = $(this).attr('alt');
				var searchUrl = "search.do?searchQuery=" + encodeURIComponent(place);
				var searchQuery = getParameterByName("searchQuery", searchUrl);
				
			    var check = 'imageClick';
			    localStorage.setItem('check', JSON.stringify(check));

			    localStorage.setItem('searchQuery', JSON.stringify(searchQuery).replace(/["']/g, ''));
			    localStorage.setItem('searchUrl', JSON.stringify(searchUrl));
			    
				window.location.href = "search.do";
			});
			
			$(".book_now_btn").click(function() {
				const bookNowDate = document.querySelector('#bookNowDate');
				const bookNowLocation = document.querySelector('#bookNowLocation');
				const bookNowCuisine = document.querySelector('#bookNowCuisine');
				
			    var check = 'bookNowClick';
			    localStorage.setItem('check', JSON.stringify(check));
				
				localStorage.setItem('bookNowDate', bookNowDate.value);
				localStorage.setItem('bookNowLocation', bookNowLocation.value);
				localStorage.setItem('bookNowCuisine', bookNowCuisine.value);
				
				window.location.href = "search.do";
			})
		</script>
    </body>
</html>