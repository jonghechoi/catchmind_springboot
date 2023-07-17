<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" href="resources/image/catchcon.png" type="image/png">
		<title>Catch Mind</title>
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="resources/css/bootstrap.css">
		<link rel="stylesheet" href="resources/vendors/linericon/style.css">
		<link rel="stylesheet" href="resources/css/font-awesome.min.css">
		<link rel="stylesheet" href="resources/vendors/bootstrap-datepicker/bootstrap-datepicker3.css">
		<link rel="stylesheet" href="resources/vendors/nice-select/css/nice-select.css">
		<link rel="stylesheet" href="resources/vendors/owl-carousel/owl.carousel.min.css">
		<!-- main css -->
		<link rel="stylesheet" href="resources/css/style.css">
		<link rel="stylesheet" href="resources/css/style_dayoung.css">
		<link rel="stylesheet" href="resources/css/responsive.css">
		<!-- <script src="js/jquery-3.2.1.min.js"></script> -->	
		<script src="resources/js/popper.js"></script>
		<script src="resources/js/bootstrap.min.js"></script>
		<script src="resources/js/jquery-3.6.4.min.js"></script>
		<script src="resources/vendors/bootstrap-datepicker/bootstrap-datepicker.js"></script>
		<script src="https://www.jqueryscript.net/demo/Mobile-friendly-Custom-Scrollbar-Plugin-With-jQuery-NiceScroll/js/jquery.nicescroll.min.js"></script>
    	<!-- <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script> -->
    	<!-- iamport.payment.js -->
	    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
	    <script src="resources/js/catchmind_dayoung.js"></script>
	    <script>
	    $(document).ready(function() {
	    	$("#requestPay").click(function(){
	    		var mid = $("#mid").val();
	    		var sid = $("#sid").val();
	    		var rdate = $("#rdate").val();
	    		var rtime = $("#rtime").val();
	    		var rtabletype = $("#rtabletype").val();
	    		var guestnumber = $("#guestnumber").val();
	    		rrequest = $("#rrequest").val();
	    		var contact = $("#contact").val();
	    		var kemail = $("#kemail").val();
	    		var paymentAmount = $("#paymentAmount").val();
	    		//alert(paymentAmount);
	    		
	    		//notes 유효성검사	
	    		if($("input:checkbox[name='notes']:checked").length !== $("input:checkbox[name='notes']").length){
	    			alert('Please check notes if you want to proceed');
	    			return false;
	    		}
	    		//Email / rphone 유효성 검사
	    		else if(contact.trim().length === 0){
	    			alert('Please write down your email address or phone number if you want to proceed');
	    			return false;
	    		}
	    		//Agreement with Order details & Payment 유효성검사	
	    		else if($("input:checkbox[name='orderDetailsRequired']:checked").length != $("input:checkbox[name='orderDetailsRequired']").length){
	    			alert('Please check payment details if you want to proceed');
	    			return false;
	    		}
	    		else{
	    			var IMP = window.IMP; // 생략 가능
	    			IMP.init("imp65513454"); // 예: imp00000000a
	    			let uuid = window.crypto.randomUUID();
	    			//alert(uuid);
	    			//alert(mid + "_" + rdate + "_" + uuid);
	    			
	    			IMP.request_pay({
	    				pg: "html5_inicis",
	    				pay_method: "card",
	    				merchant_uid: mid + "_" + rdate + "_" + uuid,
	    				name: "결제테스트 : " + mid + "_" + rdate + "_" + uuid,
	    				amount: 500,
	    				buyer_email: kemail,
	    				buyer_name: mid,
	    				buyer_tel: contact,
	    				buyer_addr: " ",
	    				buyer_postcode: " ",				
	    			}, function (rsp) {
	    			    if (rsp.success) {
	    			    	alert("rsp.success");
	    	    			$.ajax({
	    			    		type: 'POST',
	    			    		url: "/verifyIamport/" + rsp.imp_uid  
	    			    	})ne(function(data) {
	    			    		alert("data.success");
	    			    		if (rsp.paid_amount == data.response.amount) {
	    			    			var msg = '결제가 완료되었습니다.';
	    			    			msg += '\n고유ID : ' + rsp.imp_uid;
	    			    			msg += '\n상점 거래ID : ' + rsp.merchant_uid;
	    			    			msg += '\n결제 금액 : ' + rsp.amount;
	    			    			//msg += '카드 승인번호 : ' + rsp.apply_num;
	    			    			alert(msg);
	    			    			
	    	    					payForm.submit();	
	    			    		} 
	    			    		else {
	    			    			alert("An error occurred, please try again later");
	    			    		}
	    			    	});
	    	    			
	    	    			
	    	    			payForm.submit();	
	    			    } 
	    			    else {
	    			        var msg = '결제에 실패하였습니다.';
	    			        msg += '에러내용 : ' + rsp.error_msg;
	    			        
	    			        alert(msg);
	    				}
	    			});
	    		}
	    	});
	    })
	    
	    
	    </script>
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
            <div class="overlay bg-parallax" data-stellar-ratio="0.8" data-stellar-vertical-offset="0" data-background="" style="background: url('resources/image/dayoung_img/reservation_confirm_bg.jpeg') no-repeat scroll center 0 / cover"></div>
            <div class="container">
                <div class="page-cover text-center">
                    <h2 class="page-cover-tittle">Reservation</h2>
                    <!--<ol class="breadcrumb">
                        <li><a href="index.html">Home</a></li>
                        <li class="active">About</li>
                    </ol>-->
                </div>
            </div>
        </section>

        <!--================ Reservation Confirm Area  =================-->
        <section class="facilities_area section_gap">
            <div class="overlay bg-parallax" data-stellar-ratio="0.8" data-stellar-vertical-offset="0" data-background="">  
            </div>
            <div class="container">
                <!-- Start select menu -->
                <div class="section_title text-center">
                    <br><br><br><br>
                    <h2 class="title_w" style="font-size: 50px;">${shopVo.sname}</h2>
                    <br><br>
                    <h2 class="title_w">Select Menu</h2>
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
                                <c:choose> 
									<c:when test="${shopVo.smealfee > 0}"> 
										<dt style="text-align: left">Payment in advance</dt>
										<dd style="text-align: right">${priceInStringMap.mealfee}</dd>
									</c:when> 
									<c:otherwise> 
										<dt style="text-align: left">Deposit per person</dt>
										<dd style="text-align: right">${priceInStringMap.deposit}</dd>
									</c:otherwise> 
								</c:choose> 
							</dl>
                            <dl class="">
                                <dt style="text-align: left">x Person(s)</dt>
                                <dd style="text-align: right">${guestnumber}</dd>
                            </dl>
                            <hr class="hairline mt-20 mb-20"
                                style="margin-top: 20px!important;
                                       margin-bottom: 20px!important;
                                       margin: 0 -20px;">
                            <dl class="dl-lg">
                                <dt style="text-align: left">Total Amount</dt>
                                <dd style="text-align: right; color: rgb(255, 61, 0);">₩ ${paymentAmount * guestnumber}</dd>
                            </dl>
                        </div>
                        <div class="boxed-dl-list mb-20"
                             style = "border-radius: 10px;
                                      border: solid 1px #e8e8e8;
                                      padding: 20px;
                                      margin-bottom: 20px!important;
                                      display: inline-block;
                                      width: 45%;
                                      background: #f9f9f9;">
                            <h4>Refund Policy</h4>
                            <p class="font-11 color-gray">·Cancellation before 3 days : 100% will be refunded.<br>·Cancellation before 2 days : 50% will be refunded.<br>·Cancellation before 1 day : 0% will be refunded.<br>·Same-day cancellation : 0% will be refunded.<br>·No-show : 0% will be refunded.<br><br></p>
                        </div>
                    </div>
                </div>
                <hr class = "seperator">
                <!-- End select menu -->

                <!-- Start notes -->
                <!-- Start form -->
                <form name="payForm" action="booking_with_payment" method="post">
	                <input type="hidden" id="sid" name="sid" value="${param.sid}">
					<input type="hidden" id="rdate" name="rdate" value="${param.rdate}">
					<input type="hidden" id="rtabletype" name="rtabletype" value="${param.rtabletype}">
					<input type="hidden" id="rtime" name="rtime" value="${param.rtime}">
					<input type="hidden" id="guestnumber" name="guestnumber" value="${guestnumber}">
					<input type="hidden" id="mid" name="mid" value="${sessionVo.mid}">
					<input type="hidden" id="kemail" name="kemail" value="${sessionVo.kemail}">
					<input type="hidden" id="paymentAmount" name="paymentAmount" value="${paymentAmount}">
	                <c:if test="${not empty rsPolicyList}">
	                <div class="section_title text-center">
	                    <h2 class="title_w" style="margin-top: 70px;">Notes</h2>
	                    <div class="drawer-box-body fixed-height enable-scroll" style="padding: 20px; text-align: left;">
	                    	<c:forEach var="rsPolicyVo" items="${rsPolicyList}">
	                    		<label class="label-checkbox mb-15" style = "display: block">
		                            <input type="checkbox" id="notes" name="notes" class="form-checkbox" style="min-width: 20px;">
		                            <span class="label strong font-14" style="word-break: break-all;">
										${rsPolicyVo.pcontents}
		                            </span>
		                        </label>
							</c:forEach>
	                        <div class="well mt-30" style="margin-bottom: 100px;">&nbsp;</div>
	                    </div>
	                </div>
	                <hr class = "seperator">
	                </c:if>
	                <!-- End notes -->
	
	                <!-- Start reservation information -->
	                <div class="section_title text-center">
	                    <h2 class="title_w" style="margin-top: 70px;">Reservation Information</h2>
	                </div>
	                <div class="section-body">
	                    <div class="__checkout-reserv-info">
	                        <div class="__summary">
	                            <div class="__more-info">
	                                <dl style="font-size: 15px;">
	                                    <dt>Schedule</dt>
	                                    <dd>${param.rdate} · ${param.rtime} · ${guestnumber} Person(s)</dd>
	                                </dl>
	                                <dl style="font-size: 15px;">
	                                    <dt>Booker</dt>
	                                    <dd>${sessionVo.memberId} (${sessionVo.kemail})</dd>
	                                </dl>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                <hr class = "seperator2">
	                <!-- End reservation information -->
	
	                <!-- Start Special request & phone number -->
	                <div class="section_title text-center">
	                    <h2 class="title_w" style="margin-top: 70px;">Special Request</h2>
	                </div>
	                <div class="section-body mb-30">
	                    <div class="__select-textarea">
	                        <textarea class="form-input __active"
	                        		  name="rrequest"
	                        		  id="rrequest"
	                                  placeholder="     If you have any request to restaurant, please write here."
	                                  rows="4"
	                                  style="width: 80%;"></textarea>
	                    </div>
	                </div>
	                <div class="section_title text-center">
	                    <h2 class="title_w" style="margin-top: 70px;">[Required] Email / Phone Number</h2>
	                </div>
	                <div class="section-body">
	                	<c:choose>
	                		<c:when test="${sessionVo.kemail == null}">
			                    <input type="text"
			                    	   name="contact"
			                    	   id="contact"
			                    	   class="form-input __active"
			                           placeholder="     Please write down your email address / phone number"
			                           style="width: 80%;">
	                         </c:when>
	                         <c:otherwise>
	                         	<input type="text"
			                    	   name="contact"
			                    	   id="contact"
			                    	   class="form-input __active"
			                           placeholder="     ${sessionVo.kemail}"
			                           value="${sessionVo.kemail}"
			                           style="width: 80%;">
	                         </c:otherwise>
	                    </c:choose>
	                    <p class="color-gray mt-5">If you leave your email address or phone number which will be used while visit Korea,
	                                               the restaurant can contact you quickly when they have any inquiry.
	                    </p>
	                </div>
	                <hr class = "seperator">
	                <!-- End Special request & phone number -->

					<!-- Start Agreement with Order details & Payment -->
	                <div class="container gutter-sm">
	                    <div class="section-header mb-20" style = "margin-top: 80px;">
	                        <h3 class="section-title font-18">Agreement with Order details &amp; Payment</h3>
	                    </div>
	                    <div class="section-body">
	                        <div>
	                            <label class="label-checkbox label-checkbox-with-btn mb-20" style = "display: block">
	                                <input type="checkbox" id="orderDetailsRequired" name="orderDetailsRequired" class="form-checkbox">
	                                <span class="label strong font-14">[Required] Consent to the terms and conditions of payment agency service</span>
	                                <a class="__view"></a>
	                            </label>
	                            <label class="label-checkbox mb-10" style = "display: block">
	                                <input type="checkbox" id="orderDetailsRequired" name="orderDetailsRequired" class="form-checkbox">
	                                <span class="label strong font-14">[Required] Consent to the cancellation and refund regulations</span>
	                            </label>
	                            <div class="well mb-20 p-20" style="border-radius: 10px;
	                                                                border: solid 1px #e8e8e8;
	                                                                padding: 20px;
	                                                                margin-bottom: 20px!important;
	                                                                display: inline-block;
	                                                                width: 45%;
	                                                                background: #f9f9f9;">
	                                <p class="font-13 color-gray plain-txt"> Cancellation before 3 days : 100% will be refunded.
	                                    <br> Cancellation before 2 days : 50% will be refunded.
	                                    <br> Cancellation before 1 day : 0% will be refunded.
	                                    <br> Same-day cancellation : 0% will be refunded.
	                                    <br> No-show : 0% will be refunded.
	                                    <br>
	                                </p>
	                            </div>
	                        </div>
	                        <label class="label-checkbox mb-10" style = "display: block">
	                                <input type="checkbox" id="orderDetailsOptional" name="orderDetailsOptional" class="form-checkbox">
	                                <span class="label strong font-14">[Optional] I agree to provide my personal information to 3rd parties.</span>
	                        </label>
	                    </div>
	                </div>
	                <hr class = "seperator2" style="width: 90%;">
	                <!-- End Agreement with Order details & Payment -->

					<!-- Start total amount -->
	                <div class="section_title text-center">
	                    <h2 class="title_w" style="margin-top: 70px; display: inline-block; float: left">Total Amount</h2>
	                        <div class="utils" style="margin-left: auto;
	                                                  display: inline-block;
	                                                  align-items: center;
	                                                  padding-left: 10px;
	                                                  float: right;
	                                                  margin-top: 80px;">
	                            <strong class="ebold color-red font-18 mr-10" style="font-size: 28px; color: rgb(255, 61, 0);">
	                            	<dd style="text-align: right; color: rgb(255, 61, 0);">₩ ${paymentAmount * guestnumber}</dd>
	                            </strong>
	                            <!-- <a href="" class="__toggle __toggle-checkout-info __up">More</a>-->
	                        </div>
	                    </div>
	                    <div class="section-body" style="clear: both;">
	                        <p class="font-12 color-gray">
	                        	100% refundable if canceled by ${targetDate} 11:59 PM.<br><br><br><br><br><br><br>
	                        </p>
	                    </div>
	                </div>
	                <!-- <hr class = "seperator"> -->
	                <!-- End total amount -->

	                <!-- Start payment btn -->
	                <div class="sticky-bottom-btns" style="position: fixed;
	                                                       bottom: 0;
	                                                       z-index: 99;
	                                                       width: auto;
	                                                       max-width: 480px;
	                                                       left: 50%;
	                                                       transform: translateX(-50%);
	                                                       padding: 20px;
	                                                       box-sizing: border-box;
	                                                       width: 100vw;
	                                                       /*background: rgba(255,255,255,.7);*/
	                                                       -webkit-backdrop-filter: blur(2px);
	                                                       backdrop-filter: blur(2px);
	                                                       display: flex;">
	                    <button type="button" 
	                    		id="requestPay"
								class="btn btn-lg btn-red full-width ebold"
	                            style="display: block;
			                            width: 100%;
			                            flex: 1;
			                            margin-right: 10px;
			                            margin-bottom: 50px;
			                            font-weight: 700;
			                            background: #ff3d00;
			                            color: #fff;
			                            line-height: 46px;
			                            text-align: center;
			                            font-size: 14px;
			                            font-weight: 500;
			                            padding: 0 20px;
			                            position: relative;
			                            /* border: 1px solid white; */
			                            box-shadow: 3px 3px 3px 3px tomato;
			                            border-radius: 6px;">
	                        Pay ₩ ${paymentAmount * guestnumber}
	                    </button>
	                </div>
                </form>
            </div>
        </section>
        <!--================ Facilities Area  =================-->

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