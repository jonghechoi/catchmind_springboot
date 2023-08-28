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
        <link rel="stylesheet" href="/css/style.css">
        <link rel="stylesheet" href="/css/style_jonghe.css">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
    	<!-- js -->
    	<script src="/js/jquery-3.6.4.min.js"></script>
    </head>
    <script>
	    $(document).ready(function() {
	    	const sopeninghour = '${ShopVo.sopeninghour}';
	    	const sclosinghour = '${ShopVo.sclosinghour}';
	    	const sclosingdate = '${ShopVo.sclosingdate}';
	    	
	    	$('.timepickerOpening').timepicker({
	    	    timeFormat: 'HH:mm',
	    	    interval: 30,
	    	    minTime: '10',
	    	    maxTime: '23:59pm',
	    	    defaultTime: sopeninghour,
	    	    startTime: '10:00',
	    	    dynamic: false,
	    	    dropdown: true,
	    	    scrollbar: true
	    	});
	    	$('.timepickerClosing').timepicker({
	    	    timeFormat: 'HH:mm',
	    	    interval: 30,
	    	    minTime: '10',
	    	    maxTime: '23:59pm',
	    	    defaultTime: sclosinghour,
	    	    startTime: '10:00',
	    	    dynamic: false,
	    	    dropdown: true,
	    	    scrollbar: true
	    	});
	    	
	    	var message = '${message}';
	    	
	    	// Shop detail info already registered? then date choose part(<select>tag) should be choosen
	    	if (sclosingdate != null && sclosingdate.length != 0) {
	    		// Already selected option change to false
	    		var selectElement = document.getElementById('sclosingdate');
	    		//var selectedIndex = selectElement.selectedIndex;
	    		selectElement.selected = false;
	    		
	    		if(sclosingdate == 'monday') {
	    			var mondayOption = selectElement.querySelector('option[value="monday"]');
	    			mondayOption.selected = true;
	    		}else if(sclosingdate == 'tuesday') {
	    			var tuesdayOption = selectElement.querySelector('option[value="tuesday"]');
	    			tuesdayOption.selected = true;
	    		}else if(sclosingdate == 'wednesday') {
	    			var wednesdayOption = selectElement.querySelector('option[value="wednesday"]');
	    			wednesdayOption.selected = true;
	    		}else if(sclosingdate == 'thursday') {
	    			var thursdayOption = selectElement.querySelector('option[value="thursday"]');
	    			thursdayOption.selected = true;
	    		}else if(sclosingdate == 'friday') {
	    			var fridayOption = selectElement.querySelector('option[value="wednesfridayday"]');
	    			fridayOption.selected = true;
	    		}else if(sclosingdate == 'saturday') {
	    			var saturdayOption = selectElement.querySelector('option[value="saturday"]');
	    			saturdayOption.selected = true;
	    		}else if(sclosingdate == 'sunday') {
	    			var sundayOption = selectElement.querySelector('option[value="sunday"]');
	    			sundayOption.selected = true;
	    		}else if(sclosingdate == 'none') {
	    			var noneOption = selectElement.querySelector('option[value="none"]');
	    			noneOption.selected = true;
	    		}
	    	}  
	    	
	    	// Shop facility already registered? then checkbox checked & facilityDesc should be filled
   			if('${FacilityVo.parking}' == 1) {
				var checkboxElement = document.querySelector('.facility[name="parking"]');
				checkboxElement.checked = true;
			}
	    	if('${FacilityVo.valet}' == 1) {
				var checkboxElement = document.querySelector('.facility[name="valet"]');
				checkboxElement.checked = true;				
			}
	    	if('${FacilityVo.corkage}' == 1) {
				var checkboxElement = document.querySelector('.facility[name="corkage"]');
				checkboxElement.checked = true;				
			}
	    	if('${FacilityVo.adultonly}' == 1) {
				var checkboxElement = document.querySelector('.facility[name="adultonly"]');
				checkboxElement.checked = true;				
			}
	    	if('${FacilityVo.sommelier}' == 1) {
				var checkboxElement = document.querySelector('.facility[name="sommelier"]');
				checkboxElement.checked = true;				
			}
	    	if('${FacilityVo.lettering}' == 1) {
				var checkboxElement = document.querySelector('.facility[name="lettering"]');
				checkboxElement.checked = true;				
			}
	    	if('${FacilityVo.rentals}' == 1) {
				var checkboxElement = document.querySelector('.facility[name="rentals"]');
				checkboxElement.checked = true;				
			}
	    	
	    	// Shop photo already registered? then photo preview operated
	    	const sid = '${sessionScope.sessionVo.sid}';
	    	const sPhoto1 = '${ShopPhotoVo.sphoto1}';
	    	const sPhoto2 = '${ShopPhotoVo.sphoto2}';
	    	const sPhoto3 = '${ShopPhotoVo.sphoto3}';
	    	const sPhoto4 = '${ShopPhotoVo.sphoto4}';
	    	const sPhoto5 = '${ShopPhotoVo.sphoto5}';
	    	
	    	var photos = {
	    			photo1 : 0,
	    			photo2 : 0,
	    			photo3 : 0,
	    			photo4 : 0,
	    			photo5 : 0
	    	};
	    	
	    	let count = 0;
	    	if(sPhoto1.length != 0) { count++; photos.photo1 = 1; }
	    	if(sPhoto2.length != 0) { count++; photos.photo2 = 1; }
	    	if(sPhoto3.length != 0) { count++; photos.photo3 = 1; }
	    	if(sPhoto4.length != 0) { count++; photos.photo4 = 1; }
	    	if(sPhoto5.length != 0) { count++; photos.photo5 = 1; }

    		//const previewImg = document.querySelector('.upload_img5');
    		bringPhoto(sid, count, photos);
  	    	
 	    	// Photo preview when shop select photo
			const realUpload1 = document.querySelector('.real-upload1');
			const upload1 = document.querySelector('.upload1');
			upload1.addEventListener('click', () => realUpload1.click());
			realUpload1.addEventListener('change', getimagePreview);
			const realUpload2 = document.querySelector('.real-upload2');
			const upload2 = document.querySelector('.upload2');
			upload2.addEventListener('click', () => realUpload2.click());
			realUpload2.addEventListener('change', getimagePreview);
			const realUpload3 = document.querySelector('.real-upload3');
			const upload3 = document.querySelector('.upload3');
			upload3.addEventListener('click', () => realUpload3.click());
			realUpload3.addEventListener('change', getimagePreview);
			const realUpload4 = document.querySelector('.real-upload4');
			const upload4 = document.querySelector('.upload4');
			upload4.addEventListener('click', () => realUpload4.click());
			realUpload4.addEventListener('change', getimagePreview);
			const realUpload5 = document.querySelector('.real-upload5');
			const upload5 = document.querySelector('.upload5');
			upload5.addEventListener('click', () => realUpload5.click());
			realUpload5.addEventListener('change', getimagePreview);
	    });
	    
    </script>
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
        				<!--================ 변경하는 부분 =================-->                
                            <li class="nav-item active"><a class="nav-link" href="/">Home</a></li>
                            <li class="nav-item"><a class="nav-link" href="/search">Search</a></li>
							<c:if test="${sessionScope.sessionVo.roleId == 'USER'}">
								<li class="nav-item submenu dropdown">
									<a href="/mydining_scheduled" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">MY DINING</a>
									<ul class="dropdown-menu">
										<li class="nav-item active"><a class="nav-link" href="/mydining_scheduled">Scheduled</a></li>
										<li class="nav-item"><a class="nav-link" href="/mydining_visited">Visited</a></li>
										<li class="nav-item"><a class="nav-link" href="/mydining_cancel_noshow">Cancel / No-Show</a></li>
									</ul>
								</li>
							</c:if>
                            <li class="nav-item"><a class="nav-link" href="/mypage">My Page</a></li>
                            <li class="nav-item"><a class="nav-link" href="/notice">Notice</a></li>
                            <%--<c:if test="${sessionScope.sessionVo.roleId =='SHOP' or sessionScope.sessionVo.roleId == 'ADMIN'}">--%>
	                            <li class="nav-item submenu dropdown">
	                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Shop</a>
	                                <ul class="dropdown-menu">
										<li class="nav-item active"><a class="nav-link" href="/shop_information">Register</a></li>
										<li class="nav-item"><a class="nav-link" href="/shop_reservation">Reservation</a></li>
	                                </ul>
	                            </li>
<%--                            </c:if>--%>
                            <c:if test="${sessionScope.sessionVo.roleId == 'ADMIN'}">
                            	<li class="nav-item"><a class="nav-link" href="/admin">Admin</a></li>
                        	</c:if>
                        <!--================ 변경하는 부분 =================-->
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
                    <h2 class="page-cover-tittle">Restaurant Information</h2>
                    <!-- <ol class="breadcrumb">
                        <li><a href="index.html">Home</a></li>
                        <li class="active">About</li>
                    </ol> -->
                </div>
            </div>
        </section>
        <!--================Breadcrumb Area =================-->
        
        <!--================ About History Area  =================-->
        <section class="accomodation_area section_gap">
            <div class="container">
                <div class="section_title text-center restaurant_info">
                    <h2 class="title_color">Main Information</h2>
                    <p>See the important information about the restaurant </p>
                </div>
                <div id="shopDetailModification">
					<div class="shopInfo">
						<form name="" action="#" method="get">
							<ul class="shopDetail">
								<li>
									<span>Shop  :  </span>
									<input type="text" name="name" id="shopName" value="${ShopVo.sname}" disabled>
								</li>
								<li>
									<span>Phone  :  </span>
									<input type="text" name="phone" id="shopPhone" value="${ShopVo.sphone}" disabled>
								</li>
								<li>
									<span>Food Style  :  </span>
									<input type="text" name="foodstyle" id="shopFoodStyle" value="${ShopVo.sfoodstyle}" disabled>
								</li>
								<li>
									<span>Location  :  </span>
									<input type="text" name="slocshort" id="shopLocation" value="${ShopVo.slocshort}" disabled>
								</li>									
								<li>
									<span>Address  :  </span>
									<input type="text" name="sloc" id="shopAddress" value="${ShopVo.sloc}" disabled>
								</li>	
								<li>
									<span>Photo  :  </span>
									<img src="${ShopVo.smphoto}" id="shopPhoto" style="width:217px; height:217px; box-shadow: 0 2px 100px rgba(0, 0, 0, 0.1)">
								</li>	
							</ul>
						</form>
					</div>
				</div>
			</div>
	        <hr>
			<div class="container">
                <div class="section_title text-center restaurant_info">
                    <h2 class="title_color">Detail Information</h2>
                </div>
                <div id="shopDetailModification">
					<div class="shopInfo">
						<form name="shopDetailInformationForm1" action="#" method="post">
							<ul class="shopDetail sub">
								<li>
									<span>Intro  :  </span>
									<textarea rows="4" cols="50" name="sintro" id="sintro">${ShopVo.sintro}</textarea>
								</li>
								<li>
									<span>Open :  </span>
									<input type="text" name="sopeninghour" id="sopeninghour" class="timepickerOpening" required size="20" maxlength="5" style="">
								</li> 
								<li>
									<span>Close :  </span>
									<input type="text" name="sclosinghour" id="sclosinghour" class="timepickerClosing" required size="20" maxlength="5" style="">
								</li>
								<li>
									<span>Close Date :  </span>
									<select name="sclosingdate" id="sclosingdate">
									    <option value="" disabled selected hidden></option>
										<option value="monday">Monday</option>
										<option value="tuesday">TuesDay</option>
										<option value="wednesday">WednesDay</option>
										<option value="thursday">ThursDay</option>
										<option value="friday">Friday</option>
										<option value="saturday">Saturday</option>
										<option value="sunday">Sunday</option>
										<option value="none">None</option>
									</select>
								</li>
								<li id="facilityCheckBox">
									<span>Facility : </span>
									<input type="checkbox" name="parking" class="facility"><span> Parking</span>
									<input type="checkbox" name="valet" class="facility"><span> Valet</span>
									<input type="checkbox" name="corkage" class="facility"><span> Corkage</span>
									<input type="checkbox" name="adultonly" class="facility"><span> Adultonly</span>
									<input type="checkbox" name="sommelier" class="facility"><span> Sommelier</span>
									<input type="checkbox" name="lettering" class="facility"><span> Lettering</span>
									<input type="checkbox" name="rentals" class="facility"><span> Rentals</span>
									<button type="button" id="btnShopFacilityDetail">Write Detail Info</button>
								</li>
								<li>
									<span>Deposit :  </span>
									<input type="text" name="sdeposit" id="sdeposit" value="${ShopVo.sdeposit}">
								</li>
								<li>
									<span>MealFee  :  </span>
									<input type="text" name="smealfee" id="smealfee" value="${ShopVo.smealfee}">
								</li>
								<li>
									<span>Lunch  :  </span>
									<input type="text" name="lunch" id="lunch" value="${ShopVo.lunch}">
								</li>
								<li>
									<span>Dinner  :  </span>
									<input type="text" name="dinner" id="dinner" value="${ShopVo.dinner}">
								</li>								
								<li>
 									<span>Image  :  </span>
								    <input type="file" name="images1" class="real-upload1" required multiple style="display: none;">
								    <div class="upload1"><img class="upload_img1" src="/content/img/image_icon.png" alt=""></div>
								    <input type="file" name="images2" class="real-upload2" required multiple style="display: none;">
								    <div class="upload2"><img class="upload_img2" src="/content/img/image_icon.png" alt=""></div>
								    <input type="file" name="images3" class="real-upload3" required multiple style="display: none;">
								    <div class="upload3"><img class="upload_img3" src="/content/img/image_icon.png" alt=""></div>
								    <input type="file" name="images4" class="real-upload4" required multiple style="display: none;">
								    <div class="upload4"><img class="upload_img4" src="/content/img/image_icon.png" alt=""></div>
								    <input type="file" name="images5" class="real-upload5" required multiple style="display: none;">
								    <div class="upload5"><img class="upload_img5" src="/content/img/image_icon.png" alt=""></div>
								</li>								
								<li>																	
									<input type="hidden" name="sid" id="sid" value="${ShopVo.sid}"> 
									<button type="button" id="btnShopDetailInformation">Send Confirm</button>
								</li>
							</ul>
						</form>
					</div>
				</div>
            </div>
        </section>
        <!--================ About History Area  =================-->
        <!--================ start footer Area  =================-->	
         <footer class="footer-area section_gap" style="padding:50px 0 0 0; background:rgb(255, 61, 0)">
       		<%@ include file="../../footer.jsp" %>
        </footer> 
		<!--================ End footer Area  =================-->
        <!-- Optional JavaScript -->
        <script src="/js/jonghe.js"></script>
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
        <script src="/js/popper.js"></script>
        <script src="/js/bootstrap.min.js"></script>
        <script src="/vendors/owl-carousel/owl.carousel.min.js"></script>
        <script src="/js/jquery.ajaxchimp.min.js"></script>
        <script src="/vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.js"></script>
        <!-- <script src="/vendors/nice-select/js/jquery.nice-select.js"></script> -->
        <script src="/js/mail-script.js"></script>
        <script src="/js/stellar.js"></script>
        <script src="/vendors/lightbox/simpleLightbox.min.js"></script>
        <script src="/js/custom.js"></script>
    </body>
</html>