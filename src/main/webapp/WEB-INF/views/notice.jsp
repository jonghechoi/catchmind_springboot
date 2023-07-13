<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" href="image/favicon.png" type="image/png">
        <title>Royal Hotel</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="/css/bootstrap.css">
        <link rel="stylesheet" href="/vendors/linericon/style.css">
        <link rel="stylesheet" href="/css/font-awesome.min.css">
        <link rel="stylesheet" href="/vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.css">
        <link rel="stylesheet" href="/vendors/nice-select/css/nice-select.css">
        <link rel="stylesheet" href="/vendors/owl-carousel/owl.carousel.min.css">
        <!-- main css -->
        <link rel="stylesheet" href="/css/style.css">
        <link rel="stylesheet" href="/css/responsive.css">
        <style>
        section.board table.board_list tr:first-child td {
			border:1px solid white;	
			border-bottom:1px solid #777;
			text-align:right;
		}
		section.board table.board_list tr:first-child td button{
			margin:0 0 5px 0;
			width:70px;
			padding:7px 0;
			border: none;
			border-radius: 5px;
		}
		section.board table.board_list tr:first-child td button:hover {
			cursor: pointer;
		}
		section.notice table, section.notice th, section.notice td,
		section.board table, section.board th, section.board td {
			border:1px solid #777;
			border-collapse:collapse;
			text-align:center;
			font-size:10pt;
			color:#333;
		}
		section.notice th, section.notice td,
		section.board th, section.board td {
			padding:6px 0;
		}
		section.notice tr > td:nth-child(2),
		section.board tr > td:nth-child(2) {
			text-align:left;
			text-indent:20px;
		}
		section.notice tr > td:nth-child(2) > a,
		section.board tr > td:nth-child(2) > a{
			text-decoration:none;
		}
		section.notice tr > td:nth-child(2) > a:hover,
		section.board tr > td:nth-child(2) > a:hover{
			text-decoration:underline;
		}
		section.notice tr:first-child,
		section.board tr:nth-child(2) {
			background:#ddd;
			color:#333;	
		}
		section.notice tr:last-child td,
		section.board tr:last-child td {
			border:1px solid white;
			padding-bottom:40px;
		}
		div.content table, h1 {
			width:70%;
			margin:auto;	
		}
        </style>
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
                            <!--================ Menu =================-->                
                            <li class="nav-item"><a class="nav-link" href="index">Home</a></li>
                            <li class="nav-item"><a class="nav-link" href="search">Search</a></li>
                            <li class="nav-item submenu dropdown active">
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
                        <!--================ Menu =================-->
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
                    <h2 class="page-cover-tittle">Notice</h2>
                    <!-- <ol class="breadcrumb">
                        <li><a href="index.html">Home</a></li>
                        <li class="active">About</li>
                    </ol> -->
                </div>
            </div>
        </section>
        <!--================Breadcrumb Area =================-->
        
        <!--================ About History Area  =================-->
        <section class="about_history_area section_gap">
        	<div class="container">
	        	<div class="content">
					<section class="board">
						<h1 class="title">Notice</h1>			
						<table class="board_list">
							<tr>
								<td colspan="4">
									<a href="http://localhost:9000/royal-master/Admin/notice_write.jsp">
										<button type="button">register</button>
									</a>
								</td>
							</tr>
							<tr>
								<th>No</th>
								<th>Title</th>
								<th>Hits</th>
								<th>Reporting Date</th>
							</tr>
							
							
<%-- 							
							<c:forEach var="" items="${}">
								<tr>
									<td>${}</td>
									<td><a href=""></a></td>
									<td>${}</td>
									<td>${}</td>	
								</tr>						
							</c:forEach>
							
							 --%>
							
							
							
							<tr>
								<td>1</td>
								<td><a href="http://localhost:9000/royal-master/Admin/notice_content.jsp">09/05/2023 Notice</a></td>
								<td>1000</td>
								<td>2023-05-09</td>
							</tr>
							<tr>
								<td>2</td>
								<td>12/01/2023 Notice</td>
								<td>1000</td>
								<td>2023-01-12</td>
							</tr>
							<tr>
								<td>3</td>
								<td>10/02/2023 Notice</td>
								<td>1000</td>
								<td>2023-02-10</td>
							</tr>
							<tr>
								<td>4</td>
								<td>20/03/2023 Notice</td>
								<td>1000</td>
								<td>2023-03-20</td>
							</tr>
							<tr>
								<td>5</td>
								<td>15/04/2023 Notice</td>
								<td>1000</td>
								<td>2023-04-15</td>
							</tr>
							
							
							
							
							
							
							<tr>
								<td colspan="4"><< 1  2  3  4  5 >></td>
							</tr>
						</table>
					</section>
				</div>
			</div>
        </section>
        <!--================ About History Area  =================-->
        <!--================ start footer Area  =================-->	
        <footer class="footer-area section_gap">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3  col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h6 class="footer_title">About Agency</h6>
                            <p>The world has become so fast paced that people don’t want to stand by reading a page of information, they would much rather look at a presentation and understand the message. It has come to a point </p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h6 class="footer_title">Navigation Links</h6>
                            <div class="row">
                                <div class="col-4">
                                    <ul class="list_style">
                                        <li><a href="#">Home</a></li>
                                        <li><a href="#">Feature</a></li>
                                        <li><a href="#">Services</a></li>
                                        <li><a href="#">Portfolio</a></li>
                                    </ul>
                                </div>
                                <div class="col-4">
                                    <ul class="list_style">
                                        <li><a href="#">Team</a></li>
                                        <li><a href="#">Pricing</a></li>
                                        <li><a href="#">Blog</a></li>
                                        <li><a href="#">Contact</a></li>
                                    </ul>
                                </div>										
                            </div>							
                        </div>
                    </div>							
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h6 class="footer_title">Newsletter</h6>
                            <p>For business professionals caught between high OEM price and mediocre print and graphic output, </p>		
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
                    <div class="col-lg-3 col-md-6 col-sm-6">
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
                    <p class="col-lg-8 col-sm-12 footer-text m-0"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                    <div class="col-lg-4 col-sm-12 footer-social">
                        <a href="#"><i class="fa fa-facebook"></i></a>
                        <a href="#"><i class="fa fa-twitter"></i></a>
                        <a href="#"><i class="fa fa-dribbble"></i></a>
                        <a href="#"><i class="fa fa-behance"></i></a>
                    </div>
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